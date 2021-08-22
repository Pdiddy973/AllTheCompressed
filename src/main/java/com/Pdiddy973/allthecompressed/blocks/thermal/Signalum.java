package com.Pdiddy973.AllTheCompressed.blocks.thermal;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Signalum extends Block {
    public Signalum() {
        super(Properties.of(Material.STONE)
                .sound(SoundType.STONE)
                .strength(30f, 15F)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }
}
