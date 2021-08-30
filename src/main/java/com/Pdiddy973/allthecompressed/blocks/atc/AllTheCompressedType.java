package com.Pdiddy973.AllTheCompressed.blocks.atc;

import com.Pdiddy973.AllTheCompressed.block.Ender_Pearl;
import com.Pdiddy973.AllTheCompressed.block.Nether_Star;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum AllTheCompressedType {
    NETHER_STAR("nether_star", Nether_Star::new),
    ENDER_PEARL("ender_pearl", Ender_Pearl::new),
    GLASS("glass", Glass::new),
    GLOWSTONE("glowstone", Glowstone::new);

    public static final AllTheCompressedType[] VALUES = values();

    public final String name;
    public final Supplier<Block> factory;
    public final List<Block> blocks;

    AllTheCompressedType(String n, Supplier<Block> f) {
        name = n;
        factory = f;
        blocks = new ArrayList<>();
    }
}