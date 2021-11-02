package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Sand extends FallingBlock {
    public Sand() {
        super(Properties.of(Material.SAND)
            .sound(SoundType.SAND)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
