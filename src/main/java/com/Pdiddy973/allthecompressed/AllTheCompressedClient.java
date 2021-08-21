package com.Pdiddy973.AllTheCompressed;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

public class AllTheCompressedClient extends AllTheCompressedCommon {
    public static void setupItemVar() {
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            for (Block block : type.blocks) {
                ItemBlockRenderTypes.setRenderLayer(block, renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
    }
}
