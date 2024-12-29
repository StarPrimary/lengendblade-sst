package com.dinzeer.legendblade.specialattack.versionone;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.regsitry.other.LBSounds;
import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class Thrusts {




    public static void doSlash(LivingEntity playerIn, float speed) {
        playerIn.addEffect(new MobEffectInstance(Legendblade.EffectAbout.HIT_DAMAGE.get(),50,2));
        playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,50,0));
        playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,50,0));
        playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION,50,0));
        playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,50,0));
        SMoveUtil.sendDashMessage((Player) playerIn,0,speed);


        execute( playerIn.level(),playerIn.getY(),playerIn.getY(),playerIn.getZ());



    }
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(null, BlockPos.containing(x, y, z),
                        ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("legendblade:godbird")),
                        SoundSource.PLAYERS, 10, 10);
            } else {
                _level.playLocalSound(x, y, z,
                        Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(LBSounds.godbird.getId()
                        )), SoundSource.PLAYERS, 1, 1, false);
            }
        }
    }



}
