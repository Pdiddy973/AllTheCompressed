package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Snow extends Block {
    public Snow() {
        super(Properties.of(Material.SNOW)
                .sound(SoundType.SNOW)
                .strength(15f, 1200f)
                .harvestLevel(2)
                .harvestTool(ToolType.SHOVEL)
                .requiresCorrectToolForDrops());
    }
}
