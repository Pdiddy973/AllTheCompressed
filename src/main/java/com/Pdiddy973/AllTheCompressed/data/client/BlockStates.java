package com.Pdiddy973.AllTheCompressed.data.client;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.ModRegistry;
import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        ModelFile defaultBlock = models().getExistingFile(ResourceLocation.withDefaultNamespace("block/block"));

        for (Overlays value : Overlays.values()) {
            var parent = value.overlay.parent;
            var block = BuiltInRegistries.BLOCK.getOptional(parent);

            if (block.isEmpty() || block.get() == Blocks.AIR) {
                AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                continue;
            }

            for (int i=0;i<9;i++) {
                var each = value.overlay.xall.get(i);
                var path = each.getId().getPath();

                BlockModelBuilder model = models()
                    .getBuilder(path);

                String texture = blockTexture(parent).toString();
                if (value == Overlays.MAGMA || value == Overlays.DRIED_KELP || value == Overlays.SNOW || value == Overlays.WAX) {
                    texture = texture.substring(0, texture.lastIndexOf("_block"));
                }

                if (block.get() instanceof RotatedPillarBlock || value == Overlays.MELON || value == Overlays.PUMPKIN || value == Overlays.QUARTZ) {
                    model.element()
                        .allFaces(((direction, faceBuilder) -> {
                            if (direction == Direction.UP || direction == Direction.DOWN) {
                                faceBuilder.texture("#end");
                            } else {
                                faceBuilder.texture("#side");
                            }
                            faceBuilder.cullface(direction);
                        }));

                    boolean isLog = parent.getPath().endsWith("_log") || parent.getPath().endsWith("_log_0") || parent.getPath().equals("deepslate");

                    if (isLog) {
                        model.texture("end", texture.concat("_top"));
                        model.texture("side", texture);
                    } else {
                        model.texture("end", texture.concat("_top"));
                        model.texture("side", texture.concat("_side"));
                    }
                } else if (value == Overlays.DRIED_KELP || value == Overlays.GRASS || value == Overlays.HONEY || value == Overlays.PODZOL || value == Overlays.MYCELIUM) {
                    model.element()
                        .allFaces(((direction, faceBuilder) -> {
                            if (direction == Direction.UP) {
                                faceBuilder.texture("#top");
                            } else if (direction == Direction.DOWN) {
                                faceBuilder.texture("#bottom");
                            } else {
                                faceBuilder.texture("#side");
                            }
                            faceBuilder.cullface(direction);
                        }));

                    if (value == Overlays.GRASS) {
                        model.texture("bottom", "minecraft:block/dirt");
                        model.texture("side", "minecraft:block/grass_block_side");
                        model.texture("top", "allthecompressed:block/grass_block_top");
                    } else if (value == Overlays.PODZOL || value == Overlays.MYCELIUM) {
                        model.texture("bottom", "minecraft:block/dirt");
                        model.texture("side", texture.concat("_side"));
                        model.texture("top", texture.concat("_top"));
                    } else {
                        model.texture("bottom", texture.concat("_bottom"));
                        model.texture("side", texture.concat("_side"));
                        model.texture("top", texture.concat("_top"));
                    }

                } else {
                    model.element()
                        .cube("#all");

                    model.texture("all", texture);
                }

                model.element()
                    .cube("#overlay")
                    .end()
                    .renderType("minecraft:cutout")
                    .texture("overlay", String.format("%s:block/layer_%s", AllTheCompressed.MODID, i+1))
                    .texture("particle", "minecraft:block/netherite_block")
                    .parent(defaultBlock);

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
