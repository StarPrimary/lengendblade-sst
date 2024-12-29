package com.exfantasy.mclib.Utils.Dash;


import com.dinzeer.legendblade.Legendblade;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.PacketDistributor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import org.spongepowered.asm.mixin.Final;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
public class SMoveUtil {
    /**
     * 让一个实体围绕另一个实体做圆周运动。
     *
     * @param follower 跟随的实体。
     * @param leader 被跟随的实体。
     * @param radius 圆周运动的半径。
     * @param speed 旋转速度（每秒的旋转角度）。
     */
    public static void orbitAroundEntity(Entity follower, Entity leader, double radius, float speed) {
        Vec3 leaderPos = leader.position();
        Vec3 followerPos = follower.position();

        // 计算当前的偏移角度
        double offsetX = followerPos.x - leaderPos.x;
        double offsetZ = followerPos.z - leaderPos.z;
        double currentAngle = Math.toDegrees(Math.atan2(offsetZ, offsetX)) - 90.0D;

        // 计算新的角度
        double newAngle = currentAngle + speed;

        // 根据新角度计算新的位置
        double newX = leaderPos.x + radius * Math.cos(Math.toRadians(newAngle));
        double newZ = leaderPos.z + radius * Math.sin(Math.toRadians(newAngle));

        // 设置跟随实体的新位置
        follower.setPos(newX, leaderPos.y, newZ);

        // 设置跟随实体的朝向
        float yaw = (float) newAngle;
        follower.setYRot(yaw);
        follower.setYHeadRot(yaw);
    }
    public static void sendDashMessage(Player player, double dy, double dashDistance) {
        DashMessage message = new DashMessage( dy, dashDistance);
        if (player.level().isClientSide)return;
        Legendblade.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player), message);
    }//6
}
