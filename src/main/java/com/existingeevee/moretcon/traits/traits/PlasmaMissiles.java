package com.existingeevee.moretcon.traits.traits;

import com.existingeevee.moretcon.entity.entities.EntityPlasmaBolt;
import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class PlasmaMissiles extends AbstractTrait {

	public PlasmaMissiles() {
		super(MiscUtils.createNonConflictiveName("plasma_missiles"), 0);
	}

	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
		if (!wasHit || damageDealt < 0.025) {
			return;
		}

		double dist = player.getPositionEyes(1f).distanceTo(target.getPositionVector());
		EntityPlasmaBolt bolt = new EntityPlasmaBolt(target.world, player, target, tool)
				.setImpactTime(Math.max(5, (int) dist))
				.setDamage(Math.max(2, ToolHelper.getActualAttack(tool) * 0.5f));
		
		bolt.setPosition(player.posX, player.posY + player.getEyeHeight(), player.posZ);
		target.world.spawnEntity(bolt);
	}
}
