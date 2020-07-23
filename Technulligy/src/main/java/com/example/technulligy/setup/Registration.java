package com.example.technulligy.setup;

import com.example.technulligy.Technulligy;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
/*
 	public static Item aether = null;	
	public static Item c_ore = null;
	public static Item basic_core = null;
	public static Item weak_core = null;
	public static Item savage_core = null;
	public static Item guard_core = null;
	public static Item wind_core = null;
	public static Item vital_core = null;
	public static Item haste_core = null;
 */
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Technulligy.MOD_ID);
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Technulligy.MOD_ID);

	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static final RegistryObject<Item> NULLCORE = ITEMS.register("null_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> C = ITEMS.register("null_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

}
