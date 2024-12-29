package com.dinzeer.legendblade.events.tipevents;

import com.dinzeer.legendblade.data.LegendBuiltInRegsitry;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.SlashBladeCreativeGroup;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SlashBladeToolTip {
    public static void addTooltipInItemStack(ItemStack stack, String localizationKey){
        stack.getOrCreateTag().putString("customTooltip", localizationKey);
    }
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event){
        if(event.getItemStack().getOrCreateTag().contains("customTooltip")){
            event.getToolTip().add(1,Component.translatable(event.getItemStack().getOrCreateTag().getString("customTooltip")));
        }

    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public class InitEvents{
        @SubscribeEvent
        public static void build(BuildCreativeModeTabContentsEvent e){
            CreativeModeTab tab = e.getTab();
            if (tab != SlashBladeCreativeGroup.SLASHBLADE_GROUP.get())return;
            tab .getDisplayItems().forEach(
                    itemStack -> {
                        if (itemStack.getTag()!=null) {
                            var a = itemStack.getCapability(ItemSlashBlade.BLADESTATE).orElse(null);
                            if (a != null) {
                                for (manner manner : manner.values()) {
                                    if (a.getTranslationKey().equals(manner.resourceLocation.location().toString())) {
                                        addTooltipInItemStack(itemStack,manner.localizationKey);
                                    }
                                }
                            }
                        }
                    }
            );
        }
    }

    public static enum manner {
        NorMal(  LegendBuiltInRegsitry.sevensword, "customTooltip.item.legendblade.sevensword"),
        S(  LegendBuiltInRegsitry.administrator, "customTooltip.item.legendblade.administrator");

        private final ResourceKey<SlashBladeDefinition> resourceLocation;
        private final String localizationKey;

        manner(ResourceKey<SlashBladeDefinition> resourceLocation, String localizationKey) {
            this.resourceLocation = resourceLocation;
            this.localizationKey = localizationKey;
        }


    }
}
