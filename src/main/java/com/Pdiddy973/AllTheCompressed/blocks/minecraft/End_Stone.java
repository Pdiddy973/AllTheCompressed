package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class End_Stone extends Block {
    public End_Stone() {
        super(Properties.of(Material.STONE)
            .sound(SoundType.STONE)
            .strength(0.85f, 1.0f));
    }
}
