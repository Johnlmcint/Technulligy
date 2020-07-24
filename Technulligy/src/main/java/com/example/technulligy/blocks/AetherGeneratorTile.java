package com.example.technulligy.blocks;

import com.example.technulligy.tools.CustomEnergyStorage;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class AetherGeneratorTile extends TileEntity implements ITickableTileEntity {
	   private ItemStackHandler itemHandler = createHandler();
	    private CustomEnergyStorage energyStorage = createEnergy();
	    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
}