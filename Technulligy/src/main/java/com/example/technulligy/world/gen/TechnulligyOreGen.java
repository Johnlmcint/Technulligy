package com.example.technulligy.world.gen;

import com.example.technulligy.setup.Registration;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import com.example.technulligy.blocks.AetherOre;
public class TechnulligyOreGen {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 20, 5, 50));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
						 Registration.AETHER_ORE.get().getDefaultState(), 4)).withPlacement(customConfig));
		}
	}

}
