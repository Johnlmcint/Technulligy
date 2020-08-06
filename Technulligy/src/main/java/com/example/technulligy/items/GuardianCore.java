package com.example.technulligy.items;

import java.util.List;

import com.example.technulligy.Technulligy.CreativeItemGroup;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class GuardianCore extends Item {
	public GuardianCore(){
		super(new Item.Properties()
				.maxStackSize(1)
				.group(CreativeItemGroup.instance)
				);
	}
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (Screen.hasShiftDown()) {

			tooltip.add((new TranslationTextComponent("message.wip").mergeStyle(TextFormatting.RED)));
		} else {
			tooltip.add((new TranslationTextComponent("message.shiftmessage")).mergeStyle(TextFormatting.LIGHT_PURPLE));
		}
	}
}
