package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Dirt extends Block {
    public Dirt() {
        super(Properties.of(Material.DIRT)
            .sound(SoundType.GRAVEL)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
