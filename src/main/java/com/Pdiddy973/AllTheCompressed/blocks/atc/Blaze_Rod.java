package com.Pdiddy973.AllTheCompressed.blocks.atc;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Blaze_Rod extends Block {
    public Blaze_Rod() {
        super(Properties.of(Material.METAL)
                .sound(SoundType.METAL)
                .strength(15f, 1200f)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .requiresCorrectToolForDrops());
    }
}
