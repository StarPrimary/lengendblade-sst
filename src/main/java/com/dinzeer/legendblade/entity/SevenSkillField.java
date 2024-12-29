package com.dinzeer.legendblade.entity;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.events.SevenSwordSkill;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.dinzeer.legendblade.regsitry.slashblade.LBComboRegsitryA;
import com.dinzeer.legendblade.regsitry.slashblade.LBslashArtRegsitry;
import com.dinzeer.legendblade.specialattack.compat.iceandfire.Lightning;
import com.exfantasy.ServerSideHelper;
import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import com.exfantasy.mclib.Utils.EntityPointer;
import com.exfantasy.mclib.Utils.ParticleHelper;
import com.exfantasy.mclib.Utils.TeleportHelper;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.entity.Projectile;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.slasharts.Drive;
import mods.flammpfeil.slashblade.util.NBTHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import org.checkerframework.checker.units.qual.A;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SevenSkillField extends Projectile {
    static {
        SIZE = SynchedEntityData.defineId(SevenSkillField.class, EntityDataSerializers.INT);

    }
    public int getSIZE() {
        return (Integer)this.getEntityData().get(SIZE);
    }
    public void setSIZE(int value) {
        this.getEntityData().set(SIZE, value);
    }
    public void setDuring(int value){
      this.getPersistentData().putInt( "during",value);
    }
    public int getDuring(){
        return this.getPersistentData().getInt("during");
    }
    public void setDamage(float value){
        this.getPersistentData().putFloat("damage",value);
    }
    public float getDamage(){
        return this.getPersistentData().getFloat("damage");
    }

    private static final   EntityDataAccessor<Integer> SIZE ;

    public SevenSkillField(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
        this.setDuring(20);
    }

    @Override
    public boolean isInvisible() {
        return true;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SIZE, 5);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        NBTHelper.getNBTCoupler(compound).get("SIZE", this::setSIZE, new Integer[0]);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        NBTHelper.getNBTCoupler(compound).put("SIZE", new Integer[]{this.getSIZE()});
    }
    public static SevenSkillField createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new SevenSkillField(LBEntiteRegristrys.ma, worldIn);
    }
    private static final Random rand = new Random();
    @Override
    public void tick() {
        super.tick();
        if (getDuring() > 0){

            int size = this.getSIZE() + 1;
            final Vec3 _center = this.position();

            if (getDuring()>20)
                ParticleHelper.spawnHollowParticleCube(this.level(), ParticleTypes.DRAGON_BREATH, this.position(), size, 3);
            else    if  (getDuring()>10)
                ParticleHelper.spawnHollowParticleCube(this.level(), ParticleTypes.DRAGON_BREATH, this.position(), (float) (size*( 0.05*getDuring())), 3);
            else  if (getDuring()<=10 && getDuring()!=1) {
                ParticleHelper.spawnHollowParticleCube(this.level(), ParticleTypes.DRAGON_BREATH, this.position(), size * (5 * ((float) 1 / getDuring())), 3);
                if (getOwner() !=null){
                    ((LivingEntity) getOwner()).addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,4,10));
                    getOwner().lookAt(EntityAnchorArgument.Anchor.EYES, _center);
                //    getOwner().teleportTo(this.getX(), this.getY()+size*0.2*getDuring(), this.getZ());
                    if(!((LivingEntity) getOwner()).getMainHandItem().isEmpty()) {
                        SevenSwordSkill.a(((LivingEntity) getOwner()), ((LivingEntity) getOwner()).getMainHandItem(), null);
                    } //  Lightning.doSlash(((LivingEntity) getOwner()),true,getDamage()*2,1);
                }
            }
            if(getDuring()==1){
                if (getOwner()!=null) {
                    if (getOwner() instanceof Player player) {
                        if (player.level() instanceof ServerLevel level) {
                            level.sendParticles(ParticleTypes.END_ROD,this.getX(), this.getY(), this.getZ(), 110,3,6,6,6);;
                        }
                        List<Entity> _entfound1 = this.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(this.getSIZE() * 6 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        player.addEffect(new MobEffectInstance(Legendblade.EffectAbout.STRENGTH_BOOST.get(),20,3));

                        for (Entity entityiterator : _entfound1) {
                            if (entityiterator instanceof Player player1){
                                player1.playSound(SoundEvents.WITHER_DEATH);
                            }
                            if (entityiterator != this) {
                                if (entityiterator != getOwner()) {
                                    if (entityiterator instanceof LivingEntity livingEntity) {
                                        entityiterator.invulnerableTime = 0;
                                        entityiterator.hurt(new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), getOwner()), (float) (getDamage())*15);
                                       // SMoveUtil.orbitAroundEntity(entityiterator, this, this.getSIZE() , 2.5f);
                                        entityiterator.setDeltaMovement(rand.nextDouble(getSIZE()*-1, getSIZE())*0.1, rand.nextDouble(getSIZE()*-1, getSIZE())*0.1, rand.nextDouble(getSIZE()*-1, getSIZE())*0.1);
                                        player.heal(player.getMaxHealth()*0.1f);
                                        SevenSwordSkill.a(player,player.getMainHandItem(),livingEntity);

                                    }
                                }
                            }
                            getOwner().teleportTo(this.getX(), this.getY()+1, this.getZ());
                        }
                    }
                    }
            }
            //ParticleHelper.spawnParticleCubeClient(this.level(), ParticleTypes.END_ROD, this.position(), this.getSIZE()+1, 8);

            if (getOwner()!=null) {
                if (getOwner() instanceof Player player) {

                    ItemStack mainHandItem = player.getMainHandItem();
                    if (mainHandItem.getTag()!=null && mainHandItem.getTag().contains("SACooldwon")) {
                        if (mainHandItem.getTag().getInt("SACooldwon") > 0) {
                            if (player.level() instanceof ServerLevel level) {
                              //  TeleportHelper.teleportEntityInCube(level, player, this.getOnPos().getCenter(), size);
                                level.sendParticles(ParticleTypes.SOUL,player.getX(), player.getY()+1, player.getZ(), 8, 0.5, 0.3,0.3,0.3);
                              //  ServerSideHelper.simulateRightClick(((ServerPlayer) player));
                            }
                           // player.lookAt(EntityAnchorArgument.Anchor.EYES, this.position());
                            LBComboRegsitryA.sevenbladeslash.get().clickAction(player);

                        }
                    }
                    List<Entity> _entfound2 = this.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(this.getSIZE()  / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    if (_entfound2.contains(player)){
                        player.addEffect(new MobEffectInstance(Legendblade.EffectAbout.MO_DAO.get(),2,0,false,false));

                    }
                    List<Entity> _entfound = this.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(this.getSIZE() * 4 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();

                    for (Entity entityiterator : _entfound) {
                        if (entityiterator == player){
                            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,20,10));
                        }
                        if (!entityiterator.getPersistentData().getBoolean("modao")) {
                            if (entityiterator instanceof DriveSummonEntity drive) {
                                for (Entity entity : _entfound) {
                                    if (entity != this) {
                                        if (entity != player) {
                                            if (entity instanceof LivingEntity livingEntity) {
                                                livingEntity.invulnerableTime = 0;
                                                livingEntity.hurt(new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), player), (float) (drive.getDamage() * drive.getSpeed()));

                                            }
                                        }
                                    }
                                }
                                drive.remove(RemovalReason.DISCARDED);

                            }
                        }
                        if (entityiterator instanceof SumonSwordEntity drive){
                            for (Entity entity : _entfound){
                                if (entity != this) {
                                    if (entity != player) {
                                        if (entity instanceof LivingEntity livingEntity) {
                                            livingEntity.invulnerableTime = 0;
                                            livingEntity.hurt(new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), player), (float) (drive.getDamage()*drive.getSpeed()));

                                        }
                                    }
                                }
                            }
                            drive.remove(RemovalReason.DISCARDED);
                        }

                        if (entityiterator != this) {
                            if (entityiterator != getOwner()) {
                                if (entityiterator instanceof LivingEntity livingEntity) {

                                    livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 20, 1, (false), (false)));
                                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 1, (false), (false)));
                                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 2, (false), (false)));
                                    livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 2, (false), (false)));
                                    entityiterator.hurt(new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), player), (float) (getDamage()));
                                    SMoveUtil.orbitAroundEntity(entityiterator, this, this.getSIZE() * 0.2, 0.5f);
                                    //SevenSwordSkill.a(player,mainHandItem,livingEntity);
                                }
                            }
                        }
                    }
                }
            }
            setDuring(getDuring() - 1);
        }else {
            this.remove(RemovalReason.DISCARDED);
        }
    }

}
