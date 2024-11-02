package com.existingeevee.moretcon.traits.traits.internal;

import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow.PickupStatus;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.capability.projectile.TinkerProjectileHandler;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import slimeknights.tconstruct.library.tools.ranged.ProjectileCore;
import slimeknights.tconstruct.library.traits.AbstractProjectileTrait;

public class PolyshotProj extends AbstractProjectileTrait {

	public PolyshotProj() {
		super(MiscUtils.createNonConflictiveName("polyshot_projectile"), 0);
		TinkerRegistry.addTrait(this);
	}

	public static final ThreadLocal<Boolean> IS_ALREADY_PROCING = ThreadLocal.withInitial(() -> false);
	public static final ThreadLocal<Integer> HURT_RESISTANT_TIME = ThreadLocal.withInitial(() -> 0);

	@Override
	public void onLaunch(EntityProjectileBase projectileBase, World world, EntityLivingBase shooter) {
		if (IS_ALREADY_PROCING.get()) {
			return;
		}

		if (projectileBase != null && shooter != null) {
			TinkerProjectileHandler ticProjectile = projectileBase.tinkerProjectile;

			float speed = ticProjectile.getPower();

			if (!world.isRemote && ticProjectile.getItemStack().getItem() instanceof ProjectileCore) {
				IS_ALREADY_PROCING.set(true);

				int toShoot = random.nextInt(3) + 4;

				modifyProjectile(projectileBase, shooter, speed);
				for (int i = 0; i < toShoot - 1; i++) {
					spawnProjectile(projectileBase, shooter, speed);
				}
				IS_ALREADY_PROCING.set(false);
			}
		}
	}

	@Override
	public void afterHit(EntityProjectileBase projectile, World world, ItemStack ammoStack, EntityLivingBase attacker, Entity target, double impactSpeed) {
		target.hurtResistantTime = 0;
	}

	public static void spawnProjectile(EntityProjectileBase projectileBase, EntityLivingBase shooter, float power) {
		ItemStack stack = projectileBase.tinkerProjectile.getItemStack().copy();
		ItemStack launcher = projectileBase.tinkerProjectile.getLaunchingStack().copy();

		EntityProjectileBase proj = ((ProjectileCore) stack.getItem()).getProjectile(stack, launcher, shooter.world, shooter instanceof EntityPlayer ? (EntityPlayer) shooter : null, 2.1f, 0f, 1f, false);

		proj.setIsCritical(power >= 1);
		shooter.world.spawnEntity(proj);
		proj.pickupStatus = PickupStatus.CREATIVE_ONLY;
		modifyProjectile(proj, shooter, power);
	}

	public static void modifyProjectile(EntityProjectileBase projectileBase, EntityLivingBase shooter, float power) {
		// Reset projectile motion
		projectileBase.motionX = 0;
		projectileBase.motionY = 0;
		projectileBase.motionZ = 0;

		float velo = power;

		// Reshoot
		projectileBase.shoot(shooter, shooter.rotationPitch, shooter.rotationYaw, 0, velo, 25f); // MASSIVE inaccuracy, low speed
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		return newDamage * 0.5f;
	}

	@Override
	public int getPriority() {
		return 6942069; 
	}
}
