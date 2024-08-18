package com.Pdiddy973.AllTheCompressed.data.client;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import com.Pdiddy973.AllTheCompressed.util.ResourceUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.loaders.CompositeModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {
    public BlockStates(PackOutput packOutput, ExistingFileHelper fileHelper) {
        super(packOutput, AllTheCompressed.MODID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (Overlays value : Overlays.values()) {
            var parent = value.overlay.parent;
            var block = BuiltInRegistries.BLOCK.getOptional(parent);

            if (block.isEmpty() || block.get() == Blocks.AIR) {
                AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                continue;
            }

            ResourceLocation modelFile = switch (parent.getPath()) {
                case "grass_block" -> ResourceLocation.fromNamespaceAndPath(AllTheCompressed.MODID, String.format("block/%s", parent.getPath()));
                case "snow" -> ResourceLocation.fromNamespaceAndPath(parent.getNamespace(), String.format("block/%s_block", parent.getPath()));
                default -> ResourceLocation.fromNamespaceAndPath(parent.getNamespace(), String.format("block/%s", parent.getPath()));
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
}
