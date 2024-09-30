package com.Pdiddy973.AllTheCompressed.data.server;

import com.Pdiddy973.AllTheCompressed.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockLoot extends VanillaBlockLoot {
    public BlockLoot(HolderLookup.Provider provider) {
        super(provider);
    }

    @Override
    protected void generate() {
        ModRegistry.BLOCKS.getEntries().forEach(block -> dropSelf(block.get()));
        ModRegistry.OVERLAY_BLOCKS.getEntries().forEach(block -> dropSelf(block.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> blocks = new ArrayList<>();
        ModRegistry.BLOCKS.getEntries().stream()
            .map(Supplier::get)
            .forEach(blocks::add);
        ModRegistry.OVERLAY_BLOCKS.getEntries().stream()
            .map(Supplier::get)
            .forEach(blocks::add);
        return blocks;
    }
}
