package com.example.technulligy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AetherOre extends Block{
	//States what the block sounds like, how hard it is to find, and how hard it is to mine.
	public AetherOre() {
		super(Properties.create(Material.IRON)
				
				.sound(SoundType.STONE)
				.hardnessAndResistance(4,15)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.setLightLevel((p_235470_0_) -> {
					return 2;
				}));//Block Properties
	
		
	}

}//AetherOre
