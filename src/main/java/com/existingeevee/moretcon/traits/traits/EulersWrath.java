package com.existingeevee.moretcon.traits.traits;

import java.util.Random;

import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class EulersWrath extends AbstractTrait {

	public EulersWrath() {
		super(MiscUtils.createNonConflictiveName("eulers_wrath"), 0);
	}

	@Override
	public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
		NBTTagCompound comp = tool.getOrCreateSubCompound(this.getModifierIdentifier());
		Random rand = new Random(comp.getLong("Seed") + event.getPos().hashCode());
		if (rand.nextDouble() < 1 / Math.E) {
			event.setNewSpeed(event.getNewSpeed() * 2 * (float) Math.E);
		}
	}

	@Override
	public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
		if (!world.isRemote) {
			NBTTagCompound comp = tool.getOrCreateSubCompound(this.getModifierIdentifier());
			comp.setLong("Seed", random.nextLong());
		}
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		if (random.nextDouble() < 1 / Math.E) {
			return newDamage * (float) Math.E;
		}
		return newDamage;
	}

}
