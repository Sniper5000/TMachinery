package net.minecraft.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.model.TridentModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TridentRenderer extends EntityRenderer<TridentEntity> {
   public static final ResourceLocation TRIDENT_LOCATION = new ResourceLocation("textures/entity/trident.png");
   private final TridentModel model = new TridentModel();

   public TridentRenderer(EntityRendererManager p_i48828_1_) {
      super(p_i48828_1_);
   }

   public void render(TridentEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
      p_225623_4_.pushPose();
      p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(MathHelper.lerp(p_225623_3_, p_225623_1_.yRotO, p_225623_1_.yRot) - 90.0F));
      p_225623_4_.mulPose(Vector3f.ZP.rotationDegrees(MathHelper.lerp(p_225623_3_, p_225623_1_.xRotO, p_225623_1_.xRot) + 90.0F));
      IVertexBuilder ivertexbuilder = net.minecraft.client.renderer.ItemRenderer.getFoilBufferDirect(p_225623_5_, this.model.renderType(this.getTextureLocation(p_225623_1_)), false, p_225623_1_.isFoil());
      this.model.renderToBuffer(p_225623_4_, ivertexbuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      p_225623_4_.popPose();
      super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
   }

   public ResourceLocation getTextureLocation(TridentEntity p_110775_1_) {
      return TRIDENT_LOCATION;
   }
}