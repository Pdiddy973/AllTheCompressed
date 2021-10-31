package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Gold extends Block {
    public Gold() {
        super(Properties.of(Material.METAL)
            .sound(SoundType.METAL)
            .strength(0.85f, 1.0f));
    }
}
