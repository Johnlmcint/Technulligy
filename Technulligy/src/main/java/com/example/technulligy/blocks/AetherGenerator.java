package com.example.technulligy.blocks;

import javax.annotation.Nullable;
//imports the block and it's mechanics
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class AetherGenerator extends Block {
//Defines the sound, location, and tools needed to harvest this block
	public AetherGenerator() {
		// Properties of block
		super(Properties.create(Material.IRON)

				.sound(SoundType.STONE).hardnessAndResistance(1, 15).harvestLevel(1).harvestTool(ToolType.PICKAXE)
				.setLightLevel((p_235470_0_) -> {
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
