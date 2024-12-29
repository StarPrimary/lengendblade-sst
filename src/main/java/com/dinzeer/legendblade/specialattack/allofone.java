package com.dinzeer.legendblade.specialattack;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.regsitry.slashblade.LBComboRegsitry;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.Random;

public class allofone {
    private static final Random random = new Random();
    public static void doSlash(LivingEntity playerIn, float speed) {

        Collection<RegistryObject<ComboState>> entries = LBComboRegsitry.COMBO_STATES.getEntries();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(entries.size());
            if (entries.stream().skip(index).findFirst().isPresent()) {
                ComboState state = entries.stream().skip(index).findFirst().get().get();
                for (int ia = 0; ia < 10; ia++) {
                    state.releaseAction(playerIn, ia);
                }
                state.clickAction(playerIn);
                state.tickAction(playerIn);
                /*if (Math.random()<0.3) {
                }else if (Math.random()<0.7) {
                    state.releaseAction(playerIn,1);
                }else {
                    state.clickAction(playerIn);
                }*/
            }
        }


    }
}
