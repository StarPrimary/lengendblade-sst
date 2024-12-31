package com.dinzeer.legendblade.specialeffects.versionone;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber
public class BladeAttack extends SpecialEffect {
    public BladeAttack() {
        super(90,false,false);
    }
    private static final Map<Player, Long> cooldownMap = new HashMap<>();
    private static final int COOLDOWN_MILLIS = 7000;

    @SubscribeEvent
    public  static  void blaze(SlashBladeEvent.UpdateEvent event){
        ISlashBladeState state = event.getSlashBladeState();
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.BLadeAttack.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            if(!event.isSelected())
                return;

            Player player = (Player) event.getEntity();

            int level = player.experienceLevel;

            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.BLadeAttack.get(), level)) {
                long currentTime = System.currentTimeMillis();
                if (cooldownMap.containsKey(player)) {
                    long lastUsedTime = cooldownMap.get(player);
                    if (currentTime - lastUsedTime < COOLDOWN_MILLIS) {
                        return;
                    }
                }

                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));

                cooldownMap.put(player, currentTime);
            }
        }
    }

    @SubscribeEvent
    public static void onSlashBladeHit(SlashBladeEvent.HitEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.BLadeAttack.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }

            Player player = (Player)event.getUser();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.BLadeAttack.get(), level)) {
                event.getTarget().addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0));
            }
        }

    }

}
