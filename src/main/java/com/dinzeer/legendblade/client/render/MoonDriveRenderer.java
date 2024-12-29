package com.dinzeer.legendblade.client.render;


import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.entity.MoonDriveEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModelManager;
import mods.flammpfeil.slashblade.client.renderer.model.obj.WavefrontObject;
import mods.flammpfeil.slashblade.client.renderer.util.BladeRenderState;
import mods.flammpfeil.slashblade.client.renderer.util.MSAutoCloser;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MoonDriveRenderer<T extends MoonDriveEntity> extends EntityRenderer<T> {
    private static final ResourceLocation TEXTURE = Legendblade.prefix("model/util/ss.png");
    private static final ResourceLocation MODEL = Legendblade.prefix("model/util/moondrive.obj");

    @Nullable
    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return entity.getTextureLoc();
    }

    public MoonDriveRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(T entity, float entityYaw, float partialTicks, PoseStack matrixStack, @NotNull MultiBufferSource bufferIn,
                       int packedLightIn) {

        try (MSAutoCloser ignored = MSAutoCloser.pushMatrix(matrixStack)) {
            float lifetime = entity.getLifetime();
            double deathTime = lifetime;
            double baseAlpha = (Math.min(deathTime, Math.max(0, (lifetime - (entity.tickCount))))
                    / deathTime);
            baseAlpha = Math.max(0, -Math.pow(baseAlpha - 1, 4.0) + 0.75);

            matrixStack.mulPose(
                    Axis.YP.rotationDegrees(Mth.rotLerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
            matrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.rotLerp(partialTicks, entity.xRotO, entity.getXRot())));
            matrixStack.mulPose(Axis.XP.rotationDegrees(entity.getRotationRoll()));

            float scale = 0.015f;
            matrixStack.scale(scale, scale, scale);
            matrixStack.mulPose(Axis.YP.rotationDegrees(90.0F));
            int color = entity.getColor() & 0xFFFFFF;
            int alpha = ((0xFF & (int) (0xFF * baseAlpha)) << 24);
            WavefrontObject model = BladeModelManager.getInstance().getModel(MODEL);

            BladeRenderState.setCol(color | alpha);
            BladeRenderState.renderOverridedLuminous(ItemStack.EMPTY, model, "base", TEXTURE, matrixStack, bufferIn,
                    packedLightIn);
        }
    }
}
