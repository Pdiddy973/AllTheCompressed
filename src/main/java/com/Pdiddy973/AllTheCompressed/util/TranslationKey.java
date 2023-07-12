package com.Pdiddy973.AllTheCompressed.util;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class TranslationKey {
    private TranslationKey() {
        // nothing to do
    }

    private static final String FORMAT = "%s." + AllTheCompressed.MODID + ".%s";

    public static String tooltip(String key) {
        return String.format(FORMAT, "tooltip", key);
    }

    public static String block(String key) {
        return String.format(FORMAT, "block", key);
    }

    public static String item(String key) {
        return String.format(FORMAT, "item", key);
    }

    public static String gui(String key) {
        return String.format(FORMAT, "gui", key);
    }

    public static String tab() {
        return String.format("itemGroup.%s", AllTheCompressed.MODID);
    }

    public static String jei(String key) {
        return String.format(AllTheCompressed.MODID + ".int.jei.category.%s", key);
    }

    public static String chat(String key) {
        return String.format(FORMAT, "chat", key);
    }

    public static String advancement(String key) {
        return String.format(FORMAT, "advancement", key);
    }

    public static String desc(String key) {
        return key.concat(".desc");
    }

    public static MutableComponent translateTooltip(String key) {
        return Component.translatable(TranslationKey.tooltip(key));
    }

    public static MutableComponent translateTooltip(String key, Object... values) {
        return Component.translatable(TranslationKey.tooltip(key), values);
    }
}
