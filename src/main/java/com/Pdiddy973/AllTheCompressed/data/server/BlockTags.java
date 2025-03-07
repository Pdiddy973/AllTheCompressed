package com.Pdiddy973.AllTheCompressed.data.server;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.ModRegistry;
import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import com.Pdiddy973.AllTheCompressed.util.ResourceUtil;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.TagLoader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
    public BlockTags(DataGenerator generator, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), lookupProvider, AllTheCompressed.MODID, existingFileHelper);
    }

    @SuppressWarnings({"java:S3011", "java:S112"}) // need reflection for this hack, avoiding mixins since this is only used for datagen
    protected ResourceManager getManagerViaReflection() {
        try {
            Method method = Objects.requireNonNull(existingFileHelper).getClass().getDeclaredMethod("getManager", PackType.class);
            method.setAccessible(true);
            return (ResourceManager) method.invoke(existingFileHelper, PackType.SERVER_DATA);
        } catch (NullPointerException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Failed to reflect into ExistingFileHelper", e);
        }
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        TagLoader<Holder<Block>> tagLoader = new TagLoader<>(BuiltInRegistries.BLOCK::getHolder, Registries.tagsDirPath(Registries.BLOCK));

        Map<ResourceLocation, Collection<Holder<Block>>> resourceMap = tagLoader.loadAndBuild(getManagerViaReflection());

        Map<TagKey<Block>, List<Holder<Block>>> tagMap = resourceMap.entrySet().stream()
            .collect(Collectors.toUnmodifiableMap(
                entry -> TagKey.create(Registries.BLOCK, entry.getKey()),
                entry -> List.copyOf(entry.getValue()))
            );

        for (Overlays value : Overlays.values()) {
            var parent = value.overlay.parent;
            var block = BuiltInRegistries.BLOCK.getOptional(parent);
            Holder<Block> parentHolder = BuiltInRegistries.BLOCK.getHolder(parent).orElse(null);

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
