package com.example.technulligy.datagen;

import net.minecraft.data.RecipeProvider;
import com.example.technulligy.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
	public Recipes(DataGenerator generatorIn) {
		super(generatorIn);
	}
	 @Override
	    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
	        ShapedRecipeBuilder.shapedRecipe(Registration.WEAK_CORE.get())
	                .patternLine("axa")
	                .patternLine("x#x")
	                .patternLine("axa")
	                .key('a', Registration.NULL_CORE.get())
	                .key('x', Tags.Items.STONE)
	                .key('#', Tags.Items.ORES_COAL)
	                .setGroup("technulligy")
	                .build(consumer);
	    }
}
