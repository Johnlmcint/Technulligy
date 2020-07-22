package com.example.technulligy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.technulligy.world.gen.TechnulligyOreGen;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
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

		instance = this;

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		TechnulligyOreGen.generateOre();
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
	}

	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) {

	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
	}

}
