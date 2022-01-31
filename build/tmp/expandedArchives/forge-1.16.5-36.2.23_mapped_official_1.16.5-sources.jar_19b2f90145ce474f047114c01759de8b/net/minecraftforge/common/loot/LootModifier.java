/*
 * Minecraft Forge
 * Copyright (c) 2016-2021.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.common.loot;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.LootConditionManager;

/**
 * A base implementation of a Global Loot Modifier for modders to extend.
 * Takes care of ILootCondition matching and comes with a base serializer
 * implementation that takes care of Forge registry things.
 */
public abstract class LootModifier implements IGlobalLootModifier {
    protected final ILootCondition[] conditions;
    private final Predicate<LootContext> combinedConditions;
    
    /**
     * Constructs a LootModifier.
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    protected LootModifier(ILootCondition[] conditionsIn) {
        this.conditions = conditionsIn;
        this.combinedConditions = LootConditionManager.andConditions(conditionsIn);
    }
    
    @Nonnull
    @Override
    public final List<ItemStack> apply(List<ItemStack> generatedLoot, LootContext context) {
        return this.combinedConditions.test(context) ? this.doApply(generatedLoot, context) : generatedLoot;
    }
    
    /**
     * Applies the modifier to the generated loot (all loot conditions have already been checked
     * and have returned true).
     * @param generatedLoot the list of ItemStacks that will be dropped, generated by loot tables
     * @param context the LootContext, identical to what is passed to loot tables
     * @return modified loot drops
     */
    @Nonnull
    protected abstract List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context);
}
