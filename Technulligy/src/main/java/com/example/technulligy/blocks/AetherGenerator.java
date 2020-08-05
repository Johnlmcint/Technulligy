package com.example.technulligy.blocks;

import javax.annotation.Nullable;
//imports the block and it's mechanics
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class AetherGenerator extends Block {
//Defines the sound, location, and tools needed to harvest this block
	public AetherGenerator() {
		// Properties of block
		super(Properties.create(Material.IRON)

				.sound(SoundType.STONE).hardnessAndResistance(1, 15).harvestLevel(1).harvestTool(ToolType.PICKAXE)
				.setLightLevel((p_235470_0_) -> {
					return 14;
				}));

	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

<<<<<<< HEAD
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable IBlockReader reader, List<ITextComponent> list,
			ITooltipFlag flags) {
		if (Screen.hasShiftDown()) {

			list.add((new TranslationTextComponent("message.aethergenerator", Integer.toString(1000))).mergeStyle(TextFormatting.LIGHT_PURPLE));
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
			if (tileEntity instanceof AetherGeneratorTile) {
				INamedContainerProvider containerProvider = new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new TranslationTextComponent("screen.technulligy.aether_generator");
					}

					@Override
					public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
						return new AetherGeneratorContainer(i, world, pos, playerInventory, playerEntity);
					}
				};
				NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getPos());
			} else {
				throw new IllegalStateException("Oops.");
			}
		}
		return ActionResultType.SUCCESS;
	}

=======
>>>>>>> parent of ce6b5cb... Merge branch 'master' of https://github.com/Johnlmcint/Technulligy
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new AetherGeneratorTile();
	}
}
