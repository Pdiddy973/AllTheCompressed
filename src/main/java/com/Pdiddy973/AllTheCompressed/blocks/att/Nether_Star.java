package com.Pdiddy973.AllTheCompressed.blocks.att;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Nether_Star extends Block {
    public Nether_Star() {
        super(Properties.of(Material.METAL)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
