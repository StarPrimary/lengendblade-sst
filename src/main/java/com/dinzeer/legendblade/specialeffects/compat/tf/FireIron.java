package com.dinzeer.legendblade.specialeffects.compat.tf;

import com.dinzeer.legendblade.regsitry.compat.ICFLBcompatRegsitry;
import com.dinzeer.legendblade.regsitry.compat.TFLBcompat;
import com.github.alexthe666.iceandfire.IceAndFire;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import twilightforest.TwilightForestMod;

@Mod.EventBusSubscriber
public class FireIron extends SpecialEffect {
    public FireIron() {
        super(0);
    }
    @SubscribeEvent
    public static void apply(SlashBladeEvent.HitEvent event){
        if (ModList.get().isLoaded(TwilightForestMod.ID)) {
            if (event.getSlashBladeState().hasSpecialEffect(TFLBcompat.fire.getId()))
            {
                if (!(event.getUser() instanceof Player)) {

                    return;
                }
                Player player = (Player)event.getUser();
                LivingEntity target = event.getTarget();
                if (SpecialEffect.isEffective(TFLBcompat.fire.get(), player.experienceLevel)) {
                    if (target.isOnFire())
                    {
                        target.setSecondsOnFire(5);
                        target.invulnerableTime = 0;
                        target.hurt(new DamageSource(target.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), player), (float) (player.getAttributeValue(Attributes.ATTACK_DAMAGE))*0.5f);

                    }else {
                        target.setSecondsOnFire(10);

                    }
                }
            }//写暮色联动中

        }
    }
}
