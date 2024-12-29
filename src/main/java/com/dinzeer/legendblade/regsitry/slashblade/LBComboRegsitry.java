package com.dinzeer.legendblade.regsitry.slashblade;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.specialattack.versionone.*;
import com.exfantasy.mclib.Utils.SlashBlade.SlashEffectUtils;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.event.client.UserPoseOverrider;
import mods.flammpfeil.slashblade.init.DefaultResources;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.slasharts.CircleSlash;
import mods.flammpfeil.slashblade.slasharts.Drive;
import mods.flammpfeil.slashblade.slasharts.JudgementCut;
import mods.flammpfeil.slashblade.util.AttackManager;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class LBComboRegsitry {
    public static final DeferredRegister<ComboState> COMBO_STATES =
            DeferredRegister.create(ComboState.REGISTRY_KEY,MODID);



    public static final RegistryObject<ComboState> ALL_REUSE = COMBO_STATES.register
            (
                    "all_reuse",
                    ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                            .motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
                            .nextOfTimeout(entity -> SlashBlade.prefix("none"))
                            .addTickAction(ComboState.TimeLineTickAction.getBuilder().put(0, AttackManager::playQuickSheathSoundAction).build())
                            .releaseAction(ComboState::releaseActionQuickCharge)::build
            );

    public static final RegistryObject<ComboState> PROWESS = COMBO_STATES.register("prowess",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, Prowess::doSlash).build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> MP = COMBO_STATES.register("monster_power",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, MonsterPower::doSlash).build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> HP = COMBO_STATES.register("heart_slash",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1,(entityIn) -> SommonSwordSommon.doSlash(entityIn,false,10,1F))
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, (entityIn) -> Drive.doSlash(entityIn,0,20,Vec3.ZERO,false,SlashEffectUtils.addslashbladesaDamage(entityIn,5),1F))
                            .put(4, (entityIn) -> AttackManager.doSlash(entityIn, 30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(5, (entityIn) -> Drive.doSlash(entityIn,90,20,Vec3.ZERO,false,SlashEffectUtils.addslashbladesaDamage(entityIn,5),1F))
                            .put(6, (entityIn) -> AttackManager.doSlash(entityIn, 180F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(7, (entityIn) -> Drive.doSlash(entityIn,45,20,Vec3.ZERO,false,SlashEffectUtils.addslashbladesaDamage(entityIn,5),1F))
                            .put(8,(entityIn) -> SommonSwordSommon.doSlash(entityIn,false,SlashEffectUtils.addslashbladesaDamage(entityIn,10),1F))
                            .put(9,(entityIn) -> SommonSwordSommon.doSlash(entityIn,false,SlashEffectUtils.addslashbladesaDamage(entityIn,10),1F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> HPC = COMBO_STATES.register("heart_slash_c",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1,(entityIn) -> SommonSwordSommon.doSlash(entityIn,false,15,1F))
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, (entityIn) -> Drive.doSlash(entityIn,0,20,Vec3.ZERO,false,SlashEffectUtils.addslashbladesaDamage(entityIn,5),1F))
                            .put(4, (entityIn) -> AttackManager.doSlash(entityIn, 30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(5, (entityIn) -> Drive.doSlash(entityIn,90,20,Vec3.ZERO,false,SlashEffectUtils.addslashbladesaDamage(entityIn,5),1F))
                            .put(6, (entityIn) -> AttackManager.doSlash(entityIn, 180F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(7, (entityIn) -> Drive.doSlash(entityIn,45,20,Vec3.ZERO,false,SlashEffectUtils.addslashbladesaDamage(entityIn,5),1F))
                            .put(8, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(9, (entityIn) -> Drive.doSlash(entityIn,-45,20,Vec3.ZERO,false,SlashEffectUtils.addslashbladesaDamage(entityIn,5),1F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> Phantomthrust = COMBO_STATES.register("phantom_thrust",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, (entityIn) -> PhantomThrust.doSlash(entityIn,2F*3))
                            .put(9, (entityIn) -> PhantomThrust.doSlash(entityIn,2F*-3))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> Soul_Lock = COMBO_STATES.register("soul_lock",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, (entityIn) -> PhantomThrust.doSlash(entityIn,2F*-3))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> delete = COMBO_STATES.register("delete",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, (entityIn) -> SommonSwordSommon.doSlash(entityIn,14591,false,  SlashEffectUtils.addslashbladesaDamage(entityIn,5),2F,8,20))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> thatcher = COMBO_STATES.register("thatcher",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, (entityIn) -> Thatcher.doSlash(entityIn,2F))
                            .put(4, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 180))
                            .put(5, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 90))
                            .put(6, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 0))
                            .put(7, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, -90))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> HungerA = COMBO_STATES.register("hunger_absorption",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, (entityIn) -> HungerAbsorption.doSlash(entityIn,2F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> splitapart = COMBO_STATES.register("split_apart",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, (entityIn) -> Splitapart.doSlash(entityIn,2F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> greedyGrip = COMBO_STATES.register("greedy_grip",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, 30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(2, (entityIn) -> DriveSumon.doSlash(entityIn, 45F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(3, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(4, (entityIn) -> DriveSumon.doSlash(entityIn, -45F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2,SlashbladeUtils.getcolor(entityIn)))
                            .put(5, JudgementCut::doJudgementCut)
                            .put(6, GreedyGrip::doSlash)
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> flurry  = COMBO_STATES.register("flurry",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, 30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(2, (entityIn) -> DriveSumon.doSlash(entityIn, 45F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(3, (entityIn) -> DriveSumon.doSlash(entityIn, -45F, 20, Vec3.ZERO, false,SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(4, (entityIn) -> DriveSumon.doSlash(entityIn, 90F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2,SlashbladeUtils.getcolor(entityIn)))
                            .put(5, (entityIn) -> DriveSumon.doSlash(entityIn, 45F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(6, (entityIn) -> DriveSumon.doSlash(entityIn, -45F, 20, Vec3.ZERO, false,SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(7, (entityIn) -> DriveSumon.doSlash(entityIn, 90F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2,SlashbladeUtils.getcolor(entityIn)))
                            .put(8, (entityIn) -> DriveSumon.doSlash(entityIn, 45F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(9, (entityIn) -> DriveSumon.doSlash(entityIn, -45F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(10, (entityIn) -> DriveSumon.doSlash(entityIn, 90F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2,SlashbladeUtils.getcolor(entityIn)))

                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> MPSS = COMBO_STATES.register("monster_power_sommonsword",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, MonsterPower::doSlash)
                            .put(4, (entityIn) -> SommonSwordSommon.doSlash(entityIn,false,SlashEffectUtils.addslashbladesaDamage(entityIn,15),1F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static final RegistryObject<ComboState> VoidSlashPlus = COMBO_STATES.register("voidslashplus",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, JudgementCutEx::doJudgementCut)
                            .put(2, JudgementCutEx::doJudgementCut)
                            .put(3, JudgementCutEx::doJudgementCut)
                            .put(4, JudgementCutEx::doJudgementCut)
                            .put(5, JudgementCutEx::doJudgementCut)
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> swordone = COMBO_STATES.register("swordone",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))

                            .put(2, (entity)-> Swordone.doSlash(entity,false,SlashEffectUtils.addslashbladesaDamage(entity,10),2F,Vec3.ZERO))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> swordoneex = COMBO_STATES.register("swordoneex",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(3, (entity)-> Swordone.doSlash(entity,false,SlashEffectUtils.addslashbladesaDamage(entity,10),2F,Vec3.ZERO))
                            .put(4, (entity)-> Swordone.doSlash(entity,false,SlashEffectUtils.addslashbladesaDamage(entity,10),2F,Vec3.ZERO))
                            .put(5, (entity)-> Swordone.doSlash(entity,false,SlashEffectUtils.addslashbladesaDamage(entity,10),2F,Vec3.ZERO))
                            .put(6, (entity)-> Swordone.doSlash(entity,false,SlashEffectUtils.addslashbladesaDamage(entity,10),2F,Vec3.ZERO))
                            .put(7, (entity)-> Swordone.doSlash(entity,false,SlashEffectUtils.addslashbladesaDamage(entity,10),2F,Vec3.ZERO))
                            .put(8, (entity)-> Swordone.doSlash(entity,false,SlashEffectUtils.addslashbladesaDamage(entity,10),2F,Vec3.ZERO))
                            .put(9, (entity)-> Swordone.doSlash(entity,false,SlashEffectUtils.addslashbladesaDamage(entity,10),2F,Vec3.ZERO))

                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static final RegistryObject<ComboState> Thrust = COMBO_STATES.register("thrust",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> PhantomThrust.doSlash(entityIn,3F*3,2))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> Thrusta = COMBO_STATES.register("birdthrust",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> Thrusts.doSlash(entityIn,3F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static final RegistryObject<ComboState> SAKURA_END_LEFTEX = COMBO_STATES.register("sakura_end_left_ex",
            ComboState.Builder.newInstance().startAndEnd(1816, 1859).speed(6F).priority(50)
                    .next((entity) -> Legendblade.prefix("sakura_end_right_ex"))
                    .nextOfTimeout(entity -> Legendblade.prefix("sakura_end_right_ex"))
                    .clickAction((entityIn) -> AttackManager.doSlash(entityIn, 22.5F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,2)))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> Drive.doSlash(entityIn,22.5F,10,Vec3.ZERO,false,SlashEffectUtils.addslashbladesaDamage(entityIn,7),8F))
                            .build())
                    .addHitEffect(StunManager::setStun)::build);

    public static final RegistryObject<ComboState> SAKURA_END_RIGHTEX = COMBO_STATES.register("sakura_end_right_ex",
            ComboState.Builder.newInstance().startAndEnd(204, 218).speed(1.1F).priority(50)
                    .next((entity) -> Legendblade.prefix("combo_b1_end"))
                    .nextOfTimeout(entity -> Legendblade.prefix("combo_b1_end"))
                    .clickAction((entityIn) -> AttackManager.doSlash(entityIn, 180F - 22.5F, Vec3.ZERO, false, true, SlashEffectUtils.addslashbladesaDamage(entityIn,2)))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> Drive.doSlash(entityIn,180F - 22.5F,10,Vec3.ZERO,false,SlashEffectUtils.addslashbladesaDamage(entityIn,7),8F))
                            .build())
                    .addHitEffect((t, a) -> StunManager.setStun(t, 36))::build);
    public static final RegistryObject<ComboState> COMBO_B1_END = COMBO_STATES.register("combo_b1_end",
            ComboState.Builder.newInstance().startAndEnd(720, 743).priority(100)
                    .next(entity -> SlashBlade.prefix("none"))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(12 - 3, (entityIn) -> AttackManager.doSlash(entityIn, 0,
                                    new Vec3(entityIn.getRandom().nextFloat() - 0.5f, 0.8f, 0), false, true, SlashEffectUtils.addslashbladesaDamage(entityIn,10)))
                            .put(13 - 3, (entityIn) -> AttackManager.doSlash(entityIn, 5,
                                    new Vec3(entityIn.getRandom().nextFloat() - 0.5f, 0.8f, 0), true, false, SlashEffectUtils.addslashbladesaDamage(entityIn,10)))
                            .build())
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> Drive.doSlash(entityIn,180F,10,Vec3.ZERO,false,SlashEffectUtils.addslashbladesaDamage(entityIn,7),8F))
                            .put(12 - 3 + 5, (entityIn) -> UserPoseOverrider.resetRot(entityIn)).build())
                    .addHitEffect(StunManager::setStun)::build);

    public static final RegistryObject<ComboState> SlashShine  = COMBO_STATES.register("slashshine",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, 30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(2, (entityIn) -> DriveSumon.doSlash(entityIn, 45F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(3, (entityIn) -> DriveSumon.doSlash(entityIn, -45F, 20, Vec3.ZERO, false,SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(4, (entityIn) -> DriveSumon.doSlash(entityIn, 90F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2,SlashbladeUtils.getcolor(entityIn)))
                            .put(5, (entityIn) -> SommonSwordSommon.doSlash(entityIn,false,10,5F))

                            .put(10, (entityIn) -> DriveSumon.doSlash(entityIn, 90F, 20, Vec3.ZERO, false, SlashEffectUtils.addslashbladesaDamage(entityIn,15), 1f, 1f, 2,SlashbladeUtils.getcolor(entityIn)))

                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

}
