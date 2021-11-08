package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Hay extends Block {
    public Hay() {
        super(Properties.of(Material.WOOL)
            .sound(SoundType.WOOL)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
