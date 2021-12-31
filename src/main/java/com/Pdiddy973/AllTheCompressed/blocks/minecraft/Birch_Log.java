package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Birch_Log extends Block {
    public Birch_Log() {
        super(Properties.of(Material.WOOD)
            .sound(SoundType.WOOD)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
