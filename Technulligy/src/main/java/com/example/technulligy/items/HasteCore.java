package com.example.technulligy.items;

import com.example.technulligy.Technulligy.CreativeItemGroup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class HasteCore extends Item {
	public HasteCore() {
		super(new Item.Properties().maxStackSize(1).group(CreativeItemGroup.instance));
	}

	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		return new TranslationTextComponent(this.getTranslationKey(stack)).mergeStyle(TextFormatting.AQUA);
	}
}
	