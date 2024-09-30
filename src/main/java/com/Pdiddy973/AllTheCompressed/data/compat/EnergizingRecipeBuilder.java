package com.Pdiddy973.AllTheCompressed.data.compat;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import owmii.powah.block.energizing.EnergizingRecipe;

import java.util.ArrayList;
import java.util.List;

import static com.Pdiddy973.AllTheCompressed.util.ResourceUtil.prefix;

public class EnergizingRecipeBuilder {
    final Overlays overlay;
    final int count;

    long energy = 0L;
    List<Overlays> ingredients = new ArrayList<>();

    public EnergizingRecipeBuilder(Overlays overlay, int count) {
        this.overlay = overlay;
        this.count = count;
    }

    public static EnergizingRecipeBuilder build(Overlays overlays) {
        return new EnergizingRecipeBuilder(overlays, 1);
    }

    public static EnergizingRecipeBuilder build(Overlays overlays, int count) {
        return new EnergizingRecipeBuilder(overlays, count);
    }

    public EnergizingRecipeBuilder setEnergy(long energy) {
        this.energy = energy;
        return this;
    }

    public EnergizingRecipeBuilder addIngredient(Overlays ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public void save(RecipeOutput powah) {
        for (int i = 0; i < 10; i++) {
            ItemStack output;
            List<Ingredient> inputs = new ArrayList<>();

            long totalEnergy = energy * (long) Math.pow(9, i);

            if (totalEnergy > Integer.MAX_VALUE) {
                return;
            }

            if (i == 0) {
                var parent = overlay.overlay.parent;
                var block = BuiltInRegistries.BLOCK.getOptional(parent);

                if (block.isEmpty() || block.get() == Blocks.AIR) {
                    AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                    continue;
                }

                output = new ItemStack(block.get(), count);
                for (Overlays ingredient : ingredients) {
                    var iblock = BuiltInRegistries.BLOCK.getOrThrow(ResourceKey.create(Registries.BLOCK, ingredient.overlay.parent));
                    inputs.add(Ingredient.of(iblock));
                }
            } else {
                output = overlay.overlay.iall.get(i - 1).toStack().copyWithCount(count);
                for (Overlays ingredient : ingredients) {
                    inputs.add(Ingredient.of(ingredient.overlay.iall.get(i - 1)));
                }
            }

            String path = String.format("energizing/%s/x%d", overlay.overlay.parent.getPath(), i);
            powah.accept(prefix(path), new EnergizingRecipe(output, totalEnergy, inputs), null);
        }
    }
}
