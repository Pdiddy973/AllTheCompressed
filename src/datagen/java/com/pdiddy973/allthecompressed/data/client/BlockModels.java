package com.pdiddy973.allthecompressed.data.client;

import com.pdiddy973.allthecompressed.AllTheCompressed;
import com.pdiddy973.allthecompressed.ModRegistry;
import com.pdiddy973.allthecompressed.overlay.Overlays;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import tv.soaryn.xycraft.api.utils.XyCraftColors;
import tv.soaryn.xycraft.core.content.BlockContent;
import tv.soaryn.xycraft.core.datagen.CoreBaseModelProvider;
import tv.soaryn.xycraft.core.datagen.CoreMaterials;
import tv.soaryn.xycraft.core.datagen.providers.BaseModelProvider;
import tv.soaryn.xycraft.world.content.registries.WorldContent;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class BlockModels extends ModelProvider {
    static final TextureSlot OVERLAY = TextureSlot.create("overlay", TextureSlot.ALL);

    public BlockModels(PackOutput output) {
        super(output, AllTheCompressed.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(ModRegistry.FLINT_BLOCK.get());
        blockModels.createAxisAlignedPillarBlock(ModRegistry.BLAZE_ROD_BLOCK.get(), TexturedModel.COLUMN);
        blockModels.createTrivialCube(ModRegistry.ANTIMATTER_BLOCK.get());

        Set<Overlays> removeTrailingBlock = Set.of(Overlays.MAGMA, Overlays.DRIED_KELP, Overlays.SNOW, Overlays.WAX);
        Set<Overlays> columnBlocks = Set.of(Overlays.MELON, Overlays.PUMPKIN, Overlays.QUARTZ);
        Set<Overlays> bottomTopBlocks = Set.of(Overlays.DRIED_KELP, Overlays.GRASS, Overlays.HONEY, Overlays.PODZOL, Overlays.MYCELIUM);
        Set<Overlays> xychorium = Set.of(Overlays.BLUE_XYCHORIUM, Overlays.DARK_XYCHORIUM, Overlays.GREEN_XYCHORIUM, Overlays.LIGHT_XYCHORIUM, Overlays.RED_XYCHORIUM);

        for (Overlays value : Overlays.values()) {
            var parent = value.overlay.parent;
            var block = BuiltInRegistries.BLOCK.getOptional(parent);

            if (block.isEmpty() || block.get() == Blocks.AIR) {
                AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                continue;
            }

            if (xychorium.contains(value)) continue;

            for (int i=0;i<9;i++) {

                var each = value.overlay.xall.get(i);

                TextureMapping mapping = new TextureMapping();
                ExtendedModelTemplateBuilder model = ModelTemplates
                    .create("block", TextureSlot.PARTICLE, OVERLAY)
                    .extend();

                String texture = blockTexture(parent).toString();
                if (removeTrailingBlock.contains(value)) {
                    texture = texture.substring(0, texture.lastIndexOf("_block"));
                }

                if (block.get() instanceof RotatedPillarBlock || columnBlocks.contains(value)) {
                    model.element(elementBuilder -> elementBuilder
                        .allFaces(((direction, faceBuilder) -> {
                            if (direction == Direction.UP || direction == Direction.DOWN) {
                                model.requiredTextureSlot(TextureSlot.END);
                                faceBuilder.texture(TextureSlot.END);
                            } else {
                                model.requiredTextureSlot(TextureSlot.SIDE);
                                faceBuilder.texture(TextureSlot.SIDE);
                            }
                            faceBuilder.cullface(direction);
                        })));

                    boolean isLog = parent.getPath().endsWith("_log") || parent.getPath().endsWith("_log_0") || parent.getPath().equals("deepslate");

                    if (isLog) {
                        mapping.put(TextureSlot.END, fromTexture(texture.concat("_top")));
                        mapping.put(TextureSlot.SIDE, fromTexture(texture));
                    } else {
                        mapping.put(TextureSlot.END, fromTexture(texture.concat("_top")));
                        mapping.put(TextureSlot.SIDE, fromTexture(texture.concat("_side")));
                    }
                } else if (bottomTopBlocks.contains(value)) {
                    model.element(elementBuilder -> elementBuilder
                        .allFaces(((direction, faceBuilder) -> {
                            if (direction == Direction.UP) {
                                model.requiredTextureSlot(TextureSlot.TOP);
                                faceBuilder.texture(TextureSlot.TOP);
                            } else if (direction == Direction.DOWN) {
                                model.requiredTextureSlot(TextureSlot.BOTTOM);
                                faceBuilder.texture(TextureSlot.BOTTOM);
                            } else {
                                model.requiredTextureSlot(TextureSlot.SIDE);
                                faceBuilder.texture(TextureSlot.SIDE);
                            }
                            faceBuilder.cullface(direction);
                        })));

                    if (value == Overlays.GRASS) {
                        mapping.put(TextureSlot.BOTTOM, fromTexture("minecraft:block/dirt"));
                        mapping.put(TextureSlot.SIDE, fromTexture("minecraft:block/grass_block_side"));
                        mapping.put(TextureSlot.TOP, fromTexture("allthecompressed:block/grass_block_top"));
                    } else if (value == Overlays.PODZOL || value == Overlays.MYCELIUM) {
                        mapping.put(TextureSlot.BOTTOM, fromTexture("minecraft:block/dirt"));
                        mapping.put(TextureSlot.SIDE, fromTexture(texture.concat("_side")));
                        mapping.put(TextureSlot.TOP, fromTexture(texture.concat("_top")));
                    } else {
                        mapping.put(TextureSlot.BOTTOM, fromTexture(texture.concat("_bottom")));
                        mapping.put(TextureSlot.SIDE, fromTexture(texture.concat("_side")));
                        mapping.put(TextureSlot.TOP, fromTexture(texture.concat("_top")));
                    }

                } else {
                    model.element(elementBuilder -> elementBuilder
                        .cube(TextureSlot.ALL));

                    model.requiredTextureSlot(TextureSlot.ALL);
                    mapping.put(TextureSlot.ALL, fromTexture(texture));
                }

                model.element(elementBuilder -> elementBuilder
                    .cube(OVERLAY));

                mapping.put(OVERLAY, fromTexture(String.format("%s:block/layer_%s", AllTheCompressed.MODID, i+1)));
                mapping.put(TextureSlot.PARTICLE, fromTexture("minecraft:block/netherite_block"));

                TexturedModel.Provider provider = TexturedModel.createDefault(_ -> mapping, model.build());

                blockModels.createTrivialBlock(each.get(), provider);
            }
        }

        registerXycraftModels(blockModels, itemModels);
    }

    protected static final Map<XyCraftColors, Overlays> overlays = new EnumMap<>(XyCraftColors.class);

    static {
        overlays.put(XyCraftColors.Red, Overlays.RED_XYCHORIUM);
        overlays.put(XyCraftColors.Blue, Overlays.BLUE_XYCHORIUM);
        overlays.put(XyCraftColors.Green, Overlays.GREEN_XYCHORIUM);
        overlays.put(XyCraftColors.Dark, Overlays.DARK_XYCHORIUM);
        overlays.put(XyCraftColors.Light, Overlays.LIGHT_XYCHORIUM);
    }

    protected void registerXycraftModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        for (XyCraftColors color : XyCraftColors.values()) {
            Overlays value = overlays.get(color);
            BlockContent storage = WorldContent.Block.XychoriumStorage.get(color);

            var parent = value.overlay.parent;
            var block = BuiltInRegistries.BLOCK.getOptional(parent);

            if (block.isEmpty() || block.get() == Blocks.AIR) {
                AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                continue;
            }

            for (int i=0;i<9;i++) {
                var each = value.overlay.xall.get(i);

                overlayCloudBlockModel(blockModels, storage, each.get(), String.format("%s:block/layer_%s", AllTheCompressed.MODID, i+1));
            }
        }
    }

    Material fromTexture(String texture) {
        return new Material(Identifier.parse(texture));
    }

    public Identifier blockTexture(Identifier key) {
        return Identifier.fromNamespaceAndPath(key.getNamespace(), String.format("block/%s", key.getPath()));
    }

    public Identifier blockTexture(Identifier key, String suffix) {
        return Identifier.fromNamespaceAndPath(key.getNamespace(), String.format("block/%s_%s", key.getPath(), suffix));
    }

    protected void overlayCloudBlockModel(BlockModelGenerators blockModels, BlockContent content, Block block, String overlay) {
        TextureMapping mapping = new TextureMapping();
        Material texture = new Material(content.textureId());
        Material particleTexture = new Material(content.particleId());
        Material overlayTexture = new Material(Identifier.parse(overlay));
        mapping.put(TextureSlot.PARTICLE, particleTexture);
        mapping.put(TextureSlot.TEXTURE, texture);
        mapping.put(OVERLAY, overlayTexture);
        mapping.put(BaseModelProvider.CloudTextureSlot, CoreMaterials.CloudFX);
        ExtendedModelTemplateBuilder modelBuilder = BaseModelProvider.CloudTemplate.extend()
            .element(0, (elementBuilder) -> elementBuilder.color(content.getColor()))
            .element(element -> element.cube(OVERLAY)).requiredTextureSlot(OVERLAY);

        TexturedModel.Provider provider = TexturedModel.createDefault(_ -> mapping, modelBuilder.build());

        blockModels.createTrivialBlock(block, provider);
    }
}
