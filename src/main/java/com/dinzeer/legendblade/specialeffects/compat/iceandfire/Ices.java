package com.dinzeer.legendblade.specialeffects.compat.iceandfire;

import com.dinzeer.legendblade.regsitry.compat.ICFLBcompatRegsitry;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.entity.props.EntityDataProvider;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Ices extends SpecialEffect {
    public Ices() {
        super(0, false, false);
    }
    @SubscribeEvent
    public static void ice(SlashBladeEvent.HitEvent event){
        if (ModList.get().isLoaded(IceAndFire.MODID)) {
            ISlashBladeState state = event.getSlashBladeState();
            if (state.hasSpecialEffect(ICFLBcompatRegsitry.ice.getId())) {
                if (!(event.getUser() instanceof Player)) {
                    return;
                }
                Player player = (Player) event.getUser();
                int level = player.experienceLevel;

                if (SpecialEffect.isEffective(ICFLBcompatRegsitry.ice.get(), level)) {
                    LivingEntity target = event.getTarget();
                    EntityDataProvider.getCapability(target).ifPresent((data) -> {
                        data.frozenData.setFrozen(target, 300);
                    });


                }
            }
        }
    }

}
