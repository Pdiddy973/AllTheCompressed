package com.Pdiddy973.AllTheCompressed;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class AllTheCompressedClient extends AllTheCompressedCommon {
    public void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener((this::clientSetup));
    }

    private void clientSetup(FMLClientSetupEvent event) {
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            for (Block block : type.blocks) {
                RenderTypeLookup.setRenderLayer(block, renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
    }
}
