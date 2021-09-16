package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Redstone extends Block {
    public Redstone() {
        super(Properties.of(Material.METAL)
                .sound(SoundType.METAL)
                .strength(30f, 15F)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }
}
