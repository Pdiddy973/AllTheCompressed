package com.Pdiddy973.AllTheCompressed.overlay;

import com.Pdiddy973.AllTheCompressed.ModRegistry;
import com.google.common.base.Suppliers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

public class OverlayEntry {
    public final ResourceLocation parent;
    public final DeferredBlock<Block> x1;
    public final DeferredBlock<Block> x2;
    public final DeferredBlock<Block> x3;
    public final DeferredBlock<Block> x4;
    public final DeferredBlock<Block> x5;
    public final DeferredBlock<Block> x6;
    public final DeferredBlock<Block> x7;
    public final DeferredBlock<Block> x8;
    public final DeferredBlock<Block> x9;
    public final List<DeferredBlock<Block>> xall;

    public final DeferredItem<BlockItem> i1;
    public final DeferredItem<BlockItem> i2;
    public final DeferredItem<BlockItem> i3;
    public final DeferredItem<BlockItem> i4;
    public final DeferredItem<BlockItem> i5;
    public final DeferredItem<BlockItem> i6;
    public final DeferredItem<BlockItem> i7;
    public final DeferredItem<BlockItem> i8;
    public final DeferredItem<BlockItem> i9;
    public final List<DeferredItem<BlockItem>> iall;

    private boolean blockLoaded = false;

    /**
     * If the parent block has been loaded successfully
     * @return the result
     */
    public boolean isBlockLoaded() {
        return blockLoaded;
    }

    /**
     * Create a new overlay and register it
     * @param parent the parent block for this overlay
     * @param registryOverride optionally override the registry path for this block
     */
    public OverlayEntry(ResourceLocation parent, @Nullable String registryOverride) {
        this.parent = parent;
        String path = registryOverride == null ? parent.getPath() : registryOverride;
        Supplier<BlockBehaviour.Properties> properties = getProperties(parent);
        boolean pillar = parent.getPath().endsWith("_log");


        x1 = block(path, properties, 1, pillar);
        x2 = block(path, properties, 2, pillar);
        x3 = block(path, properties, 3, pillar);
        x4 = block(path, properties, 4, pillar);
        x5 = block(path, properties, 5, pillar);
        x6 = block(path, properties, 6, pillar);
        x7 = block(path, properties, 7, pillar);
        x8 = block(path, properties, 8, pillar);
        x9 = block(path, properties, 9, pillar);
        xall = List.of(x1, x2, x3, x4, x5, x6, x7, x8, x9);

        i1 = blockItem(x1);
        i2 = blockItem(x2);
        i3 = blockItem(x3);
        i4 = blockItem(x4);
        i5 = blockItem(x5);
        i6 = blockItem(x6);
        i7 = blockItem(x7);
        i8 = blockItem(x8);
        i9 = blockItem(x9);
        iall = List.of(i1, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    private static final BlockBehaviour.Properties defaultProperties = BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(1.0F);

    /**
     * Retrieve the block properties for the parent block at registration time
     * @param parent the parent block
     * @return a supplier for the properties
     */
    private Supplier<BlockBehaviour.Properties> getProperties(ResourceLocation parent) {
        return Suppliers.memoize(() -> {
            BlockBehaviour.Properties properties = defaultProperties;
            if (ModList.get().isLoaded(parent.getNamespace())) {
                var block = BuiltInRegistries.BLOCK.getOptional(parent);
                if (block.isPresent()) {
                    blockLoaded = true;
                    properties = BlockBehaviour.Properties.ofFullCopy(block.get());
                }
            }
            return properties;
        });
    }

    /**
     * Register a BlockItem for a Block
     *
     * @param block the Block
     * @return the new registry object
     */
    private static DeferredItem<BlockItem> blockItem(DeferredBlock<Block> block) {
        return ModRegistry.OVERLAY_ITEMS.register(block.getKey().location().getPath(),
            () -> new BlockItem(block.get(), new Item.Properties()));
    }

    /**
     * Register an OverlayBlock
     * @param path the registry path of the block this is based on
     * @param properties the block properties for the new block
     * @param level the compression level of the block
     * @param pillar whether the block is a pillar block
     * @return the new registry entry
     */
    private static DeferredBlock<Block> block(String path, Supplier<BlockBehaviour.Properties> properties, int level, boolean pillar) {
        Supplier<Block> supplier;
        if (pillar) {
            supplier = () -> new OverlayPillarBlock(properties.get(), level);
        } else {
            supplier = () -> new OverlayBlock(properties.get(), level);
        }
        return ModRegistry.OVERLAY_BLOCKS.register(generateName(path, level), supplier);
    }

    private static String generateName(String path, int level) {
        return String.format(Locale.ROOT, "%s_%dx", path, level);
    }
}
