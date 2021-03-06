package net.minecraft.client.particle;

import java.util.Random;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface IAnimatedSprite {
   TextureAtlasSprite get(int p_217591_1_, int p_217591_2_);

   TextureAtlasSprite get(Random p_217590_1_);
}