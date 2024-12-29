package com.dinzeer.legendblade.regsitry.compat;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.entity.Compat.FireSummonSwordEntity;
import com.dinzeer.legendblade.entity.Compat.IceSummonSwordEntity;
import com.dinzeer.legendblade.entity.Compat.LightningSummonSwordEntity;
import com.dinzeer.legendblade.entity.SevenSkillField;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.google.common.base.CaseFormat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class ICFEntiyRegsitry {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    public  void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
        eventBus.addListener(this::register1);
    }
    public static final ResourceLocation LightningSummonSwordEntityLOC = new ResourceLocation(MODID, classToString(LightningSummonSwordEntity.class));
    public static EntityType<LightningSummonSwordEntity> LSS;
    public static final ResourceLocation FireSummonSwordEntityLOC = new ResourceLocation(MODID, classToString(FireSummonSwordEntity.class));
    public static EntityType<FireSummonSwordEntity> FSFE;
    public static final ResourceLocation IceSummonSwordEntityLOC = new ResourceLocation(MODID, classToString(IceSummonSwordEntity.class));
    public static EntityType<IceSummonSwordEntity> ISSE;
    public  void register1(RegisterEvent event){
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<LightningSummonSwordEntity> entity = LSS = EntityType.Builder
                        .of(LightningSummonSwordEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(LightningSummonSwordEntity::createInstance)
                        .build(LightningSummonSwordEntityLOC.toString());
                helper.register(LightningSummonSwordEntityLOC, entity);

            }


        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {


                {
                    EntityType<FireSummonSwordEntity> entity = FSFE = EntityType.Builder
                            .of(FireSummonSwordEntity::new, MobCategory.MISC)
                            .sized(0.9F, 0.9F)
                            .setTrackingRange(4)
                            .setUpdateInterval(20).setCustomClientFactory(FireSummonSwordEntity::createInstance)
                            .build(FireSummonSwordEntityLOC.toString());
                    helper.register(FireSummonSwordEntityLOC, entity);
                }

    });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {


            {
                EntityType<IceSummonSwordEntity> entity = ISSE = EntityType.Builder
                        .of(IceSummonSwordEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(IceSummonSwordEntity::createInstance)
                        .build(IceSummonSwordEntityLOC.toString());
                helper.register(IceSummonSwordEntityLOC, entity);
            }

        });

    }
    public static boolean isICFENTITY(Entity entity){
        return ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith(IceAndFire.MODID);
    }

    public static String classToString(Class<? extends Entity> entityClass)
    {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName())
                .replace("entity_", "");
    }

}
