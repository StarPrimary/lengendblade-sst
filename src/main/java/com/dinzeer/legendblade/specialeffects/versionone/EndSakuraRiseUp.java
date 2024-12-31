package com.dinzeer.legendblade.specialeffects.versionone;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.exfantasy.mclib.Utils.SlashBlade.SlashEffectUtils;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import mods.flammpfeil.slashblade.slasharts.SakuraEnd;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EndSakuraRiseUp extends SpecialEffect {
    public EndSakuraRiseUp() {
        super(150,false,false);
    }
    @SubscribeEvent
    public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {

            ISlashBladeState state = event.getSlashBladeState();
            if (state.hasSpecialEffect(LBSpecialEffectsRegistry.EndSakuraRiseUp.getId())) {
                if (!(event.getUser() instanceof Player)) {
                    return;
                }

                Player player = (Player)event.getUser();
                RandomSource random = player.getRandom();
                int level = player.experienceLevel;
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.EndSakuraRiseUp.get(), level)) {
                    if(random.nextInt(100)>=50){
                        SakuraEnd.doSlash(player, 22.5F, Vec3.ZERO, false, false,
                                SlashEffectUtils.addslashbladesaDamage(player,2))              ;
                        SakuraEnd.doSlash(player, -22.5F, Vec3.ZERO, false, false,
                                SlashEffectUtils.addslashbladesaDamage(player,2))              ;



                    }
                }
            }
        }
}

