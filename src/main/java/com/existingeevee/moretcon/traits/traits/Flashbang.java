package com.existingeevee.moretcon.traits.traits;

import com.existingeevee.moretcon.other.utils.MiscUtils;
import com.existingeevee.moretcon.traits.traits.abst.IBombTrait;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class Flashbang extends AbstractTrait implements IBombTrait {

	public Flashbang() {
		super(MiscUtils.createNonConflictiveName("flashbang"), 0xffffff);
	}

	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
		target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 40, 0));
		target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 40, 4));
		target.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 40, 0));
	}
}