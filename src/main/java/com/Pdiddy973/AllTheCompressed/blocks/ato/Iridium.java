package com.Pdiddy973.AllTheCompressed.blocks.ato;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Iridium extends Block {
    public Iridium() {
        super(Properties.of(Material.METAL)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
