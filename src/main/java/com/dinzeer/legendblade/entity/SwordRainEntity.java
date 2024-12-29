package com.dinzeer.legendblade.entity;

import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import mods.flammpfeil.slashblade.entity.EntityHeavyRainSwords;
import mods.flammpfeil.slashblade.entity.Projectile;
import mods.flammpfeil.slashblade.util.KnockBacks;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

public class SwordRainEntity extends EntityAbstractSummonedSword {
    private static final EntityDataAccessor<Boolean> IT_FIRED;
    long fireTime = -1L;
    int ON_GROUND_LIFE_TIME = 20;
    int ticksInGround = 0;

    public SwordRainEntity(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
        this.setPierce((byte)5);
        CompoundTag compoundtag = this.getPersistentData();
        ListTag listtag = compoundtag.getList("CustomPotionEffects", 9);
        MobEffectInstance mobeffectinstance = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 10);
        listtag.add(mobeffectinstance.save(new CompoundTag()));
        this.getPersistentData().put("CustomPotionEffects", listtag);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IT_FIRED, false);
    }

    public void doFire() {
        this.getEntityData().set(IT_FIRED, true);
    }

    public boolean itFired() {
        return (Boolean)this.getEntityData().get(IT_FIRED);
    }

    public static SwordRainEntity createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new SwordRainEntity(SlashBlade.RegistryEvents.HeavyRainSwords, worldIn);
    }

    public void tick() {
        if (!this.itFired() && this.level().isClientSide() && this.getVehicle() == null) {
            this.startRiding(this.getOwner(), true);
        }

        super.tick();
    }

    public void rideTick() {
        if (this.itFired() && this.fireTime <= (long)this.tickCount) {
            this.faceEntityStandby();
            this.stopRiding();
            Vec3 dir = new Vec3(0.0, -1.0, 0.0);
            this.shoot(dir.x, dir.y, dir.z, 4.0F, 2.0F);
            this.tickCount = 0;
        } else {
            this.setDeltaMovement(Vec3.ZERO);
            if (this.canUpdate()) {
                this.baseTick();
            }

            this.faceEntityStandby();
            if (!this.itFired()) {
                int basedelay = 10;
                this.fireTime = (long)(this.tickCount + basedelay + this.getDelay());
                this.doFire();
            }

        }
    }

    private void faceEntityStandby() {
        this.setPos(this.position());
        this.setRot(this.getYRot(), -90.0F);
    }

    public void setSpread(Vec3 basePos) {
        double areaSize = 2.5;
        double offsetX = (this.random.nextDouble() * 2.0 - 1.0) * areaSize;
        double offsetZ = (this.random.nextDouble() * 2.0 - 1.0) * areaSize;
        this.setPos(basePos.x + offsetX, basePos.y, basePos.z + offsetZ);
    }

    protected void onHitEntity(EntityHitResult p_213868_1_) {
        Entity targetEntity = p_213868_1_.getEntity();
        if (targetEntity instanceof LivingEntity a) {
            KnockBacks.cancel.action.accept((LivingEntity)targetEntity);
            StunManager.setStun((LivingEntity)targetEntity);
            a.invulnerableTime=0;
        }

        super.onHitEntity(p_213868_1_);
    }

    protected void tryDespawn() {
        ++this.ticksInGround;
        if (this.ON_GROUND_LIFE_TIME <= this.ticksInGround) {
            this.burst();
        }

    }

    static {
        IT_FIRED = SynchedEntityData.defineId(EntityHeavyRainSwords.class, EntityDataSerializers.BOOLEAN);
    }
}
