package com.dinzeer.legendblade.entity;

import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import mods.flammpfeil.slashblade.entity.IShootable;
import mods.flammpfeil.slashblade.entity.Projectile;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.util.KnockBacks;
import mods.flammpfeil.slashblade.util.RayTraceHelper;
import mods.flammpfeil.slashblade.util.TargetSelector;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import org.joml.Vector3f;

import java.util.Optional;
import java.util.stream.Stream;

public class SpSumonSwordEntity extends EntityAbstractSummonedSword {
    private static final EntityDataAccessor<Boolean> IT_FIRED = SynchedEntityData.defineId(SpSumonSwordEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> SPEED = SynchedEntityData.defineId(SpSumonSwordEntity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Vector3f> OFFSET = SynchedEntityData.defineId(SpSumonSwordEntity.class, EntityDataSerializers.VECTOR3);
    long fireTime = -1;

    public SpSumonSwordEntity(EntityType<? extends Projectile> entityTypeIn, Level worldIn)
    {
        super(entityTypeIn, worldIn);

        this.setPierce((byte) 5);
    }

    public static SpSumonSwordEntity createInstance(PlayMessages.SpawnEntity packet, Level worldIn)
    {
        return new SpSumonSwordEntity(LBEntiteRegristrys.ss, worldIn);
    }

    @Override
    protected void defineSynchedData()
    {
        super.defineSynchedData();

        this.entityData.define(IT_FIRED, false);
        this.entityData.define(SPEED, 3.0f);
        this.entityData.define(OFFSET, Vec3.ZERO.toVector3f());
    }

    public void doFire() {
        this.getEntityData().set(IT_FIRED, true);
    }

    public boolean itFired() {
        return this.getEntityData().get(IT_FIRED);
    }

    public void setSpeed(float speed)
    {
        this.getEntityData().set(SPEED, speed);
    }

    public float getSpeed() {return this.getEntityData().get(SPEED);}

    public void setOffset(Vec3 offset)
    {
        this.getEntityData().set(OFFSET, offset.toVector3f());
    }

    public Vec3 getOffset() {return new Vec3(this.getEntityData().get(OFFSET));}


    @Override
    public void tick()
    {
        if (!itFired() && level().isClientSide() && getVehicle() == null)
        {
            startRiding(this.getOwner(), true);
        }

        super.tick();
    }

    @Override
    public void rideTick()
    {
        if (itFired())
        {
            faceEntityStandby();
            Entity target = getVehicle();
            this.stopRiding();

            this.tickCount = 0;
            Vec3 dir = this.getViewVector(1.0f);

            if (target != null)
            {
                dir = this.position().subtract(target.position()).multiply(1, 0, 1).normalize();
            }
            this.shoot(dir.x, dir.y, dir.z, this.getSpeed(), 1.0f);
            if (target instanceof ServerPlayer)
            {
                ((ServerPlayer) target).playNotifySound(SoundEvents.ENDER_DRAGON_FLAP, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
            return;
        }

        this.setDeltaMovement(Vec3.ZERO);
        if (canUpdate()) this.baseTick();

        faceEntityStandby();

        if (tickCount >= getDelay()) doFire();
    }

    private void faceEntityStandby()
    {
        if (this.getVehicle() == null)
        {
            doFire();
            return;
        }
        int countPerRound = 24;
        double degPerRound = 360.0 / countPerRound;
        double degYaw = (getDelay() * degPerRound) - ((int) ((getDelay() * degPerRound) / 360.0)) * 360.0;
        double yaw = Math.toRadians(degYaw - 180);

        Vec3 dir = this.getOffset();

        // yaw
        dir = dir.yRot((float) -yaw);
        dir = dir.normalize().scale(2);

        dir = dir.add(this.getVehicle().position());

        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();

        setPos(dir);
        setRot((float) (-degYaw), 0);
    }
    @Override
    protected void onHitEntity(EntityHitResult result)
    {

        Entity targetEntity = result.getEntity();
        if (targetEntity instanceof LivingEntity)
        {
            KnockBacks.cancel.action.accept((LivingEntity) targetEntity);
            StunManager.setStun((LivingEntity) targetEntity);
        }
        if (targetEntity instanceof LivingEntity lv) {
            lv.heal(20);
        }
        super.onHitEntity(result);
    }
}
