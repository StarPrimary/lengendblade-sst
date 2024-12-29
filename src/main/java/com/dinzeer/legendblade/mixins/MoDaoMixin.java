package com.dinzeer.legendblade.mixins;



import com.exfantasy.mclib.Utils.EntityPointer;
import com.exfantasy.mclib.Utils.ParticleHelper;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.entity.Projectile;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.checkerframework.checker.units.qual.C;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;


@Mixin(EntityDrive.class)
public abstract class MoDaoMixin {


    @Inject(method = "tick" , at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        EntityDrive entity = (EntityDrive)(Object)this;
        if (entity.getShooter()==null)return;

        if (entity.getPersistentData().getBoolean("modao")){
            final Vec3 _center = entity.position();

          //EntityPointer.sendParticleCircle((ServerLevel) entity.level(), entity, ParticleTypes.END_ROD, 3, 3);
            List<Entity> _entfound = entity.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator != entity.getShooter()) {
                    if (entityiterator != entity.getShooter()) {
                        if (entityiterator instanceof LivingEntity) {
                            if (entityiterator.invulnerableTime<=0) {
                                if (entityiterator.level() instanceof ServerLevel) EntityPointer.sendParticleCircle((ServerLevel) entityiterator.level(), entityiterator, ParticleTypes.ENCHANTED_HIT, 1, 2);
                            }
                            ((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 3, (false), (false)));
                            entityiterator.hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity.getShooter()), (float) ((((LivingEntity) entity.getShooter()).getAttributeValue(Attributes.ATTACK_DAMAGE))*1.3f ));


                        }
                    }
                }


            }
        }
        if (entity.getPersistentData().getBoolean("modao1")){
            final Vec3 _center = entity.position();
            boolean isD = false;
          //EntityPointer.sendParticleCircle((ServerLevel) entity.level(), entity, ParticleTypes.END_ROD, 3, 3);
            List<Entity> _entfound = entity.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator != entity.getShooter()) {
                    if (entityiterator != entity.getShooter()) {
                        if (entityiterator instanceof LivingEntity) {
                                entityiterator.invulnerableTime =0;
                                ParticleHelper.spawnHollowParticleCube(entity.level(),ParticleTypes.END_ROD,entityiterator.position(),2,2);
                                        isD=true;

                            ((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 3, (false), (false)));
                            ((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 5, (false), (false)));
                            entityiterator.hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity.getShooter()), (float) ((((LivingEntity) entity.getShooter()).getAttributeValue(Attributes.ATTACK_DAMAGE))*7.5f ));


                        }
                    }
                }


            }
            if (isD)entity.remove(Entity.RemovalReason.DISCARDED);
        }

    }
}
