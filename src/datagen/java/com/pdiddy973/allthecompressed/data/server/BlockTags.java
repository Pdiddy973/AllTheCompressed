package com.pdiddy973.allthecompressed.data.server;

import com.pdiddy973.allthecompressed.AllTheCompressed;
import com.pdiddy973.allthecompressed.overlay.Overlays;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.TagLoader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static net.minecraft.tags.BlockTags.BEACON_BASE_BLOCKS;
import static net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE;
import static net.minecraft.tags.BlockTags.MINEABLE_WITH_HOE;
import static net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE;
import static net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL;
import static net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL;
import static net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL;
import static net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL;
import static net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS;
import static net.minecraft.tags.BlockTags.SOUL_SPEED_BLOCKS;
import static net.minecraft.tags.BlockTags.SWORD_EFFICIENT;


public class BlockTags extends BlockTagsProvider {
    private final ResourceManager serverResources;

    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ResourceManager serverResources) {
        super(output, lookupProvider, AllTheCompressed.MODID);
        this.serverResources = serverResources;
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        TagLoader.ElementLookup<Holder<Block>> elementLookup = (TagLoader.ElementLookup<Holder<Block>>) TagLoader.ElementLookup.fromFrozenRegistry(BuiltInRegistries.BLOCK);

        Map<TagKey<Block>, List<Holder<Block>>> tagMap = TagLoader.loadTagsForRegistry(serverResources, BuiltInRegistries.BLOCK.key(), elementLookup);

        for (Overlays value : Overlays.values()) {
            var parent = value.overlay.parent;
            var block = BuiltInRegistries.BLOCK.getOptional(parent);
            Holder<Block> parentHolder = BuiltInRegistries.BLOCK.get(parent).orElse(null);

            if (block.isEmpty() || block.get() == Blocks.AIR) {
                AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                continue;
            }

            var blocks = value.overlay.xall.stream()
                .map(Supplier::get)
                .toArray(Block[]::new);
            for (TagKey<Block> mineable : List.of(
                MINEABLE_WITH_PICKAXE,
                MINEABLE_WITH_AXE,
                MINEABLE_WITH_HOE,
                MINEABLE_WITH_SHOVEL,
                SWORD_EFFICIENT,
                NEEDS_DIAMOND_TOOL,
                NEEDS_IRON_TOOL,
                NEEDS_STONE_TOOL,
                BEACON_BASE_BLOCKS,
                SOUL_FIRE_BASE_BLOCKS,
                SOUL_SPEED_BLOCKS
            )) {
                if (tagMap.get(mineable).contains(parentHolder)) {
                    AllTheCompressed.LOGGER.info("adding tag {} for block {}", mineable, parent);
                    tag(mineable).add(blocks);
                }
            }
        }
    }
}
