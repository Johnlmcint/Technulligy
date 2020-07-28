package com.example.technulligy.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class AetherGenerator extends Block {

	public AetherGenerator() {
		//Properties of block
		super(Properties.create(Material.IRON)

				.sound(SoundType.STONE).hardnessAndResistance(1, 15)
				.harvestLevel(1)
				.harvestTool(ToolType.PICKAXE)
				// unmapped lightvalue
				.func_235838_a_((p_235470_0_) -> {
					return 14; 
				}));

	}
	 @Override
	    public boolean hasTileEntity(BlockState state) {
	        return true;
	    }
	  @Nullable
	    @Override
	    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
	        return new AetherGeneratorTile();
	    }
}
