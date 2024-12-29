package com.dinzeer.legendblade.specialeffects.compat.iceandfire;

import com.dinzeer.legendblade.regsitry.compat.ICFLBcompatRegsitry;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.entity.props.EntityDataProvider;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import javax.swing.text.html.HTMLDocument;
@Mod.EventBusSubscriber
public class Lightnings extends SpecialEffect {
    public Lightnings() {
        super(0,false,false);
    }
    @SubscribeEvent
    public static void ice(SlashBladeEvent.HitEvent event){
        if (ModList.get().isLoaded(IceAndFire.MODID)) {

        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(ICFLBcompatRegsitry.lightning.getId())) {
            LivingEntity user = event.getUser();
            if (!(user instanceof Player)) {
                return;
            }

            LivingEntity target = event.getTarget();
            BlockPos blockpos = target.blockPosition();
            Level level = target.level();
            Player player = (Player) event.getUser();
            if (SpecialEffect.isEffective(ICFLBcompatRegsitry.ice.get(), player.experienceLevel)) {
                LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(level);
                if (lightningbolt != null) {
                    lightningbolt.moveTo(Vec3.atBottomCenterOf(blockpos));
                    lightningbolt.setCause(user instanceof ServerPlayer ? (ServerPlayer) user : null);
                    level.addFreshEntity(lightningbolt);
                    user.playSound(SoundEvents.TRIDENT_THUNDER, 5.0F, 1.0F);
                }
            }
        }
    }
    }
}//还有一个对注册名前半边有“iceandfire”的生物造成伤害翻倍的效果
