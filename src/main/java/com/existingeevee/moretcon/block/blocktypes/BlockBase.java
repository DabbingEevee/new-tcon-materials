package com.existingeevee.moretcon.block.blocktypes;

import java.util.Random;

import javax.annotation.Nullable;

import com.existingeevee.moretcon.block.ISimpleBlockItemProvider;
import com.existingeevee.moretcon.inits.ModBlocks;
import com.existingeevee.moretcon.inits.ModItems;
import com.existingeevee.moretcon.other.utils.FireproofItemUtil;
import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBase extends Block implements ISimpleBlockItemProvider {

	private boolean canBeBeacon = false;
	private boolean canBurn = true;

	public BlockBase(String itemName, Material material, int harvestLevel) {

		super(material);
		setUnlocalizedName(MiscUtils.createNonConflictiveName(itemName.toLowerCase()));
		if (harvestLevel > 0) {
			setHarvestLevel("pickaxe", harvestLevel);
		}
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return canBeBeacon;
	}

	public BlockBase canBeBeacon(boolean bool) {
		this.canBeBeacon = bool;
		return this;
	}

	@Override
	public int quantityDropped(Random random) {
		if (this.equals(ModBlocks.blockSiltClay)) {
			return 4;
		}
		return 1;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (this.equals(ModBlocks.blockSiltClay)) {
			return 4;
		}
		return 1;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if (state.getBlock().equals(ModBlocks.blockSiltClay)) {
			return ModItems.itemSiltClay == null ? Item.getItemFromBlock(this) : ModItems.itemSiltClay;
		}
		return super.getItemDropped(state, rand, fortune);
	}

	@Override
	public SoundType getSoundType(IBlockState state, World world, BlockPos pos, @Nullable Entity entity) {
		if ((state.getBlock() == ModBlocks.blockCragravel) || (state.getBlock() == ModBlocks.blockSiltClay)) {
			return SoundType.GROUND;
		}
		return super.getSoundType(state, world, pos, entity);
	}

	public boolean canBurn() {
		return this.canBurn;
	}

	public BlockBase setCanBurn(boolean bool) {
		this.canBurn = bool;
		return this;
	}

	@Override
	public Block setSoundType(SoundType sound) {
		return super.setSoundType(sound);
	}

	@Override
	public ItemBlock createBlockItem() {
		if (this.canBurn) {
			return new ItemBlock(this);
		}
		return new ItemBlock(this) {
			@Override
			public boolean onEntityItemUpdate(EntityItem entityItem) {
				FireproofItemUtil.onUpdateSafe(entityItem);
				return true;
			}
		};
	}
	
	public BlockBase setHarvestLevelC(String string, int i) {
		super.setHarvestLevel(string, i);
		return this;
	}
}