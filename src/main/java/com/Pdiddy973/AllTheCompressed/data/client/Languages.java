package com.Pdiddy973.AllTheCompressed.data.client;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.ModRegistry;
import com.Pdiddy973.AllTheCompressed.data.LanguageUtil;
import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static com.Pdiddy973.AllTheCompressed.util.TranslationKey.tab;
import static com.Pdiddy973.AllTheCompressed.util.TranslationKey.tooltip;


public class Languages {
    private Languages() {
        // nothing to do
    }

    public static class English extends LanguageProvider {

        private final LanguageUtil languageUtil;

        public English(PackOutput packOutput, ExistingFileHelper fileHelper) {
            super(packOutput, AllTheCompressed.MODID, "en_us");
            languageUtil = new LanguageUtil(fileHelper);
        }

        @Override
        protected void addTranslations() {
            add(tab(), "AllTheCompressed");
            add(tooltip("quantity"), "Total blocks: %s");
            addBlock(ModRegistry.FLINT_BLOCK, "Flint Block");
            addBlock(ModRegistry.BLAZE_ROD_BLOCK, "Blaze Rod Block");
            addBlock(ModRegistry.ANTIMATTER_BLOCK, "Antimatter Block");

            for (Overlays value : Overlays.values()) {
                var parent = value.overlay.parent;
                var block = BuiltInRegistries.BLOCK.getOptional(parent);

                if (block.isEmpty() || block.get() == Blocks.AIR) {
                    AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                    continue;
                }

                String parentName = languageUtil.getParentName(parent);

                for (int i=0;i<9;i++) {
                    add(value.overlay.iall.get(i).get(), String.format("%s %sx", parentName, i+1));
                }
            }
        }

        /*
         * Mod translations cannot be loaded during runData, we inject them manually to work around this.
         */
        @Override
        public void add(String key, String value) {
            super.add(key, value);
            languageUtil.put(key, value);
        }
    }
}
