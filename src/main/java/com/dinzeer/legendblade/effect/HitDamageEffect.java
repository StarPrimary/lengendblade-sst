package com.dinzeer.legendblade.effect;

import com.dinzeer.legendblade.specialeffects.versionone.Liuli;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class HitDamageEffect extends MobEffect {
    public HitDamageEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xff0000);
    }
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int p_19468_) {
        super.applyEffectTick(entity, p_19468_);
        final Vec3 _center = entity.position();
        if (entity.level() instanceof ServerLevel l) Liuli.sendParticleCircle(l, entity, ParticleTypes.ENCHANT, 1, 5);
        List<Entity> _entfound = entity.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        for (Entity entityiterator : _entfound) {
            if (entityiterator != entity) {
                    if (entityiterator instanceof LivingEntity) {
                        ((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.POISON, 20, 1, (false), (false)));
                        ((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 1, (false), (false)));
                        ((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 2, (false), (false)));
                        ((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 2, (false), (false)));
                        if (entityiterator.invulnerableTime <=0) {
                            if (entityiterator.level() instanceof ServerLevel l)
                                Liuli.sendParticleCircle(l, entityiterator, ParticleTypes.END_ROD, 2, 10);
                            entity.playSound(SoundEvents.ANVIL_PLACE);
                        }
                        entityiterator.hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), ((float) (entity.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.2f * (p_19468_ + 1))));
                    }
                }

        }

    }

    @Override
    public String getDescriptionId() {
        return "effect.legendblade.hit_damage";
    }
}
