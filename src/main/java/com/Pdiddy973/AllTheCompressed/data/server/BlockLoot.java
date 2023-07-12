package com.Pdiddy973.AllTheCompressed.data.server;

import com.Pdiddy973.AllTheCompressed.ModRegistry;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Collectors;

public class BlockLoot extends VanillaBlockLoot {
    @Override
    protected void generate() {
        ModRegistry.BLOCKS.getEntries().forEach(block -> dropSelf(block.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModRegistry.BLOCKS.getEntries().stream()
            .map(RegistryObject::get)
            .toList();
    }
}
