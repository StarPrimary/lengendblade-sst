package com.dinzeer.legendblade.events;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.entity.Compat.FireSummonSwordEntity;
import com.dinzeer.legendblade.entity.DemonBladeFragments;
import com.dinzeer.legendblade.entity.SevenSkillField;
import com.dinzeer.legendblade.regsitry.compat.ICFEntiyRegsitry;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.exfantasy.mclib.Utils.Dash.DashMessage;
import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import com.exfantasy.mclib.Utils.EntityPointer;
import com.exfantasy.mclib.Utils.PathGenerator;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import com.exfantasy.mclib.Utils.TeleportHelper;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.util.VectorHelper;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.exfantasy.mclib.Utils.Dash.ClientPacketHandler.sendDemonBladeMessage;
import static com.exfantasy.mclib.Utils.Dash.ClientPacketHandler.sendDemonBladeMessageA;

@Mod.EventBusSubscriber
public class SevenSwordSkill {
    @SubscribeEvent
    public static void appluA(PlayerInteractEvent.LeftClickEmpty event){


        if (event.getEntity().isShiftKeyDown()){
            sendDemonBladeMessageA(event.getEntity());
        }else {
            sendDemonBladeMessage(event.getEntity());
        }
        }


    @SubscribeEvent
    public static void UnLock(LivingDeathEvent event){
        if (!(event.getEntity() instanceof WitherBoss))return;
        if (event.getSource().getEntity() instanceof Player entity) {
            ItemStack stack = entity.getMainHandItem();
            CompoundTag tag = stack.getTag();
            if (stack.getTag().contains("UnLock"))return;
            if (SlashbladeUtils.getStringNBT(tag, "translationKey").equals("item.legendblade.sevensword")) {
                 stack.getCapability(ItemSlashBlade.BLADESTATE).orElse(null).setTexture(Legendblade.prefix("model/sevensword/texture0.png"));
                stack.getTag().putString("translationKey", "item.legendblade.sevensword_unlock");
                 SlashbladeUtils.setStringNBT(stack.getTag(), "TextureName", "legendblade:model/sevensword/texture0.png");
                tag.putBoolean("UnLock",true);
            //    tag.getCompound("Parent").putString("TextureName","legendblade:model/sevensword/texture0.png");
                entity.sendSystemMessage(Component.translatable("se.legendblade.tooltip.sevensowrd.4"));
                entity.level().playSound(entity, entity.getOnPos(), SoundEvents.ENDER_DRAGON_SHOOT, null);
                if (entity.level() instanceof ServerLevel serverLevel){
                    serverLevel.sendParticles(ParticleTypes.EXPLOSION, entity.getX(), entity.getY(), entity.getZ(), 15, 0.1, 1, 1, 1);
                }
            }
            if (SlashbladeUtils.getStringNBT(tag, "translationKey").equals("item.slashblade.guhunqu")) {
                tag.putBoolean("UnLock",true);
                //    tag.getCompound("Parent").putString("TextureName","legendblade:model/sevensword/texture0.png");
                entity.sendSystemMessage(Component.translatable("se.legendblade.tooltip.sevensowrd.4"));
                entity.level().playSound(entity, entity.getOnPos(), SoundEvents.ENDER_DRAGON_SHOOT, null);
                if (entity.level() instanceof ServerLevel serverLevel){
                    serverLevel.sendParticles(ParticleTypes.EXPLOSION, entity.getX(), entity.getY(), entity.getZ(), 15, 0.1, 1, 1, 1);
                }
            }
        }
        }

    @SubscribeEvent
    public static void tooltipAffix(ItemTooltipEvent event){
        ItemStack stack = event.getItemStack();
        CompoundTag tag = stack.getTag();
        if (tag == null)return;
        if( SlashbladeUtils.getStringNBT(tag,"translationKey").equals("item.legendblade.sevensword")) {
            if (!stack.getTag().contains("UnLock")) {
                event.getToolTip().set(0, Component.translatable("se.legendblade.tooltip.sevensowrd.1").append(event.getToolTip().get(0)));
                event.getToolTip().add(Component.translatable("se.legendblade.tooltip.sevensowrd.2"));

            }else {
                event.getToolTip().set(0, Component.translatable("se.legendblade.tooltip.sevensowrd.3").append(event.getToolTip().get(0)));
            }

        }
    }
    @SubscribeEvent
    public static void slash(SlashBladeEvent.DoSlashEvent event){
       /* CompoundTag tag = event.getBlade().getTag();
        if( SlashbladeUtils.getStringNBT(tag,"translationKey").equals("item.legendblade.sevensword")) {
            if (((Player) event.getUser()).experienceLevel >=LBSpecialEffectsRegistry.FragmentedEdge.get().getRequestLevel()){
                SlashbladeUtils.setStringNBT(tag,"TextureName","legendblade:model/sevensword/texture0.png");
            }
        }*/

        LivingEntity entity = event.getUser();
        ItemStack stack =event.getBlade();
        a(entity,stack,null);
        final Vec3 _center = entity.position();
        if (entity.hasEffect(Legendblade.EffectAbout.MO_DAO.get())){
            List<Entity> _entfound = entity.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 * 4 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
              for (Entity entity2 : _entfound){
                if (entity2 instanceof LivingEntity livingEntity){
                    if (entity2!=entity){
                        livingEntity.invulnerableTime = 0;
                        entity2.hurt(new DamageSource(entity2.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), (float) entity.getAttributeValue(Attributes.ATTACK_DAMAGE)*1);

                    }
                }
                if (entity2 instanceof SevenSkillField sevenSkillField){
                    entity.lookAt(EntityAnchorArgument.Anchor.EYES, sevenSkillField.position());
                    if (entity.level() instanceof ServerLevel level1) {
                        TeleportHelper.teleportEntityInCube(level1,entity,entity2.getOnPos().getCenter(),8);
                    }
                    RandomSource random = entity2.level().getRandom();
                    for (int i = 0; i < random.nextInt(3)+1; i++) {


                        EntityDrive drive = new EntityDrive(SlashBlade.RegistryEvents.Drive, entity.level());

                        entity.level().addFreshEntity(drive);

                        drive.setBaseSize(60);
                        drive.getDimensions(Pose.STANDING).scale(36, 36);
                        drive.getPersistentData().putBoolean("modao", true);
                        drive.getPersistentData().putBoolean("modao1", true);


                        drive.setPos(_center.x, _center.y, _center.z);
                        drive.setDamage(1.5f);
                        drive.setSpeed(1.0f+i*0.2f);
                        Vec3 directionVec = sevenSkillField.position().subtract(entity.position()).normalize();

                        drive.shoot(directionVec.x, directionVec.y, directionVec.z, drive.getSpeed(), 0);
                        drive.setColor(5177599);
                        drive.setOwner(entity);

                        drive.setLifetime(60);
                    }
                }
            }
        }
    }

