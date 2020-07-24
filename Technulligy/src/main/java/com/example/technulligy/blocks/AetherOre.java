package com.example.technulligy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AetherOre extends Block{
	
	public AetherOre() {
		super(Properties.create(Material.IRON)
				
				.sound(SoundType.STONE)
				.hardnessAndResistance(3,15)
				.harvestLevel(1)
				.harvestTool(ToolType.PICKAXE)
				
				);//Block Properties
	
		
	}

}//AetherOre
