package com.example.technulligy.datagen;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import com.example.technulligy.Technulligy;
import com.google.gson.JsonElement;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemModelProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class Items extends ItemModelProvider {

	public Items(BiConsumer<ResourceLocation, Supplier<JsonElement>> generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}

   
    	
}
