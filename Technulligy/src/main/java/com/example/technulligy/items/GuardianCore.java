package com.example.technulligy.items;

import com.example.technulligy.Technulligy.CreativeItemGroup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class GuardianCore extends Item {
	public GuardianCore(){
		super(new Item.Properties()
				.maxStackSize(1)
				.group(CreativeItemGroup.instance)
				);
	}
}
