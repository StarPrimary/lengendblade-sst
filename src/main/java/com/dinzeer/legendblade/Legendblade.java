package com.dinzeer.legendblade;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import com.dinzeer.legendblade.effect.MoDaoEffect;
import com.dinzeer.legendblade.effect.SumeruEffect;
import com.dinzeer.legendblade.entity.DemonBladeFragments;
import com.dinzeer.legendblade.network.DemonBladeMessage;
import com.dinzeer.legendblade.network.DemonBladeMessageA;
import com.dinzeer.legendblade.regsitry.compat.*;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.dinzeer.legendblade.regsitry.other.LBSounds;
import com.dinzeer.legendblade.regsitry.other.LangRegsitry;
import com.dinzeer.legendblade.regsitry.slashblade.LBComboRegsitry;
import com.dinzeer.legendblade.regsitry.slashblade.LBComboRegsitryA;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.regsitry.slashblade.LBslashArtRegsitry;
import com.exfantasy.mclib.Utils.Dash.DashMessage;
import com.dinzeer.legendblade.effect.HitDamageEffect;
import com.dinzeer.legendblade.effect.StrengthBoost;
import com.dinzeer.legendblade.regsitry.other.LBModItems;
import com.dinzeer.legendblade.regsitry.creativetab.ItemTab;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import dev.xkmc.l2hostility.init.L2Hostility;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import twilightforest.TwilightForestMod;


@Mod(Legendblade.MODID)
public class Legendblade {


    public static ResourceLocation prefix(String path) {

        return new ResourceLocation(MODID, path);
    }


    public static final String MODID = "legendblade";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final Registrate REGISTRATE = Registrate.create(MODID);


    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MODID, "main"),
            () -> "1.0",
            s -> true,
            s -> true
    );



    public Legendblade() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        LangRegsitry.registerAddlang();
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::register);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
         LBEntiteRegristrys.register(modEventBus);
        LBComboRegsitry.COMBO_STATES.register(modEventBus);
        LBComboRegsitryA.COMBO_STATES.register(modEventBus);
        LBSpecialEffectsRegistry.REGISTRY_KEY2.register(modEventBus);
        EffectAbout.REGISTRY.register(modEventBus);
        LBslashArtRegsitry.SLASH_ARTS.register(modEventBus);
        LBModItems.register();
        if (ModList.get().isLoaded(IceAndFire.MODID)){

            new ICFEntiyRegsitry().register(modEventBus);
            ICFLBcompatRegsitry.register(modEventBus);
        }
        LBSounds.REGISTRY.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        if (ModList.get().isLoaded(L2Hostility.MODID)){

          new L2LBcompatRegsitry().register(modEventBus);
        }
        ItemTab.REGISTRY.register(modEventBus);
        if (ModList.get().isLoaded(SlashBladeAddon.MODID)){
            SBALBSlashArtRegsitry.register(modEventBus);
        }
        if (ModList.get().isLoaded(TwilightForestMod.ID)){
            TFLBcompat.register(modEventBus);
        }
        int id = 0;
        INSTANCE.messageBuilder(DashMessage.class, id++)
                .encoder(DashMessage::encode)
                .decoder(DashMessage::decode)
                .consumerMainThread(DashMessage::handle)
                .add();
        INSTANCE.registerMessage(id++, DemonBladeMessage.class, DemonBladeMessage::encode, DemonBladeMessage::new, DemonBladeMessage::handle);
        INSTANCE.registerMessage(id++, DemonBladeMessageA.class, DemonBladeMessageA::encode, DemonBladeMessageA::new, DemonBladeMessageA::handle);
    }
    public void register(RegisterEvent event) {
        LBEntiteRegristrys.register(event);



    }
    public static class EffectAbout{
        public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Legendblade.MODID);
        public static final RegistryObject<StrengthBoost> STRENGTH_BOOST = REGISTRY.register("strength_boost", StrengthBoost::new);
        public static final RegistryObject<HitDamageEffect> HIT_DAMAGE = REGISTRY.register("hit_damage", HitDamageEffect::new);
        public static final RegistryObject<SumeruEffect> SUMERU = REGISTRY.register("sumeru", SumeruEffect::new);
        public static final RegistryObject<MoDaoEffect> MO_DAO = REGISTRY.register("mo_dao", MoDaoEffect::new);
    }
}
