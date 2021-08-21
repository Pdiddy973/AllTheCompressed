package com.Pdiddy973.AllTheCompressed.generators;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.AllTheCompressedType;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AllTheCompressedItemModelProvider extends ItemModelProvider {
    public AllTheCompressedItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, AllTheCompressed.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            for (int i = 1; i <= 9; i++) {
                withExistingParent(AllTheCompressed.MODID+":"+type.name+"_"+i, new ResourceLocation(AllTheCompressed.MODID, "block/" + type.name+"_"+i));
            }
        }
    }
}

