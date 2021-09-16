package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Soul_Sand extends Block {
    public Soul_Sand() {
        super(Properties.of(Material.SAND)
                .sound(SoundType.SOUL_SAND)
                .strength(15f, 1200f)
                .harvestLevel(2)
                .harvestTool(ToolType.SHOVEL)
                .requiresCorrectToolForDrops());
    }
}
