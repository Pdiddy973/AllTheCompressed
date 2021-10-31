package com.Pdiddy973.AllTheCompressed;

import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FallingDamageBlock extends FallingBlock {
    public FallingDamageBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected void falling(FallingBlockEntity fallingEntity) {
        fallingEntity.setHurtsEntities(1f,20);
    }
}
