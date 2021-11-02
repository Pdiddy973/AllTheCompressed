package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Soul_Soil extends Block {
    public Soul_Soil() {
        super(Properties.of(Material.SAND)
            .sound(SoundType.SOUL_SOIL)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}

