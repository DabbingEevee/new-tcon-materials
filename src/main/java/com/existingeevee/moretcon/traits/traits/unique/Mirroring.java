package com.existingeevee.moretcon.traits.traits.unique;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.capability.projectile.TinkerProjectileHandler;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.traits.AbstractProjectileTrait;
import slimeknights.tconstruct.library.traits.IProjectileTrait;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class Mirroring extends AbstractProjectileTrait { //TODO rework using mixins

	public Mirroring() {
		super(MiscUtils.createNonConflictiveName("mirroring"), 0);
        MinecraftForge.EVENT_BUS.register(this);
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
		List<ITrait> traits = getNeededTraits(entity);
		traits.removeIf(t -> !(t instanceof IProjectileTrait));
		traits.forEach(t -> ((IProjectileTrait) t).onProjectileUpdate(entity, world, toolStat));
	}

	@Override
	public void onMovement(EntityProjectileBase projectile, World world, double slowdown) {
		List<ITrait> traits = getNeededTraits(projectile);
		traits.removeIf(t -> !(t instanceof IProjectileTrait));
		traits.forEach(t -> ((IProjectileTrait) t).onMovement(projectile, world, slowdown));
	}

	@Override
	public void afterHit(EntityProjectileBase projectile, World world, ItemStack ammoStack, EntityLivingBase attacker, Entity target, double impactSpeed) {
		List<ITrait> traits = getNeededTraits(projectile);
		traits.removeIf(t -> !(t instanceof IProjectileTrait));
		traits.forEach(t -> ((IProjectileTrait) t).afterHit(projectile, world, ammoStack, attacker, target, impactSpeed));
	}

	@Override
	public void onLaunch(EntityProjectileBase projectileBase, World world, EntityLivingBase shooter) {
		List<ITrait> traits = getNeededTraits(projectileBase);
		traits.removeIf(t -> !(t instanceof IProjectileTrait));
		traits.forEach(t -> ((IProjectileTrait) t).onLaunch(projectileBase, world, shooter));
	}

	private static final Method getStatTraits$Material = ObfuscationReflectionHelper.findMethod(Material.class, "getStatTraits", List.class, String.class);

	@SubscribeEvent
	public void onLivingAttackEvent(LivingHurtEvent e) {
		DamageSource source = e.getSource();
		Entity entity = source.getTrueSource();
		if (entity instanceof EntityPlayer && source.getImmediateSource() instanceof EntityProjectileBase) {
			TinkerProjectileHandler projectile = ((EntityProjectileBase) source.getImmediateSource()).tinkerProjectile;
			EntityPlayer player = ((EntityPlayer) e.getSource().getTrueSource());
			ItemStack arrow = projectile.getItemStack();
			ItemStack launcher = projectile.getLaunchingStack();

			if (!ToolHelper.getTraits(arrow).contains(this)) {
				return;
			}

			List<Material> materials = new ArrayList<>();

			materials.addAll(MiscUtils.getMaterials(launcher));
			materials.addAll(MiscUtils.getEmbossments(launcher));

			materials = new ArrayList<>(new HashSet<>(materials));
			List<ITrait> traits = getNeededTraits(((EntityProjectileBase) source.getImmediateSource()));
			// players base damage (includes tools damage stat)
			float baseDamage = (float) player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();

			// missing because not supported by tcon tools: vanilla damage enchantments, we
			// have our own modifiers
			// missing because not supported by tcon tools: vanilla knockback enchantments,
			// we have our own modifiers

			// calculate if it's a critical hit
			boolean isCritical = player.fallDistance > 0.0F && !player.onGround && !player.isOnLadder()
					&& !player.isInWater() && !player.isPotionActive(MobEffects.BLINDNESS) && !player.isRiding();

			for (ITrait trait : traits) {
				if (trait.isCriticalHit(arrow, player, e.getEntityLiving())) {
					isCritical = true;
				}
			}

			// calculate actual damage
			float damage = e.getAmount();
			if (e.getEntityLiving() != null) {
				for (ITrait trait : traits) {
					damage = trait.damage(arrow, player, e.getEntityLiving(), baseDamage, damage, isCritical);
				}
			}

			// apply critical damage
			if (isCritical) {
				damage *= 1.5f;
			}

			if(e.getEntityLiving() != null) {
				int hurtResistantTime = e.getEntityLiving().hurtResistantTime;
				for(ITrait trait : traits) {
					trait.onHit(arrow, player, e.getEntityLiving(), damage, isCritical);
					e.getEntityLiving().hurtResistantTime = hurtResistantTime;
				}
			}

			Item arrowItem = arrow.getItem();
			// calculate cutoff
			if (arrowItem instanceof ToolCore) {
				damage = ToolHelper.calcCutoffDamage(damage, ((ToolCore) arrowItem).damageCutoff());
			}

			e.setAmount(damage);

			ArrayList<ITrait> finalTraits = new ArrayList<>(traits);
			float hp = e.getEntityLiving().getHealth();
			boolean crit = isCritical;
			MiscUtils.executeInNTicks(() -> {
				float finalDamage = hp - e.getEntityLiving().getHealth();
			    for(ITrait trait : finalTraits) {
			    	trait.afterHit(arrow, player, e.getEntityLiving(), finalDamage, crit, true); // hit is always true
			    }
			}, 1);
		}
	}

	@SuppressWarnings("unchecked")
	private static List<ITrait> getNeededTraits(EntityProjectileBase projectileBase) {
		List<ITrait> traits = new ArrayList<>();

		TinkerProjectileHandler projectile = projectileBase.tinkerProjectile;

		ItemStack launcherStack = projectile.getLaunchingStack();
		ItemStack arrowStack = projectile.getItemStack();

		List<Material> materials = new ArrayList<>();
		materials.addAll(MiscUtils.getMaterials(launcherStack));
		materials.addAll(MiscUtils.getEmbossments(launcherStack));

		materials = new ArrayList<>(new HashSet<>(materials));
		for (Material material : materials) {
			try {
				traits.addAll((List<ITrait>) getStatTraits$Material.invoke(material, MaterialTypes.PROJECTILE));
				traits.addAll(material.getDefaultTraits());
			} catch (IllegalAccessException | InvocationTargetException ignored) {
			}
		}
		traits = new ArrayList<>(new HashSet<>(traits));
		traits.removeAll(ToolHelper.getTraits(arrowStack));
		return traits;
	}
}