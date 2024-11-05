package com.existingeevee.moretcon.inits;

import com.existingeevee.moretcon.effects.PotionBleeding;
import com.existingeevee.moretcon.effects.PotionBloodGodsBlessing;
import com.existingeevee.moretcon.effects.PotionCharged;
import com.existingeevee.moretcon.effects.PotionHyperflames;
import com.existingeevee.moretcon.other.utils.CompatManager;

import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModPotions {
	public static Potion corrosive;
	public static Potion bloodgodsblessing;

	public static Potion bleeding;
	public static Potion charged;
	public static Potion hyperflames;

	public static void init() {
		// coldflames = new PotionColdFlames();
		bloodgodsblessing = new PotionBloodGodsBlessing();
		bleeding = new PotionBleeding();
		hyperflames = new PotionHyperflames();
		charged = new PotionCharged();

		ForgeRegistries.POTIONS.registerAll(
				bleeding,
				charged,
				hyperflames);

		if (CompatManager.easterEggs) {
			ForgeRegistries.POTIONS.registerAll(
					bloodgodsblessing);
		}
		if (CompatManager.thebetweenlands) {
			/*
			 * corrosive = new PotionCorosiveBlast(); ForgeRegistries.POTIONS.registerAll(
			 * corrosive );
			 */
		}

	}
}
