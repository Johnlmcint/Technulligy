package com.example.technulligy.blocks;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;

public class CoreForge extends Block {
	
	public CoreForge() {
		super(Properties.create(Material.IRON)
				
			.sound(SoundType.ANVIL)
			.hardnessAndResistance(1,15)
			.harvestLevel(1)
			.harvestTool(ToolType.PICKAXE)

				);//Actual Properties of the block
		
	}//Creating Blocks properties
	
	@Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
	
	@Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
	}
}//CoreForge
