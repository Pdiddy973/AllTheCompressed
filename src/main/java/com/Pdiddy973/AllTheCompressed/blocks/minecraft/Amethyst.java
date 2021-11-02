package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Amethyst extends Block {
    public Amethyst() {
        super(Properties.of(Material.AMETHYST)
            .sound(SoundType.AMETHYST)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
