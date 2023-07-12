package com.Pdiddy973.AllTheCompressed.overlay;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class OverlayPillarBlock extends OverlayBlock {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public OverlayPillarBlock(Properties properties, int level) {
        super(properties, level);
        this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    @SuppressWarnings({"java:S1874", "deprecation"}) // deprecated in MC code
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return rotatePillar(blockState, rotation);
    }

    public static BlockState rotatePillar(BlockState blockState, Rotation rotation) {
        return switch (rotation) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (blockState.getValue(AXIS)) {
                case X -> blockState.setValue(AXIS, Direction.Axis.Z);
                case Z -> blockState.setValue(AXIS, Direction.Axis.X);
                default -> blockState;
            };
            default -> blockState;
        };
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
    }
}
