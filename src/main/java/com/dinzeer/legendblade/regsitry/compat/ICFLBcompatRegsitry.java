package com.dinzeer.legendblade.regsitry.compat;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.specialattack.compat.iceandfire.Fire;
import com.dinzeer.legendblade.specialattack.compat.iceandfire.Ice;
import com.dinzeer.legendblade.specialattack.compat.iceandfire.Lightning;
import com.dinzeer.legendblade.specialeffects.compat.iceandfire.Fires;
import com.dinzeer.legendblade.specialeffects.compat.iceandfire.Ices;
import com.dinzeer.legendblade.specialeffects.compat.iceandfire.Icfbreakers;
import com.dinzeer.legendblade.specialeffects.compat.iceandfire.Lightnings;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.init.DefaultResources;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import mods.flammpfeil.slashblade.util.AttackManager;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class ICFLBcompatRegsitry {
    public static final DeferredRegister<ComboState> COMBO_STATES =
            DeferredRegister.create(ComboState.REGISTRY_KEY,MODID);
    public static final DeferredRegister<SlashArts> SLASH_ARTS =
            DeferredRegister.create(SlashArts.REGISTRY_KEY, MODID);
    public static final DeferredRegister<SpecialEffect> REGISTRY_KEY2= DeferredRegister.create(SpecialEffect.REGISTRY_KEY, MODID);
    public static final RegistryObject<ComboState> Lightningsummonsword =COMBO_STATES.register("lightningsummonsword",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
            .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
            .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
            .put(2, (entityIn) -> Lightning.doSlash(entityIn,false,15,3F))
            .build())
            .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> Firesummonsword =COMBO_STATES.register("firesummonsword",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> Fire.doSlash(entityIn,false,15,3F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> Icesummonsword =COMBO_STATES.register("icesummonsword",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> Ice.doSlash(entityIn,false,15,3F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<SlashArts> lightningsummonsword;
    public static final RegistryObject<SlashArts> firesummonsword;
    public static final RegistryObject<SlashArts> icesummonsword;


    public static final RegistryObject<SpecialEffect> fire;
    public static final RegistryObject<SpecialEffect> lightning;
    public static final RegistryObject<SpecialEffect> ice;
    public static final RegistryObject<SpecialEffect> icfbreaker;


static {
    lightningsummonsword=SLASH_ARTS.register("lightningsummonsword",() -> new SlashArts((e) ->Lightningsummonsword.getId()));
    firesummonsword=SLASH_ARTS.register("firesummonsword",() -> new SlashArts((e) ->Firesummonsword.getId()));
    icesummonsword=SLASH_ARTS.register("icesummonsword",() -> new SlashArts((e) ->Icesummonsword.getId()));
    fire=REGISTRY_KEY2.register("fire", Fires::new);
    lightning=REGISTRY_KEY2.register("lightning", Lightnings::new);
    ice=REGISTRY_KEY2.register("ice", Ices::new);
    icfbreaker=REGISTRY_KEY2.register("icfbreaker", Icfbreakers::new);
}

    public static void register(IEventBus modeventbus) {
        COMBO_STATES.register(modeventbus);
        SLASH_ARTS.register(modeventbus);
        REGISTRY_KEY2.register(modeventbus);
    }
}
