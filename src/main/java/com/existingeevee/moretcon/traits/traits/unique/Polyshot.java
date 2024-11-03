package com.existingeevee.moretcon.traits.traits.unique;

import com.existingeevee.moretcon.traits.traits.abst.DummyTrait;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tools.ProjectileLauncherNBT;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class Polyshot extends DummyTrait {

	public Polyshot() {
		super("polyshot", 0x545454);
		MinecraftForge.EVENT_BUS.register(this); //ToolHelper. // Arrow
	}

	@Override
	public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
		super.applyEffect(rootCompound, modifierTag);
		if (TinkerUtil.hasCategory(rootCompound, Category.LAUNCHER)) {
			ProjectileLauncherNBT launcherData = new ProjectileLauncherNBT(TagUtil.getToolTag(rootCompound));
			launcherData.drawSpeed -= 0.25;
			TagUtil.setToolTag(rootCompound, launcherData.get());
		}
	} 
}