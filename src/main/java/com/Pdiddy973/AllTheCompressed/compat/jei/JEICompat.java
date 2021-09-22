package com.Pdiddy973.AllTheCompressed.compat.jei;

import com.Pdiddy973.AllTheCompressed.config.Config;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

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
            ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM, Arrays.asList(
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:allthemodium_block_1x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:allthemodium_block_2x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:allthemodium_block_3x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:allthemodium_block_4x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:allthemodium_block_5x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:allthemodium_block_6x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:allthemodium_block_7x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:allthemodium_block_8x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:allthemodium_block_9x"))),

                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:vibranium_block_1x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:vibranium_block_2x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:vibranium_block_3x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:vibranium_block_4x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:vibranium_block_5x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:vibranium_block_6x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:vibranium_block_7x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:vibranium_block_8x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:vibranium_block_9x"))),

                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:unobtainium_block_1x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:unobtainium_block_2x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:unobtainium_block_3x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:unobtainium_block_4x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:unobtainium_block_5x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:unobtainium_block_6x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:unobtainium_block_7x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:unobtainium_block_8x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:unobtainium_block_9x"))),

                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:ua_alloy_block_1x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:ua_alloy_block_2x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:ua_alloy_block_3x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:ua_alloy_block_4x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:ua_alloy_block_5x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:ua_alloy_block_6x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:ua_alloy_block_7x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:ua_alloy_block_8x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:ua_alloy_block_9x"))),

                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:uv_alloy_block_1x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:uv_alloy_block_2x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:uv_alloy_block_3x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:uv_alloy_block_4x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:uv_alloy_block_5x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:uv_alloy_block_6x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:uv_alloy_block_7x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:uv_alloy_block_8x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:uv_alloy_block_9x"))),

                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:va_alloy_block_1x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:va_alloy_block_2x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:va_alloy_block_3x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:va_alloy_block_4x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:va_alloy_block_5x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:va_alloy_block_6x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:va_alloy_block_7x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:va_alloy_block_8x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:va_alloy_block_9x")))
            ));

        }

        if (!Config.COMMON.mekanism.get()) {
            ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM, Arrays.asList(
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:steel_block_1x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:steel_block_2x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:steel_block_3x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:steel_block_4x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:steel_block_5x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:steel_block_6x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:steel_block_7x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:steel_block_8x"))),
                    new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:steel_block_9x")))
            ));
        }
    }
}
