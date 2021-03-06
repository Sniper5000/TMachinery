package net.minecraft.advancements.criterion;

import com.google.gson.JsonObject;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.util.ResourceLocation;

public class TickTrigger extends AbstractCriterionTrigger<TickTrigger.Instance> {
   public static final ResourceLocation ID = new ResourceLocation("tick");

   public ResourceLocation getId() {
      return ID;
   }

   public TickTrigger.Instance createInstance(JsonObject p_230241_1_, EntityPredicate.AndPredicate p_230241_2_, ConditionArrayParser p_230241_3_) {
      return new TickTrigger.Instance(p_230241_2_);
   }

   public void trigger(ServerPlayerEntity p_193182_1_) {
      this.trigger(p_193182_1_, (p_241523_0_) -> {
         return true;
      });
   }

   public static class Instance extends CriterionInstance {
      public Instance(EntityPredicate.AndPredicate p_i232007_1_) {
         super(TickTrigger.ID, p_i232007_1_);
      }
   }
}