package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Snow extends Block {
    public Snow() {
        super(Properties.of(Material.SNOW)
            .sound(SoundType.SNOW)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
