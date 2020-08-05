package com.example.technulligy.items;

import com.example.technulligy.Technulligy.CreativeItemGroup;
import com.example.technulligy.setup.CoreTier;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class ZealousPicaxe extends PickaxeItem {

	public ZealousPicaxe(CoreTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, 1, -2.8f, new Item.Properties().maxStackSize(1).group(CreativeItemGroup.instance));
	}
	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		return new TranslationTextComponent(this.getTranslationKey(stack)).mergeStyle(TextFormatting.AQUA);
	}

}
