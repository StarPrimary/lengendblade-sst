package com.dinzeer.legendblade.specialattack.versionone;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class GreedyGrip {
    public static void doSlash(LivingEntity playerIn)
    {
        playerIn.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1));

    }
}
