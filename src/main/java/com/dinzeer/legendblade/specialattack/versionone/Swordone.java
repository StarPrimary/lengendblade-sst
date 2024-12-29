package com.dinzeer.legendblade.specialattack.versionone;

import com.dinzeer.legendblade.entity.DriveSummonEntityOne;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import mods.flammpfeil.slashblade.capability.concentrationrank.ConcentrationRankCapabilityProvider;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.util.VectorHelper;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Swordone {
    public static void doSlash(LivingEntity playerIn, boolean critical, double damage, float speed,Vec3 centerOffset)
    {
        int colorCode = playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state -> state.getColorCode()).orElse(0xFF3333FF);
        doSlash(playerIn, colorCode, critical, damage, speed,centerOffset);
    }

    public static void doSlash(LivingEntity playerIn, int colorCode, boolean critical, double damage, float speed,Vec3 centerOffset)
    {
        Vec3 pos = playerIn.position().add(0.0D, (double) playerIn.getEyeHeight() * 0.75D, 0.0D)
                .add(playerIn.getLookAngle().scale(0.3f));

        pos = pos.add(VectorHelper.getVectorForRotation(-90.0F, playerIn.getViewYRot(0)).scale(centerOffset.y))
                .add(VectorHelper.getVectorForRotation(0, playerIn.getViewYRot(0) + 90).scale(centerOffset.z))
                .add(playerIn.getLookAngle().scale(centerOffset.z));

        if (playerIn.level().isClientSide()) return;

        Vec3 finalPos = pos;
        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {

            Level worldIn = playerIn.level();

            int count = 8;

            DriveSummonEntityOne ss = new DriveSummonEntityOne(LBEntiteRegristrys.ssdo, worldIn);

            playerIn.level().addFreshEntity(ss);
            float Speed = Mth.randomBetween(ss.level().getRandom(), speed, speed);

            ss.setPos(finalPos.x, finalPos.y, finalPos.z);
            ss.setDamage(damage);
            ss.setSpeed(speed);
            ss.shoot(playerIn.getLookAngle().x, playerIn.getLookAngle().y, playerIn.getLookAngle().z, ss.getSpeed(), 0);

            ss.setOwner(playerIn);

            ss.setRotationRoll(0);


            ss.setColor(colorCode);
            ss.setIsCritical(critical);

            ss.setLifetime(20);

            if (playerIn != null)
                playerIn.getCapability(ConcentrationRankCapabilityProvider.RANK_POINT)
                        .ifPresent(rank -> ss.setRank(rank.getRankLevel(playerIn.level().getGameTime())));


        });
}
}
