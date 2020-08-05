package com.example.technulligy.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import com.example.technulligy.Technulligy.CreativeItemGroup;
import com.example.technulligy.setup.CoreTier;

public class SavageSword extends SwordItem {
	public SavageSword(CoreTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {

		super(tier, 3, -2.2f, new Item.Properties().maxStackSize(1).group(CreativeItemGroup.instance));
	}
	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		return new TranslationTextComponent(this.getTranslationKey(stack)).mergeStyle(TextFormatting.RED);
	}

}
