package com.existingeevee.moretcon.traits.traits;

import com.existingeevee.moretcon.other.utils.MiscUtils;
import com.existingeevee.moretcon.traits.ModTraits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class Slimesharp extends AbstractTrait {

	public Slimesharp() {
		super(MiscUtils.createNonConflictiveName("slimesharp"), 0);
	}

	@Override
	public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
		if (ModTraits.overslime.isToolWithTrait(tool)) {
			float amount = ModTraits.overslime.getNumber(tool) / 1f / ModTraits.overslime.getNumberMax(tool);
			event.setNewSpeed(event.getNewSpeed() * (1 + 2 * amount));
		}
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		if (ModTraits.overslime.isToolWithTrait(tool)) {
			float amount = ModTraits.overslime.getNumber(tool) / 1f / ModTraits.overslime.getNumberMax(tool);

			newDamage *= 1 + (amount * 0.5);
		}
		return newDamage;
	}
}
