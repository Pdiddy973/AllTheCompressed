package com.Pdiddy973.AllTheCompressed.data.server;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

import static com.Pdiddy973.AllTheCompressed.util.ResourceUtil.compress;
import static com.Pdiddy973.AllTheCompressed.util.ResourceUtil.decompress;

public class CraftingRecipes extends RecipeProvider {
    public CraftingRecipes(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        for (Overlays value : Overlays.values()) {
            var parent = value.overlay.parent;
            var block = ForgeRegistries.BLOCKS.getValue(parent);

            if (block == null || block == Blocks.AIR) {
                AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                continue;
            }

            var ingredient = block.asItem();
            for (var item : value.overlay.iall) {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ingredient, 9)
                    .requires(item.get())
                    .unlockedBy(getHasName(item.get()), has(item.get()))
                    .save(consumer, decompress(item.getId()));

                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item.get())
                    .define('#', ingredient)
                    .pattern("###")
                    .pattern("###")
                    .pattern("###")
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(consumer, compress(item.getId()));

                ingredient = item.get();
            }
        }
    }
}
