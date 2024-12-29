package com.dinzeer.legendblade.specialeffects.versionone;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber
public class Liuli extends SpecialEffect {

    public Liuli() {
        super(30,false,false);
    }
    public static int apply(LivingEntity player){
        int level = player.getActiveEffects().stream().filter(e -> e.getEffect() != Legendblade.EffectAbout.STRENGTH_BOOST.get()).toList().size();
        if (level <=0)return level;
        player.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
        player.addEffect(new MobEffectInstance(Legendblade.EffectAbout.STRENGTH_BOOST.get(),600,level-1));
        return  level;
    }
    public static void sendParticleCircle(ServerLevel level, Entity entity, SimpleParticleType particleType, float radius, int count) {
        double posX = entity.getX();
        double posY = entity.getY() + entity.getBbHeight() * 0.5;
        double posZ = entity.getZ();

        RandomSource random = RandomSource.create(); // 创建随机数生成器

        for (int i = 0; i < count; i++) {
            // 计算角度
            double angle = i * (2 * Math.PI / count);

            // 在圆周上计算粒子位置
            double offsetX = radius * Math.cos(angle);
            double offsetZ = radius * Math.sin(angle);

            // 添加一点随机偏移，使粒子分散
            offsetX += random.nextDouble() * 0.1 - 0.05;
            offsetZ += random.nextDouble() * 0.1 - 0.05;

            // 发送粒子
            level.sendParticles(particleType, posX + offsetX, posY, posZ + offsetZ, 1, 0.0, 0.0, 0.0, 0.05);
        }
    }
    @SubscribeEvent
    public static void use(SlashBladeEvent.DoSlashEvent event){
        ISlashBladeState state = event.getSlashBladeState();
        if (event.getUser() instanceof  Player player){
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.Liuli.getId())) {
            int apply = apply(player);
            if (apply<=0)return;
            MutableComponent translatable = Component.translatable("legendblade.message.liuli", apply);
            player.displayClientMessage(translatable, true);
            player.playSound(SoundEvents.ZOMBIE_ATTACK_WOODEN_DOOR);
            if (player.level() instanceof  ServerLevel level){
                sendParticleCircle(level,player, ParticleTypes.SMOKE,apply, apply*3);
            }


        }
        }
    }
}
