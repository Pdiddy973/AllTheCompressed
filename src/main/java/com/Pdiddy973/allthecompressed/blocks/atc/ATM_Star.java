package com.Pdiddy973.AllTheCompressed.blocks.atc;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ATM_Star extends Block {
    public ATM_Star() {
        super(Properties.of(Material.METAL)
                .sound(SoundType.METAL)
                .strength(15f, 30F));
    }
}
