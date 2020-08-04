package com.example.technulligy.blocks;

import java.util.List;

import javax.annotation.Nullable;

//imports the block and it's mechanics
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;
import com.example.technulligy.blocks.PowerCubeContainer;
import com.example.technulligy.blocks.PowerCubeTile;
public class PowerCube extends Block {
//Defines the sound, location, and tools needed to harvest this block
	public PowerCube() {

		// Properties of block
		super(Properties.create(Material.IRON)

				.sound(SoundType.STONE).hardnessAndResistance(1, 15).harvestLevel(1).harvestTool(ToolType.PICKAXE)
				.harvestLevel(1)
				.setLightLevel((p_235470_0_) -> {
					return 14;
				}));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable IBlockReader reader, List<ITextComponent> list,
			ITooltipFlag flags) {
		if (Screen.hasShiftDown()) {

			list.add((new TranslationTextComponent("message.powercube", Integer.toString(1000))).mergeStyle(TextFormatting.LIGHT_PURPLE));
		} else {
			list.add((new TranslationTextComponent("message.shiftmessage")).mergeStyle(TextFormatting.LIGHT_PURPLE));
		}
	}

	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		if (BlockStateProperties.POWERED.equals(true)) {
			return 14;
		} else {
			return 0;
		}

	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return getDefaultState().with(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player,
			Hand hand, BlockRayTraceResult trace) {
		if (!world.isRemote) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if (tileEntity instanceof PowerCubeTile) {
				INamedContainerProvider containerProvider = new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new TranslationTextComponent("screen.technulligy.power_cube");
					}

					@Override
					public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
						return new PowerCubeContainer(i, world, pos, playerInventory, playerEntity);
					}
				};
				NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getPos());
			} else {
				throw new IllegalStateException("Oops.");
			}
		}
		return ActionResultType.SUCCESS;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new PowerCubeTile();
	}
}
