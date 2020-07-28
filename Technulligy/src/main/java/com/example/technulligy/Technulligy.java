package com.example.technulligy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.technulligy.init.BlockInit;
//import com.example.technulligy.init.BlockInit.CreativeItemGroup;
import com.example.technulligy.setup.Registration;
import com.example.technulligy.world.gen.TechnulligyOreGen;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("technulligy")
@Mod.EventBusSubscriber(modid = Technulligy.MOD_ID, bus = Bus.MOD)
public class Technulligy {

	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "technulligy";
	public static Technulligy instance;

	public Technulligy() {

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
	//	Registration.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		//Registration.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	//	Registration.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		instance = this;

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		TechnulligyOreGen.generateOre();
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
	}
	public static class CreativeItemGroup extends ItemGroup {
		public static final CreativeItemGroup instance = new CreativeItemGroup(ItemGroup.GROUPS.length,"technulligytab");
		private CreativeItemGroup(int index, String label) {
			super(index, label);
		}
		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.c_oreb);
		}
	}
}
