package com.existingeevee.moretcon.inits;

import com.existingeevee.moretcon.ModInfo;
import com.existingeevee.moretcon.fluid.LiquidFluid;
import com.existingeevee.moretcon.other.utils.CompatManager;
import com.existingeevee.moretcon.other.utils.RegisterHelper;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class ModFluids {

	public static int totalFluids;
	/** ------------------------------------- **/
	public static Fluid liquidFusionite = new LiquidFluid("liquidfusionite",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidfusionite_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidfusionite_flowing")).setCColor(0x3399ff).setLuminosity(15)
			.setDensity(1000).setViscosity(2000).setTemperature(1000);
	public static Fluid liquidValasium = new LiquidFluid("liquidvalasium",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidvalasium_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidvalasium_flowing")).setCColor(0x93c4c4).setLuminosity(15)
			.setDensity(1000).setViscosity(2000).setTemperature(1000);
	public static Fluid liquidSyrmorite = new LiquidFluid("liquidsyrmorite",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidsyrmorite_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidsyrmorite_flowing")).setCColor(0x234187).setLuminosity(10)
			.setDensity(1000).setViscosity(2000).setTemperature(1000);
	public static Fluid liquidOctine = new LiquidFluid("liquidoctine",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidoctine_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidoctine_flowing")).setCColor(0xff8206).setLuminosity(15)
			.setDensity(1000).setViscosity(2000).setTemperature(1200);
	public static Fluid liquidIrradium = new LiquidFluid("liquidirradium",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidirradium_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidirradium_flowing")).setCColor(0x00ed00).setLuminosity(15)
			.setDensity(1000).setViscosity(4000).setTemperature(1000);
	public static Fluid liquidSolsteel = new LiquidFluid("liquidsolarsteel",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidsolarsteel_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidsolarsteel_flowing")).setCColor(0xffad33).setLuminosity(15)
			.setDensity(8000).setViscosity(1500).setTemperature(2000);
	public static Fluid liquidGallium = new LiquidFluid("liquidgallium",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidgallium_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidgallium_flowing")).setCColor(0xffffff).setLuminosity(0)
			.setDensity(1000).setViscosity(1500).setTemperature(100);
	public static Fluid liquidPenguinite = new LiquidFluid("liquidpenguinite",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidpenguinite_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidpenguinite_flowing")).setLuminosity(15)
			.setDensity(1000).setViscosity(2000).setTemperature(250);
	public static Fluid liquidHydrogen = new LiquidFluid("liquidhydrogen",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/hydrogengas_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/hydrogengas_flowing")).setCColor(0xff0000).setLuminosity(0)
			.setDensity(-5).setViscosity(1000).setTemperature(0).setGaseous(true);
	public static Fluid liquidBurningSulfurFlow = new LiquidFluid("burningsulfurflow",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/burningsulfurflow_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/burningsulfurflow_flowing")).setCColor(0xffe59f).setLuminosity(3)
			.setDensity(1000).setViscosity(800).setTemperature(750);
	public static Fluid liquidEmber = new LiquidFluid("liquidember",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidember_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidember_flowing")).setCColor(0xff8206).setLuminosity(13)
			.setDensity(1000).setViscosity(800).setTemperature(1750);
	public static Fluid liquidIronwood = new LiquidFluid("liquidironwood",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidironwood_still"),
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidironwood_flowing")).setCColor(0x372a07).setLuminosity(13)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidArkenium = new LiquidFluid("liquidarkenium").setCColor(0x595959).setLuminosity(13)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidRuneSteel = new LiquidFluid("liquidrunesteel").setCColor(0xcc9900).setLuminosity(13)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidGravitonium = new LiquidFluid("liquidGravitonium".toLowerCase()).setCColor(0x003300).setLuminosity(13)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidValkyrieMetal = new LiquidFluid("liquidValkyrieMetal".toLowerCase()).setCColor(0xffffff).setLuminosity(13)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidTrichromadentium = new LiquidFluid("liquidTrichromadentium".toLowerCase()).setCColor(0xffffff).setLuminosity(13)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidAtronium = new LiquidFluid("liquidatronium").setCColor(0xd99857).setLuminosity(15)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidEbonite = new LiquidFluid("liquidebonite").setCColor(0xffffff).setLuminosity(15)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidHallowsite = new LiquidFluid("liquidhallowsite").setCColor(0x6add9d).setLuminosity(15)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidBlightsteel = new LiquidFluid("liquidblightsteel").setCColor(0x243c5a).setLuminosity(15)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidSanguiseelium = new LiquidFluid("liquidsanguiseelium").setCColor(0xFF0000).setLuminosity(15)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidZracohlium = new LiquidFluid("liquidzracohlium").setCColor(0x696942).setLuminosity(12)
			.setDensity(1000).setViscosity(800).setTemperature(1500);
	public static Fluid liquidSlimesteel = new LiquidFluid("liquidSlimesteel").setCColor(0x47efea).setLuminosity(15)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	
	public static Fluid liquidFusionLava = new LiquidFluid("liquidfusionlava",
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidfusionlava_still"), //were gonna just use the solsteel textures for now until i have more time
			new ResourceLocation(ModInfo.MODID + ":blocks/fluids/liquidfusionlava_flowing")).setCColor(0x00ffff).setLuminosity(15)
			.setDensity(8000).setViscosity(1500).setTemperature(2000);
	public static Fluid liquidLiquifiedSouls = new LiquidFluid("liquifiedSouls".toLowerCase()).setCColor(0xffffff).setLuminosity(0)
			.setDensity(1000).setViscosity(800).setTemperature(0);

	public static Fluid liquidSwampSteel = new LiquidFluid("liquidSwampSteel".toLowerCase()).setCColor(0x001100).setLuminosity(13)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidRotiron = new LiquidFluid("liquidRotiron".toLowerCase()).setCColor(0x001100).setLuminosity(13)
			.setDensity(1000).setViscosity(800).setTemperature(1100);
	public static Fluid liquidRottenSludge = new LiquidFluid("rottenSludge".toLowerCase()).setCColor(0x001100).setLuminosity(0)
			.setDensity(1000).setViscosity(800).setTemperature(0);
	public static Fluid liquidMummySludge = new LiquidFluid("mummySludge".toLowerCase()).setCColor(0x60634e).setLuminosity(0)
			.setDensity(1000).setViscosity(800).setTemperature(0);
	public static Fluid liquidBetweenSludge = new LiquidFluid("betweenSludge".toLowerCase()).setCColor(0x344a30).setLuminosity(0)
			.setDensity(1000).setViscosity(800).setTemperature(0);

	public static Fluid liquidGoldenAmber = new LiquidFluid("liquidGoldenAmber".toLowerCase()).setCColor(0xeaee57).setLuminosity(0)
			.setDensity(1000).setViscosity(800).setTemperature(0);

	public static Fluid liquidAncientAlloy = new LiquidFluid("liquidAncientAlloy".toLowerCase()).setCColor(0x9fc1c0).setLuminosity(13)
			.setDensity(1000).setViscosity(800).setTemperature(1100);

	/** ------------------------------------- **/

	private static void registerFluids(Fluid... fluid) {
		for (Fluid i : fluid) {
			ModFluids.addFluid(i);
		}
	}

	public static void init() {
		if (CompatManager.loadMain) {
			ModFluids.registerFluids(
					liquidSlimesteel
			);
		}
		
		if (CompatManager.loadMain) {
			ModFluids.registerFluids(
					/** ------------------------------------- **/
					liquidFusionite,
					liquidIrradium,
					liquidSolsteel,
					liquidHydrogen,
					liquidGallium,
					liquidRuneSteel,
					liquidGravitonium,
					liquidTrichromadentium,
					liquidAtronium,
					liquidEbonite,
					liquidFusionLava,
					liquidValasium,
					liquidHallowsite,
					liquidBlightsteel,
					liquidSanguiseelium,
					liquidLiquifiedSouls,
					liquidZracohlium
			/** ------------------------------------- **/
			);
		} //CustomModelRenderCoreHooks
		if (CompatManager.twilightforest) {
			ModFluids.registerFluids(
					liquidPenguinite,
					liquidIronwood);
		}

		if (CompatManager.thebetweenlands) {
			ModFluids.registerFluids(
					liquidSyrmorite,
					liquidBurningSulfurFlow,
					liquidOctine,
					liquidEmber,
					liquidSwampSteel,
					liquidRotiron,
					liquidRottenSludge,
					liquidMummySludge,
					liquidBetweenSludge,
					liquidAncientAlloy
					);

		}
		if (CompatManager.aether_legacy) {
			ModFluids.registerFluids(
					liquidArkenium,
					liquidValkyrieMetal,
					liquidGoldenAmber);
		}
		if (CompatManager.easterEggs) {

		}

	}

	private static void addFluid(Fluid fluid) {
		RegisterHelper.registerFluid(fluid);
	}

}
