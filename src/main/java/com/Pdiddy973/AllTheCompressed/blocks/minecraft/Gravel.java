package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Gravel extends FallingBlock {
    public Gravel() {
        super(Properties.of(Material.SAND)
            .sound(SoundType.GRAVEL)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}

