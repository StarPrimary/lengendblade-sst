package com.dinzeer.legendblade.specialattack.versionone;

import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class HungerAbsorption {


    public static void doSlash(LivingEntity playerIn, float speed, boolean what)
    {
        int colorCode = playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(ISlashBladeState::getColorCode).orElse(0xFF3333FF);
        doSlash(playerIn,speed);
    }

    public static void doSlash(LivingEntity playerIn, float speed) {

        SMoveUtil.sendDashMessage((Player) playerIn,0,speed);
        playerIn.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 3));
        playerIn.heal(8);


    }

}
