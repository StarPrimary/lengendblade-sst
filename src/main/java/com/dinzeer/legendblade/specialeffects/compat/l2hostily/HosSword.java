package com.dinzeer.legendblade.specialeffects.compat.l2hostily;

import com.dinzeer.legendblade.regsitry.compat.L2LBcompatRegsitry;
import dev.xkmc.l2complements.init.registrate.LCEffects;
import dev.xkmc.l2hostility.init.L2Hostility;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class HosSword extends SpecialEffect {
    public HosSword() {
        super(30,true,true);
    }
    @SubscribeEvent
    public static void slash(SlashBladeEvent.HitEvent event) {
        if(ModList.get().isLoaded(L2Hostility.MODID)){
        if (event.getSlashBladeState().hasSpecialEffect(L2LBcompatRegsitry.HosSword.getId())){
            event.getTarget().addEffect(new MobEffectInstance(LCEffects.CURSE.get(), 100, 0, false, false));

        }}
    }
}
