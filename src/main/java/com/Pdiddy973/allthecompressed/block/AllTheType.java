package com.Pdiddy973.AllTheCompressed.block;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum AllTheType {
    NETHER_STAR("nether_star", Nether_Star::new),
    ENDER_PEARL("ender_pearl", Ender_Pearl::new);

    public static final AllTheType[] VALUES = values();

    public final String name;
    public final Supplier<Block> factory;
    public final List<Block> blocks;

    AllTheType(String n, Supplier<Block> f) {
        name = n;
        factory = f;
        blocks = new ArrayList<>();
    }
}