        public static void a(LivingEntity entity,ItemStack stack,LivingEntity tartget2) {
            if (stack.getTag()==null)return;
            if (!stack.getTag().getBoolean("UnLock")) return;
            if (SlashbladeUtils.hasSpecialEffect(stack, (LBSpecialEffectsRegistry.FragmentedEdge.getId()).toString())) {
                if (entity.hasEffect(Legendblade.EffectAbout.MO_DAO.get()))return;
                LivingEntity target = EntityPointer.raycastForEntityTo(entity.level(), entity, 16, true);
                if (target == null) {
                    Optional<LivingEntity> targetedEntity = EntityPointer.findTargetedEntity(entity, 10);
                    if (targetedEntity.isEmpty()) return;
                    target = targetedEntity.get();
                }
                Vec3 pos = entity.position().add(0.0D, (double) entity.getEyeHeight() * 0.75D, 0.0D)
                        .add(entity.getLookAngle().scale(0.3f));
                Vec3 centerOffset = new Vec3(0.0D, 0.0D, 0.0D);
                pos = pos.add(VectorHelper.getVectorForRotation(-90.0F, entity.getViewYRot(0)).scale(centerOffset.y))
                        .add(VectorHelper.getVectorForRotation(0, entity.getViewYRot(0) + 90).scale(centerOffset.z))
                        .add(entity.getLookAngle().scale(centerOffset.z));
                EntityDrive drive = new EntityDrive(SlashBlade.RegistryEvents.Drive, entity.level());

                entity.level().addFreshEntity(drive);

                drive.setBaseSize(50);
                drive.getDimensions(Pose.STANDING).scale(18, 18);
                drive.getPersistentData().putBoolean("modao", true);


                drive.setPos(pos.x, pos.y, pos.z);
                drive.setDamage(1f);
                drive.setSpeed(1.2f);
                Vec3 directionVec = target.position().subtract(entity.position()).normalize();

                drive.shoot(directionVec.x, directionVec.y, directionVec.z, drive.getSpeed(), 0);
                drive.setColor(5177599);
                drive.setOwner(entity);

                drive.setLifetime(60);
                List<Vec3> vl = PathGenerator.generatePath(Vec3.atCenterOf(entity.blockPosition()), Vec3.atCenterOf(target.blockPosition()));
                for (Vec3 v : vl) {
                    if (entity.level() instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.DRAGON_BREATH, v.x(), v.y(), v.z(), 4, 0.3, 0.3, 0.3, 0.1);
                        {
                            final Vec3 _center = v;
                            List<Entity> _entfound = serverLevel.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                            for (Entity entityiterator : _entfound) {
                                if (entityiterator != entity) {
                                    if (entityiterator instanceof LivingEntity) {
                                        entity.heal((float) (entity.getMaxHealth() * 0.01));
                                        entityiterator.invulnerableTime = 0;
                                        entityiterator.hurt(new DamageSource(serverLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), (float) (entity.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5 + 2));
                                    }
                                }
                            }
                        }
                    }
                }
                entity.teleportTo(target.getX(), target.getY(), target.getZ());
                if (entity instanceof Player player) {SMoveUtil.sendDashMessage(player, 0, 1.4);}
                else {
                   DashMessage.vmove(entity,0,1.4);
                }
                // player.lookAt(EntityAnchorArgument.Anchor.EYES, target.position().add(0,0.5,0));

                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 2));
                entity.addEffect(new MobEffectInstance(Legendblade.EffectAbout.HIT_DAMAGE.get(), 25, 2));
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 3));
                entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 2));
                // entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 30, 5));
                entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 30, 5));
                entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 2));

            }
        }
    }


