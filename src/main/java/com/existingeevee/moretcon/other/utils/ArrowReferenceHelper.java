package com.existingeevee.moretcon.other.utils;

import java.util.Map;
import java.util.WeakHashMap;

import com.existingeevee.moretcon.other.StaticVars;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.capability.projectile.TinkerProjectileHandler;
import slimeknights.tconstruct.library.events.TinkerToolEvent.OnBowShoot;

/*
 * A simple class designed to store the direct reference of the arrow stack such that they can be interacted with later.
 */

public class ArrowReferenceHelper {

	private static final Map<ItemStack, ItemStack> PROJECTILE_STACKS = new WeakHashMap<>();

	@Deprecated // Nuh uh dont even think about it
	public static void saveProjectileStack(ItemStack ammoCopy, ItemStack ammo) {
		PROJECTILE_STACKS.put(ammoCopy, ammo);
	}

	public static ItemStack getProjectileStack(TinkerProjectileHandler proj) {
		return PROJECTILE_STACKS.getOrDefault(proj.getItemStack(), ItemStack.EMPTY);
	}

	public static ItemStack getProjectileStack(ItemStack ammoCopy) {
		return PROJECTILE_STACKS.getOrDefault(ammoCopy, ItemStack.EMPTY);
	}

	@SubscribeEvent
	public static void onOnBowShoot(OnBowShoot event) {
		StaticVars.lastArrowFired.set(event.ammo);
	}
}