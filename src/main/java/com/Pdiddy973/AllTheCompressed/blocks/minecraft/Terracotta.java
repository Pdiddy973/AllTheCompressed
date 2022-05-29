package com.Pdiddy973.AllTheCompressed.blocks.minecraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class Terracotta extends Block {
    public Terracotta() {
        super(Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE)
            .requiresCorrectToolForDrops()
            .strength(1.25f, 4.2f));
    }
}
