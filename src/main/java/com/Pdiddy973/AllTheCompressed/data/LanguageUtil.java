package com.Pdiddy973.AllTheCompressed.data;

import com.google.common.collect.ImmutableMap;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.StringDecomposer;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LanguageUtil {
    private final Map<String, Language> languageMap = new HashMap<>();
    private final ExistingFileHelper fileHelper;

    public LanguageUtil(ExistingFileHelper fileHelper) {
        this.fileHelper = fileHelper;
        languageMap.put("minecraft", Language.getInstance());
    }

    public String getParentName(ResourceLocation parent) {
        String translationKey = String.format("block.%s.%s", parent.getNamespace(), parent.getPath());
        return getLanguage(parent.getNamespace()).getOrDefault(translationKey);
    }

    private Language getLanguage(String mod) {
        if (!ModList.get().isLoaded(mod)) {
            throw new IllegalArgumentException("Mod is not loaded: " + mod);
        }
        return languageMap.computeIfAbsent(mod, this::loadLanguage);
    }

    /**
     * @see net.minecraft.locale.Language#loadDefault()
     * Adapted from loadDefault to load lang files from other mods at runtime,
     * in order to generate x1-x9 names based on the original block name
     * @param mod the mod to load from
     * @return the new Language object
     */
    @SuppressWarnings({"java:S5803", "java:S112"}) // ignore VisibleForTesting warning
    private Language loadLanguage(String mod) {
        ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
        String langFile = String.format("/assets/%s/lang/en_us.json", mod);

        try {
            Resource resource = fileHelper.getResource(new ResourceLocation(mod, "/lang/en_us.json"), PackType.CLIENT_RESOURCES);
            InputStream is = resource.open();
            Language.loadFromJson(is, builder::put);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to load file: %s", langFile), e);
        }

        final Map<String, String> map = new java.util.HashMap<>(builder.build());
        return new Language() {
            public String getOrDefault(String key, String fallback) {
                return map.getOrDefault(key, fallback);
            }

            public boolean has(String key) {
                return map.containsKey(key);
            }

            public boolean isDefaultRightToLeft() {
                return false;
            }

            public FormattedCharSequence getVisualOrder(FormattedText formattedText) {
                return sink -> formattedText.visit((style, text) -> {
                    return StringDecomposer.iterateFormatted(text, style, sink) ? Optional.empty() : FormattedText.STOP_ITERATION;
                }, Style.EMPTY).isPresent();
            }

            @Override
            public Map<String, String> getLanguageData() {
                return map;
            }
        };
    }

}
