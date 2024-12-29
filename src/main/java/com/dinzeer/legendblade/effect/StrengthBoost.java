package com.dinzeer.legendblade.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.UUID;

public class StrengthBoost extends MobEffect
{
    protected final double multiplier =0.82;
    protected final double MaxLevel = 255;
    private static final String STRENGTH_BOOST_UUID = ("e7b6b8b2-c9a3-4f02-b6b9-e7b6b8b2c9a5");
    public StrengthBoost() {
        super(MobEffectCategory.BENEFICIAL, -26368);
        addAttributeModifier(Attributes.ATTACK_DAMAGE, STRENGTH_BOOST_UUID,  0, AttributeModifier.Operation.MULTIPLY_BASE);

    }
    @Override
    public double getAttributeModifierValue(int p_19430_, AttributeModifier p_19431_) {
        if (p_19430_ == 0) return 1.82;
        return Math.min(p_19430_, MaxLevel) * multiplier;
    }
    @Override
    public String getDescriptionId() {
        return "effect.legendblade.strength_damage";
    }
}
