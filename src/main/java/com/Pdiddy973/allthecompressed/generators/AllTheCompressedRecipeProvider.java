package com.Pdiddy973.AllTheCompressed.generators;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.AllTheCompressedType;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class AllTheCompressedRecipeProvider extends RecipeProvider {
    public AllTheCompressedRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            Block[] blockList = AllTheCompressed.BLOCKS.get(type.name);
            Block baseBlock = type.getBaseBlock();
            ShapelessRecipeBuilder
                    .shapeless(baseBlock, 9)
                    .requires(blockList[0])
                    .unlockedBy("has_compressed_"+type.name+"_x1", has(blockList[0]))
                    .save(consumer, AllTheCompressed.MODID+":"+type.name+"_"+1+"_uncraft");
            ShapedRecipeBuilder
                    .shaped(blockList[0])
                    .define('#', baseBlock)
                    .pattern("###").pattern("###").pattern("###")
                    .unlockedBy("has_"+type.name, has(baseBlock))
                    .save(consumer);
            for (int i = 1; i < 9; i++) {
                ShapelessRecipeBuilder
                        .shapeless(blockList[i-1], 9)
                        .requires(blockList[i])
                        .unlockedBy("has_compressed_"+type.name+"_x"+(i+1), has(blockList[i]))
                        .save(consumer, AllTheCompressed.MODID+":"+type.name+"_"+(i+1)+"_uncraft");
                ShapedRecipeBuilder
                        .shaped(blockList[i])
                        .define('#', blockList[i-1])
                        .pattern("###").pattern("###").pattern("###")
                        .unlockedBy("has_compressed_"+type.name+"_x"+i, has(blockList[i-1]))
                        .save(consumer);
            }
        }
    }
}

