package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Obsidian extends Block {
    public Obsidian() {
        super(Properties.of(Material.STONE)
                .sound(SoundType.STONE)
                .strength(15f, 2000f)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .requiresCorrectToolForDrops());
    }
}
