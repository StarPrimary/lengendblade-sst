package com.dinzeer.legendblade.regsitry.compat;

import cn.mmf.slashblade_addon.specialattacks.WaterDrive;
import com.dinzeer.legendblade.Legendblade;
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
import cn.mmf.slashblade_addon.specialattacks.*;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class SBALBSlashArtRegsitry {
    public static final DeferredRegister<ComboState> COMBO_STATES =
            DeferredRegister.create(ComboState.REGISTRY_KEY,MODID);
    public static final DeferredRegister<SlashArts> SLASH_ARTS =
            DeferredRegister.create(SlashArts.REGISTRY_KEY, MODID);
    public static final DeferredRegister<SpecialEffect> REGISTRY_KEY2= DeferredRegister.create(SpecialEffect.REGISTRY_KEY, MODID);
    public static final RegistryObject<SlashArts> terrifyingwavesSA;
    public static final RegistryObject<SlashArts> lightingsumSA;
    public static final RegistryObject<SlashArts> DanceSA;
    public static final RegistryObject<SpecialEffect> Terrifyingwaves;
    public static final RegistryObject<SpecialEffect> FireDancy;
    public static final RegistryObject<SpecialEffect> Lightingsum;
    public static final RegistryObject<ComboState> terrifyingwaves = COMBO_STATES.register("terrifying_waves",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(3, (entityIn) -> WaterDrive.doSlash(entityIn,90,10,Vec3.ZERO,false,10.0,1F))
                            .put(4, (entityIn) -> WaterDrive.doSlash(entityIn,90,10,Vec3.ZERO,false,10.0,1F))
                            .put(5, (entityIn) -> WaterDrive.doSlash(entityIn,90,10,Vec3.ZERO,false,10.0,1F))
                            .put(6, (entityIn) -> WaterDrive.doSlash(entityIn,90,10,Vec3.ZERO,false,10.0,1F))
                            .put(7, (entityIn) -> WaterDrive.doSlash(entityIn,90,10,Vec3.ZERO,false,10.0,1F))
                            .put(8, (entityIn) -> WaterDrive.doSlash(entityIn,90,10,Vec3.ZERO,false,10.0,1F))
                            .put(9, (entityIn) -> WaterDrive.doSlash(entityIn,90,10,Vec3.ZERO,false,10.0,1F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static final RegistryObject<ComboState> lightinggwaves = COMBO_STATES.register("lighting_swordsex",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(3, (entityIn) -> LightingSwords.doSlash(entityIn,false,10.5,5F))
                            .put(4, (entityIn) -> LightingSwords.doSlash(entityIn,false,10.5,5F))
                            .put(5, (entityIn) -> LightingSwords.doSlash(entityIn,false,10.5,5F))
                            .put(6, (entityIn) -> LightingSwords.doSlash(entityIn,false,10.5,5F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);


    public static final RegistryObject<ComboState> Dance = COMBO_STATES.register("fire_dance",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(3, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 180.0F))
                            .put(4, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 90.0F))
                            .put(5, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 0.0F))
                            .put(6, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, -90.0F))
                            .put(7, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 180.0F))
                            .put(8, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 90.0F))
                            .put(9, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 0.0F))
                            .put(10, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, -90.0F))
                            .put(11, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 180.0F))
                            .put(12, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 90.0F))
                            .put(13, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 0.0F))
                            .put(14, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, -90.0F))
                            .put(15, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 180.0F))
                            .put(16, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 90.0F))
                            .put(17, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 0.0F))
                            .put(18, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, -90.0F))
                            .put(19, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, 0.0F))
                            .put(20, (entityIn) -> FireSpiral.doCircleSlash(entityIn, -30.0F, -90.0F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);





    public static void register(IEventBus modeventbus) {
        COMBO_STATES.register(modeventbus);
        SLASH_ARTS.register(modeventbus);
        REGISTRY_KEY2.register(modeventbus);
    }
    static {
        terrifyingwavesSA=SLASH_ARTS.register("terrifyingwaves", () -> new SlashArts((e) -> terrifyingwaves.getId()));
        lightingsumSA=SLASH_ARTS.register("lighting_swordsex", () -> new SlashArts((e) -> lightinggwaves.getId()));
        DanceSA=SLASH_ARTS.register("fire_dance", () -> new SlashArts((e) -> Dance.getId()));
        Terrifyingwaves=REGISTRY_KEY2.register("terrifying_waves", com.dinzeer.legendblade.specialeffects.compat.slashbladeaddon.Terrifyingwaves::new);
        FireDancy=REGISTRY_KEY2.register("fire_dancy", com.dinzeer.legendblade.specialeffects.compat.slashbladeaddon.FireDancy::new);
        Lightingsum=REGISTRY_KEY2.register("lighting_sum", com.dinzeer.legendblade.specialeffects.compat.slashbladeaddon.Lightingsum::new);
    }
}
