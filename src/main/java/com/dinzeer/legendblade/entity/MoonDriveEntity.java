package com.dinzeer.legendblade.entity;

import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.entity.Projectile;
import mods.flammpfeil.slashblade.util.KnockBacks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;

public class MoonDriveEntity extends EntityDrive {
    public MoonDriveEntity(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }
    public static MoonDriveEntity createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new MoonDriveEntity(LBEntiteRegristrys.md, worldIn);
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        if (entity.isOnFire() && entity.isAlive()) {
            entity.extinguishFire();
        }
        if (entity instanceof LivingEntity) {
            KnockBacks.cancel.action.accept((LivingEntity)entity);
            StunManager.setStun((LivingEntity)entity);
        }
        this.level().explode(this, this.getX(), this.getY(), this.getZ(), 4, Level.ExplosionInteraction.NONE);


    }

}
