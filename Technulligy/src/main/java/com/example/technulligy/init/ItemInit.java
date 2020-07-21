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

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry()
				.register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("null_core"));
		event.getRegistry()
				.register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("aether"));
		
		
		
	}
			
}				