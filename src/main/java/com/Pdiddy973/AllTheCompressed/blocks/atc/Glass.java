package com.Pdiddy973.AllTheCompressed.blocks.atc;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Glass extends Block {
    public Glass() {
        super(Properties.of(Material.GLASS)
                .sound(SoundType.GLASS)
                .strength(30f, 15F)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }
}
