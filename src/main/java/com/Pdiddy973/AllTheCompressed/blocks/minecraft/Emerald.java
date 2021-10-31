package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Emerald extends Block {
    public Emerald() {
        super(Properties.of(Material.METAL)
            .sound(SoundType.METAL)
            .strength(0.85f, 1.0f));
    }
}
