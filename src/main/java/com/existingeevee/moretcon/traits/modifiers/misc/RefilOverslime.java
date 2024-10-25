package com.existingeevee.moretcon.traits.modifiers.misc;

import java.util.ArrayList;

import com.existingeevee.moretcon.other.utils.MiscUtils;
import com.existingeevee.moretcon.traits.ModTraits;

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

public class RefilOverslime extends Modifier {

	final int amountRestore;
	
	public static final String KEY = "ToRestore";
	
	public RefilOverslime(String id, int restore) {
		super(MiscUtils.createNonConflictiveName("restore_overslime_" + id));
		MinecraftForge.EVENT_BUS.register(this);
		this.amountRestore = restore;
	}

	@Override
	public boolean isHidden() {
		return true;
	}

	@Override
	public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
		rootCompound.setInteger(KEY, rootCompound.getInteger(KEY) + 1);
	}

	@Override
	public boolean canApplyCustom(ItemStack stack) throws TinkerGuiException {
		if (!ModTraits.overslime.isToolWithTrait(stack) || ModTraits.overslime.getNumberMax(stack) <= ModTraits.overslime.getNumber(stack)) {
			return false;
		}
		
		int toRepair = TagUtil.getTagSafe(stack).getInteger(KEY) + 1;
		int fixAmount = toRepair * amountRestore;

		int damage = ModTraits.overslime.getNumberMax(stack) - ModTraits.overslime.getNumber(stack);

		boolean shouldAllow = fixAmount - damage <= amountRestore;

		if (!shouldAllow) {
			return false;
		}
		return true;
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void handleToolModifyEvent(ToolModifyEvent event) {
		NBTTagCompound comp = TagUtil.getTagSafe(event.getItemStack());
		int toRestore = comp.getInteger(KEY) - 1; // For some reason tinkers does it an extra time aggghhh

		if (toRestore > 0) {
			
			ModTraits.overslime.addNumber(event.getItemStack(), toRestore * amountRestore);
			
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
			comp.removeTag(KEY);
		}
	}
}
