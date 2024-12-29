package com.dinzeer.legendblade.client;

import com.dinzeer.legendblade.regsitry.compat.ICFEntiyRegsitry;
import com.dinzeer.legendblade.regsitry.compat.L2LBcompatRegsitry;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.github.alexthe666.iceandfire.IceAndFire;
import dev.xkmc.l2hostility.init.L2Hostility;
import mods.flammpfeil.slashblade.client.renderer.entity.DriveRenderer;
import mods.flammpfeil.slashblade.client.renderer.entity.SummonedSwordRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import com.dinzeer.legendblade.client.render.*;
import static com.dinzeer.legendblade.Legendblade.MODID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT,modid = MODID)
public class LegendbladeClient {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(LBEntiteRegristrys.ss, SummonedSwordRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.sd, DriveRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ssex, SummonedSwordRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.sr, SummonedSwordRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ssdo, DriveRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ma, SevenSkillFieldRender::new);
        event.registerEntityRenderer(LBEntiteRegristrys.md, MoonDriveRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.sps, SaveAllRender::new);
        event.registerEntityRenderer(LBEntiteRegristrys.dbf, DemonBladeFragmentsRender::new);
        if(ModList.get().isLoaded(IceAndFire.MODID)){
        event.registerEntityRenderer(ICFEntiyRegsitry.FSFE, SummonedSwordRenderer::new);
        event.registerEntityRenderer(ICFEntiyRegsitry.LSS, SummonedSwordRenderer::new);
        event.registerEntityRenderer(ICFEntiyRegsitry.ISSE, SummonedSwordRenderer::new);
        }
        if (ModList.get().isLoaded(L2Hostility.MODID)){
        event.registerEntityRenderer(L2LBcompatRegsitry.HSS, SummonedSwordRenderer::new);
        }
    }
}
