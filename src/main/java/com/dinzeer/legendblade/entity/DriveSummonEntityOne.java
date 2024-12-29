package com.dinzeer.legendblade.entity;

import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.entity.Projectile;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;

public class DriveSummonEntityOne  extends EntityDrive {
    public DriveSummonEntityOne(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public static DriveSummonEntityOne createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new DriveSummonEntityOne(LBEntiteRegristrys.ssdo, worldIn);
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            Entity owner = getOwner();
            if (livingEntity == owner)return;
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 6,false,false));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 120, 6,false,false));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 120, 6,false,false));
            if (entity.isAlive()) {
                EntityDrive dv = new EntityDrive(SlashBlade.RegistryEvents.Drive, this.level());
                this.level().addFreshEntity(dv);
                dv.shoot(0, -1, 0, dv.getSpeed(), 0);
                dv.setOwner(owner);

                dv.setSpeed(0.3f);
                dv.setXRot(-0);
                dv.setYRot(-90);
                dv.setPos(entity.getX(), entity.getY() + 6, entity.getZ());
                dv.setColor(SlashbladeUtils.getcolor(owner));
                dv.setBaseSize(3);
                dv.setDamage(getDamage() * 3f);
            }
        }
    }
}
