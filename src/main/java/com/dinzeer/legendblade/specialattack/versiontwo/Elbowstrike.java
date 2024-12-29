package com.dinzeer.legendblade.specialattack.versiontwo;

import com.exfantasy.mclib.Utils.Dash.DashMessage;
import com.exfantasy.mclib.Utils.EntityPointer;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class Elbowstrike {
    public static void doSlash(LivingEntity playerIn) {
        LivingEntity target = EntityPointer.raycastForEntityTo(playerIn.level(), playerIn, 32, true);
        if (target == null) {
            Optional<LivingEntity> targetedEntity = EntityPointer.findTargetedEntity(playerIn, 10);
            if (targetedEntity.isEmpty()) return;
            target = targetedEntity.get();
        }
        if (target!=null){
            DashMessage.vmove(target,3,-10)  ;      }




    }



}

