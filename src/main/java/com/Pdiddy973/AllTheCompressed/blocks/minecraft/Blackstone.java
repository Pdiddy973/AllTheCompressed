package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Blackstone extends Block {
    public Blackstone() {
        super(Properties.of(Material.STONE)
            .sound(SoundType.STONE)
                        .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
