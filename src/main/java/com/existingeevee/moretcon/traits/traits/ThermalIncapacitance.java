package com.existingeevee.moretcon.traits.traits;

import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.biome.Biome;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.shared.client.ParticleEffect;
import slimeknights.tconstruct.tools.TinkerTools;

public class ThermalIncapacitance extends AbstractTrait {

	public ThermalIncapacitance() {
		super(MiscUtils.createNonConflictiveName("thermal_incapacitance"), 0xffffff);
	}

	@Override
	public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
		Biome biome = player.world.getBiomeForCoordsBody(player.getPosition());
		if (biome.getTemperature(player.getPosition()) < 0.5 || biome.isSnowyBiome() && player.world.isRaining()) {
			if (attackEntitySecondary(new EntityDamageSource("onIce", player), 2, target, false, true)) {
				TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_ARMOR, target, Math.round(2));
			}
		} else if (biome.getTemperature(player.getPosition()) > 1.75) {
			if (attackEntitySecondary(new EntityDamageSource("onFire", player).setFireDamage(), 2, target, false, true)) {
				TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_FIRE, target, Math.round(2));
			}
		}
	}
}