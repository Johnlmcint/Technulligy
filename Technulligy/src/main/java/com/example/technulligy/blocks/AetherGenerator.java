package com.example.technulligy.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class AetherGenerator extends Block {
	public static BooleanProperty POWERED = BlockStateProperties.POWERED;
	public AetherGenerator() {
	
		// Properties of block
		super(Properties.create(Material.IRON)
				
				.sound(SoundType.STONE).hardnessAndResistance(1, 15).harvestLevel(1).harvestTool(ToolType.PICKAXE)
				.setLightLevel((p_235470_0_) -> {
					return 14;
				}));
		this.setDefaultState(this.stateContainer.getBaseState().with(POWERED, false));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
@Override
protected void fillStateContainer(Builder<Block, BlockState> builder) {
	super.fillStateContainer(builder);
	builder.add(POWERED);
}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new AetherGeneratorTile();
	}
}
