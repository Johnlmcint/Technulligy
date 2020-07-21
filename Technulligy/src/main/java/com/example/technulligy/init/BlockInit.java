package com.example.technulligy.init;

import net.minecraft.util.text.NBTTextComponent.Block;
import net.minecraftforge.client.model.obj.MaterialLibrary.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class BlockInit {
	
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

	public static final RegistryObject<Block> ROCK_BLOCK = BLOCKS.register("rock", () -> new Block(Block.Properties.create(Material.ROCK)));

	public Technulligy() {
	    BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
