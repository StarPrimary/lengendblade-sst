package com.dinzeer.legendblade.client.render;

import com.dinzeer.legendblade.Legendblade;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModelManager;
import mods.flammpfeil.slashblade.client.renderer.model.obj.WavefrontObject;
import mods.flammpfeil.slashblade.client.renderer.util.BladeRenderState;
import mods.flammpfeil.slashblade.client.renderer.util.MSAutoCloser;
import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class SaveAllRender<T extends EntityAbstractSummonedSword> extends EntityRenderer<T> {
    private static final ResourceLocation TEXTURE = Legendblade.prefix("model/util/ss.png");
    private static final ResourceLocation MODEL = Legendblade.prefix("model/util/moondrive.obj");
    @Nullable
    public ResourceLocation getTextureLocation(T entity) {
        return entity.getTextureLoc();
    }

    public SaveAllRender(EntityRendererProvider.Context context) {
        super(context);
    }

    public void render(T entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource bufferIn, int packedLightIn) {
        MSAutoCloser msac = MSAutoCloser.pushMatrix(matrixStack);

        try {
            Entity hits = entity.getHitEntity();
            boolean hasHitEntity = hits != null;
            if (hasHitEntity) {
                matrixStack.mulPose(Axis.YN.rotationDegrees(Mth.rotLerp(partialTicks, hits.yRotO, hits.getYRot()) - 90.0F));
                matrixStack.mulPose(Axis.YN.rotationDegrees(entity.getOffsetYaw()));
            } else {
                matrixStack.mulPose(Axis.YP.rotationDegrees(Mth.rotLerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
            }

            matrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.rotLerp(partialTicks, entity.xRotO, entity.getXRot())));
            matrixStack.mulPose(Axis.XP.rotationDegrees(entity.getRoll()));
            float scale = 0.0075F;
            matrixStack.scale(scale, scale, scale);
            matrixStack.mulPose(Axis.YP.rotationDegrees(90.0F));
            if (hasHitEntity) {
                matrixStack.translate(0.0F, 0.0F, -100.0F);
            }
            WavefrontObject model = BladeModelManager.getInstance().getModel(MODEL);
            BladeRenderState.setCol(entity.getColor(), false);
            BladeRenderState.renderOverridedLuminous(ItemStack.EMPTY, model, "base", TEXTURE, matrixStack, bufferIn,
                    packedLightIn);
        } catch (Throwable var13) {
            if (msac != null) {
                try {
                    msac.close();
                } catch (Throwable var12) {
                    var13.addSuppressed(var12);
                }
            }

            throw var13;
        }

        if (msac != null) {
            msac.close();
        }

    }
}
