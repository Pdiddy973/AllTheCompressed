package com.Pdiddy973.AllTheCompressed.compat;

import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;

import static com.Pdiddy973.AllTheCompressed.AllTheCompressed.MODID;

@JeiPlugin
public class JEICompat implements IModPlugin {

    private static final ResourceLocation PLUGIN_ID = new ResourceLocation(MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

//    @Override
//    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
//        IIngredientManager ingredientManager = jeiRuntime.getIngredientManager();
//
//        for (Overlays value : Overlays.values()) {
//            if (!ModList.get().isLoaded(value.getMod().toString())) {
//                ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, value.getOverlay().iall.stream()
//                    .map(RegistryObject::get)
//                    .map(Item::getDefaultInstance)
//                    .toList()
//                );
//            }
//        }
//    }
}
