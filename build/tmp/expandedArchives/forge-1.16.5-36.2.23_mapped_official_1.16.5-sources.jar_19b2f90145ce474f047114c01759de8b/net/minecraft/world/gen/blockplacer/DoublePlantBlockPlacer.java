package net.minecraft.world.gen.blockplacer;

import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class DoublePlantBlockPlacer extends BlockPlacer {
   public static final Codec<DoublePlantBlockPlacer> CODEC;
   public static final DoublePlantBlockPlacer INSTANCE = new DoublePlantBlockPlacer();

   protected BlockPlacerType<?> type() {
      return BlockPlacerType.DOUBLE_PLANT_PLACER;
   }

   public void place(IWorld p_225567_1_, BlockPos p_225567_2_, BlockState p_225567_3_, Random p_225567_4_) {
      ((DoublePlantBlock)p_225567_3_.getBlock()).placeAt(p_225567_1_, p_225567_2_, 2);
   }

   static {
      CODEC = Codec.unit(() -> {
         return INSTANCE;
      });
   }
}