package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Dirt extends Block {
    public Dirt() {
        super(Properties.of(Material.DIRT)
                .sound(SoundType.GRAVEL)
                .strength(30f, 15F)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }
}
