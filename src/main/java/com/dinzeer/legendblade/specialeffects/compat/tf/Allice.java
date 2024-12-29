package com.dinzeer.legendblade.specialeffects.compat.tf;

import com.dinzeer.legendblade.regsitry.compat.TFLBcompat;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import twilightforest.TwilightForestMod;
import twilightforest.init.TFMobEffects;

@Mod.EventBusSubscriber
public class Allice extends SpecialEffect {
    public Allice() {
        super(0);
    }
    @SubscribeEvent
    public static void apply(SlashBladeEvent.HitEvent event){
        if (ModList.get().isLoaded(TwilightForestMod.ID)) {
            if (event.getSlashBladeState().hasSpecialEffect(TFLBcompat.allice.getId()))
            {
                if (!(event.getUser() instanceof Player)) {

                    return;
                }
                Player player = (Player)event.getUser();
                LivingEntity target = event.getTarget();
                if (SpecialEffect.isEffective(TFLBcompat.allice.get(), player.experienceLevel)) {
                   target.addEffect(new MobEffectInstance(TFMobEffects.FROSTY.get(), 100, 2));
                }
            }//写暮色联动中

        }
    }
}
