package com.dinzeer.legendblade.specialattack.versionone;

import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class MonsterPower {


    public static void doSlash(LivingEntity playerIn)
    {
        int colorCode = playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state -> state.getColorCode()).orElse(0xFF3333FF);
        doSlash(playerIn, colorCode);
    }

    public static void doSlash(LivingEntity playerIn,int colorCode)
    {
        playerIn.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 100, 1));
        playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1));

    }
}
