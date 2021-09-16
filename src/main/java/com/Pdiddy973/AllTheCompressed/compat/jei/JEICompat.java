package com.Pdiddy973.AllTheCompressed.compat.jei;

import com.Pdiddy973.AllTheCompressed.config.Config;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;

import java.util.Arrays;

import static com.Pdiddy973.AllTheCompressed.AllTheCompressed.MODID;

@JeiPlugin
public class JEICompat implements IModPlugin {

    private static final ResourceLocation PLUGIN_ID = new ResourceLocation(MODID, "jei_plugin");


    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        IIngredientManager ingredientManager = jeiRuntime.getIngredientManager();
        if (!Config.COMMON.allthemodium.get()) {
            if (!ModList.get().isLoaded("allthemodium")) {
                ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM, Arrays.asList(

                ));
            }
        }
        if (!Config.COMMON.alltheores.get()) {
            if (!ModList.get().isLoaded("alltheores")) {
                ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM, Arrays.asList(

                ));
            }
        }
        if (!Config.COMMON.mekanism.get()) {
            if (!ModList.get().isLoaded("mekanism")) {
                ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM, Arrays.asList(

                ));
            }
        }
        if (!Config.COMMON.compressium.get()) {
            if (!ModList.get().isLoaded("compressium")) {
                ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM, Arrays.asList(

                ));
            }
        }
        if (Config.COMMON.powah.get()) {
            if (!ModList.get().isLoaded("powah")) {
                ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM, Arrays.asList(

                ));
            }
        }
        if (Config.COMMON.thermal.get()) {
            if (!ModList.get().isLoaded("thermal")) {
                ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM, Arrays.asList(

                ));
            }
        }
    }
}
