package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Soul_Sand extends Block {
    public Soul_Sand() {
        super(Properties.of(Material.SAND)
            .sound(SoundType.SOUL_SAND)
            .strength(0.85f, 1.0f));
    }
}
