package com.Pdiddy973.AllTheCompressed.generators;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.AllTheCompressedType;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

public class AllTheCompressedLanguageProvider extends LanguageProvider {

    private final String locale;

    public AllTheCompressedLanguageProvider(DataGenerator gen, String locale) {
        super(gen, AllTheCompressed.MODID, locale);
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        Map<String, Map<String,String>> config = null;
        try {
            Reader reader = new FileReader("config/languageValues.json");
            Gson gson = new Gson();
            JsonReader configFile = new JsonReader(reader);
            config = gson.fromJson(configFile, Map.class);
        } catch (FileNotFoundException e) {
        }
        if (config != null) {
            Map<String, String> localeMap = config.get(locale);
            add("itemGroup.compressium", localeMap.get("itemGroup"));
            for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
                for (int i = 0; i < 9; i++) {
                    add(type.blocks.get(i), localeMap.get(type.name) + " ("+(i+1)+"X)");
                }
            }
        }
    }
}
