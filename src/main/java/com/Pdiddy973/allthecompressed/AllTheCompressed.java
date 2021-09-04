package com.Pdiddy973.AllTheCompressed;


import com.Pdiddy973.AllTheCompressed.blocks.atc.AllTheCompressedType;
import com.Pdiddy973.AllTheCompressed.blocks.atc.AllTheType;
import com.Pdiddy973.AllTheCompressed.blocks.atm.AllTheModiumType;
import com.Pdiddy973.AllTheCompressed.blocks.ato.AllTheOresType;
import com.Pdiddy973.AllTheCompressed.blocks.mekanism.MekanismType;
import com.Pdiddy973.AllTheCompressed.blocks.minecraft.MinecraftType;
import com.Pdiddy973.AllTheCompressed.blocks.powah.PowahType;
import com.Pdiddy973.AllTheCompressed.blocks.thermal.ThermalType;
import com.Pdiddy973.AllTheCompressed.config.Config;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("allthecompressed")
public class AllTheCompressed {
    public static final ItemGroup creativeTab = new ItemGroup("AllTheCompressed") {
        @Override
        // @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:nether_star_block_1x")));
        }
    };

    public AllTheCompressed() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);
        Config.loadConfig(Config.COMMON_SPEC, FMLPaths.CONFIGDIR.get().resolve("allthecompressed-common.toml").toString());

        if (Config.COMMON.allthemodium.get()) {
            if (ModList.get().isLoaded("allthemodium")) {
                FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::allthemodiumBlocks);
                FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::allthemodiumItems);
            }
        }

        if (Config.COMMON.alltheores.get()) {
            if (ModList.get().isLoaded("alltheores")) {
                FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::alltheoresBlocks);
                FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::alltheoresItems);
            }
        }

        if (Config.COMMON.mekanism.get()) {
            if (ModList.get().isLoaded("mekanism")) {
                FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::mekanismBlocks);
                FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::mekanismItems);
            }
        }

        if (!ModList.get().isLoaded("compressium")) {
            FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::minecraftBlocks);
            FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::minecraftItems);
        }

        if (Config.COMMON.powah.get()) {
            if (ModList.get().isLoaded("powah")) {
                FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::powahBlocks);
                FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::powahItems);
            }
        }

        if (Config.COMMON.thermal.get()) {
            if (ModList.get().isLoaded("thermal_foundation")) {
                FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::thermalBlocks);
                FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::thermalItems);
            }
        }
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::registerBlocks);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::registerItems);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::registerBlock);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::registerItem);

        DistExecutor.runForDist(() -> () -> new AllTheCompressedClient(), () -> () -> new AllTheCompressedCommon()).init();
    }

    //ATC Blocks
    private void registerBlock(RegistryEvent.Register<Block> event) {
        for (AllTheType type : AllTheType.VALUES) {
            Block block = type.factory.get();
            event.getRegistry().register(block.setRegistryName(type.name + "_block"));
            type.blocks.add(block);
        }
    }

    private void registerItem(RegistryEvent.Register<Item> event) {
        for (AllTheType type : AllTheType.VALUES) {
            for (Block block : type.blocks) {
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(creativeTab)).setRegistryName(block.getRegistryName()));
            }
        }
    }

    private void registerBlocks(RegistryEvent.Register<Block> event) {
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            for (int i = 0; i < 9; i++) {
                Block block = type.factory.get();
                event.getRegistry().register(block.setRegistryName(type.name + "_block_" + (i + 1) + "x"));
                type.blocks.add(block);
            }
        }
    }

    private void registerItems(RegistryEvent.Register<Item> event) {
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            for (Block block : type.blocks) {
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(creativeTab)).setRegistryName(block.getRegistryName()));
            }
        }
    }

    //AllTheModium Blocks
    private void allthemodiumBlocks(RegistryEvent.Register<Block> event) {
        for (AllTheModiumType type : AllTheModiumType.VALUES) {
            for (int i = 0; i < 9; i++) {
                Block block = type.factory.get();
                event.getRegistry().register(block.setRegistryName(type.name + "_block_" + (i + 1) + "x"));
                type.blocks.add(block);
            }
        }
    }

    private void allthemodiumItems(RegistryEvent.Register<Item> event) {
        for (AllTheModiumType type : AllTheModiumType.VALUES) {
            for (Block block : type.blocks) {
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(creativeTab)).setRegistryName(block.getRegistryName()));
            }
        }
    }

    //AllTheOres Blocks
    private void alltheoresBlocks(RegistryEvent.Register<Block> event) {
        for (AllTheOresType type : AllTheOresType.VALUES) {
            for (int i = 0; i < 9; i++) {
                Block block = type.factory.get();
                event.getRegistry().register(block.setRegistryName(type.name + "_block_" + (i + 1) + "x"));
                type.blocks.add(block);
            }
        }
    }

    private void alltheoresItems(RegistryEvent.Register<Item> event) {
        for (AllTheOresType type : AllTheOresType.VALUES) {
            for (Block block : type.blocks) {
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(creativeTab)).setRegistryName(block.getRegistryName()));
            }
        }
    }

    //Mekanism Blocks
    private void mekanismBlocks(RegistryEvent.Register<Block> event) {
        for (MekanismType type : MekanismType.VALUES) {
            for (int i = 0; i < 9; i++) {
                Block block = type.factory.get();
                event.getRegistry().register(block.setRegistryName(type.name + "_block_" + (i + 1) + "x"));
                type.blocks.add(block);
            }
        }
    }

    private void mekanismItems(RegistryEvent.Register<Item> event) {
        for (MekanismType type : MekanismType.VALUES) {
            for (Block block : type.blocks) {
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(creativeTab)).setRegistryName(block.getRegistryName()));
            }
        }
    }

    //Minecraft Blocks
    private void minecraftBlocks(RegistryEvent.Register<Block> event) {
        for (MinecraftType type : MinecraftType.VALUES) {
            for (int i = 0; i < 9; i++) {
                Block block = type.factory.get();
                event.getRegistry().register(block.setRegistryName(type.name + "_block_" + (i + 1) + "x"));
                type.blocks.add(block);
            }
        }
    }

    private void minecraftItems(RegistryEvent.Register<Item> event) {
        for (MinecraftType type : MinecraftType.VALUES) {
            for (Block block : type.blocks) {
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(creativeTab)).setRegistryName(block.getRegistryName()));
            }
        }
    }

    //Powah Blocks
    private void powahBlocks(RegistryEvent.Register<Block> event) {
        for (PowahType type : PowahType.VALUES) {
            for (int i = 0; i < 9; i++) {
                Block block = type.factory.get();
                event.getRegistry().register(block.setRegistryName(type.name + "_block_" + (i + 1) + "x"));
                type.blocks.add(block);
            }
        }
    }

    private void powahItems(RegistryEvent.Register<Item> event) {
        for (PowahType type : PowahType.VALUES) {
            for (Block block : type.blocks) {
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(creativeTab)).setRegistryName(block.getRegistryName()));
            }
        }
    }

    //Thermal Blocks
    private void thermalBlocks(RegistryEvent.Register<Block> event) {
        for (ThermalType type : ThermalType.VALUES) {
            for (int i = 0; i < 9; i++) {
                Block block = type.factory.get();
                event.getRegistry().register(block.setRegistryName(type.name + "_block_" + (i + 1) + "x"));
                type.blocks.add(block);
            }
        }
    }

    private void thermalItems(RegistryEvent.Register<Item> event) {
        for (ThermalType type : ThermalType.VALUES) {
            for (Block block : type.blocks) {
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(creativeTab)).setRegistryName(block.getRegistryName()));
            }
        }
    }
}
