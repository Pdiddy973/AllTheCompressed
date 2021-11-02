package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Red_Sand extends Block {
    public Red_Sand() {
        super(Properties.of(Material.SAND)
            .sound(SoundType.SAND)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
