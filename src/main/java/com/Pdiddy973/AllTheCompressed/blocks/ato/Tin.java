package com.Pdiddy973.AllTheCompressed.blocks.ato;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Tin extends Block {
    public Tin() {
        super(Properties.of(Material.METAL)
                .sound(SoundType.METAL)
                .strength(15f, 1200f)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .requiresCorrectToolForDrops());
    }
}
