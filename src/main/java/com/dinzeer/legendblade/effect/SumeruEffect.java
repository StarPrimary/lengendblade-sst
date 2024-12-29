package com.dinzeer.legendblade.effect;

import com.dinzeer.legendblade.Legendblade;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SumeruEffect extends MobEffect {
    public SumeruEffect() {
        super(MobEffectCategory.BENEFICIAL, -26368);
    }
    @SubscribeEvent
    public static void recordDamage(LivingHurtEvent event){
        LivingEntity entity = event.getEntity();
        if (entity!=null) {
            if (event.getSource().getEntity() instanceof LivingEntity entity1) {
                if (entity1.hasEffect(Legendblade.EffectAbout.SUMERU.get())) {
                    event.setAmount(event.getAmount() * (entity1.getEffect(Legendblade.EffectAbout.SUMERU.get()).getAmplifier() * 0.3f + 1));
                }
            }
            if (entity.hasEffect(Legendblade.EffectAbout.SUMERU.get())) {
                entity.getPersistentData().putFloat("Sumereu_damage", entity.getPersistentData().getFloat("Sumereu_damage") + event.getAmount());

                event.setCanceled(true);

            }
        }

    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap p_19470_, int p_19471_) {
        float damage = entity.getPersistentData().getFloat("Sumereu_damage");
        entity.getPersistentData().remove("Sumereu_damage");
        entity.hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), damage*0.75f);
    }
}
