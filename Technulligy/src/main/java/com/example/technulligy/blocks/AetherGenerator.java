package com.example.technulligy.blocks;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;

public class AetherGenerator extends Block {

	public AetherGenerator() {
		//Properties of block
		super(Properties.create(Material.IRON)

				.sound(SoundType.STONE).hardnessAndResistance(1, 15).harvestLevel(1).harvestTool(ToolType.PICKAXE)
				.func_235838_a_((p_235470_0_) -> {
					return 14;
				}));

	}

}
