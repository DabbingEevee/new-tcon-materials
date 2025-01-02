package com.existingeevee.moretcon.traits.traits;

import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class Executor extends AbstractTrait {

	public Executor() {
		super(MiscUtils.createNonConflictiveName("executor"), 0xff0000);
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		double healthRemainingRatio = target.getHealth() / target.getMaxHealth();

		return healthRemainingRatio < 0.1 ? newDamage * 20 : newDamage;
	} 

}