package com.Pdiddy973.AllTheCompressed;

import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import com.Pdiddy973.AllTheCompressed.util.ResourceUtil;
import com.Pdiddy973.AllTheCompressed.util.TranslationKey;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModRegistry {
    private ModRegistry() {
        // nothing to do
    }

    public static final TagKey<Item> i1 = ResourceUtil.modTag("1x");
    public static final TagKey<Item> i2 = ResourceUtil.modTag("2x");
    public static final TagKey<Item> i3 = ResourceUtil.modTag("3x");
    public static final TagKey<Item> i4 = ResourceUtil.modTag("4x");
    public static final TagKey<Item> i5 = ResourceUtil.modTag("5x");
    public static final TagKey<Item> i6 = ResourceUtil.modTag("6x");
    public static final TagKey<Item> i7 = ResourceUtil.modTag("7x");
    public static final TagKey<Item> i8 = ResourceUtil.modTag("8x");
    public static final TagKey<Item> i9 = ResourceUtil.modTag("9x");

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AllTheCompressed.MODID);
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AllTheCompressed.MODID);
    public static final DeferredRegister.Items OVERLAY_ITEMS = DeferredRegister.createItems(AllTheCompressed.MODID);
    public static final DeferredRegister.Blocks OVERLAY_BLOCKS = DeferredRegister.createBlocks(AllTheCompressed.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AllTheCompressed.MODID);

    public static final Supplier<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("creative_tab", () -> CreativeModeTab.builder()
        .icon(() -> Overlays.GOLD.overlay.i4.get().getDefaultInstance())
        .title(Component.translatable(TranslationKey.tab()))
        .displayItems((parameters, output) -> {
            for (Overlays value : Overlays.values()) {
                if (ModList.get().isLoaded(value.mod.toString())) {
                    value.overlay.iall.stream()
                        .map(Supplier::get)
                        .map(Item::getDefaultInstance)
                        .forEach(output::accept);
                }
            }

            ITEMS.getEntries().stream()
                .map(Supplier::get)
                .map(Item::getDefaultInstance)
                .forEach(output::accept);
        }).build()
    );

    public static final DeferredBlock<Block> FLINT_BLOCK = BLOCKS.registerBlock("flint_block", Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    public static final DeferredItem<BlockItem> FLINT_BLOCK_ITEM = blockItem(FLINT_BLOCK);

    public static final DeferredBlock<Block> BLAZE_ROD_BLOCK = BLOCKS.registerBlock("blaze_rod_block", Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.GOLD));
    public static final DeferredItem<BlockItem> BLAZE_ROD_BLOCK_ITEM = blockItem(BLAZE_ROD_BLOCK);

    public static final DeferredBlock<Block> ANTIMATTER_BLOCK = BLOCKS.registerBlock("antimatter_block", Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE));
    public static final DeferredItem<BlockItem> ANTIMATTER_BLOCK_ITEM = blockItem(ANTIMATTER_BLOCK);


    /**
     * Register a BlockItem for a Block
     *
     * @param holder the Block
     * @return the new registry object
     */
    private static DeferredItem<BlockItem> blockItem(Holder<Block> holder) {
        return ITEMS.register(holder.unwrapKey().map(ResourceKey::location).map(ResourceLocation::getPath).orElseThrow(),
            () -> new BlockItem(holder.value(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        Overlays.init();
        ITEMS.register(bus);
        BLOCKS.register(bus);
        OVERLAY_ITEMS.register(bus);
        OVERLAY_BLOCKS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
    }
}
