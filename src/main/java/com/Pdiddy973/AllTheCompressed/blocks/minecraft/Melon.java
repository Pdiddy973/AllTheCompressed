package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Melon extends Block {
    public Melon() {
        super(Properties.of(Material.PLANT)
            .sound(SoundType.SLIME_BLOCK)
            .strength(0.85f, 1.0f));
    }
}
