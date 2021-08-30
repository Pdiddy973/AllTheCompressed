package com.Pdiddy973.AllTheCompressed.blocks.mekanism;


import net.minecraft.block.Block;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum MekanismType {
    STEEL("steel", Steel::new);

    public static final MekanismType[] VALUES = values();

    public final String name;
    public final Supplier<Block> factory;
    public final List<Block> blocks;

    MekanismType(String n, Supplier<Block> f) {
        name = n;
        factory = f;
        blocks = new ArrayList<>();
    }
}
