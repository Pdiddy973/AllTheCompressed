package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Hay extends Block {
    public Hay() {
        super(Properties.of(Material.WOOL)
            .sound(SoundType.WOOL)
            .strength(0.85f, 1.0f));
    }
}
