package com.Pdiddy973.AllTheCompressed.data.client;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.data.LanguageUtil;
import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;

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

            for (Overlays value : Overlays.values()) {
                var parent = value.overlay.parent;
                var block = ForgeRegistries.BLOCKS.getValue(parent);

                if (block == null || block == Blocks.AIR) {
                    AllTheCompressed.LOGGER.error("missing block during datagen: {}", parent);
                    continue;
                }

                String parentName = languageUtil.getParentName(parent);

                for (int i=0;i<9;i++) {
                    add(value.overlay.iall.get(i).get(), String.format("%s %sx", parentName, i+1));
                }
            }
        }
    }
}
