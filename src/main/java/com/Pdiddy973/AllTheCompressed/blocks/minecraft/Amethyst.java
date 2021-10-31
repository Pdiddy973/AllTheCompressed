package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Amethyst extends Block {
    public Amethyst() {
        super(Properties.of(Material.AMETHYST)
            .sound(SoundType.AMETHYST)
            .strength(0.85f, 1.0f));
    }
}
