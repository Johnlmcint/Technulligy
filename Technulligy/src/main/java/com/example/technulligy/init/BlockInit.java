package com.example.technulligy.init;

import com.example.technulligy.Technulligy;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Technulligy.MOD_ID)
@Mod.EventBusSubscriber(modid = Technulligy.MOD_ID, bus = Bus.MOD)
public class BlockInit {
	public static final Block aether_ore = null;
	public static final Block c_oreb = null;
	public static final Block core_forge = null;

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)).setRegistryName("aether_ore"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(15, 15).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)).setRegistryName("c_oreb"));
		event.getRegistry().register(new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(1, 15).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)).setRegistryName("core_forge"));
	}
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new BlockItem(aether_ore,new Item.Properties().group(ItemGroup.MISC)).setRegistryName("aether_ore"));
		event.getRegistry().register(new BlockItem(c_oreb, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("c_oreb"));
		event.getRegistry().register(new BlockItem(core_forge, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("core_forge"));
		
	}
}
