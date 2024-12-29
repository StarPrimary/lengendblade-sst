package com.dinzeer.legendblade.specialattack.versionone;

import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class Prowess {



        public static void doSlash(LivingEntity playerIn)
        {
            int colorCode = playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state -> state.getColorCode()).orElse(0xFF3333FF);
            doSlash(playerIn, colorCode);
        }

        public static void doSlash(LivingEntity playerIn,int colorCode)
        {

            playerIn.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0));
            playerIn.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, 1));
            playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 2));
            playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 2));
            playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 100, 2));
            playerIn.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 2));

    }

}



