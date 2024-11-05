package com.existingeevee.moretcon.traits.traits;

import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class Cryogenics extends AbstractTrait {

	public Cryogenics() {
		super(MiscUtils.createNonConflictiveName("cryogenics"), 0xffffff);
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		return 
				target.isPotionActive(MobEffects.RESISTANCE) &&
				target.isPotionActive(MobEffects.SLOWNESS) &&
				target.isPotionActive(MobEffects.MINING_FATIGUE) 
				? newDamage : newDamage + damage * 0.25f;
	}

	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
		if (wasHit) {
			target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 3 * 20, 1));
			target.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 3 * 20, 0));
			target.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 3 * 20, 1));
		}
	}
}