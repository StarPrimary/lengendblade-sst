package com.dinzeer.legendblade.specialeffects.versiontwo;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import mods.flammpfeil.slashblade.slasharts.Drive;
import mods.flammpfeil.slashblade.slasharts.WaveEdge;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Bloodfox extends SpecialEffect {
    public Bloodfox() {
        super(30);
    }
    @SubscribeEvent
    public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {

        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.bloodfox.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }//写血狐se

            Player player = (Player)event.getUser();
            RandomSource random = player.getRandom();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.bloodfox.get(), level)) {
                if(player.getHealth()<=player.getMaxHealth()/2){
                    Drive.doSlash(player,event.getRoll(),30,Vec3.ZERO,false,10,3F);//血狐的se
                    if (!player.hasEffect(MobEffects.ABSORPTION)){
                        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 300, 10));
                    }else
                    if (player.getEffect(MobEffects.ABSORPTION).getDuration()<=5*20){
                        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 300, 9));
                    }
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 1));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1));
                }else {
                    player.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                    player.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 100, 0));
                    player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 4));
                }


            }





        }
    }
}
