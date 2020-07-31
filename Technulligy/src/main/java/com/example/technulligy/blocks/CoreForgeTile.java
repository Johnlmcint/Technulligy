package com.example.technulligy.blocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.example.technulligy.setup.Registration;
import com.example.technulligy.tools.CustomEnergyStorage;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class CoreForgeTile extends TileEntity implements ITickableTileEntity {
	private ItemStackHandler itemHandler = createHandler();
	private CustomEnergyStorage energyStorage = createEnergy();
	private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	private int counter;


	public CoreForgeTile() {
		super(Registration.CORE_FORGE_TILE.get());
	}

	@Override
	public void tick() {
		if (world.isRemote) {
			return;
		}


		BlockState blockState = world.getBlockState(pos);
		if (blockState.get(BlockStateProperties.POWERED) != counter > 0) {
			world.setBlockState(pos, blockState.with(BlockStateProperties.POWERED, counter > 0),
					Constants.BlockFlags.NOTIFY_NEIGHBORS + Constants.BlockFlags.BLOCK_UPDATE);
		}

	}

	@Override
	public void read(BlockState blockstate, CompoundNBT tag) {
		 itemHandler.deserializeNBT(tag.getCompound("inv"));
	        energyStorage.deserializeNBT(tag.getCompound("energy"));

	        counter = tag.getInt("counter");
	        super.read(blockstate, tag);
	}

	@Override
	public CompoundNBT write(CompoundNBT tag) {
		tag.put("inv", itemHandler.serializeNBT());
		tag.put("energy", energyStorage.serializeNBT());

		tag.putInt("counter", counter);
		return super.write(tag);
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(1) {

			@Override
			protected void onContentsChanged(int slot) {
				markDirty();
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				return stack.getItem() == Registration.NULL_CORE.get();
			}

			@Nonnull
			@Override
			public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
				if (stack.getItem() != Registration.NULL_CORE.get()) {
					return stack;
				}
				return super.insertItem(slot, stack, simulate);
			}
		};
	}

	private CustomEnergyStorage createEnergy() {
		return new CustomEnergyStorage(10000000, 0) {
			@Override
			protected void onEnergyChanged() {
				markDirty();
			}
		};
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)) {
			return handler.cast();
		}
		if (cap.equals(CapabilityEnergy.ENERGY)) {
			return energy.cast();
		}
		return super.getCapability(cap, side);
	}

}