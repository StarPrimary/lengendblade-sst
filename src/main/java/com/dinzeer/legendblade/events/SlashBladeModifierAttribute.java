package com.dinzeer.legendblade.events;

import com.dinzeer.legendblade.data.LegendBuiltInRegsitry;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber
public class SlashBladeModifierAttribute {
    private static final UUID SevenSwordHealthUUID = UUID.fromString("c6c4e4e7-c7a7-4f07-b6e6-c6e6c6e6c6e6");
    private static final UUID SevenSwordAttackUUID = UUID.fromString("c6c4e4e7-c7a7-4f07-b6e6-c6e6c6e6c6e6");
@SubscribeEvent
    public static void apply(ItemAttributeModifierEvent event){
    ItemStack stack = event.getItemStack();
    if (stack.getTag()==null)return;
    if (event.getSlotType() == EquipmentSlot.MAINHAND)
   if( SlashbladeUtils.getStringNBT(stack.getTag(),"translationKey").equals("item.legendblade.sevensword")){
       event.addModifier(Attributes.MAX_HEALTH,new AttributeModifier(SevenSwordHealthUUID,"SevenSwordHealth",-0.5,AttributeModifier.Operation.MULTIPLY_TOTAL));
       event.addModifier(Attributes.ATTACK_DAMAGE,new AttributeModifier(SevenSwordAttackUUID,"SevenSwordAttack",0.3,AttributeModifier.Operation.MULTIPLY_TOTAL));
   }
}
}
