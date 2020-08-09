package com.example.technulligy.blocks;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.example.technulligy.setup.Registration;
import com.example.technulligy.tools.CustomEnergyStorage;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
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

public class AetherGeneratorTile extends TileEntity implements ITickableTileEntity {
	private ItemStackHandler itemHandler = createHandler();
	private CustomEnergyStorage energyStorage = createEnergy();
	private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	private int counter;


	public AetherGeneratorTile() {
		super(Registration.AETHER_GENERATOR_TILE.get());
	}
// All tickable tile entitys require a tick function, to set what they do each tick
// 20 tick = one second
	@Override
	public void tick() {
		if (world.isRemote) {
			return;
		}

		if (counter > 0) {
			counter--;
			// Sets the amount of energy Aether  contains
			if (counter <= 0) {
				energyStorage.addEnergy(10000);
			}
			markDirty();
		}

		if (counter <= 0) {
			ItemStack stack = itemHandler.getStackInSlot(0);
			if (stack.getItem() == Registration.AETHER.get()) {
				itemHandler.extractItem(0, 1, false);
				counter = 20;
				markDirty();
			}
		}
//Check for nearby block and update tile entity
		BlockState blockState = world.getBlockState(pos);
		if (blockState.get(BlockStateProperties.POWERED) != counter > 0) {
			world.setBlockState(pos, blockState.with(BlockStateProperties.POWERED, counter > 0),
					Constants.BlockFlags.NOTIFY_NEIGHBORS + Constants.BlockFlags.BLOCK_UPDATE);
		}

		sendOutPower();
	}

	private void sendOutPower() {
		AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
		if (capacity.get() > 0) {
			for (Direction direction : Direction.values()) {
				TileEntity te = world.getTileEntity(pos.offset(direction));
				if (te != null) {
					boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
						if (handler.canReceive()) {
							int received = handler.receiveEnergy(Math.min(capacity.get(), 50000), false);
							capacity.addAndGet(-received);
							energyStorage.consumeEnergy(received);
							markDirty();
							return capacity.get() > 0;
						} else {
							return true;
						}
					}).orElse(true);
					if (!doContinue) {
						return;
					}
				}
			}
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
				return stack.getItem() == Registration.AETHER.get();
			}

			@Nonnull
			@Override
			public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
				if (stack.getItem() != Registration.AETHER.get()) {
					return stack;
				}
				return super.insertItem(slot, stack, simulate);
			}
		};
	}

	private CustomEnergyStorage createEnergy() {
		return new CustomEnergyStorage(100000, 0) {
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
