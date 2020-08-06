package com.example.technulligy.blocks;

import java.util.stream.Stream;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class CoreForge extends Block {
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(2, 0, 2, 16, 3, 10),
			Block.makeCuboidShape(3, 3, 3, 4, 8, 9),
			Block.makeCuboidShape(14, 3, 3, 15, 8, 9),
			Block.makeCuboidShape(4, 8, 3, 14, 9, 9),
			Block.makeCuboidShape(6, 3, 4, 14, 4, 9),
			Block.makeCuboidShape(3, 3, 9, 15, 8, 10),
			Block.makeCuboidShape(4, 3, 3, 14, 8, 4),
			Block.makeCuboidShape(5, 9, 6, 7, 13, 8)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
			
	public static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(0, 0, 6, 14, 3, 14),
			Block.makeCuboidShape(12, 3, 7, 13, 8, 13),
			Block.makeCuboidShape(1, 3, 7, 2, 8, 13),
			Block.makeCuboidShape(2, 8, 7, 12, 9, 13),
			Block.makeCuboidShape(2, 3, 7, 10, 4, 12),
			Block.makeCuboidShape(1, 3, 6, 13, 8, 7),
			Block.makeCuboidShape(2, 3, 12, 12, 8, 13),
			Block.makeCuboidShape(9, 9, 8, 11, 13, 10)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	public static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(6, 0, 2, 14, 3, 16),
			Block.makeCuboidShape(7, 3, 3, 13, 8, 4),
			Block.makeCuboidShape(7, 3, 14, 13, 8, 15),
			Block.makeCuboidShape(7, 8, 4, 13, 9, 14),
			Block.makeCuboidShape(7, 3, 6, 12, 4, 14),
			Block.makeCuboidShape(6, 3, 3, 7, 8, 15),
			Block.makeCuboidShape(12, 3, 4, 13, 8, 14),
			Block.makeCuboidShape(8, 9, 5, 10, 13, 7)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	public static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(2, 0, 0, 10, 3, 14),
			Block.makeCuboidShape(3, 3, 12, 9, 8, 13),
			Block.makeCuboidShape(3, 3, 1, 9, 8, 2),
			Block.makeCuboidShape(3, 8, 2, 9, 9, 12),
			Block.makeCuboidShape(4, 3, 2, 9, 4, 10),
			Block.makeCuboidShape(9, 3, 1, 10, 8, 13),
			Block.makeCuboidShape(3, 3, 2, 4, 8, 12),
			Block.makeCuboidShape(6, 9, 9, 8, 13, 11)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	public CoreForge() {
		super(Properties.create(Material.IRON)
				
			.sound(SoundType.ANVIL)
			.hardnessAndResistance(1,15)
			.harvestLevel(1)
			.harvestTool(ToolType.PICKAXE)

				);//Actual Properties of the block
		
	}//Creating Blocks properties
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		
		switch (state.get(FACING)) {
			case NORTH:
				return SHAPE_N;
			case SOUTH:
				return SHAPE_S;
			case EAST:
				return SHAPE_E;
			case WEST:
				return SHAPE_W;
			default:
				return SHAPE_N;
		}
		
	}//Adjusting the VoxelShape
	
	@Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
	
	@Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
	}
	
	@Override
	public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 0.6f;
		
	}
	
}//CoreForge
