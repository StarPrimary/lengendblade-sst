package com.dinzeer.legendblade.regsitry.slashblade;

import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class AllofoneRegsitry {
    public static final DeferredRegister<ComboState> COMBO_STATES =
            DeferredRegister.create(ComboState.REGISTRY_KEY,MODID);
    public static final DeferredRegister<SlashArts> SLASH_ARTS =
            DeferredRegister.create(SlashArts.REGISTRY_KEY, MODID);


    public static  RegistryObject<ComboState> Dance =LBComboRegsitry.delete;


    public static void register(IEventBus modeventbus) {
        COMBO_STATES.register(modeventbus);
        SLASH_ARTS.register(modeventbus);
    }
}
