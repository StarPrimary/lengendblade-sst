package com.dinzeer.legendblade.data;

import cn.mmf.slashblade_addon.registry.SBASlashArtsRegistry;
import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.regsitry.compat.ICFLBcompatRegsitry;
import com.dinzeer.legendblade.regsitry.compat.TFLBcompat;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.regsitry.slashblade.LBslashArtRegsitry;
import com.dinzeer.legendblade.regsitry.compat.L2LBcompatRegsitry;
import com.dinzeer.legendblade.regsitry.compat.SBALBSlashArtRegsitry;
import dev.xkmc.l2complements.init.registrate.LCEnchantments;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.registry.SlashArtsRegistry;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.PropertiesDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.RenderDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class LegendBuiltInRegsitry {
    //伪死念
    public static final ResourceKey<SlashBladeDefinition> NIHILEXFAKE;
    //血腥
    public static final ResourceKey<SlashBladeDefinition> BLOODKATANA;
    //真红
    public static final ResourceKey<SlashBladeDefinition> SHINKU;
    //妖刀「神狐」
    public static final ResourceKey<SlashBladeDefinition> GODFOX;
    //锈迹斑斑的刀
    public static final ResourceKey<SlashBladeDefinition> RUSTGODFOX;
    //木鞘「刃条」
    public static final ResourceKey<SlashBladeDefinition> stickgodfox;
    //御神灵刀「神狐」
    public static final ResourceKey<SlashBladeDefinition> NEOGODFOX;
    //木鞘「神狐」
    public static final ResourceKey<SlashBladeDefinition> WHITEGODFOX;
    //御神刀「神狐」
    public static final ResourceKey<SlashBladeDefinition> TRUEGODFOX;
    //恶
    public static final ResourceKey<SlashBladeDefinition> evil;
    //一代色欲
    public static final ResourceKey<SlashBladeDefinition> asmodeus;
    //一代暴食
    public static final ResourceKey<SlashBladeDefinition> beelzebub;
    //一代懒惰
    public static final ResourceKey<SlashBladeDefinition> belphegor;
    //一代嫉妒
    public static final ResourceKey<SlashBladeDefinition> leviathan;
    //一代傲慢
    public static final ResourceKey<SlashBladeDefinition> lucifer;
    //一代贪婪
    public static final ResourceKey<SlashBladeDefinition> mammon;
    //一代愤怒
    public static final ResourceKey<SlashBladeDefinition> samael;
    //EX色欲
    public static final ResourceKey<SlashBladeDefinition> asmodeusex;
    //EX暴食
    public static final ResourceKey<SlashBladeDefinition> beelzebubex;
    //EX懒惰
    public static final ResourceKey<SlashBladeDefinition> belphegorex;
    //EX恶
    public static final ResourceKey<SlashBladeDefinition> evilex;
    //EX嫉妒
    public static final ResourceKey<SlashBladeDefinition> leviathanex;
    //EX傲慢
    public static final ResourceKey<SlashBladeDefinition> luciferex;
    //EX贪婪
    public static final ResourceKey<SlashBladeDefinition> mammonex;
    //EX愤怒
    public static final ResourceKey<SlashBladeDefinition> samaelex;
    //ex白狐
    public static final ResourceKey<SlashBladeDefinition> foxex;
    //ex黑狐
    public static final ResourceKey<SlashBladeDefinition> foxex2;
    //exex灵刃狐月刀
    public static final ResourceKey<SlashBladeDefinition> foxexfinal;
    //无九
    public static final ResourceKey<SlashBladeDefinition> wujiu;
    //原罪交响曲·贝尔西普
    public static final ResourceKey<SlashBladeDefinition> belphebubex;
    //乌卡EX
    public static final ResourceKey<SlashBladeDefinition> waterex;
    //阿贝EX
    public static final ResourceKey<SlashBladeDefinition> fireex;
    //坎娜EX
    public static final ResourceKey<SlashBladeDefinition> lightningex;
    //魔刀千刃
    public static final ResourceKey<SlashBladeDefinition> sevensword;
    //毕方
    public static final ResourceKey<SlashBladeDefinition> godbird;
    //红樱ex
    public static final ResourceKey<SlashBladeDefinition> crimsoncherryex;
    //荧光惊异
    public static final ResourceKey<SlashBladeDefinition> amazedshine;
    //狱刀ex
    public static final ResourceKey<SlashBladeDefinition> nihilulex;
    //炼狱刀死念ex
    public static final ResourceKey<SlashBladeDefinition> nihilbxex;
    //恶太刀「破法」
    public static final ResourceKey<SlashBladeDefinition> ark;
    //破法EX
    public static final ResourceKey<SlashBladeDefinition> neo;
    //管理员之刃「伪物」
    public static final ResourceKey<SlashBladeDefinition> administrator;
    //血羽「邪凤」
    public static final ResourceKey<SlashBladeDefinition> demonbird;
    //龙骨刀「烈火」
    public static final ResourceKey<SlashBladeDefinition> fire;
    //龙骨刀「怒雷」
    public static final ResourceKey<SlashBladeDefinition> ice;
    //龙骨刀「天寒」
    public static final ResourceKey<SlashBladeDefinition> lightning;
    //柱子的刀
    public static final ResourceKey<SlashBladeDefinition> zhuzi;
    //龙钢猎刃「怒焰」
    public static final ResourceKey<SlashBladeDefinition> blaze;
    //龙钢猎刃「天霆」
    public static final ResourceKey<SlashBladeDefinition> zerogalaxy;
    //龙钢猎刃「永霜」
    public static final ResourceKey<SlashBladeDefinition> foreverice;
    //妖魔刀「血狐」
    public static final ResourceKey<SlashBladeDefinition> truebloodfox;
    //痛刀「爱莉」
    public static final ResourceKey<SlashBladeDefinition> eiily;
    //现世刀「斩月」
    public static final ResourceKey<SlashBladeDefinition> zangetsu;
    //铭刀「蟾宫」
    public static final ResourceKey<SlashBladeDefinition> frog;
    //铭刀「鱼音」
    public static final ResourceKey<SlashBladeDefinition> fish;
    //天锁斩月
    public static final ResourceKey<SlashBladeDefinition> tensazangetsu;
    //红「天锁斩月」
    public static final ResourceKey<SlashBladeDefinition> tensazangetsured;
    //物理学圣剑
    public static final ResourceKey<SlashBladeDefinition> crowbar;
    //彩虹之剑
    public static final ResourceKey<SlashBladeDefinition> rainbow;
    //§4§o铭刀「悭臾」
    public static final ResourceKey<SlashBladeDefinition> undragon;
    //骑士刃「甲穿」
    public static final ResourceKey<SlashBladeDefinition> breakarm;
    //冰晶刃「寒流」
    public static final ResourceKey<SlashBladeDefinition> allice;
    //炽铁刃「炎灼」
    public static final ResourceKey<SlashBladeDefinition> fireiron;
    static {
        SHINKU=register("shinku");
        BLOODKATANA=register("bloodkatana");
        NIHILEXFAKE=register("nihilexfake");
        TRUEGODFOX=register("truegodfox");
        evil=register("evil");
        asmodeus=register("asmodeus");
        beelzebub=register("beelzebub");
        belphegor=register("belphegor");
        leviathan=register("leviathan");
        lucifer=register("lucifer");
        mammon=register("mammon");
        samael=register("samael");
        asmodeusex=register("asmodeusex");
        beelzebubex=register("beelzebubex");
        belphegorex=register("belphegorex");
        leviathanex=register("leviathanex");
        luciferex=register("luciferex");
        mammonex=register("mammonex");
        samaelex=register("samaelex");
        evilex=register("evilex");
        foxex=register("foxex");
        foxex2=register("foxex2");
        foxexfinal=register("foxexfinal");
        GODFOX=register("godfox");
        RUSTGODFOX=register("rustgodfox");
        stickgodfox=register("stickgodfox");
        NEOGODFOX=register("neogodfox");
        WHITEGODFOX=register("whitegodfox");
        wujiu=register("wujiu");
        belphebubex=register("belphebubex");
        waterex=register("waterex");
        fireex=register("fireex");
        lightningex=register("lightningex");
        sevensword=register("sevensword");
        godbird=register("godbird");
        crimsoncherryex=register("crimsoncherryex");
        amazedshine=register("amazedshine");
        nihilulex=register("nihilulex");
        nihilbxex=register("nihilbxex");
        ark=register("ark");
        neo=register("neo");

        administrator=register("administrator");
        demonbird=register("demonbird");
        fire=register("dragon_fire");
        ice=register("dragon_ice");
        lightning=register("dragon_lightning");
        zhuzi=register("zhuzi");
        blaze=register("blaze");
        zerogalaxy=register("zerogalaxy");
        foreverice=register("foreverice");
        truebloodfox=register("truebloodfox");
        eiily=register("eiily");
        zangetsu=register("zangetsu");
        frog=register("frog");
        fish=register("fish");
        tensazangetsu=register("tensazangetsu");
        tensazangetsured=register("tensazangetsured");
        crowbar=register("crowbar");
        rainbow=register("rainbow");

        undragon=register("undragon");
        breakarm=register("breakarm");
        allice=register("allice");
        fireiron=register("fireiron");
    }
    public static void registerAll(BootstapContext<SlashBladeDefinition> bootstrap) {

        bootstrap.register(
                NIHILEXFAKE, new SlashBladeDefinition(Legendblade.prefix("nihilexfake"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/nihilexfake/texture.png"))
                                .modelName(Legendblade.prefix("model/named/nihilexfake/model.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(10)
                                .maxDamage(80)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                BLOODKATANA, new SlashBladeDefinition(Legendblade.prefix("bloodkatana"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/bloodkatanat/texture.png"))
                                .modelName(Legendblade.prefix("model/named/bloodkatanat/model.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(25)
                                .slashArtsType(LBslashArtRegsitry.HPC.getId())
                                .maxDamage(80)
                                .addSpecialEffect(LBSpecialEffectsRegistry.BAdBlood.getId())
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 5)

                        )
                ));
        bootstrap.register(
                SHINKU, new SlashBladeDefinition(Legendblade.prefix("shinku"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/shinku/texture.png"))
                                .modelName(Legendblade.prefix("model/named/shinku/model.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(25)
                                .slashArtsType(LBslashArtRegsitry.HP.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.BLadeAttack.getId())
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 6),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 5)

                        )
                ));
        bootstrap.register(
                GODFOX, new SlashBladeDefinition(Legendblade.prefix("godfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/godfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/godfox/model.obj"))
                                .effectColor(15906304)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.MP.getId())
                                .baseAttackModifier(18)
                                .maxDamage(80)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.RESPIRATION), 1)

                        )
                ));

        bootstrap.register(
                RUSTGODFOX, new SlashBladeDefinition(Legendblade.prefix("rustgodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/rustgodfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(5)
                                .maxDamage(80)
                                .build(),
                        List.of()
                ));

        bootstrap.register(
                stickgodfox, new SlashBladeDefinition(Legendblade.prefix("stickgodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/stickgodfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/stickgodfox/model.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(10)
                                .slashArtsType(SlashArtsRegistry.DRIVE_HORIZONTAL.getId())
                                .maxDamage(80)
                                .build(),
                        List.of()
                ));

        bootstrap.register(
                NEOGODFOX, new SlashBladeDefinition(Legendblade.prefix("neogodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/neogodfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/neogodfox/model.obj"))
                                .effectColor(15906304)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(LBSpecialEffectsRegistry.BlessingSummonSword.getId())
                                .slashArtsType(LBslashArtRegsitry.MPSS.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(24)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.RESPIRATION), 1)
                        )
                ));

        bootstrap.register(
                WHITEGODFOX, new SlashBladeDefinition(Legendblade.prefix("whitegodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/whitegodfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/whitegodfox/model.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(12)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(80)
                                .build(),
                        List.of()
                ));

        bootstrap.register(
                TRUEGODFOX, new SlashBladeDefinition(Legendblade.prefix("truegodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/truegodfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/truegodfox/model.obj"))
                                .effectColor(15906304)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(LBSpecialEffectsRegistry.BLESSING.getId())
                                .slashArtsType(LBslashArtRegsitry.PROWESS.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(22)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.RESPIRATION), 1)
                        )
                ));


        bootstrap.register(
                evil, new SlashBladeDefinition(Legendblade.prefix("evil"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/unnamed/evil.png"))
                                .modelName(Legendblade.prefix("model/unnamed/evil.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(8)
                                .slashArtsType(SlashArtsRegistry.NONE.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .maxDamage(80)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                asmodeus, new SlashBladeDefinition(Legendblade.prefix("asmodeus"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/asmodeus/asmodeus.png"))
                                .modelName(Legendblade.prefix("model/named/asmodeus/asmodeus.obj"))
                                .effectColor(5898495)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.PhantomThrust.getId())
                                .baseAttackModifier(15)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 1))
                ));
        bootstrap.register(
                beelzebub, new SlashBladeDefinition(Legendblade.prefix("beelzebub"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/beelzebub/beelzebub.png"))
                                .modelName(Legendblade.prefix("model/named/beelzebub/beelzebub.obj"))
                                .effectColor(65298)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.HungerAbsorption.getId())
                                .baseAttackModifier(16)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 1))
                ));
        bootstrap.register(
                belphegor, new SlashBladeDefinition(Legendblade.prefix("belphegor"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/belphegor/belphegor.png"))
                                .modelName(Legendblade.prefix("model/named/belphegor/belphegor.obj"))
                                .effectColor(8703)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(LBslashArtRegsitry.soullock.getId())
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 4),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_EFFICIENCY), 2))
                ));

        bootstrap.register(
                leviathan, new SlashBladeDefinition(Legendblade.prefix("leviathan"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/leviathan/leviathan.png"))
                                .modelName(Legendblade.prefix("model/named/leviathan/leviathan.obj"))
                                .effectColor(65499)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.flurry.getId())
                                .baseAttackModifier(15)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 2))
                ));
        bootstrap.register(
                lucifer, new SlashBladeDefinition(Legendblade.prefix("lucifer"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/lucifer/lucifer.png"))
                                .modelName(Legendblade.prefix("model/named/lucifer/lucifer.obj"))
                                .effectColor(16514816)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.Thatcher.getId())
                                .baseAttackModifier(16)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 1),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 2))
                ));

        bootstrap.register(
                mammon, new SlashBladeDefinition(Legendblade.prefix("mammon"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/mammon/mammon.png"))
                                .modelName(Legendblade.prefix("model/named/mammon/mammon.obj"))
                                .effectColor(16737792)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.GreedyGrip.getId())
                                .baseAttackModifier(16)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 1),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.PUNCH_ARROWS), 1)))
                );
        bootstrap.register(
                samael, new SlashBladeDefinition(Legendblade.prefix("samael"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/samael/samael.png"))
                                .modelName(Legendblade.prefix("model/named/samael/samael.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.Splitapart.getId())
                                .baseAttackModifier(18)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 1),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 1)
                        )
                ));
        bootstrap.register(
                asmodeusex, new SlashBladeDefinition(Legendblade.prefix("asmodeusex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/asmodeusex/asmodeusex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/asmodeusex/asmodeusex.obj"))
                                .effectColor(5898495)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.PhantomThrust.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.poison.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .baseAttackModifier(21)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 3)
                        )
                ));
        bootstrap.register(
                beelzebubex, new SlashBladeDefinition(Legendblade.prefix("beelzebubex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/beelzebubex/beelzebubex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/beelzebubex/beelzebubex.obj"))
                                .effectColor(65298)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.HungerAbsorption.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Feastful.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5)
                        )
                ));
        bootstrap.register(
                belphegorex, new SlashBladeDefinition(Legendblade.prefix("belphegorex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/belphegorex/belphegorex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/belphegorex/belphegorex.obj"))
                                .effectColor(8703)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.soullock.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Shackles.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .baseAttackModifier(16)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_EFFICIENCY), 3)
                        )
                ));
        bootstrap.register(
                evilex, new SlashBladeDefinition(Legendblade.prefix("evilex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/evilex/evilex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/evilex/evilex.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(10)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .maxDamage(80)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                leviathanex, new SlashBladeDefinition(Legendblade.prefix("leviathanex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/leviathanex/leviathanex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/leviathanex/leviathanex.obj"))
                                .effectColor(65499)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.flurry.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Resentment.getId())
                                .baseAttackModifier(19)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 7)
                        )
                ));
        bootstrap.register(
                luciferex, new SlashBladeDefinition(Legendblade.prefix("luciferex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/luciferex/luciferex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/luciferex/luciferex.obj"))
                                .effectColor(16514816)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Suppress.getId())
                                .slashArtsType(LBslashArtRegsitry.Thatcher.getId())
                                .baseAttackModifier(18)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 6),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 7)
                        )
                ));
        bootstrap.register(
                mammonex, new SlashBladeDefinition(Legendblade.prefix("mammonex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/mammonex/mammonex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/mammonex/mammonex.obj"))
                                .effectColor(16737792)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(LBslashArtRegsitry.GreedyGrip.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Endless.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.PUNCH_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MENDING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 7)
                        )
                ));
        bootstrap.register(
                samaelex, new SlashBladeDefinition(Legendblade.prefix("samaelex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/samaelex/samaelex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/samaelex/samaelex.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.Splitapart.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Bloodthirsty.getId())
                                .baseAttackModifier(25)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 6),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 6),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 7)
                        )
                ));
        bootstrap.register(
                foxex, new SlashBladeDefinition(Legendblade.prefix("foxex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/foxex/texture.png"))
                                .modelName(Legendblade.prefix("model/foxex/model.obj"))
                                .effectColor(16187647)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.FoxBlessing.getId())
                                .slashArtsType(LBslashArtRegsitry.VoidSlashPlus.getId())
                                .baseAttackModifier(22)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3)
                        )
                ));
        bootstrap.register(
                foxex2, new SlashBladeDefinition(Legendblade.prefix("foxex2"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/foxex/texture2.png"))
                                .modelName(Legendblade.prefix("model/foxex/model.obj"))
                                .effectColor(2633861)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.FoxBlessing.getId())
                                .slashArtsType(LBslashArtRegsitry.Thrust.getId())
                                .baseAttackModifier(22)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3)
                        )
                ));
        bootstrap.register(
                foxexfinal, new SlashBladeDefinition(Legendblade.prefix("foxexfinal"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/foxex/texture3.png"))
                                .effectColor(16187647)
                                .modelName(Legendblade.prefix("model/foxex/model2.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.SAKURAENDEX.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.SummonSword.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.FoxBlessing.getId())
                                .baseAttackModifier(35)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                        )
                ));
        bootstrap.register(
                wujiu, new SlashBladeDefinition(Legendblade.prefix("wujiu"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/yaoxing/wujiu.png"))
                                .modelName(Legendblade.prefix("model/yaoxing/wujiu.obj"))
                                .effectColor(12434877)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.swordone.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Liuli.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Liulione.getId())
                                .baseAttackModifier(30)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.ALL_DAMAGE_PROTECTION), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 5)

                        )
                ));

        bootstrap.register(
                belphebubex, new SlashBladeDefinition(Legendblade.prefix("belphebubex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/beelzebubex/beelzebubexex_export.png"))
                                .modelName(Legendblade.prefix("model/bladeex/beelzebubex/beelzebubex.obj"))
                                .effectColor(65298)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.HungerAbsorption.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Feastful.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Shackles.getId())
                                .baseAttackModifier(25)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5)
                        )
                ));

        bootstrap.register(
                waterex, new SlashBladeDefinition(Legendblade.prefix("waterex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/kaumyex/water.png"))
                                .modelName(Legendblade.prefix("model/kaumyex/kamuyex.obj"))
                                .effectColor(8703)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SBALBSlashArtRegsitry.terrifyingwavesSA.getId())
                                .addSpecialEffect(SBALBSlashArtRegsitry.Terrifyingwaves.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5)
                        )
                ));
        bootstrap.register(
                fireex, new SlashBladeDefinition(Legendblade.prefix("fireex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/kaumyex/fire.png"))
                                .modelName(Legendblade.prefix("model/kaumyex/kamuyex.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SBALBSlashArtRegsitry.DanceSA.getId())
                                .addSpecialEffect(SBALBSlashArtRegsitry.FireDancy.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5)
                        )
                ));
        bootstrap.register(
                lightningex, new SlashBladeDefinition(Legendblade.prefix("lightningex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/kaumyex/lightning.png"))
                                .modelName(Legendblade.prefix("model/kaumyex/kamuyex.obj"))
                                .effectColor(16766720)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SBALBSlashArtRegsitry.lightingsumSA.getId())
                                .addSpecialEffect(SBALBSlashArtRegsitry.Lightingsum.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 15),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7)
                        )
                ));
        bootstrap.register(
                sevensword, new SlashBladeDefinition(Legendblade.prefix("sevensword"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/sevensword/texture.png"))
                                .modelName(Legendblade.prefix("model/sevensword/model.obj"))
                                .effectColor(10289407)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(30)
                                .slashArtsType(LBslashArtRegsitry.sevenbladeslash.getId())
                                .maxDamage(80)
                                .addSpecialEffect(LBSpecialEffectsRegistry.FragmentedEdge.getId())
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 15),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10)
                        )
                ));
        bootstrap.register(
                godbird, new SlashBladeDefinition(Legendblade.prefix("godbird"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/godbird/texture.png"))
                                .modelName(Legendblade.prefix("model/godbird/model.obj"))
                                .effectColor(65343)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(LBslashArtRegsitry.Thrusts.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 10)
                        )
                ));

        bootstrap.register(
                crimsoncherryex, new SlashBladeDefinition(Legendblade.prefix("crimsoncherryex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/nihill/crimsoncherry.png"))
                                .modelName(Legendblade.prefix("model/nihill/nihilbloodex.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.SAKURA_END.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.EndSakuraRiseUp.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 5)
                        )
                ));
        bootstrap.register(
                amazedshine, new SlashBladeDefinition(Legendblade.prefix("amazedshine"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/testmyability/testmyability.png"))
                                .modelName(Legendblade.prefix("model/testmyability/testmyability.obj"))
                                .effectColor(16769536)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.SlashShine.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.TheShineSummonSword.getId())
                                .baseAttackModifier(23)
                                .maxDamage(300)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.INFINITY_ARROWS), 10)
                        )
                ));
        bootstrap.register(
                nihilulex, new SlashBladeDefinition(Legendblade.prefix("nihilulex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/nihill/nihilul.png"))
                                .modelName(Legendblade.prefix("model/nihill/nihilbloodex.obj"))
                                .effectColor(16187647)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.WaveEdgeRiseUp.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 5)
                        )
                ));
        bootstrap.register(
                nihilbxex, new SlashBladeDefinition(Legendblade.prefix("nihilbxex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/nihill/nihilbx.png"))
                                .modelName(Legendblade.prefix("model/nihill/nihilbloodex.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.SAKURAENDEX.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.EndSakuraRiseUp.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.WaveEdgeRiseUp.getId())
                                .baseAttackModifier(35)
                                .maxDamage(80)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 15),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MENDING), 10)
                        )
                ));
        bootstrap.register(
                ark, new SlashBladeDefinition(Legendblade.prefix("ark"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/ark/ark.png"))
                                .modelName(Legendblade.prefix("model/ark/ark.obj"))
                                .effectColor(10289407)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(L2LBcompatRegsitry.HosSword.getId())
                                .slashArtsType(L2LBcompatRegsitry.HosSwords.getId())
                                .baseAttackModifier(15)
                                .maxDamage(80)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                neo, new SlashBladeDefinition(Legendblade.prefix("neo"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/ark/neo.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icf/model.obj"))
                                .effectColor(10289407)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(L2LBcompatRegsitry.HosSwords.getId())
                                .addSpecialEffect(L2LBcompatRegsitry.HosSword.getId())
                                .addSpecialEffect(L2LBcompatRegsitry.ARK.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(LCEnchantments.FLAME_BLADE.get()), 3),
                                new EnchantmentDefinition(getEnchantmentID(LCEnchantments.SHARP_BLADE.get()), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10)

                        )

                ));
        bootstrap.register(
                administrator, new SlashBladeDefinition(Legendblade.prefix("administrator"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/administrator/administrator.png"))
                                .modelName(Legendblade.prefix("model/administrator/administrator.obj"))
                                .effectColor(14591)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(20)
                                .slashArtsType(LBslashArtRegsitry.delete.getId())
                                .maxDamage(80)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10)

                        )
                ));
        bootstrap.register(
                demonbird, new SlashBladeDefinition(Legendblade.prefix("demonbird"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/blood/demonbird/texture.png"))
                                .modelName(Legendblade.prefix("model/godbird/model.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(LBslashArtRegsitry.BloodThrusts.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3)
                        )
                ));
        bootstrap.register(
                fire, new SlashBladeDefinition(Legendblade.prefix("dragon_fire"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icf/fire.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icf/model.obj"))
                                .effectColor(16477711)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(ICFLBcompatRegsitry.fire.getId())
                                .slashArtsType(ICFLBcompatRegsitry.Firesummonsword.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(13)
                                .maxDamage(80)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10)
                        )
                ));
        bootstrap.register(
                ice, new SlashBladeDefinition(Legendblade.prefix("dragon_ice"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icf/ice.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icf/model.obj"))
                                .effectColor(46079)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(ICFLBcompatRegsitry.ice.getId())
                                .slashArtsType(ICFLBcompatRegsitry.Icesummonsword.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(13)
                                .maxDamage(80)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10))
                ));
        bootstrap.register(
                lightning, new SlashBladeDefinition(Legendblade.prefix("dragon_lightning"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icf/lightning.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icf/model.obj"))
                                .effectColor(8847615)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(ICFLBcompatRegsitry.lightning.getId())
                                .slashArtsType(ICFLBcompatRegsitry.lightningsummonsword.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(13)
                                .maxDamage(80)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10))
                ));
        bootstrap.register(
                zhuzi, new SlashBladeDefinition(Legendblade.prefix("zhuzi"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/sange.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(1834752)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(13)
                                .maxDamage(80)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3))
                ));
        bootstrap.register(
                blaze, new SlashBladeDefinition(Legendblade.prefix("blaze"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icfex/fire.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icfex/terra.obj"))
                                .effectColor(16477711)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(ICFLBcompatRegsitry.Firesummonsword.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.fire.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.icfbreaker.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(30)
                                .maxDamage(800)
                                .build(),
                        List.of( new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10)
                        )
                ));
        bootstrap.register(
                zerogalaxy, new SlashBladeDefinition(Legendblade.prefix("zerogalaxy"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icfex/lightning.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icfex/terra.obj"))
                                .effectColor(8847615)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(ICFLBcompatRegsitry.Lightningsummonsword.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.lightning.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.icfbreaker.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(30)
                                .maxDamage(800)
                                .build(),
                        List.of( new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10)
                        )
                ));

        bootstrap.register(
                foreverice, new SlashBladeDefinition(Legendblade.prefix("foreverice"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icfex/ice.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icfex/terra.obj"))
                                .effectColor(46079)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(ICFLBcompatRegsitry.Icesummonsword.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.ice.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.icfbreaker.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(30)
                                .maxDamage(800)
                                .build(),
                        List.of( new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10)
                        )
                ));
        bootstrap.register(
                truebloodfox, new SlashBladeDefinition(Legendblade.prefix("truebloodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/blood/demonfox/demonfox.png"))
                                .modelName(Legendblade.prefix("model/named/truegodfox/model.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(LBSpecialEffectsRegistry.bloodfox.getId())
                                .slashArtsType(LBslashArtRegsitry.Splitapart.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(25)
                                .maxDamage(80)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 5)
                        )
                ));
        bootstrap.register(
                eiily, new SlashBladeDefinition(Legendblade.prefix("eiily"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/white.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(11010303)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(7)
                                .maxDamage(80)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3))
                ));
        bootstrap.register(
                zangetsu, new SlashBladeDefinition(Legendblade.prefix("zangetsu"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/zangetsu/zangetsu.png"))
                                .modelName(Legendblade.prefix("model/lostblade/zangetsu/zangetsu.obj"))
                                .effectColor(54527)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.MoonDrive.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 3)
                        )
                ));
        bootstrap.register(
                frog, new SlashBladeDefinition(Legendblade.prefix("frog"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/frog/frog.png"))
                                .modelName(Legendblade.prefix("model/lostblade/frog/frog.obj"))
                                .effectColor(16766464)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.FrogGlaxy.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5)
                        )
                ));
        bootstrap.register(
                fish, new SlashBladeDefinition(Legendblade.prefix("fish"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/fish/fish.png"))
                                .modelName(Legendblade.prefix("model/lostblade/fish/fish.obj"))
                                .effectColor(54527)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.SaveAll.getId())
                                .baseAttackModifier(17)
                                .maxDamage(80)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.ALL_DAMAGE_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SWEEPING_EDGE), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 2)
                        )
                ));
        bootstrap.register(
                tensazangetsu, new SlashBladeDefinition(Legendblade.prefix("tensazangetsu"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/tensazangetsu/texture.png"))
                                .modelName(Legendblade.prefix("model/lostblade/tensazangetsu/model.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))

                                .baseAttackModifier(17)
                                .maxDamage(80)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5)
                        )
                ));
        bootstrap.register(
                tensazangetsured, new SlashBladeDefinition(Legendblade.prefix("tensazangetsured"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/tensazangetsu/texture2.png"))
                                .modelName(Legendblade.prefix("model/lostblade/tensazangetsu/model.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))

                                .baseAttackModifier(17)
                                .maxDamage(80)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5)
                        )
                ));
        bootstrap.register(
                crowbar, new SlashBladeDefinition(Legendblade.prefix("crowbar"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/crowbar/crowbar.png"))
                                .modelName(Legendblade.prefix("model/lostblade/crowbar/crowbar.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.Elbowstrike.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.ALL_DAMAGE_PROTECTION), 5)
                        )
                ));
        bootstrap.register(
                undragon, new SlashBladeDefinition(Legendblade.prefix("undragon"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/undragon/undragon.png"))
                                .modelName(Legendblade.prefix("model/lostblade/undragon/undragon.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.swordRain.getId())
                                .baseAttackModifier(32)
                                .maxDamage(80)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 9)
                        )
                ));

        bootstrap.register(
                breakarm, new SlashBladeDefinition(Legendblade.prefix("breakarm"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/tfcompat/breakarm.png"))
                                .modelName(Legendblade.prefix("model/named/truegodfox/model.obj"))
                                .effectColor(32768)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                                .addSpecialEffect(TFLBcompat.breakarm.getId())
                                .baseAttackModifier(18)
                                .maxDamage(80)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                        )
                )
        );
        bootstrap.register(
                allice, new SlashBladeDefinition(Legendblade.prefix("allice"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/tfcompat/allice.png"))
                                .modelName(Legendblade.prefix("model/named/truegodfox/model.obj"))
                                .effectColor(54527)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.CIRCLE_SLASH.getId())
                                .addSpecialEffect(TFLBcompat.allice.getId())
                                .baseAttackModifier(20)
                                .maxDamage(80).build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                        )
                )
        );
        bootstrap.register(
                fireiron, new SlashBladeDefinition(Legendblade.prefix("fireiron"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/tfcompat/fireiron.png"))
                                .modelName(Legendblade.prefix("model/named/truegodfox/model.obj"))
                                .effectColor(14749969)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(20)
                                .slashArtsType(SBASlashArtsRegistry.SPIRAL_EDGE.getId())
                                .addSpecialEffect(TFLBcompat.fire.getId())
                                .maxDamage(80).build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                        )
                )
        );
    }





    private static ResourceKey<SlashBladeDefinition> register(String id) {
        return ResourceKey.create(SlashBladeDefinition.REGISTRY_KEY, Legendblade.prefix(id));
    }
    static ResourceLocation getEnchantmentID(Enchantment enchantment) {
        return ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
    }

}
