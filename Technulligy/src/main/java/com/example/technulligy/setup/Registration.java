package com.example.technulligy.setup;

import java.util.function.Supplier;

import com.example.technulligy.Technulligy;
import com.example.technulligy.Technulligy.CreativeItemGroup;
import com.example.technulligy.blocks.AetherGenerator;
import com.example.technulligy.blocks.AetherGeneratorContainer;
import com.example.technulligy.blocks.AetherGeneratorTile;
import com.example.technulligy.blocks.AetherOre;
import com.example.technulligy.blocks.CoreForge;
import com.example.technulligy.blocks.PowerCube;
import com.example.technulligy.blocks.PowerCubeContainer;
import com.example.technulligy.blocks.PowerCubeTile;
import com.example.technulligy.items.BasicCore;
import com.example.technulligy.items.GuardianCore;
import com.example.technulligy.items.HasteCore;
import com.example.technulligy.items.SavageCore;
import com.example.technulligy.items.SavageSword;
import com.example.technulligy.items.VitalityCore;
import com.example.technulligy.items.WeakCore;
import com.example.technulligy.items.WindCore;
import com.example.technulligy.items.ZealousPickaxe;
import com.example.technulligy.setup.CoreTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Technulligy.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Technulligy.MOD_ID);
	 public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES,Technulligy.MOD_ID);
	   public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Technulligy.MOD_ID);
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static final RegistryObject<Item> NULL_CORE = ITEMS.register("null_core", () -> new Item(new Item.Properties().group(CreativeItemGroup.instance)));
	public static final RegistryObject<Item> CORE_CENTER = ITEMS.register("core_center", () -> new Item(new Item.Properties().group(CreativeItemGroup.instance)));
	public static final RegistryObject<Item> AETHER = ITEMS.register("aether", () -> new Item(new Item.Properties().group(CreativeItemGroup.instance)));
	public static final RegistryObject<Item> C_ORE = ITEMS.register("c_ore", () -> new Item(new Item.Properties().group(CreativeItemGroup.instance)));
	public static final RegistryObject<Item> BASIC_CORE = ITEMS.register("basic_core", BasicCore::new);
	public static final RegistryObject<Item> WEAK_CORE = ITEMS.register("weak_core", WeakCore::new);
	public static final RegistryObject<Item> SAVAGE_CORE = ITEMS.register("savage_core", SavageCore::new);
	public static final RegistryObject<Item> GUARD_CORE = ITEMS.register("guard_core", GuardianCore::new);
	public static final RegistryObject<Item> WIND_CORE= ITEMS.register("wind_core", WindCore::new);
	public static final RegistryObject<Item> VITAL_CORE = ITEMS.register("vital_core", VitalityCore::new);
	public static final RegistryObject<Item> HASTE_CORE = ITEMS.register("haste_core", HasteCore::new);
	public static final RegistryObject<Block> CORE_FORGE = BLOCKS.register("core_forge", CoreForge::new);
	public static final RegistryObject<Block> AETHER_ORE = BLOCKS.register("aether_ore", AetherOre::new);
	public static final RegistryObject<Item> AETHER_ORE_ITEM = ITEMS.register("aether_ore",() -> new BlockItem(AETHER_ORE.get(), new Item.Properties().group(CreativeItemGroup.instance)));
    public static final RegistryObject<Item> CORE_FORGE_ITEM  = ITEMS.register("core_forge", () -> new BlockItem(CORE_FORGE.get(), new Item.Properties().group(CreativeItemGroup.instance)));
    
    //Aether Generator
    public static final RegistryObject<AetherGenerator> AETHER_GENERATOR = BLOCKS.register("aether_generator", AetherGenerator::new);
    public static final RegistryObject<Item> AETHER_GENERATOR_ITEM = ITEMS.register("aether_generator", () -> new BlockItem(AETHER_GENERATOR.get(), new Item.Properties().group(CreativeItemGroup.instance)));
    public static final RegistryObject<TileEntityType<AetherGeneratorTile>> AETHER_GENERATOR_TILE = TILES.register("aether_generator", () -> TileEntityType.Builder.create(AetherGeneratorTile::new, AETHER_GENERATOR.get()).build(null));
    public static final RegistryObject<ContainerType<AetherGeneratorContainer>> AETHER_GENERATOR_CONTAINER = CONTAINERS.register("aether_generator", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new AetherGeneratorContainer(windowId, world, pos, inv, inv.player);
    }));
    //Power Cube
    public static final RegistryObject<PowerCube> POWERCUBE = BLOCKS.register("power_cube", PowerCube::new);
    public static final RegistryObject<Item> POWER_CUBE_ITEM = ITEMS.register("power_cube_item", () -> new BlockItem(POWERCUBE.get(), new Item.Properties().group(CreativeItemGroup.instance)));
    public static final RegistryObject<TileEntityType<PowerCubeTile>> POWER_CUBE_TILE = TILES.register("power_cube", () -> TileEntityType.Builder.create(PowerCubeTile::new, POWERCUBE.get()).build(null));
    public static final RegistryObject<ContainerType<PowerCubeContainer>> POWER_CUBE_CONTAINER = CONTAINERS.register("power_cube", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new PowerCubeContainer(windowId, world, pos, inv, inv.player);
    }));
 /*   public static final RegistryObject<TileEntityType<AetherGeneratorTile>> CORE_FORGE_TILE = TILES.register("core_forge", () -> TileEntityType.Builder.create(AetherGeneratorTile::new, CORE_FORGE.get()).build(null));
    public static final RegistryObject<ContainerType<AetherGeneratorContainer>> CORE_FORGE_CONTAINER = CONTAINERS.register("core_forge", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new AetherGeneratorContainer(windowId, world, pos, inv, inv.player);
    }));*/

    }


