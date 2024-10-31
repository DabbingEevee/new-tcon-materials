package com.existingeevee.moretcon.traits.traits;

import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class Macrocrystaline extends AbstractTrait {

	public Macrocrystaline() {
		super(MiscUtils.createNonConflictiveName("macrocrystaline"), 0xffffff);
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		return newDamage + damage * getPerfection(tool) * 0.2f;
	}

	@Override
	public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
		event.setNewSpeed(event.getNewSpeed() + event.getOriginalSpeed() * getPerfection(tool));
	}
	
	private int getPerfection(ItemStack tool) {
		int i = 0;
		while (ToolHelper.getCurrentDurability(tool) / ((int) Math.pow(2, i) + 0.5) == 0) { // the + 0.5 is just used for rounding lul
			i++;
		}
		return i;
	}
}
