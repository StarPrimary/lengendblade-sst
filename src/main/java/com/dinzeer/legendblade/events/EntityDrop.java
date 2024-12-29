package com.dinzeer.legendblade.events;

import com.dinzeer.legendblade.Config;
import com.dinzeer.legendblade.regsitry.other.LBModItems;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

import static com.exfantasy.mclib.Utils.SlashBlade.SlashEffectUtils.hasSpecialEffect;

@Mod.EventBusSubscriber
public class EntityDrop {

    @SubscribeEvent
    public static void entityheal(LivingDropsEvent e){
        LivingEntity entity = e.getEntity();
        Level level = entity.level();
        double randomValue = Math.random();

            if (e.getSource().getDirectEntity() instanceof Player player){
                int lv=player.experienceLevel;
                if(level.isClientSide)return;
                if (entity.getAttributeBaseValue(Attributes.MAX_HEALTH) >= Config.soul_crystal && randomValue <= 0.44){

                    ItemStack p_32005_ = new ItemStack(LBModItems.soul_crystal.get());
                    p_32005_.setCount(1);
                    level.addFreshEntity(new ItemEntity(level,entity.getX(),entity.getY()+1,entity.getZ()
                            , p_32005_));
                }
            }

    }
}
