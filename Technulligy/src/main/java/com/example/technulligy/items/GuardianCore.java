package com.example.technulligy.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class GuardianCore extends Item {
	public GuardianCore(){
		super(new Item.Properties()
				.maxStackSize(1)
				.group(ItemGroup.MISC)
				);
	}
}
