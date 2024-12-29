package com.dinzeer.legendblade.client;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.common.Mod;

import java.util.Random;

import static com.dinzeer.legendblade.Legendblade.LOGGER;
import static com.dinzeer.legendblade.Legendblade.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorInit {
    @SubscribeEvent
    public static void registerColor(RegisterColorHandlersEvent.Item event){
        event.register(ColorInit::getColor, SBItems.slashblade );
    }
    private static final Random r = new Random()  ;

    public static int getColor(ItemStack stack, int color){
        LOGGER.debug("a");
        LazyOptional<ISlashBladeState> capability = stack.getCapability(ItemSlashBlade.BLADESTATE);
        if (!capability.isPresent())return -1 ;
        var state = capability.resolve().get();
        if (state.getSpecialEffects().contains(LBSpecialEffectsRegistry.RainBow.getId())) {
            int colorCode = r.nextInt(999999);
            state.setColorCode(colorCode);
//            state.setColorCode(cc+1);
            return colorCode;
        }
        return -1;
    }
}
