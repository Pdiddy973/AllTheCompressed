package com.Pdiddy973.AllTheCompressed.blocks.thermal;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Invar extends Block {
    public Invar() {
        super(Properties.of(Material.METAL)
                .sound(SoundType.METAL)
                .strength(30f, 15F)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }
}
