package com.exfantasy.mclib.Utils.SlashBlade;

import com.dinzeer.legendblade.Config;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import static com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils.RepairCounter;


public class SlashEffectUtils {
    public static boolean hasSpecialEffect(ItemStack stack, String effect) {
        CompoundTag tag = stack.getOrCreateTag(); // 获取或创建NBT标签

        if (tag.contains("bladeState")) { // 检查是否存在ForgeCaps标签
            CompoundTag forgeCaps = tag.getCompound("bladeState");

            if (forgeCaps.contains("SpecialEffects")) { // 检查SpecialEffects标签
                ListTag specialEffects = forgeCaps.getList("SpecialEffects", 8); // 8表示String类型
                for (int i = 0; i < specialEffects.size(); i++) {
                    String currentEffect = specialEffects.getString(i);
                    if (effect.equals(currentEffect)) {
                        return true; // 找到了指定的特殊效果
                    }
                }

            }

        }
        return false; // 没有找到指定的特殊效果
    }
    public static int addslashbladesaDamage(LivingEntity player,int damageex) {
        ItemStack stack= player.getMainHandItem();
        CompoundTag tag = stack.getOrCreateTag(); // 获取或创建NBT标签
        double add=damageex*(
                1+ addslashbladesaDamageKey(player)
        );
        return (int)add;
    }
    public static double addslashbladesaDamageKey(LivingEntity player) {
        ItemStack stack = player.getMainHandItem();
        CompoundTag tag = stack.getOrCreateTag();
        if (Config.damegeaddd * SlashbladeUtils.getNumberNBT(tag, RepairCounter) > Config.damegeadddmaX * SlashbladeUtils.getNumberNBT(tag, RepairCounter)){
            return  Config.damegeadddmaX * SlashbladeUtils.getNumberNBT(tag, RepairCounter);
    }
        return  Config.damegeaddd * SlashbladeUtils.getNumberNBT(tag, RepairCounter);
    }


}