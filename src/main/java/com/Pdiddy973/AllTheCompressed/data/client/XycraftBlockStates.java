package com.Pdiddy973.AllTheCompressed.data.client;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import tv.soaryn.xycraft.api.content.XyCraftColors;
import tv.soaryn.xycraft.core.content.BlockContent;
import tv.soaryn.xycraft.core.datagen.BlockStateDataGen;
import tv.soaryn.xycraft.world.content.registries.WorldContent;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class XycraftBlockStates extends BlockStateDataGen {
    protected static final Map<XyCraftColors, Overlays> overlays = new EnumMap<>(XyCraftColors.class);

    static {
        overlays.put(XyCraftColors.Red, Overlays.RED_XYCHORIUM);
        overlays.put(XyCraftColors.Blue, Overlays.BLUE_XYCHORIUM);
        overlays.put(XyCraftColors.Green, Overlays.GREEN_XYCHORIUM);
        overlays.put(XyCraftColors.Dark, Overlays.DARK_XYCHORIUM);
        overlays.put(XyCraftColors.Light, Overlays.LIGHT_XYCHORIUM);
    }

    public XycraftBlockStates(PackOutput output,ExistingFileHelper exFileHelper) {
        super(output, new ArrayList<>(), AllTheCompressed.MODID, exFileHelper);
    }

    @Override
    public String getName() {
        return "ATC XyCraft Compressed Blocks";
    }

    @Override
    protected void registerStatesAndModels() {
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
                var path = each.getId().getPath();

                BlockModelBuilder model = cloudModelTintable(path, storage);
                model.texture("tex", "xycraft_world:block/connected/xychorium_storage_single");

                model.element()
                    .cube("#overlay")
                    .end()
                    .renderType("minecraft:cutout")
                    .texture("overlay", String.format("%s:block/layer_%s", AllTheCompressed.MODID, i+1))
                    .texture("particle", "minecraft:block/netherite_block");

                simpleBlockWithItem(each.get(), model);
            }
        }
    }
}
