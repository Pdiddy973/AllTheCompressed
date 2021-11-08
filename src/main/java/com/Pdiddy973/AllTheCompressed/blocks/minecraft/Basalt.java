package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Basalt extends Block {
    public Basalt() {
        super(Properties.of(Material.STONE)
            .sound(SoundType.BASALT)
                        .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
