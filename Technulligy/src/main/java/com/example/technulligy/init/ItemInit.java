package com.example.technulligy.init;

import com.example.technulligy.Technulligy;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Technulligy.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Technulligy.MOD_ID)
public class ItemInit {

	public static Item null_core = null;
	public static Item aether = null;	
	public static Item c_ore = null;
	public static Item basic_core = null;
	public static Item weak_core = null;
	public static Item savage_core = null;
	public static Item guard_core = null;
	public static Item wind_core = null;
	public static Item vital_core = null;
	public static Item haste_core = null;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("null_core"));
	
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("aether"));
				
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("c_ore"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("basic_core"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("weak_core"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("savage_core"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("guard_core"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("wind_core"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("vital_core"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("haste_core"));

	}

}