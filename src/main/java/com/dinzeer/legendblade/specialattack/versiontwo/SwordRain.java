package com.dinzeer.legendblade.specialattack.versiontwo;

import com.dinzeer.legendblade.entity.SumonSwordEntity;
import com.dinzeer.legendblade.entity.SwordRainEntity;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.dinzeer.legendblade.specialattack.versionone.SommonSwordSommon;
import com.dinzeer.legendblade.specialeffects.versionone.SummonSword;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.SlashBladeConfig;
import mods.flammpfeil.slashblade.capability.concentrationrank.CapabilityConcentrationRank;
import mods.flammpfeil.slashblade.entity.EntityHeavyRainSwords;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.util.AdvancementHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import static mods.flammpfeil.slashblade.ability.SummonedSwordArts.ADVANCEMENT_HEAVY_RAIN_SWORDS;

public class SwordRain {
    public static void doSlash(LivingEntity playerIn, boolean critical, double damage, float speed)
    {
        int colorCode = playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state -> state.getColorCode()).orElse(0xFF3333FF);
        doSlash(playerIn, colorCode, critical, damage, speed);
    }

    public static void doSlash(LivingEntity playerIn, int colorCode, boolean critical, double damage, float speed)
    {
        if (playerIn.level().isClientSide()) return;
        if (Screen.hasShiftDown()) {
            // summon
            playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {

                Level worldIn = playerIn.level();
                Entity target = state.getTargetEntity(worldIn);
                if (state.isBroken() || state.isSealed()
                        || !SwordType.from(playerIn.getMainHandItem()).contains(SwordType.BEWITCHED))
                    return;
                int powerLevel = playerIn.getMainHandItem().getEnchantmentLevel(Enchantments.POWER_ARROWS);

                state.setProudSoulCount(
                        state.getProudSoulCount());

                AdvancementHelper.grantCriterion(playerIn, ADVANCEMENT_HEAVY_RAIN_SWORDS);

                int rank = playerIn.getCapability(CapabilityConcentrationRank.RANK_POINT)
                        .map(r -> r.getRank(worldIn.getGameTime()).level).orElse(0);

                Vec3 basePos;

                if (target != null) {
                    basePos = target.position();
                } else {
                    Vec3 forwardDir = calculateViewVector(0, playerIn.getYRot());
                    basePos = playerIn.getPosition(0).add(forwardDir.scale(5));
                }

                float yOffset = 7;
                basePos = basePos.add(0, yOffset, 0);

                {// no random pos
                    SwordRainEntity ss = new SwordRainEntity(
                            LBEntiteRegristrys.sr, worldIn);

                    worldIn.addFreshEntity(ss);

                    ss.setOwner(playerIn);
                    ss.setColor(state.getColorCode());
                    ss.setRoll(0);
                    ss.setDamage(powerLevel);
                    // force riding
                    ss.startRiding(playerIn, true);

                    ss.setDelay(0);

                    ss.setPos(basePos);

                    ss.setXRot(-90);
                }

                int count = 9 + Math.min(rank - 1, 0);
                int multiplier = 2;
                for (int i = 0; i < count; i++)
                    for (int l = 0; l < multiplier; l++) {
                        SwordRainEntity ss = new SwordRainEntity(
                                LBEntiteRegristrys.sr, worldIn);

                        worldIn.addFreshEntity(ss);

                        ss.setOwner(playerIn);
                        ss.setColor(state.getColorCode());
                        ss.setRoll(0);
                        ss.setDamage((5 * (powerLevel + 1) * 2));
                        // force riding
                        ss.startRiding(playerIn, true);

                        ss.setDelay(i);

                        ss.setSpread(basePos);

                        ss.setXRot(-90);


                    }
            });
        }else {
            SommonSwordSommon.doSlash(playerIn, colorCode, critical, damage, speed);
        }



        playerIn.playSound(SoundEvents.ENDER_DRAGON_FLAP, 0.2F, 1.45F);
    }
    static Vec3 calculateViewVector(float x, float y) {
        float f = x * ((float) Math.PI / 180F);
        float f1 = -y * ((float) Math.PI / 180F);
        float f2 = Mth.cos(f1*2);
        float f3 = Mth.sin(f1*2);
        float f4 = Mth.cos(f*2);
        float f5 = Mth.sin(f*2);
        return new Vec3((double) (f3 * f4), (double) (-f5), (double) (f2 * f4));
    }
}
