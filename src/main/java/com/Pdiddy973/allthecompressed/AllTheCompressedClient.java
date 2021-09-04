package com.Pdiddy973.AllTheCompressed;

import com.Pdiddy973.AllTheCompressed.blocks.atc.AllTheCompressedType;
import com.Pdiddy973.AllTheCompressed.blocks.atc.AllTheType;
import com.Pdiddy973.AllTheCompressed.blocks.atm.AllTheModiumType;
import com.Pdiddy973.AllTheCompressed.blocks.ato.AllTheOresType;
import com.Pdiddy973.AllTheCompressed.blocks.mekanism.MekanismType;
import com.Pdiddy973.AllTheCompressed.blocks.minecraft.MinecraftType;
import com.Pdiddy973.AllTheCompressed.blocks.powah.PowahType;
import com.Pdiddy973.AllTheCompressed.blocks.thermal.ThermalType;
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
        for (AllTheType type : AllTheType.VALUES) {
            for (Block block : type.blocks) {
                RenderTypeLookup.setRenderLayer(block, renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            for (Block block : type.blocks) {
                RenderTypeLookup.setRenderLayer(block, renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
        for (AllTheModiumType type : AllTheModiumType.VALUES) {
            for (Block block : type.blocks) {
                RenderTypeLookup.setRenderLayer(block, renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
        for (AllTheOresType type : AllTheOresType.VALUES) {
            for (Block block : type.blocks) {
                RenderTypeLookup.setRenderLayer(block, renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
        for (MekanismType type : MekanismType.VALUES) {
            for (Block block : type.blocks) {
                RenderTypeLookup.setRenderLayer(block, renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
        for (MinecraftType type : MinecraftType.VALUES) {
            for (Block block : type.blocks) {
                RenderTypeLookup.setRenderLayer(block, renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
        for (PowahType type : PowahType.VALUES) {
            for (Block block : type.blocks) {
                RenderTypeLookup.setRenderLayer(block, renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
        for (ThermalType type : ThermalType.VALUES) {
            for (Block block : type.blocks) {
                RenderTypeLookup.setRenderLayer(block, renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
    }
}
