package com.existingeevee.moretcon.block.ore;

import java.util.Random;

import com.existingeevee.moretcon.block.blocktypes.BlockBase;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockOre extends BlockBase {

	public Item toDrop;
	int minDropAmount = 1;
	int maxDropAmount = 0;
	Item smeltResult;

	public BlockOre(String name, int harvest) {
		this(name, harvest, null, 1, 1);
	}

	public BlockOre(String name, int harvest, Item toDrop) {
		this(name, harvest, toDrop, 1, 1);
	}

	public BlockOre(String name, int harvest, Item toDrop, int dropAmount) {
		this(name, harvest, toDrop, dropAmount, dropAmount);
	}

	public BlockOre(String name, int harvest, Item toDrop, int minDropAmount, int maxDropAmount) {
		super(name, Material.ROCK, harvest);
		this.toDrop = toDrop;
		this.minDropAmount = minDropAmount;
		this.maxDropAmount = maxDropAmount;
	}

	@Override
	public int quantityDropped(Random random) {
		if (this.minDropAmount > this.maxDropAmount) {
			int i = this.minDropAmount;
			this.minDropAmount = this.maxDropAmount;
			this.maxDropAmount = i;
		}
		return this.minDropAmount + random.nextInt(this.maxDropAmount - this.minDropAmount + 1);
	}

	public ItemStack getOreDrop() {
		return new ItemStack(this.toDrop);
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			if (i < 0) {
				i = 0;
			}
			return this.quantityDropped(random) * (i + 1);
		} else {
			return this.quantityDropped(random);
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return toDrop == null ? Item.getItemFromBlock(this) : toDrop;
	}
}