package com.dinzeer.legendblade.regsitry.slashblade;

import com.dinzeer.legendblade.specialattack.versiontwo.SaveAll;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class LBslashArtRegsitry {
    public static final DeferredRegister<SlashArts> SLASH_ARTS =
            DeferredRegister.create(SlashArts.REGISTRY_KEY, MODID);

    public static final RegistryObject<SlashArts> PROWESS;
    public static final RegistryObject<SlashArts> MP;
    public static final RegistryObject<SlashArts> HP;
    public static final RegistryObject<SlashArts> HPC;
    public static final RegistryObject<SlashArts> PhantomThrust;
    public static final RegistryObject<SlashArts> soullock;
    public static final RegistryObject<SlashArts> Thatcher;
    public static final RegistryObject<SlashArts> HungerAbsorption;
    public static final RegistryObject<SlashArts> Splitapart;
    public static final RegistryObject<SlashArts> GreedyGrip;
    public static final RegistryObject<SlashArts> flurry;
    public static final RegistryObject<SlashArts> MPSS;
    public static final RegistryObject<SlashArts> VoidSlashPlus;
    public static final RegistryObject<SlashArts> Thrust;
    public static final RegistryObject<SlashArts> SAKURAENDEX;
    public static final RegistryObject<SlashArts> swordone;
    public static final RegistryObject<SlashArts> swordoneex;
    public static final RegistryObject<SlashArts> Thrusts;
    public static final RegistryObject<SlashArts> SlashShine;
    public static final RegistryObject<SlashArts> delete;
    public static final RegistryObject<SlashArts> BloodThrusts;
    public static final RegistryObject<SlashArts> sevenbladeslash;
    public static final RegistryObject<SlashArts> MoonDrive;
    public static final RegistryObject<SlashArts> FrogGlaxy;
    public static final RegistryObject<SlashArts> SaveAll;
    public static final RegistryObject<SlashArts> Elbowstrike;
    public static final RegistryObject<SlashArts> swordRain;

    static {
        PROWESS=SLASH_ARTS.register("prowess", () -> new SlashArts((e) ->
                LBComboRegsitry.PROWESS.getId()));
        MP=SLASH_ARTS.register("monster_power", () -> new SlashArts((e) ->
                LBComboRegsitry.MP.getId()));
        HP=SLASH_ARTS.register("heart_slash", () -> new SlashArts((e) ->LBComboRegsitry.HP.getId()));
        HPC=SLASH_ARTS.register("heart_slashc", () -> new SlashArts((e) ->LBComboRegsitry.HPC.getId()));
        PhantomThrust=SLASH_ARTS.register("phantom_thrust", () -> new SlashArts((e) ->
                LBComboRegsitry.Phantomthrust.getId()));
        soullock=SLASH_ARTS.register("soul_lock", () -> new SlashArts((e) ->
                LBComboRegsitry.Soul_Lock.getId()));
        Thatcher=SLASH_ARTS.register("thatcher", () -> new SlashArts((e) ->
                LBComboRegsitry.thatcher.getId()));
        HungerAbsorption=SLASH_ARTS.register("hunger_absorption", () -> new SlashArts((e) ->
                LBComboRegsitry.HungerA.getId()));
        Splitapart=SLASH_ARTS.register("split_apart", () -> new SlashArts((e) ->
                LBComboRegsitry.splitapart.getId()));
        GreedyGrip=SLASH_ARTS.register("greedy_grip", () -> new SlashArts((e) ->
                LBComboRegsitry.greedyGrip.getId()));
        flurry=SLASH_ARTS.register("flurry", () -> new SlashArts((e) ->
                LBComboRegsitry.flurry.getId()));
        MPSS=SLASH_ARTS.register("mpss", () -> new SlashArts((e) ->LBComboRegsitry.MPSS.getId()));
        VoidSlashPlus=SLASH_ARTS.register("void_slash_plus", () -> new SlashArts((e) ->LBComboRegsitry.VoidSlashPlus.getId()));
        Thrust=SLASH_ARTS.register("thrust", () -> new SlashArts((e) ->LBComboRegsitry.Thrust.getId()));
        SAKURAENDEX=SLASH_ARTS.register("sakura_endex", () -> new SlashArts((e) ->LBComboRegsitry.SAKURA_END_LEFTEX.getId()));
        swordone=SLASH_ARTS.register("swordone", () -> new SlashArts((e) ->LBComboRegsitry.swordone.getId()));
        swordoneex=SLASH_ARTS.register("swordoneex", () -> new SlashArts((e) ->LBComboRegsitry.swordoneex.getId()));
        Thrusts=SLASH_ARTS.register("birdthrust", () -> new SlashArts((e) ->LBComboRegsitry.Thrusta.getId()));
        SlashShine=SLASH_ARTS.register("slashshine",() -> new SlashArts((e) ->LBComboRegsitry.SlashShine.getId()));
        delete=SLASH_ARTS.register("delete",() -> new SlashArts((e) ->LBComboRegsitry.delete.getId()));
        BloodThrusts=SLASH_ARTS.register("bloodbirdthrust",() -> new SlashArts((e) ->LBComboRegsitryA.Bloodthrusts.getId()));
        sevenbladeslash=SLASH_ARTS.register("sevenbladeslash",() -> new SlashArts((e) ->LBComboRegsitryA.sevenbladeslash.getId()));
        MoonDrive=SLASH_ARTS.register("moondrive",() -> new SlashArts((e) ->LBComboRegsitryA.MoonDrive.getId()));
        FrogGlaxy=SLASH_ARTS.register("frog_glaxy",() -> new SlashArts((e) ->LBComboRegsitryA.FrogGlaxy.getId()));
        SaveAll =SLASH_ARTS.register("save_all",() -> new SlashArts((e) ->LBComboRegsitryA.saveall.getId()));
        Elbowstrike=SLASH_ARTS.register("elbowstrike",() -> new SlashArts((e) ->LBComboRegsitryA.elbowstrike.getId()));
        swordRain=SLASH_ARTS.register("swordrain",() -> new SlashArts((e) ->LBComboRegsitryA.swordRain.getId()));
    }
}
