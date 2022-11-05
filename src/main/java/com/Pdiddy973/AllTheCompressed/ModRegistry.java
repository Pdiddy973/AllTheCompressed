package com.Pdiddy973.AllTheCompressed;

import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModRegistry {
    private ModRegistry() {
        // nothing to do
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AllTheCompressed.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AllTheCompressed.MODID);

    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(AllTheCompressed.MODID) {
        private static final Supplier<Item> ITEM_SUPPLIER = Suppliers.memoize(
            () -> ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:gold_block_4x")));

        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ITEM_SUPPLIER.get());
        }
    };

    public static void registerBlocks() {
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            for (int i = 0; i < 9; i++) {
                RegistryObject<Block> block = BLOCKS.register(type.name + "_block_" + (i + 1) + "x", type.factory);
                blockItem(block);
            }
        }
    }

    /**
     * Register a BlockItem for a Block
     *
     * @param registryObject the Block
     * @return the new registry object
     */
    private static RegistryObject<BlockItem> blockItem(RegistryObject<Block> registryObject) {
        return ITEMS.register(registryObject.getId().getPath(),
            () -> new BlockItem(registryObject.get(), new Item.Properties().tab(CREATIVE_TAB)));
    }

    public static void register() {
        registerBlocks();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        BLOCKS.register(bus);
    }
}
