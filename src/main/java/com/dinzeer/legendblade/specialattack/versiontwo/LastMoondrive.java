package com.dinzeer.legendblade.specialattack.versiontwo;

import com.dinzeer.legendblade.entity.MoonDriveEntity;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import mods.flammpfeil.slashblade.capability.concentrationrank.ConcentrationRankCapabilityProvider;
import mods.flammpfeil.slashblade.util.KnockBacks;
import mods.flammpfeil.slashblade.util.VectorHelper;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class LastMoondrive {
    public static void doSlash(LivingEntity playerIn, Vec3 centerOffset) {

        if (playerIn.level().isClientSide()) return;

        Vec3 pos = playerIn.position().add(0.0D, (double) playerIn.getEyeHeight() * 0.75D, 0.0D)
                .add(playerIn.getLookAngle().scale(0.3f));

        pos = pos.add(VectorHelper.getVectorForRotation(-90.0F, playerIn.getViewYRot(0)).scale(centerOffset.y))
                .add(VectorHelper.getVectorForRotation(0, playerIn.getViewYRot(0) + 90).scale(centerOffset.z))
                .add(playerIn.getLookAngle().scale(centerOffset.z));
        {

            MoonDriveEntity drive = new MoonDriveEntity(LBEntiteRegristrys.md, playerIn.level());

            playerIn.level().addFreshEntity(drive);
            float speed = Mth.randomBetween(drive.level().getRandom(), 0.5F, 1F);

            drive.setPos(pos.x, pos.y, pos.z);
            drive.setDamage(10);
            drive.setSpeed(speed);
            drive.shoot(playerIn.getLookAngle().x, playerIn.getLookAngle().y, playerIn.getLookAngle().z, drive.getSpeed(), 0);

            drive.setOwner(playerIn);

            drive.setRotationRoll(90);


            drive.setColor(16711680);
            drive.setIsCritical(true);
            drive.setKnockBack(KnockBacks.cancel);
            drive.setLifetime(20);

            if (playerIn != null)
                playerIn.getCapability(ConcentrationRankCapabilityProvider.RANK_POINT)
                        .ifPresent(rank -> drive.setRank(rank.getRankLevel(playerIn.level().getGameTime())));





        }
    }
}
