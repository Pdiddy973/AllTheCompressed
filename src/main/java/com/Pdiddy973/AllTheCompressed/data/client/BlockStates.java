package com.Pdiddy973.AllTheCompressed.data.client;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.ModRegistry;
import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import com.Pdiddy973.AllTheCompressed.util.ResourceUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.loaders.CompositeModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class BlockStates extends BlockStateProvider {
    public BlockStates(PackOutput packOutput, ExistingFileHelper fileHelper) {
        super(packOutput, AllTheCompressed.MODID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModRegistry.FLINT_BLOCK);
        columnBlockWithItem(ModRegistry.BLAZE_ROD_BLOCK);

        for (Overlays value : Overlays.values()) {
            var parent = value.overlay.parent;
            var block = BuiltInRegistries.BLOCK.getOptional(parent);

            if (block.isEmpty() || block.get() == Blocks.AIR) {
                AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                continue;
            }

            ResourceLocation modelFile = switch (parent.getPath()) {
                case "grass_block" -> ResourceUtil.block(parent.getPath());
                default -> blockTexture(parent);
            };

            var original = models().getExistingFile(modelFile);

            for (int i=0;i<9;i++) {
                var each = value.overlay.xall.get(i);
                var path = each.getId().getPath();
                var model = models()
                    .getBuilder(path)
                    .customLoader(CompositeModelBuilder::begin)
                    .child("solid", models().nested().renderType("minecraft:solid").parent(original))
                    .child("translucent", models().nested().renderType("minecraft:translucent")
                        .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cube_all")))
                        .texture("all", ResourceUtil.block(String.format("layer_%s", i+1))))
                    .end().parent(original);
                simpleBlockWithItem(each.get(), model);
            }
        }
    }

    public void simpleBlockWithItem(Supplier<Block> block) {
        super.simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    public void columnBlockWithItem(DeferredBlock<Block> block) {
        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(block.get());
        ModelFile modelFile = models().cubeColumn(key.getPath(), blockTexture(key), blockTexture(key, "end"));
        super.simpleBlockWithItem(block.get(), modelFile);
    }

    public ResourceLocation blockTexture(ResourceLocation key) {
        return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), String.format("block/%s", key.getPath()));
    }

    public ResourceLocation blockTexture(ResourceLocation key, String suffix) {
        return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), String.format("block/%s_%s", key.getPath(), suffix));
    }
}
