package net.minecraft.block;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.SmithingTableContainer;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SmithingTableBlock extends CraftingTableBlock {
   private static final ITextComponent CONTAINER_TITLE = new TranslationTextComponent("container.upgrade");

   public SmithingTableBlock(AbstractBlock.Properties p_i49974_1_) {
      super(p_i49974_1_);
   }

   public INamedContainerProvider getMenuProvider(BlockState p_220052_1_, World p_220052_2_, BlockPos p_220052_3_) {
      return new SimpleNamedContainerProvider((p_235576_2_, p_235576_3_, p_235576_4_) -> {
         return new SmithingTableContainer(p_235576_2_, p_235576_3_, IWorldPosCallable.create(p_220052_2_, p_220052_3_));
      }, CONTAINER_TITLE);
   }

   public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
      if (p_225533_2_.isClientSide) {
         return ActionResultType.SUCCESS;
      } else {
         p_225533_4_.openMenu(p_225533_1_.getMenuProvider(p_225533_2_, p_225533_3_));
         p_225533_4_.awardStat(Stats.INTERACT_WITH_SMITHING_TABLE);
         return ActionResultType.CONSUME;
      }
   }
}