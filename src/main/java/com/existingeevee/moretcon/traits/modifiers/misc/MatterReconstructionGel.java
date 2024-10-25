package com.existingeevee.moretcon.traits.modifiers.misc;

import java.util.ArrayList;

import com.existingeevee.moretcon.inits.ModItems;
import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.events.TinkerCraftingEvent.ToolModifyEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.TinkerGuiException;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class MatterReconstructionGel extends Modifier {

	public MatterReconstructionGel() {
		super(MiscUtils.createNonConflictiveName("MatterReconstructionGel".toLowerCase()));
		this.addItem(ModItems.matterReconstructionGel);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public boolean isHidden() {
		return true;
	}

	@Override
	public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
		rootCompound.setInteger("ToRepair", rootCompound.getInteger("ToRepair") + 1);
	}

	@Override
	public boolean canApplyCustom(ItemStack stack) throws TinkerGuiException {
		int toRepair = TagUtil.getTagSafe(stack).getInteger("ToRepair") + 1;
		int maxDamage = stack.getMaxDamage();
		float fixAmountOne = Math.max(256, maxDamage / 10f);
		float fixAmount = toRepair * fixAmountOne;

		int damage = ToolHelper.isBroken(stack) ? maxDamage : stack.getItemDamage();
		boolean isDamaged = damage > 0;

		boolean shouldAllow = fixAmount - damage <= fixAmountOne;

		if (!shouldAllow || !isDamaged) {
			return false;
		}
		return true;
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void handleToolModifyEvent(ToolModifyEvent event) {
		NBTTagCompound comp = TagUtil.getTagSafe(event.getItemStack());
		int toRepair = comp.getInteger("ToRepair") - 1; // For some reason tinkers does it an extra time aggghhh

		if (toRepair > 0) {

			int maxDamage = event.getItemStack().getMaxDamage();
			int fixAmount = Math.round(toRepair * Math.max(256, maxDamage / 10f));
			ToolHelper.repairTool(event.getItemStack(), fixAmount);
			NBTTagList list = comp.getCompoundTag("TinkerData").getTagList("Modifiers", NBT.TAG_STRING);
			ArrayList<Integer> toRemove = new ArrayList<>();
			int i = 0;
			for (NBTBase base : list) {
				if (((NBTTagString) base).getString().equals(this.getIdentifier())) {
					toRemove.add(i);
				}
				i++;
			}
			toRemove.forEach(list::removeTag);
			comp.removeTag("ToRepair");
		}
	}
}
