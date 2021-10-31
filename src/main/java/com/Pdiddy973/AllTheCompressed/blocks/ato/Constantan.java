package com.Pdiddy973.AllTheCompressed.blocks.ato;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Constantan extends Block {
    public Constantan() {
        super(Properties.of(Material.STONE)
            .sound(SoundType.METAL)
            .strength(0.85f, 1.0f));
    }
}
