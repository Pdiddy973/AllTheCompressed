package com.pdiddy973.allthecompressed.data.server;

import com.pdiddy973.allthecompressed.AllTheCompressed;
import com.pdiddy973.allthecompressed.ModRegistry;
import com.pdiddy973.allthecompressed.data.compat.EnergizingRecipeBuilder;
import com.pdiddy973.allthecompressed.overlay.Overlays;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.registries.DeferredItem;
import owmii.powah.Powah;


import java.util.concurrent.CompletableFuture;

import static com.pdiddy973.allthecompressed.util.ResourceUtil.compress;
import static com.pdiddy973.allthecompressed.util.ResourceUtil.decompress;

public class CraftingRecipes extends RecipeProvider {
    public CraftingRecipes(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        craftingRecipes();
        energizingRecipes();
        for (Overlays value : Overlays.values()) {
            var parent = value.overlay.parent;
            var block = BuiltInRegistries.BLOCK.getOptional(parent);
            var conditional = output;
            if (!parent.getNamespace().equals("minecraft")) {
                conditional = output.withConditions(new ModLoadedCondition(parent.getNamespace()));
            }

            if (block.isEmpty() || block.get() == Blocks.AIR) {
                AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                continue;
            }

            var ingredient = block.get().asItem();
            for (var item : value.overlay.iall) {
                blockRecipes(item, ingredient, conditional);

                ingredient = item.get();
            }
        }
    }

    private void blockRecipes(DeferredItem<BlockItem> item, Item ingredient, RecipeOutput consumer) {
        shapeless(RecipeCategory.BUILDING_BLOCKS, ingredient, 9)
            .group(AllTheCompressed.MODID)
            .requires(item.get())
            .unlockedBy(getHasName(item.get()), has(item.get()))
            .save(consumer, decompress(item.getId()));

        shaped(RecipeCategory.BUILDING_BLOCKS, item.get())
            .group(AllTheCompressed.MODID)
            .define('#', ingredient)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .unlockedBy(getHasName(ingredient), has(ingredient))
            .save(consumer, compress(item.getId()));
    }


    protected void craftingRecipes() {
        blockRecipes(ModRegistry.FLINT_BLOCK_ITEM, Items.FLINT, output);
        blockRecipes(ModRegistry.BLAZE_ROD_BLOCK_ITEM, Items.BLAZE_ROD, output);

//        RecipeOutput mekanism = consumer.withConditions(new ModLoadedCondition("mekanism"));
//        blockRecipes(ModRegistry.ANTIMATTER_BLOCK_ITEM, MekanismItems.ANTIMATTER_PELLET.get(), mekanism);
    }

    protected void energizingRecipes() {
        RecipeOutput powah = output.withConditions(new ModLoadedCondition(Powah.MOD_ID));

        EnergizingRecipeBuilder.build(Overlays.ENERGIZED_STEEL, 2)
            .setEnergy(90_000)
            .addIngredient(Overlays.IRON)
            .addIngredient(Overlays.GOLD)
            .save(powah);

        EnergizingRecipeBuilder.build(Overlays.BLAZING_CRYSTAL)
            .setEnergy(1_080_000)
            .addIngredient(Overlays.BLAZE)
            .save(powah);

        EnergizingRecipeBuilder.build(Overlays.NIOTIC_CRYSTAL)
            .setEnergy(2_700_000)
            .addIngredient(Overlays.DIAMOND)
            .save(powah);

        EnergizingRecipeBuilder.build(Overlays.SPIRITED_CRYSTAL)
            .setEnergy(9_000_000)
            .addIngredient(Overlays.EMERALD)
            .save(powah);
    }

    public static class Runner extends RecipeProvider.Runner {
        @Override
        public String getName() {
            return "allthecompressed:crafting_recipes";
        }

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new CraftingRecipes(provider, output);
        }
    }
}
