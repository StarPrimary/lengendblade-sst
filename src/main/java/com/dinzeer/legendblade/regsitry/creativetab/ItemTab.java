package com.dinzeer.legendblade.regsitry.creativetab;

import com.dinzeer.legendblade.regsitry.other.LBModItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.dinzeer.legendblade.Legendblade.MODID;


public class ItemTab {

    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> LBITEM = REGISTRY.register("legendblade",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.legendblade.legendbladeitem")).icon(() -> new ItemStack(
                            LBModItems.lightpinkjadeofuda)).displayItems((parameters, tabData) -> {
                    })

                    .build());
    public static void register(IEventBus e){
        REGISTRY.register(e);
    }
}
