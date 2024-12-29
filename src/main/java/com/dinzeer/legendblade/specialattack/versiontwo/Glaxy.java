package com.dinzeer.legendblade.specialattack.versiontwo;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.regsitry.other.LBSounds;
import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class Glaxy {



    public static void doSlash(LivingEntity playerIn) {
        playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,50,5));
       for (int z= 0;z<10;z++) {
           Level level = playerIn.level();
           if (!level.isClientSide()) {
               BlockPos blockpos = playerIn.blockPosition();
               if (playerIn.level().canSeeSky(blockpos)) {
                   LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(playerIn.level());
                   if (lightningbolt != null) {
                       playerIn.invulnerableTime = 0;
                       lightningbolt.setPos(Vec3.atBottomCenterOf(blockpos));
                       playerIn.level().addFreshEntity(lightningbolt);
                       playerIn.playSound(SoundEvents.TRIDENT_THUNDER, 5.0F, 1.0F);
                   }
               }
           }
       }
    }

}
