package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Glowstone extends Block {
    public Glowstone() {
        super(Properties.of(Material.GLASS)
                .sound(SoundType.GLASS)
                .strength(30f, 15F)
                .lightLevel((b) -> 15)
                .requiresCorrectToolForDrops());
    }
}
