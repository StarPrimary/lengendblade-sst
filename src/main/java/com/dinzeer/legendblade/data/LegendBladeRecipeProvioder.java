package com.dinzeer.legendblade.data;

import cn.mmf.slashblade_addon.data.SlashBladeAddonBuiltInRegistry;
import com.dinzeer.legendblade.regsitry.other.LBModItems;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import dev.xkmc.l2complements.init.registrate.LCItems;
import dev.xkmc.l2hostility.init.registrate.LHItems;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.recipe.SlashBladeIngredient;
import mods.flammpfeil.slashblade.recipe.SlashBladeShapedRecipeBuilder;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.init.TFItems;

import java.util.function.Consumer;

public class LegendBladeRecipeProvioder extends RecipeProvider implements IConditionBuilder {

    public LegendBladeRecipeProvioder(PackOutput output) {
        super(output);
    }
    protected void buildRecipes(Consumer<FinishedRecipe> consumer){


        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.NIHILEXFAKE.location())
                .pattern("ABC")
                .pattern("BDB")
                .pattern("EBA")
                .define('A', SBItems.proudsoul_ingot)
                .define('B', Items.IRON_BLOCK)
                .define('C',  SBItems.proudsoul_crystal)
                .define('E', LBModItems.blood_tachi)
                .define('D',SBItems.slashblade)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.SHINKU.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHA")
                .define('A', SBItems.proudsoul_sphere)
                .define('B', LBModItems.jadeofuda)
                .define('C', LBModItems.lightpinkjadeofuda)
                .define('D',LBModItems.crimsonjadeofuda)
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.NIHILEXFAKE.location())
                                .proudSoul(25000)
                                .killCount(5000)
                                .refineCount(20)
                                .build()
                ))
                .define('F', LBModItems.redjadeofuda)
                .define('G', LBModItems.pinkjadeofuda)
                .define('H', LBModItems.scarletjadeofuda)

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.BLOODKATANA.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHA")
                .define('A', SBItems.proudsoul_sphere)
                .define('B', LBModItems.iron_tachi)
                .define('C', LBModItems.lightred_tachi)
                .define('D',LBModItems.red_tachi)
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.NIHILEXFAKE.location())
                                .proudSoul(25000)
                                .killCount(5000)
                                .refineCount(20)
                                .addEnchantment(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 1))
                                .addEnchantment(new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 1))
                                .addEnchantment(new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 1))
                                .build()
                ))
                .define('F', LBModItems.sored_tachi)
                .define('G', LBModItems.blood_tachi)
                .define('H', LBModItems.slightlyred_tachi)

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.stickgodfox.location())
                .pattern("AB ")
                .pattern("CDC")
                .pattern(" EA")
                .define('A', Items.REDSTONE)
                .define('B', Items.FLINT)
                .define('C', Items.IRON_INGOT)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.RUSTGODFOX.location())
                                .proudSoul(500)
                                .refineCount(1)
                                 .build()
                ))
                .define('E',Items.STICK)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.WHITEGODFOX.location())
                .pattern("ABA")
                .pattern("ACA")
                .pattern("ADA")
                .define('A', SBItems.proudsoul_ingot)
                .define('B', Items.OAK_LOG)

                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.stickgodfox.location())
                                .killCount(500)
                                .proudSoul(2500)
                                .refineCount(5)
                                .build()
                ))
                .define('D', Items.OAK_SLAB)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.GODFOX.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("ABA")
                .define('A', SBItems.proudsoul_ingot)
                .define('B', LBModItems.tearfluorite)
                .define('C', Items.NETHER_STAR)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.WHITEGODFOX.location())
                                .killCount(500)
                                .proudSoul(10000)
                                .refineCount(10)
                                .build()
                ))

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.TRUEGODFOX.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("ABA")
                .define('A', SBItems.proudsoul_ingot)
                .define('C', LBModItems.tearfluorite)
                .define('B', Items.NETHER_STAR)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.GODFOX.location())
                                .killCount(1200)
                                .proudSoul(25000)
                                .refineCount(10)
                                .build()
                ))

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.evil.location())
                .pattern(" A ")
                .pattern("BCB")
                .pattern("DAD")
                .define('A', Items.IRON_INGOT)
                .define('C', SBItems.slashblade)
                .define('B', Items.REDSTONE)
                .define('D',Items.OBSIDIAN)

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.asmodeus.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EBE")
                .define('A', Items.POPPY)
                .define('B', Items.DANDELION)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evil.location())
                                .killCount(1000)
                                .proudSoul(1500)
                                .refineCount(10)
                                .build()
                ))
                .define('E',Items.REDSTONE_LAMP)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.beelzebub.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EBE")
                .define('A', Items.COOKED_PORKCHOP)
                .define('B', Items.COOKED_BEEF)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evil.location())
                                .killCount(1000)
                                .proudSoul(1500)
                                .refineCount(10)
                                .build()
                ))
                .define('E',Items.CAKE)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.belphegor.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EBE")
                .define('A', Items.BLUE_BED)
                .define('B', Items.POWERED_RAIL)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evil.location())
                                .killCount(1000)
                                .proudSoul(1500)
                                .refineCount(10)
                                .build()
                ))
                .define('E',Items.IRON_DOOR)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.leviathan.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EBE")
                .define('A', Items.BLAZE_ROD)
                .define('B', Items.GHAST_TEAR)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evil.location())
                                .killCount(1000)
                                .proudSoul(1500)
                                .refineCount(10)
                                .build()
                ))
                .define('E',Items.IRON_SWORD)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.lucifer.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EBE")
                .define('A', Items.GLOWSTONE)
                .define('B', Items.NETHER_STAR)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evil.location())
                                .killCount(1000)
                                .proudSoul(1500)
                                .refineCount(10)
                                .build()
                ))
                .define('E',Items.BOOKSHELF)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.mammon.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EBE")
                .define('A', Items.GOLD_BLOCK)
                .define('B', Items.DIAMOND)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evil.location())
                                .killCount(1000)
                                .proudSoul(1500)
                                .refineCount(10)
                                .build()
                ))
                .define('E',Items.EMERALD)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.samael.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EBE")
                .define('A', Items.TNT)
                .define('B', Items.LAVA_BUCKET)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evil.location())
                                .killCount(1000)
                                .proudSoul(1500)
                                .refineCount(10)
                                .build()
                ))
                .define('E',Items.BOW)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.NEOGODFOX.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EBE")
                .define('A', Items.DIAMOND_BLOCK)
                .define('B', Items.NETHER_STAR)
                .define('C', LBModItems.tearfluorite)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.GODFOX.location())
                                .killCount(7000)
                                .proudSoul(1500)
                                .refineCount(30)
                                .build()
                ))
                .define('E',Items.GLOWSTONE)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.asmodeusex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', LBModItems.luxuria)
                .define('B', LBModItems.saligiasphere)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.asmodeus.location())
                                .killCount(5000)
                                .proudSoul(35000)
                                .refineCount(50)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evilex.location())
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.beelzebubex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', LBModItems.gula)
                .define('B', LBModItems.saligiasphere)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.beelzebub.location())
                                .killCount(5000)
                                .proudSoul(35000)
                                .refineCount(50)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evilex.location())
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.belphegorex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', LBModItems.acedia)
                .define('B', LBModItems.saligiasphere)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.belphegor.location())
                                .killCount(5000)
                                .proudSoul(35000)
                                .refineCount(50)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evilex.location())
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.evilex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EBE")
                .define('A', Items.REDSTONE_BLOCK)
                .define('B', Items.OBSIDIAN)
                .define('C', SBItems.proudsoul_ingot)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evil.location())
                                .killCount(1000)
                                .proudSoul(1500)
                                .refineCount(10)
                                .build()
                ))
                .define('E',Items.REDSTONE_BLOCK)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.leviathanex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', LBModItems.invidia)
                .define('B', LBModItems.saligiasphere)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.leviathan.location())
                                .killCount(5000)
                                .proudSoul(35000)
                                .refineCount(50)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evilex.location())
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.luciferex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', LBModItems.superbia)
                .define('B', LBModItems.saligiasphere)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.lucifer.location())
                                .killCount(5000)
                                .proudSoul(35000)
                                .refineCount(50)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evilex.location())
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.mammonex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', LBModItems.avaritia)
                .define('B', LBModItems.saligiasphere)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.mammon.location())
                                .killCount(5000)
                                .proudSoul(35000)
                                .refineCount(50)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evilex.location())
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.samaelex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', LBModItems.ira)
                .define('B', LBModItems.saligiasphere)
                .define('C', SBItems.proudsoul_sphere)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.samael.location())
                                .killCount(5000)
                                .proudSoul(35000)
                                .refineCount(50)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evilex.location())
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.foxex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("ACA")
                .define('A', Items.GLOWSTONE)
                .define('B', Items.NETHER_STAR)
                .define('C', Items.DIAMOND_BLOCK)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.FOX_WHITE.location())
                                .killCount(1000)
                                .proudSoul(12000)
                                .refineCount(6)
                                .build()
                ))

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.foxex2.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("ACA")
                .define('A', Items.GLOWSTONE)
                .define('B', Items.NETHER_STAR)
                .define('C', Items.DIAMOND_BLOCK)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.FOX_BLACK.location())
                                .killCount(1000)
                                .proudSoul(12000)
                                .refineCount(6)
                                .build()
                ))

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.foxexfinal.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('E', Items.GLOWSTONE)
                .define('B', Items.DRAGON_EGG)
                .define('A', Items.DIAMOND_BLOCK)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.foxex.location())
                                .killCount(4500)
                                .proudSoul(24000)
                                .refineCount(20)
                                .build()
                ))
                .define('C',Items.OBSIDIAN)

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.wujiu.location())
                .pattern("CAB")
                .pattern("ABA")
                .pattern("DAC")
                .define('A', Items.NETHER_STAR)
                .define('B', Items.NETHERITE_INGOT)
                .define('C', SBItems.proudsoul_trapezohedron)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.MURAMASA.location())
                                .killCount(10000)
                                .proudSoul(30000)
                                .refineCount(100)
                                .build()
                ))

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.belphebubex.location())
                .pattern("ADC")
                .pattern("BEB")
                .pattern("CFA")
                .define('A', LBModItems.gula)
                .define('B', LBModItems.saligiaex)
                .define('C', LBModItems.acedia)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.belphegor.location())
                                .proudSoul(3000)
                                .refineCount(10)
                                .build()
                ))
                .define('F',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.beelzebub.location())
                                .proudSoul(3000)
                                .refineCount(10)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.evilex.location())
                                .killCount(2000)
                                .proudSoul(3000)
                                .refineCount(10)
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.waterex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', SBItems.proudsoul_sphere)
                .define('D', Items.DIAMOND_BLOCK)
                .define('C', Items .NETHER_STAR)


                .define('B',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.KAMUY_WATER.location())
                                .killCount(3000)
                                .proudSoul(3000)
                                .refineCount(10)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.KIRISAYA.location())
                                .killCount(3000)
                                .proudSoul(3000)
                                .refineCount(10)
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.fireex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', SBItems.proudsoul_sphere)
                .define('D', Items.DIAMOND_BLOCK)
                .define('C', Items.NETHER_STAR)


                .define('B',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.KAMUY_FIRE.location())
                                .killCount(3000)
                                .proudSoul(3000)
                                .refineCount(10)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.LAEMMLE.location())
                                .killCount(3000)
                                .proudSoul(3000)
                                .refineCount(10)
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.lightningex.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', SBItems.proudsoul_sphere)
                .define('D', Items.DIAMOND_BLOCK)
                .define('C', Items.NETHER_STAR)


                .define('B',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.KAMUY_LIGHTING.location())
                                .killCount(3000)
                                .proudSoul(3000)
                                .refineCount(10)
                                .build()
                ))
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.GREEN_MIST.location())
                                .killCount(3000)
                                .proudSoul(3000)
                                .refineCount(10)
                                .build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.godbird.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("ABA")
                .define('A', Items.VINE)
                .define('B', Items.FEATHER)
                .define('C', SBItems.proudsoul_sphere)


                .define('D',SlashBladeIngredient.of(
                        SBItems.slashblade_white, RequestDefinition.Builder.newInstance()
                                .killCount(2000).refineCount(15).proudSoul(15000).build()
                ))
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.crimsoncherryex.location())
                .pattern("ABA")
                .pattern("CDE")
                .pattern("AFA")
                .define('A', Items.DIAMOND_BLOCK)
                .define('B',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.CRIMSONCHERRY.location())
                                .killCount(3000)
                                .proudSoul(30000)
                                .refineCount(20)
                                .build()
                ))
                .define('F',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.NIHILEXFAKE.location())
                                .killCount(3000)
                                .proudSoul(30000)
                                .refineCount(20)
                                .build()
                ))
                .define('C',LBModItems.blood_tachi)
                .define('E',LBModItems.scarletjadeofuda)
                .define('D',Items.NETHERITE_INGOT)

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.amazedshine.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("BAB")
                .define('A', Items.BEACON)
                .define('B',Items.BOOKSHELF)
                .define('D',SlashBladeIngredient.of(
                        SBItems.slashblade_silverbamboo, RequestDefinition.Builder.newInstance()
                                .refineCount(80).addSwordType(SwordType.BROKEN).build()
                ))
                .define('C',SBItems.proudsoul_sphere)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.nihilulex.location())
                .pattern("ABA")
                .pattern("CDE")
                .pattern("AFA")
                .define('A', Items.DIAMOND_BLOCK)
                .define('B',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.NIHILUL.location())
                                .killCount(3000)
                                .proudSoul(30000)
                                .refineCount(20)
                                .build()
                ))
                .define('F',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.NIHILEXFAKE.location())
                                .killCount(6000)
                                .proudSoul(30000)
                                .refineCount(20)
                                .build()
                ))
                .define('C',LBModItems.blood_tachi)
                .define('E',LBModItems.scarletjadeofuda)
                .define('D',Items.NETHERITE_INGOT)

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.nihilbxex.location())
                .pattern("ABA")
                .pattern("ACA")
                .pattern("ADA")
                .define('A', Items.DIAMOND_BLOCK)
                .define('B',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.nihilulex.location())
                                .killCount(8000)
                                .proudSoul(50000)
                                .refineCount(20)
                                .build()
                ))
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.NIHILBX.location())
                                .killCount(8000)
                                .proudSoul(30000)
                                .refineCount(20)
                                .build()
                ))
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.crimsoncherryex.location())
                                .killCount(8000)
                                .proudSoul(50000)
                                .refineCount(20)
                                .build()
                ))

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.sevensword.location())
                .pattern("ABA")
                .pattern("DCD")
                .pattern("AEA")
                .define('A', Items.NETHERITE_BLOCK)
                .define('B',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.NIHILEXFAKE.location())
                                .killCount(10000)
                                .proudSoul(50000)
                                .refineCount(20)
                                .build()
                ))
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.KIRISAYA.location())
                                .killCount(10000)
                                .proudSoul(30000)
                                .refineCount(20)
                                .build()
                ))
                .define('D',Items.DRAGON_EGG)
                .define('E',LBModItems.blood_tachi)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.ark.location())
                .pattern("ABA")
                .pattern("DCD")
                .pattern("ABA")
                .define('A', Items.LAPIS_BLOCK)
                .define('B', LCItems.CURSED_DROPLET)
                .define('C',SlashBladeIngredient.of(

                        SBItems.slashblade_silverbamboo, RequestDefinition.Builder.newInstance()
                                .killCount(100)
                                .proudSoul(500)
                                .refineCount(10).build()
                ))
                .define('D',Items.SPIDER_EYE)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);


        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.neo.location())
                .pattern("BEA")
                .pattern("FCF")
                .pattern("DEB")
                .define('A', LHItems.MIRACLE_INGOT)
                .define('B', LHItems.CHAOS_INGOT)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.ark.location())
                                .killCount(5000)
                                .proudSoul(55000)
                                .refineCount(20)
                                .build()
                ))
                .define('D',LBModItems.saligiasphere)
                .define('E',LCItems.CURSED_DROPLET)
                .define('F',LHItems.WITCH_DROPLET)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.administrator.location())
                .pattern("AAA")
                .pattern("BCB")
                .pattern("DED")
                .define('A', Items.NETHER_STAR)
                .define('B', SBItems.proudsoul_sphere)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.KIRISAYA.location())
                                .killCount(50000)
                                .proudSoul(55000)
                                .refineCount(100)
                                .build()
                ))
                .define('D',Items.LAPIS_BLOCK)
                .define('E',Items.DRAGON_EGG)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.fire.location())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("DBA")
                .define('A', IafItemRegistry.FIRE_DRAGON_BLOOD.get())
                .define('B', IafItemRegistry.DRAGON_BONE.get())
                .define('C',SBItems.slashblade)
                .define('D',IafItemRegistry.DRAGONBONE_SWORD_FIRE.get())
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.ice.location())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("DBA")
                .define('A', IafItemRegistry.ICE_DRAGON_BLOOD.get())
                .define('B', IafItemRegistry.DRAGON_BONE.get())
                .define('C',SBItems.slashblade)
                .define('D',IafItemRegistry.DRAGONBONE_SWORD_ICE.get())
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.lightning.location())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("DBA")
                .define('A', IafItemRegistry.LIGHTNING_DRAGON_BLOOD.get())
                .define('B', IafItemRegistry.DRAGON_BONE.get())
                .define('C',SBItems.slashblade)
                .define('D',IafItemRegistry.DRAGONBONE_SWORD_LIGHTNING.get())
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.blaze.location())
                .pattern("ADA")
                .pattern("BCB")
                .pattern("ADA")
                .define('A', IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get())
                .define('B', IafItemRegistry.FIRE_DRAGON_BLOOD.get())
                .define('C',SlashBladeIngredient.of(
                                RequestDefinition.Builder.newInstance()
                                        .name(LegendBuiltInRegsitry.fire.location())
                                        .killCount(3000)
                                        .proudSoul(65000)
                                        .refineCount(20)
                                        .build()
                ))
                .define('D', IafItemRegistry.DRAGON_SKULL_FIRE.get())
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.foreverice.location())
                .pattern("ADA")
                .pattern("BCB")
                .pattern("ADA")
                .define('A', IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get())
                .define('B', IafItemRegistry.ICE_DRAGON_BLOOD.get())
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.ice.location())
                                .killCount(3000)
                                .proudSoul(65000)
                                .refineCount(20)
                                .build()
                ))
                .define('D', IafItemRegistry.DRAGON_SKULL_ICE.get())
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.zerogalaxy.location())
                .pattern("ADA")
                .pattern("BCB")
                .pattern("ADA")
                .define('A', IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get())
                .define('B', IafItemRegistry.LIGHTNING_DRAGON_BLOOD.get())
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.lightning.location())
                                .killCount(3000)
                                .proudSoul(65000)
                                .refineCount(20)
                                .build()
                ))
                .define('D', IafItemRegistry.DRAGON_SKULL_LIGHTNING.get())
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.truebloodfox.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', LBModItems.ira)
                .define('C', LBModItems.tearfluorite)
                .define('B', Items.NETHER_STAR)
                .define('E', LBModItems.scarletjadeofuda)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(LegendBuiltInRegsitry.GODFOX.location())
                                .killCount(6200)
                                .proudSoul(30000)
                                .refineCount(20)
                                .build()
                ))

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.eiily.location())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.AMETHYST_CLUSTER)
                .define('B',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.SANGE.location())
                                .build()
                ))

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.demonbird.location())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ADA")
                .define('A', LBModItems.ira)
                .define('B', SBItems.proudsoul_sphere)
                .define('C',SlashBladeIngredient.of(
                        SBItems.slashblade, RequestDefinition.Builder.newInstance()
                                .killCount(3000).refineCount(5).proudSoul(20000).build()
                ))
                .define('D',SBItems.proudsoul_ingot)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.zangetsu.location())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ADA")
                .define('A', Items.DIAMOND_ORE)
                .define('B', SBItems.proudsoul_sphere)
                .define('C',SlashBladeIngredient.of(
                        SBItems.slashblade, RequestDefinition.Builder.newInstance()
                                .killCount(3000).refineCount(5).proudSoul(20000).build()
                ))
                .define('D',SBItems.proudsoul_ingot)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.frog.location())
                .pattern("ABA")
                .pattern("ECE")
                .pattern("ADA")
                .define('A', Items.GHAST_TEAR)
                .define('B', SBItems.proudsoul_sphere)
                .define('C',SlashBladeIngredient.of(
                        SBItems.slashblade, RequestDefinition.Builder.newInstance()
                                .killCount(3000).refineCount(5).proudSoul(20000).build()
                ))
                .define('D',LBModItems.icegem)
                .define('E',Items.ICE)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.crowbar.location())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("DED")
                .define('A', Items.REDSTONE_BLOCK)
                .define('B', SBItems.proudsoul_sphere)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeAddonBuiltInRegistry.FLUORESCENT_BAR.location())
                                .proudSoul(1500)
                                .refineCount(10)
                                .killCount(1000)
                                .addEnchantment(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3))
                                .build()
                ))
                .define('D',Items.OBSIDIAN)
                .define('E',Items.IRON_BLOCK)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.fish.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', Items.WATER_BUCKET)
                .define('B', SBItems.proudsoul_sphere)
                .define('C',Items.ICE)
                .define('D',SlashBladeIngredient.of(

                        SBItems.slashblade, RequestDefinition.Builder.newInstance()
                                .proudSoul(1500)
                                .refineCount(3)
                                .killCount(300)
                                .build()
                ))
                .define('E',LBModItems.water_gem)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.undragon.location())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', LBModItems.dragon_gem)
                .define('B', SBItems.proudsoul_sphere)
                .define('C',SlashBladeIngredient.of(

                        SBItems.slashblade_silverbamboo, RequestDefinition.Builder.newInstance()
                                .proudSoul(1500)
                                .refineCount(20)
                                .killCount(3000)
                                .build()
                ))
                .define('D',SlashBladeIngredient.of(

                        SBItems.slashblade, RequestDefinition.Builder.newInstance()
                                .proudSoul(500000)
                                .refineCount(30)
                                .killCount(10000)
                                .build()
                ))
                .define('E',Items.DRAGON_EGG)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.breakarm.location())
                .pattern("ABC")
                .pattern("DED")
                .pattern("CFA")
                .define('A', TFItems.KNIGHTMETAL_SWORD.get())
                .define('B',  TFItems.KNIGHT_PHANTOM_TROPHY.get())
                .define('C', TFItems.KNIGHTMETAL_AXE.get())
                .define('D',TFItems.KNIGHTMETAL_PICKAXE.get())
                .define('E',SlashBladeIngredient.of(

                        SBItems.slashblade, RequestDefinition.Builder.newInstance()
                                .refineCount(30)
                                .killCount(3000)
                                .build()
                ))
                .define('F',TFItems.BLOCK_AND_CHAIN.get())
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.fireiron.location())
                .pattern("ABC")
                .pattern("DED")
                .pattern("CFA")
                .define('A', TFItems.FIERY_SWORD.get())
                .define('B',  TFItems.HYDRA_TROPHY.get())
                .define('C', TFItems.FIERY_PICKAXE.get())
                .define('D',TFItems.FIERY_INGOT.get())
                .define('E',SlashBladeIngredient.of(

                        SBItems.slashblade, RequestDefinition.Builder.newInstance()
                                .refineCount(10)
                                .killCount(1000)
                                .build()
                ))
                .define('F',TFItems.FIERY_INGOT.get())
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(LegendBuiltInRegsitry.allice.location())
                .pattern("ABC")
                .pattern("DED")
                .pattern("CFA")
                .define('A', TFItems.ICE_SWORD.get())
                .define('B',  TFItems.SNOW_QUEEN_TROPHY.get())
                .define('C', TFItems.ICE_BOMB.get())
                .define('D',TFItems.KNIGHTMETAL_INGOT.get())
                .define('E',SlashBladeIngredient.of(

                        SBItems.slashblade, RequestDefinition.Builder.newInstance()
                                .refineCount(20)
                                .killCount(2000)
                                .build()
                ))
                .define('F',TFItems.ICE_BOW.get())
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);





    }



    static ResourceLocation getEnchantmentID(Enchantment enchantment) {
        return ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
    }
    public Item getItem(ResourceLocation item) {
        return ForgeRegistries.ITEMS.getValue(item);
    }
}
