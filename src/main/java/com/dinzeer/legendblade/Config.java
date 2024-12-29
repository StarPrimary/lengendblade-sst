package com.dinzeer.legendblade;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = Legendblade.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue open_damege_fix = BUILDER
            .comment("Whether to enable abnormal damage repair")
            .comment("是否启用平衡捍卫者")
            .define("open_damege_fix", false);
    private static final ForgeConfigSpec.ConfigValue<Double> damegeadd = BUILDER
            .comment("The forging number affects the sa and se ratio, with a default forging ratio of 1 and an additional ratio of 0.1")
            .comment("锻数影响sa倍率，默认1锻造：0.1额外倍率（已不再维护）")
            .define("damegeadd", 0.1);
    private static final ForgeConfigSpec.ConfigValue<Double> damegeaddmax = BUILDER
            .comment("damegeadd max if 0 is off")
            .comment("锻造数影响倍率上限，0为关闭（已不在维护）")
            .define("damegeaddmax", 0.0);
    private static final ForgeConfigSpec.BooleanValue sevenbladeskill = BUILDER
            .comment("seven sword kill or no kill")
            .comment("魔刀sa是否靠杀敌启动")
            .define("sevenbladeskill", true);
    private static final ForgeConfigSpec.ConfigValue<Double> Soul_crystal = BUILDER
            .comment("soul crystal loot")
            .comment("魂缚晶的掉落要求血量（看基础值）")
            .define("soul_crystal", 200.0);
    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean Open_damege_fix;
    public static double damegeaddd;
    public static double damegeadddmaX;
    public static boolean sevenbladesKill;
    public static double soul_crystal;
    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        Open_damege_fix = open_damege_fix.get();
        damegeaddd=damegeadd.get();
        damegeadddmaX=damegeaddmax.get();
        sevenbladesKill=sevenbladeskill.get();
        soul_crystal=Soul_crystal.get();
    }
}
