package net.minecraft.client.renderer.entity.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CowModel<T extends Entity> extends QuadrupedModel<T> {
   public CowModel() {
      super(12, 0.0F, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
      this.head = new ModelRenderer(this, 0, 0);
      this.head.addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, 0.0F);
      this.head.setPos(0.0F, 4.0F, -8.0F);
      this.head.texOffs(22, 0).addBox(-5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F);
      this.head.texOffs(22, 0).addBox(4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F);
      this.body = new ModelRenderer(this, 18, 4);
      this.body.addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, 0.0F);
      this.body.setPos(0.0F, 5.0F, 2.0F);
      this.body.texOffs(52, 0).addBox(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F);
      --this.leg0.x;
      ++this.leg1.x;
      this.leg0.z += 0.0F;
      this.leg1.z += 0.0F;
      --this.leg2.x;
      ++this.leg3.x;
      --this.leg2.z;
      --this.leg3.z;
   }

   public ModelRenderer getHead() {
      return this.head;
   }
}