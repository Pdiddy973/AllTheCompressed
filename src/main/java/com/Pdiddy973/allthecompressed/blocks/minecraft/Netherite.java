package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Netherite extends Block {
    public Netherite() {
        super(Properties.of(Material.STONE)
                .sound(SoundType.STONE)
                .strength(30f, 15F)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }
}
