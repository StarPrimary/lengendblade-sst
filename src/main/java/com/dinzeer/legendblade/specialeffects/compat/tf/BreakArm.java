package com.dinzeer.legendblade.specialeffects.compat.tf;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.regsitry.compat.ICFEntiyRegsitry;
import com.dinzeer.legendblade.regsitry.compat.ICFLBcompatRegsitry;
import com.dinzeer.legendblade.regsitry.compat.TFLBcompat;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
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
import twilightforest.TwilightForestMod;

@Mod.EventBusSubscriber
public class BreakArm  extends SpecialEffect {
    public BreakArm() {
        super(60);
    }

    @SubscribeEvent
    public static void apply(LivingHurtEvent event) {
        if (ModList.get().isLoaded(TwilightForestMod.ID)) {

            LivingEntity target = event.getEntity();
            if (event.getSource().getEntity() instanceof Player player) {
                if (SlashbladeUtils.hasSpecialEffect(player.getMainHandItem(), Legendblade.MODID+":breakarm")) {
                if (SpecialEffect.isEffective(TFLBcompat.breakarm.get(), player.experienceLevel)) {


                        if (target.getArmorValue()>0) {
                            if (target.getArmorValue()>20){
                            event.setAmount((float) (event.getAmount() * (( (double) target.getArmorValue() /15)+1)));

                            }else {
                                event.setAmount(event.getAmount() *2);

                            }

                        }

                }
                else {
                    event.setAmount((float) (event.getAmount()*0.5));
                }
                }

            }

        }
    }
}