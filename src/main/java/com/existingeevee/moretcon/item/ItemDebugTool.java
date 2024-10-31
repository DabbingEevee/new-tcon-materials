package com.existingeevee.moretcon.item;

import java.util.List;

import com.existingeevee.moretcon.other.BiValue;
import com.existingeevee.moretcon.other.ModTabs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemDebugTool extends ItemBase {

	public ItemDebugTool() {
		super("debugtool", 0xceedff);
		this.setMaxStackSize(1);
		this.setTab(ModTabs.moarTConMisc);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (debugFunction(worldIn, playerIn)) {
			return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
		}

		if (worldIn.isRemote) {
			if (playerIn.isSneaking()) {
				List<Entity> entities = worldIn.getEntitiesWithinAABBExcludingEntity(playerIn, playerIn.getEntityBoundingBox().expand(5.0D, 5.0D, 5.0D).expand(-5, -5, -5));
				BiValue<Entity, Double> dval = new BiValue<>(null, Double.MAX_VALUE);
				for (Entity e : entities) {
					double distance = e.getPositionVector().distanceTo(playerIn.getPositionVector());
					if (distance < dval.getB()) {
						dval = new BiValue<>(e, distance);
					}
				}
				if (dval.getA() != null) {
					playerIn.sendMessage(new TextComponentString(dval.getA().serializeNBT().toString()));
				}
			} else {
				playerIn.sendMessage(new TextComponentString(playerIn.getHeldItem(handIn.equals(EnumHand.MAIN_HAND) ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND).serializeNBT().toString()));
			}

		}

		playerIn.getCooldownTracker().setCooldown(this, 5);
		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	protected boolean debugFunction(World worldIn, EntityPlayer playerIn) { // this is used by me to test stuff.
		return false;
	}
}
