package com.Pdiddy973.AllTheCompressed.util;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ResourceUtil {
    private ResourceUtil() {
        // nothing to do
    }

    public static ResourceLocation prefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(AllTheCompressed.MODID, path);
    }

    public static String id(String path) {
        return prefix(path).toString();
    }

    public static ResourceLocation forge(String path) {
        return ResourceLocation.fromNamespaceAndPath("forge", path);
    }

    public static ResourceLocation c(String path) {
        return ResourceLocation.fromNamespaceAndPath("c", path);
    }


    public static TagKey<Item> tag(String path) {
        return ItemTags.create(ResourceLocation.parse(path));
    }

    public static TagKey<Block> blockTag(String path) {
        return BlockTags.create(ResourceLocation.parse(path));
    }

    public static TagKey<Item> modTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(AllTheCompressed.MODID, path));
    }


    public static ResourceLocation block(String path) {
        return prefix(String.format("block/%s", path));
    }

    public static ResourceLocation compress(ResourceLocation output) {
        return prefix(String.format("compress/%s", output.getPath()));
    }

    public static ResourceLocation decompress(ResourceLocation output) {
        return prefix(String.format("decompress/%s", output.getPath()));
    }
}
