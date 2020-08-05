package com.example.technulligy.datagen;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.functions.CopyName;
import net.minecraft.loot.functions.CopyNbt;
import net.minecraft.loot.functions.SetContents;

public abstract class BaseLootTableProvider extends LootTableProvider {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

	protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
	private final DataGenerator generator;

	public BaseLootTableProvider(DataGenerator datgaGeneratorIn) {
		super(datgaGeneratorIn);
		this.generator = datgaGeneratorIn;
	}

	protected abstract void addTables();

	protected LootTable.Builder createStandardTable(String name, Block block) {
		LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1))
				.addEntry(ItemLootEntry.builder(block).acceptFunction(CopyName.builder(CopyName.Source.BLOCK_ENTITY))
						.acceptFunction(CopyNbt.builder(CopyNbt.Source.BLOCK_ENTITY)
								.addOperation("inv", "BlockEntityTag.inv", CopyNbt.Action.REPLACE)
								.addOperation("energy", "BlockEntityTag.energy", CopyNbt.Action.REPLACE))
						.acceptFunction(SetContents.builderIn()))

		;
		return LootTable.builder().addLootPool(builder);
	}
	

	public SetContents.Builder addLootEntry;
}
