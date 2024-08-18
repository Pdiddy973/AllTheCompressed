package com.Pdiddy973.AllTheCompressed.data.server;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.ModRegistry;
import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(DataGenerator generator, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), lookupProvider, blockTags, AllTheCompressed.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for (Overlays value : Overlays.values()) {
            var parent = value.overlay.parent;
            var block = BuiltInRegistries.BLOCK.getOptional(parent);

            if (block.isEmpty() || block.get() == Blocks.AIR) {
                AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                continue;
            }

            tag(ModRegistry.i1).add(value.overlay.i1.get());
            tag(ModRegistry.i2).add(value.overlay.i2.get());
            tag(ModRegistry.i3).add(value.overlay.i3.get());
            tag(ModRegistry.i4).add(value.overlay.i4.get());
            tag(ModRegistry.i5).add(value.overlay.i5.get());
            tag(ModRegistry.i6).add(value.overlay.i6.get());
            tag(ModRegistry.i7).add(value.overlay.i7.get());
            tag(ModRegistry.i8).add(value.overlay.i8.get());
            tag(ModRegistry.i9).add(value.overlay.i9.get());
        }
    }
}
