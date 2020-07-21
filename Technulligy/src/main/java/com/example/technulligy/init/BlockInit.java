package com.example.technulligy.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmml.common.Mod.EventBusSubscriber.Bus;


public class BlockInit {

	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

	public static final RegistryObject<Block> ROCK_BLOCK = BLOCKS.register("rock", () -> new Block(Block.Properties.create(Material.ROCK)));

	public Technulligy() {
	    BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
