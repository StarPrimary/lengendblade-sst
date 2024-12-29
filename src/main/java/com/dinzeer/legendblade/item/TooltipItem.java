package com.dinzeer.legendblade.item;

import  com.dinzeer.legendblade.item.*;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class TooltipItem extends Item {

    private final Component translate;

    public TooltipItem(Properties properties,Component translate) {
        super(properties);
        this.translate = translate;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        var e = translate;
        if (e == null) {
            list.add(LangData.IDS.BANNED.get().withStyle(ChatFormatting.RED));
        } else {
            list.add(MutableComponent.create(translate.getContents()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, list, flag);
    }

    @Override
    public boolean canBeHurtBy(DamageSource source) {
        if (getRarity(getDefaultInstance()) != Rarity.COMMON) {
            if (source.is(DamageTypeTags.IS_LIGHTNING) || source.is(DamageTypeTags.IS_FIRE) || source.is(DamageTypeTags.IS_EXPLOSION))
                return false;
        }
        return true;
    }

}