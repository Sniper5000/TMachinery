package net.minecraft.client.particle;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EmitterParticle extends MetaParticle {
   private final Entity entity;
   private int life;
   private final int lifeTime;
   private final IParticleData particleType;

   public EmitterParticle(ClientWorld p_i232451_1_, Entity p_i232451_2_, IParticleData p_i232451_3_) {
      this(p_i232451_1_, p_i232451_2_, p_i232451_3_, 3);
   }

   public EmitterParticle(ClientWorld p_i232452_1_, Entity p_i232452_2_, IParticleData p_i232452_3_, int p_i232452_4_) {
      this(p_i232452_1_, p_i232452_2_, p_i232452_3_, p_i232452_4_, p_i232452_2_.getDeltaMovement());
   }

   private EmitterParticle(ClientWorld p_i232453_1_, Entity p_i232453_2_, IParticleData p_i232453_3_, int p_i232453_4_, Vector3d p_i232453_5_) {
      super(p_i232453_1_, p_i232453_2_.getX(), p_i232453_2_.getY(0.5D), p_i232453_2_.getZ(), p_i232453_5_.x, p_i232453_5_.y, p_i232453_5_.z);
      this.entity = p_i232453_2_;
      this.lifeTime = p_i232453_4_;
      this.particleType = p_i232453_3_;
      this.tick();
   }

   public void tick() {
      for(int i = 0; i < 16; ++i) {
         double d0 = (double)(this.random.nextFloat() * 2.0F - 1.0F);
         double d1 = (double)(this.random.nextFloat() * 2.0F - 1.0F);
         double d2 = (double)(this.random.nextFloat() * 2.0F - 1.0F);
         if (!(d0 * d0 + d1 * d1 + d2 * d2 > 1.0D)) {
            double d3 = this.entity.getX(d0 / 4.0D);
            double d4 = this.entity.getY(0.5D + d1 / 4.0D);
            double d5 = this.entity.getZ(d2 / 4.0D);
            this.level.addParticle(this.particleType, false, d3, d4, d5, d0, d1 + 0.2D, d2);
         }
      }

      ++this.life;
      if (this.life >= this.lifeTime) {
         this.remove();
      }

   }
}