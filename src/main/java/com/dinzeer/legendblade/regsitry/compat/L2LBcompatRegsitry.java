package com.dinzeer.legendblade.regsitry.compat;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.entity.Compat.HosSummonSwordEntity;
import com.dinzeer.legendblade.entity.Compat.LightningSummonSwordEntity;
import com.dinzeer.legendblade.specialattack.compat.iceandfire.Hoss;
import com.dinzeer.legendblade.specialattack.compat.iceandfire.Ice;
import com.dinzeer.legendblade.specialeffects.compat.l2hostily.Ark;
import com.dinzeer.legendblade.specialeffects.compat.l2hostily.HosSword;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.init.DefaultResources;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import mods.flammpfeil.slashblade.util.AttackManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import static com.dinzeer.legendblade.Legendblade.MODID;
import static com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys.classToString;

public class L2LBcompatRegsitry {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    public static final DeferredRegister<ComboState> COMBO_STATES =
            DeferredRegister.create(ComboState.REGISTRY_KEY,MODID);
    public static final DeferredRegister<SlashArts> SLASH_ARTS =
            DeferredRegister.create(SlashArts.REGISTRY_KEY, MODID);
    public static final DeferredRegister<SpecialEffect> REGISTRY_KEY2= DeferredRegister.create(SpecialEffect.REGISTRY_KEY, MODID);

    public static final ResourceLocation HosSummonSword = new ResourceLocation(MODID, classToString(HosSummonSwordEntity.class));
    public static EntityType<HosSummonSwordEntity> HSS;
    public static final RegistryObject<SlashArts> HosSwords;
    public static final RegistryObject<SpecialEffect> HosSword;
    public static final RegistryObject<SpecialEffect> ARK;
    public static final RegistryObject<ComboState> Hss =COMBO_STATES.register("hss",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> Hoss.doSlash(entityIn,false,15,3F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public  void register1(RegisterEvent event){
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<HosSummonSwordEntity> entity = HSS = EntityType.Builder
                        .of(HosSummonSwordEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(HosSummonSwordEntity::createInstance)
                        .build(HosSummonSword.toString());
                helper.register(HosSummonSword, entity);

            }

    });
    }
    public  void register(IEventBus modeventbus) {
        COMBO_STATES.register(modeventbus);
        SLASH_ARTS.register(modeventbus);
        REGISTRY_KEY2.register(modeventbus);
        ENTITIES.register(modeventbus);
        modeventbus.addListener(this::register1);
    }
    static {
        HosSword=REGISTRY_KEY2.register("hossword",HosSword::new);
        ARK=REGISTRY_KEY2.register("ark", Ark::new);
        HosSwords=SLASH_ARTS.register("hosswords",(() -> new SlashArts((e) ->Hss.getId())));
    }
}
