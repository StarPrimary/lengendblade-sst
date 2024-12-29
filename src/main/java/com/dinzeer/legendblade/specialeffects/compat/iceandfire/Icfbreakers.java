package com.dinzeer.legendblade.specialeffects.compat.iceandfire;

import com.dinzeer.legendblade.regsitry.compat.ICFEntiyRegsitry;
import com.dinzeer.legendblade.regsitry.compat.ICFLBcompatRegsitry;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import com.github.alexthe666.iceandfire.IceAndFire;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class Icfbreakers extends SpecialEffect {
    public Icfbreakers() {
        super(40,false,false);
    }
    @SubscribeEvent
    public static void apply(LivingHurtEvent event){
        if (ModList.get().isLoaded(IceAndFire.MODID)) {


        LivingEntity target = event.getEntity();
        if (event.getSource().getEntity() instanceof Player player) {
            if (SpecialEffect.isEffective(ICFLBcompatRegsitry.icfbreaker.get(), player.experienceLevel)) {
            if (SlashbladeUtils.hasSpecialEffect(player.getMainHandItem(),ICFLBcompatRegsitry.icfbreaker.getId().toString())) {

                if (ICFEntiyRegsitry.isICFENTITY(target)) {
                    event.setAmount(event.getAmount() * 2);
                }

            }
            }
        }
    }
}

}
//开整？

