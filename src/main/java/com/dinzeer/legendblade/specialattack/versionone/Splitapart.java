package com.dinzeer.legendblade.specialattack.versionone;

import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class Splitapart {


    public static void doSlash(LivingEntity playerIn, float speed) {

        SMoveUtil.sendDashMessage((Player) playerIn,0,speed);
        playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 3));
        playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1));
        if (playerIn.getHealth()>8) {
            playerIn.setHealth(playerIn.getHealth() - 8);
        }else {
            playerIn.hurt(new DamageSource(playerIn.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL), playerIn), 8);
        }

    }
}
