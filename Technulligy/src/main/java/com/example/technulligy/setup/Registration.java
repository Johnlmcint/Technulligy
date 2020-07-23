package com.example.technulligy.setup;

import com.example.technulligy.Technulligy;
import com.example.technulligy.blocks.CoreForge;

import net.minecraft.item.ItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Technulligy.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Technulligy.MOD_ID);

	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static final RegistryObject<Item> NULL_CORE = ITEMS.register("null_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> AETHER = ITEMS.register("aether", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> C_ORE = ITEMS.register("c_ore", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> BASIC_CORE = ITEMS.register("basic_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> WEAK_CORE = ITEMS.register("weak_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> SAVAGE_CORE = ITEMS.register("savage_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> GUARD_CORE = ITEMS.register("guard_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> WIND_CORE= ITEMS.register("wind_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> VITAL_CORE = ITEMS.register("vital_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> HASTE_CORE = ITEMS.register("haste_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Block> CORE_FORGE = BLOCKS.register("core_forge", CoreForge::new);
    public static final RegistryObject<Item> CORE_FORGE_ITEM  = ITEMS.register("core_forge", () -> new BlockItem(CORE_FORGE.get(), new Item.Properties().group(ItemGroup.MISC)));

}
