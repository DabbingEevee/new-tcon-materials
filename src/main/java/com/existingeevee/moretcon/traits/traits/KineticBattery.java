package com.existingeevee.moretcon.traits.traits;

import com.existingeevee.moretcon.other.utils.MiscUtils;
import com.existingeevee.moretcon.other.utils.ReequipHack;
import com.existingeevee.moretcon.other.utils.SoundHandler;
import com.existingeevee.moretcon.traits.traits.abst.NumberTrackerTrait;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class KineticBattery extends NumberTrackerTrait {

	public KineticBattery() {
		super(MiscUtils.createNonConflictiveName("kinetic_battery"), 0);
		ReequipHack.registerIgnoredKey(this.getModifierIdentifier());
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		if (this.getNumber(tool) > 0 && player.isSneaking()) {
			newDamage *= 1 + 1f * this.getNumber(tool) / this.getNumberMax(tool);
		}
		return newDamage;
	}

	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
		if (this.getNumber(tool) > 0 && player.isSneaking() && wasHit) {
			player.world.playSound(null, player.getPosition(), SoundHandler.SWOOSH_EXPLOSION, SoundCategory.PLAYERS, 1, 1);
			this.setNumber(tool, 0);

			if (player.world instanceof WorldServer) {
				SPacketParticles spacketparticles = new SPacketParticles(EnumParticleTypes.EXPLOSION_LARGE, true, (float) target.getPositionVector().x, (float) target.getPositionVector().y, (float) target.getPositionVector().z, 0, 0, 0, 0, 1);
				for (EntityPlayerMP p : player.world.getPlayers(EntityPlayerMP.class, p -> true)) {
					if (p.getPositionVector().squareDistanceTo(target.getPositionVector()) < 100 * 100) {
						p.connection.sendPacket(spacketparticles);
					}
				}
			}
		}
		
		if (wasHit) {
			this.addNumber(tool, Math.round(damageDealt / 2f));
		}
	}

	@Override
	public float knockBack(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float knockback, float newKnockback, boolean isCritical) {
		if (this.getNumber(tool) > 0 && player.isSneaking()) {
			newKnockback += 4f * this.getNumber(tool) / this.getNumberMax(tool);
		}
		return newKnockback;
	}

	@Override
	public int getNumberMax(ItemStack stack) {
		return 50;
	}

	@SubscribeEvent
	public void onHurt(LivingHurtEvent event) {
		for (EnumHand hand : EnumHand.values()) {
			ItemStack stack = event.getEntityLiving().getHeldItem(hand);
			if (this.isToolWithTrait(stack)) {
				this.addNumber(stack, Math.round(event.getAmount()));
				return;
			}
		}
	}
}
