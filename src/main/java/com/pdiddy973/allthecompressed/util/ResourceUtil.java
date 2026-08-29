package com.pdiddy973.allthecompressed.util;

import com.pdiddy973.allthecompressed.AllTheCompressed;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Block;

public class ResourceUtil {
    private ResourceUtil() {
        // nothing to do
    }

    public static Identifier prefix(String path) {
        return Identifier.fromNamespaceAndPath(AllTheCompressed.MODID, path);
    }

    public static String id(String path) {
        return prefix(path).toString();
    }

    public static Identifier forge(String path) {
        return Identifier.fromNamespaceAndPath("forge", path);
    }

    public static Identifier c(String path) {
        return Identifier.fromNamespaceAndPath("c", path);
    }


    public static TagKey<Item> tag(String path) {
        return ItemTags.create(Identifier.parse(path));
    }

    public static TagKey<Block> blockTag(String path) {
        return BlockTags.create(Identifier.parse(path));
    }

    public static TagKey<Item> modTag(String path) {
        return ItemTags.create(Identifier.fromNamespaceAndPath(AllTheCompressed.MODID, path));
    }


    public static Identifier block(String path) {
        return prefix(String.format("block/%s", path));
    }

    public static ResourceKey<Recipe<?>> compress(Identifier output) {
        return ResourceKey.create(Registries.RECIPE, prefix(String.format("compress/%s", output.getPath())));
    }

    public static ResourceKey<Recipe<?>> decompress(Identifier output) {
        return ResourceKey.create(Registries.RECIPE, prefix(String.format("decompress/%s", output.getPath())));
    }
}
