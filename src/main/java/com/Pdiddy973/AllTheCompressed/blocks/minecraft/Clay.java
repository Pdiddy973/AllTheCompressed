package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class Clay extends Block {
    public Clay() {
        super(Properties.of(Material.CLAY)
            .sound(SoundType.GRAVEL)
            .requiresCorrectToolForDrops()
            .strength(7.0f, 20.0f));
    }
}
