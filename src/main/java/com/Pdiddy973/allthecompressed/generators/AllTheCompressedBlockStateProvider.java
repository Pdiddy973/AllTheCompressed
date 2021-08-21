package com.Pdiddy973.AllTheCompressed.generators;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.AllTheCompressedType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.loaders.MultiLayerModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AllTheCompressedBlockStateProvider extends BlockStateProvider {

    public AllTheCompressedBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, AllTheCompressed.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            Block[] blocks = AllTheCompressed.BLOCKS.get(type.name);
            for (int i = 0; i < 9; i++) {
                simpleBlock(blocks[i], models().getBuilder(AllTheCompressed.MODID+":"+type.name+"_"+(i+1))
                    .parent(this.models().getExistingFile(mcLoc("block/block")))
                    .texture("particle", type.particlePath)
                    .customLoader(MultiLayerModelBuilder::begin)
                        .submodel(RenderType.solid(),
                                this.models().nested().parent(this.models().getExistingFile(type.baseBlockModel)))
                        .submodel(RenderType.translucent(),
                                this.models().nested().parent(this.models().getExistingFile(mcLoc("block/cube_all")))
                                        .texture("all", new ResourceLocation(AllTheCompressed.MODID, "block/layer_"+(i+1))))
                    .end());
            }
        }
    }
}
