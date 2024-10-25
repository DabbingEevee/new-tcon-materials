package com.existingeevee.moretcon.traits.traits;

import com.existingeevee.moretcon.other.utils.MiscUtils;
import com.gildedgames.the_aether.Aether;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import slimeknights.tconstruct.library.traits.AbstractTrait;


public class Rootplicating extends AbstractTrait {

	public Rootplicating() {
		super(MiscUtils.createNonConflictiveName("rootplicating"), 0);
	}

	static final PropertyBool PROPERTY = PropertyBool.create(Aether.doubleDropNotifier());
	
	@Override
	public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase entity, boolean wasEffective) {
		if(entity instanceof EntityPlayer && (tool.getDestroySpeed(world.getBlockState(pos)) > 1.0f || ForgeHooks.isToolEffective(world, pos, tool))) {
			if(!state.getProperties().containsKey(PROPERTY)) {
				return;
			}
			if(state.getValue(PROPERTY) && !world.isRemote) {
				NonNullList<ItemStack> blockDrop = NonNullList.create();
				state.getBlock().getDrops(blockDrop, world, pos, state, 0);
				blockDrop.forEach(stack -> world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack.copy())));
			}
		}
	}
}