package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Honey extends Block {
    public Honey() {
        super(Properties.of(Material.SPONGE)
            .sound(SoundType.HONEY_BLOCK)
            .strength(0.85f, 1.0f));
    }
}
