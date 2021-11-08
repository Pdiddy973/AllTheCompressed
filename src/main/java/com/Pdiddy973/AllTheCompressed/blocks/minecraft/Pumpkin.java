package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Pumpkin extends Block {
    public Pumpkin() {
        super(Properties.of(Material.PLANT)
            .sound(SoundType.SLIME_BLOCK)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
