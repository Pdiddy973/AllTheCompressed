package com.Pdiddy973.AllTheCompressed.blocks.atm;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class va_alloy extends Block {
    public va_alloy() {
        super(Properties.of(Material.METAL)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
