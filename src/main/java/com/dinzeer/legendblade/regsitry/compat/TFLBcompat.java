package com.dinzeer.legendblade.regsitry.compat;

import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import com.dinzeer.legendblade.specialeffects.compat.tf.*;
import static com.dinzeer.legendblade.Legendblade.MODID;

public class TFLBcompat {
    public static final DeferredRegister<SpecialEffect> REGISTRY_KEY2= DeferredRegister.create(SpecialEffect.REGISTRY_KEY, MODID);
    public static final RegistryObject<SpecialEffect> fire;
    public static final RegistryObject<SpecialEffect> breakarm;
    public static final RegistryObject<SpecialEffect> allice;
    public static void register(IEventBus modeventbus) {

        REGISTRY_KEY2.register(modeventbus);

    }
    static {
        fire=REGISTRY_KEY2.register("fireiron", FireIron::new);
        breakarm=REGISTRY_KEY2.register("breakarm", BreakArm::new);
        allice=REGISTRY_KEY2.register("allice", Allice::new);
    }
}
