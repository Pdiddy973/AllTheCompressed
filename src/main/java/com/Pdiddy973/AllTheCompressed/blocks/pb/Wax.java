package com.Pdiddy973.AllTheCompressed.blocks.pb;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Wax extends Block {
    public Wax() {
        super(Properties.of(Material.SPONGE)
            .sound(SoundType.HONEY_BLOCK)
            .strength(7.0f, 20.0f));
    }
}
