package com.Pdiddy973.AllTheCompressed.blocks.powah;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Spirited_Crystal extends Block {
    public Spirited_Crystal() {
        super(Properties.of(Material.METAL)
                .sound(SoundType.METAL)
                .strength(15f, 1200f)
                .requiresCorrectToolForDrops());
    }
}
