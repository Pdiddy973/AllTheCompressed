package com.Pdiddy973.AllTheCompressed.blocks.atc;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Glowstone extends Block {
    public Glowstone() {
        super(Properties.of(Material.GLASS)
                .sound(SoundType.GLASS)
                .strength(30f, 15F)
                .harvestTool(ToolType.PICKAXE)
                .lightLevel((b)->15)
                .requiresCorrectToolForDrops());
    }
}
