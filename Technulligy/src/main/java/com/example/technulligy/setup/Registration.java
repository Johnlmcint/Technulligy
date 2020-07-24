package com.example.technulligy.setup;

import com.example.technulligy.Technulligy;
import com.example.technulligy.blocks.CoreForge;
import com.example.technulligy.blocks.CoreForgeTile;
import com.example.technulligy.items.BasicCore;
import com.example.technulligy.items.GuardianCore;
import com.example.technulligy.items.SavageCore;
import com.example.technulligy.items.WeakCore;
import com.example.technulligy.items.WindCore;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Technulligy.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Technulligy.MOD_ID);
	 private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES,Technulligy.MOD_ID);

	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static final RegistryObject<Item> NULL_CORE = ITEMS.register("null_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> CORE_CENTER = ITEMS.register("core_center", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> AETHER = ITEMS.register("aether", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> C_ORE = ITEMS.register("c_ore", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> BASIC_CORE = ITEMS.register("basic_core", BasicCore::new);
	public static final RegistryObject<Item> WEAK_CORE = ITEMS.register("weak_core", WeakCore::new);
	public static final RegistryObject<Item> SAVAGE_CORE = ITEMS.register("savage_core", SavageCore::new);
	public static final RegistryObject<Item> GUARD_CORE = ITEMS.register("guard_core", GuardianCore::new);
	public static final RegistryObject<Item> WIND_CORE= ITEMS.register("wind_core", WindCore::new);
	public static final RegistryObject<Item> VITAL_CORE = ITEMS.register("vital_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> HASTE_CORE = ITEMS.register("haste_core", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Block> CORE_FORGE = BLOCKS.register("core_forge", CoreForge::new);
    public static final RegistryObject<Item> CORE_FORGE_ITEM  = ITEMS.register("core_forge", () -> new BlockItem(CORE_FORGE.get(), new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<TileEntityType<CoreForgeTile>> CORE_FORGE_TILE = TILES.register("core_forge", () -> TileEntityType.Builder.create(CoreForgeTile::new, CORE_FORGE.get()).build(null));
}
