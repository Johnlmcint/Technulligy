package com.example.technulligy.setup;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum CoreTier implements IItemTier {
	;

	@Override
	public int getMaxUses() {
		return 3062;
	}

	@Override
	public float getEfficiency() {
		return 11;
	}

	@Override
	public float getAttackDamage() {
		return 11;
	}

	@Override
	public int getHarvestLevel() {
		return 4;
	}

	@Override
	public int getEnchantability() {
		return 20;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(Registration.BASIC_CORE.get());
	}

}
