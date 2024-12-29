package com.dinzeer.legendblade.regsitry.other;

import com.dinzeer.legendblade.entity.*;
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

public class LBEntiteRegristrys {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    public static final ResourceLocation SSLOC = new ResourceLocation(MODID, classToString(SumonSwordEntity.class));
    public static EntityType<SumonSwordEntity> ss;
    public static final ResourceLocation SDLOC = new ResourceLocation(MODID, classToString(DriveSummonEntity.class));
    public static EntityType<DriveSummonEntity> sd;
    public static final ResourceLocation SSEXLOC = new ResourceLocation(MODID, classToString(SumonSwordEntityEX.class));
    public static EntityType<SumonSwordEntityEX> ssex;
    public static final ResourceLocation SSDOLOC = new ResourceLocation(MODID, classToString(DriveSummonEntityOne.class));
    public static EntityType<DriveSummonEntityOne> ssdo;
    public static final ResourceLocation maloc = new ResourceLocation(MODID, classToString(SevenSkillField.class));
    public static EntityType<SevenSkillField> ma;
    public static final ResourceLocation MDLOC = new ResourceLocation(MODID, classToString(MoonDriveEntity.class));
    public static EntityType<MoonDriveEntity> md;
    public static final ResourceLocation spsLOC = new ResourceLocation(MODID, classToString(SpSumonSwordEntity.class));
    public static EntityType<SpSumonSwordEntity> sps;
    public static final ResourceLocation dbfloc = new ResourceLocation(MODID, classToString(DemonBladeFragments.class));
    public static EntityType<DemonBladeFragments> dbf;
    public static final ResourceLocation srloc = new ResourceLocation(MODID, classToString(SwordRainEntity.class));
    public static EntityType<SwordRainEntity> sr;
    public static void register(RegisterEvent event){

        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SumonSwordEntity> entity = ss = EntityType.Builder
                        .of(SumonSwordEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SumonSwordEntity::createInstance)
                        .build(SSLOC.toString());
                helper.register(SSLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<DriveSummonEntity> entity = sd = EntityType.Builder
                        .of(DriveSummonEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(DriveSummonEntity::createInstance)
                        .build(SDLOC.toString());
                helper.register(SDLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SumonSwordEntityEX> entity = ssex = EntityType.Builder
                        .of(SumonSwordEntityEX::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SumonSwordEntityEX::createInstance)
                        .build(SSEXLOC.toString());
                helper.register(SSEXLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<DriveSummonEntityOne> entity = ssdo = EntityType.Builder
                        .of(DriveSummonEntityOne::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(DriveSummonEntityOne::createInstance)
                        .build(SSDOLOC.toString());
                helper.register(SSDOLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SevenSkillField> entity = ma = EntityType.Builder
                        .of(SevenSkillField::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SevenSkillField::createInstance)
                        .build(maloc.toString());
                helper.register(maloc, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<MoonDriveEntity> entity = md = EntityType.Builder
                        .of(MoonDriveEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(MoonDriveEntity::createInstance)
                        .build(MDLOC.toString());
                helper.register(MDLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SpSumonSwordEntity> entity = sps = EntityType.Builder
                        .of(SpSumonSwordEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SpSumonSwordEntity::createInstance)
                        .build(spsLOC.toString());
                helper.register(spsLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<DemonBladeFragments> entity = dbf = EntityType.Builder
                        .of(DemonBladeFragments::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(DemonBladeFragments::createInstance)
                        .build(dbfloc.toString());
                helper.register(dbfloc, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SwordRainEntity> entity = sr = EntityType.Builder
                        .of(SwordRainEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SwordRainEntity::createInstance)
                        .build(srloc.toString());
                helper.register(srloc, entity);
            }

        });
    }


    public static String classToString(Class<? extends Entity> entityClass)
    {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName())
                .replace("entity_", "");
    }






}










