package com.dinzeer.legendblade.client.screen;

import com.dinzeer.legendblade.Legendblade;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.network.chat.CommonComponents;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import static com.dinzeer.legendblade.Legendblade.MODID;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SumeruEffectScreen {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int w = event.getWindow().getGuiScaledWidth();
        int h = event.getWindow().getGuiScaledHeight();
        Level world = null;
        double x = 0;
        double y = 0;
        double z = 0;
        int init1 = 0;
        Player entity = Minecraft.getInstance().player;
        if (!entity.hasEffect(Legendblade.EffectAbout.SUMERU.get()))return;

        if (entity != null) {
            world = entity.level();
            x = entity.getX();
            y = entity.getY();
            z = entity.getZ();
        }
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(1, 1, 1, 1);
            event.getGuiGraphics().blit(new ResourceLocation(MODID+ ":textures/screens/red.png"), 0, 0, 0, 0, event.getWindow().getWidth(), event.getWindow().getHeight(), 200, 5);
      /*     if (entity.getPersistentData().getBoolean("zhan"))
           {
               event.getGuiGraphics().blit(new ResourceLocation(MODID+ ":textures/screens/zhan.png"), 0, 0, 0, 0, event.getWindow().getWidth(), event.getWindow().getHeight(), 200, 5);
           }*/
            RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1, 1, 1, 1);
    }
}
