package com.example.technulligy.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class WeakCore extends Item {
	public WeakCore(){
		super(new Item.Properties()
				.maxStackSize(1)
				.group(ItemGroup.MISC)
				);
	}
}
