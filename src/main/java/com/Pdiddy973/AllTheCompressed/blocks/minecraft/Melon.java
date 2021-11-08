package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Melon extends Block {
    public Melon() {
        super(Properties.of(Material.PLANT)
            .sound(SoundType.SLIME_BLOCK)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
