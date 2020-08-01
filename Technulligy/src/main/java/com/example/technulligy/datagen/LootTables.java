package com.example.technulligy.datagen;

import com.example.technulligy.setup.Registration;

import net.minecraft.data.DataGenerator;

public class LootTables extends BaseLootTableProvider {

	public LootTables(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}

	@Override
	protected void addTables() {
		  lootTables.put(Registration.AETHER_GENERATOR.get(), createStandardTable("aether_generator", Registration.AETHER_GENERATOR.get()));
		  lootTables.put(Registration.CORE_FORGE.get(), createStandardTable("core_forge", Registration.CORE_FORGE.get()));
		
	}
}