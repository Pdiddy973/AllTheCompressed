package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Basalt extends Block {
    public Basalt() {
        super(Properties.of(Material.STONE)
            .sound(SoundType.BASALT)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
