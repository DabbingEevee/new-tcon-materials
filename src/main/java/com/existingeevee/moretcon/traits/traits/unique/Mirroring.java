package com.existingeevee.moretcon.traits.traits.unique;

import java.util.Random;

import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import slimeknights.tconstruct.library.traits.AbstractProjectileTrait;

public class Mirroring extends AbstractProjectileTrait {

	public Mirroring() {
		super(MiscUtils.createNonConflictiveName("mirroring"), 0);
	}

	private static final Random rand = new Random();

	@Override
	public void onProjectileUpdate(EntityProjectileBase entity, World world, ItemStack toolStat) {
		if (entity.world.isRemote) {
			Vec3d position = entity.getPositionVector();
			boolean inGround = entity.serializeNBT().getBoolean("inGround");
			int particles = Math.min(4, inGround ? 1 : (int) new Vec3d(entity.motionX, entity.motionY, entity.motionZ).lengthSquared() + 1);
			for (int i = 0; i < particles; i++) {
				entity.world.spawnParticle(EnumParticleTypes.REDSTONE, true, position.x + (rand.nextDouble() * 0.5 - 0.25), (position.y + (rand.nextDouble() * 0.5 - 0.25)) - 0.05, position.z + (rand.nextDouble() * 0.5 - 0.25), 0, 1, 1);
			}
		}
	}

	@Override
	public boolean isToolWithTrait(ItemStack itemStack) {
		return super.isToolWithTrait(itemStack);
	}

}