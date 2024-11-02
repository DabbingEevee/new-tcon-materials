package com.existingeevee.moretcon.inits;

import com.existingeevee.moretcon.ModInfo;
import com.existingeevee.moretcon.config.ConfigHandler;
import com.existingeevee.moretcon.materials.CompositeRegistry;
import com.existingeevee.moretcon.materials.CompositeRegistry.CompositeData;
import com.existingeevee.moretcon.materials.DelagateFluidMaterial;
import com.existingeevee.moretcon.materials.MTMaterialIntegration;
import com.existingeevee.moretcon.materials.UniqueMaterial;
import com.existingeevee.moretcon.other.MoreTConLogger;
import com.existingeevee.moretcon.other.utils.CompatManager;
import com.existingeevee.moretcon.other.utils.MaterialUtils;
import com.existingeevee.moretcon.other.utils.MiscUtils;
import com.existingeevee.moretcon.other.utils.RegisterHelper;
import com.existingeevee.moretcon.traits.ModTraits;

import landmaster.plustic.tools.stats.BatteryCellMaterialStats;
import landmaster.plustic.tools.stats.LaserMediumMaterialStats;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ArrowShaftMaterialStats;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.BowStringMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.FletchingMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTraits;
import thebetweenlands.common.registries.BlockRegistry;
import twilightforest.compat.TConstruct;

public class ModMaterials implements MaterialTypes {

	public static int totalMaterials;

	public static final Material materialWeedwood = new Material(MiscUtils.createNonConflictiveName("weedwood"), 0xcc9900);
	public static final Material materialIronwood = new Material(MiscUtils.createNonConflictiveName("ironwood"), 0xcc9900);
	public static final Material materialFusionite = new Material(MiscUtils.createNonConflictiveName("fusionite"), 0x3399ff);
	public static final Material materialSyrmorite = new Material(MiscUtils.createNonConflictiveName("syrmorite"), 0x234187);
	public static final Material materialValonite = new Material(MiscUtils.createNonConflictiveName("valonite"), 0xcab1ca);
	public static final Material materialOctine = new Material(MiscUtils.createNonConflictiveName("octine"), 0xff8206);
	public static final Material materialEmberlight = new Material(MiscUtils.createNonConflictiveName("emberlight"), 0xe8926d);
	public static final Material materialReedRope = new Material(MiscUtils.createNonConflictiveName("reedrope"), 0x000b4e0b);
	public static final Material materialAnglerTooth = new Material(MiscUtils.createNonConflictiveName("anglertooth"), 0x00cfcf99);
	public static final Material materialDragonFlyWing = new Material(MiscUtils.createNonConflictiveName("dragonflywing"), 0x00bed6db);
	public static final Material materialIrradium = new Material(MiscUtils.createNonConflictiveName("irradium"), 0x00ed00);
	public static final Material materialSolsteel = new Material(MiscUtils.createNonConflictiveName("solarsteel"), 0xffad33);
	public static final Material materialPenguinite = new Material(MiscUtils.createNonConflictiveName("penguinite"), 0xe6e6ffff);
	public static final Material materialVoidSpar = new Material(MiscUtils.createNonConflictiveName("voidspar"), 0xb37e15ff);
	public static final Material materialGarstone = new Material(MiscUtils.createNonConflictiveName("garstone"), 0xff0a0a);
	public static final Material materialBloodstone = new Material(MiscUtils.createNonConflictiveName("bloodstone"), 0x660a0a);
	public static final Material materialGallium = new Material(MiscUtils.createNonConflictiveName("gallium"), 0xffffff);
	public static final Material materialSlimyBone = new Material(MiscUtils.createNonConflictiveName("slimybone"), 0xede6bf);
	public static final Material materialEnderal = new Material(MiscUtils.createNonConflictiveName("enderal"), 0xb32d0080);
	public static final Material materialEnderexamite = new Material(MiscUtils.createNonConflictiveName("enderexamite"), 0x8e3acf);
	public static final Material materialFerroherb = new Material(MiscUtils.createNonConflictiveName("ferroherb"), 0x4c5e3a);
	public static final Material materialRuneSteel = new Material(MiscUtils.createNonConflictiveName("runeSteel"), 0xb6905e);
	public static final Material materialArkenium = new Material(MiscUtils.createNonConflictiveName("arkenium"), 0x595959);
	public static final Material materialSkyroot = new Material(MiscUtils.createNonConflictiveName("skyroot"), 0x6c633e);
	public static final Material materialHolystone = new Material(MiscUtils.createNonConflictiveName("holystone"), 0xa3a3a3);
	public static final Material materialZanite = new Material(MiscUtils.createNonConflictiveName("zanite"), 0x6611dd);
	public static final Material materialGravitite = new Material(MiscUtils.createNonConflictiveName("gravitite"), 0xcc55aa);
	public static final Material materialValkyrieMetal = new Material(MiscUtils.createNonConflictiveName("valkyriemetal"), 0xeaee57);
	public static final Material materialAmberwood = new Material(MiscUtils.createNonConflictiveName("amberwood"), 0xeaee57);
	public static final Material materialGravitonium = new Material(MiscUtils.createNonConflictiveName("gravitonium"), 0x00aa00);
	public static final Material materialTrichromadentium = new Material(MiscUtils.createNonConflictiveName("trichromadentium"), 0x777777);
	public static final Material materialSwampSteel = new Material(MiscUtils.createNonConflictiveName("swampsteel"), 0x003906);
	public static final Material materialRotiron = new Material(MiscUtils.createNonConflictiveName("rotiron"), 0x002400);
	public static final Material materialEchostone = new Material(MiscUtils.createNonConflictiveName("echostone"), 0x00725a);
	public static final Material materialIgniglomerate = new Material(MiscUtils.createNonConflictiveName("igniglomerate"), 0xB33B00);
	public static final Material materialAtronium = new Material(MiscUtils.createNonConflictiveName("atronium"), 0xd99857);
	public static final Material materialEbonite = new Material(MiscUtils.createNonConflictiveName("ebonite"), 0x270339);
	public static final Material materialErythynite = new Material(MiscUtils.createNonConflictiveName("erythynite"), 0x00ff00);
	public static final Material materialShadowglass = new Material(MiscUtils.createNonConflictiveName("shadowglass"), 0x2a275e);
	public static final Material materialEtherstone = new Material(MiscUtils.createNonConflictiveName("etherstone"), 0xf1ea3b);
	public static final Material materialValasium = new Material(MiscUtils.createNonConflictiveName("valasium"), 0x9ab7d6);
	public static final Material materialElectarite = new Material(MiscUtils.createNonConflictiveName("electarite"), 0x6666FF);
	public static final Material materialHallowsite = new Material(MiscUtils.createNonConflictiveName("hallowsite"), 0x34eb98);
	public static final Material materialAncientAlloy = new Material(MiscUtils.createNonConflictiveName("ancientalloy"), 0xa2c2c0);
	public static final Material materialBlightsteel = new Material(MiscUtils.createNonConflictiveName("blightsteel"), 0x243c5a);
	public static final Material materialSanguiseelium = new Material(MiscUtils.createNonConflictiveName("sanguiseelium"), 0x6b1313);
	public static final Material materialZracohlium = new Material(MiscUtils.createNonConflictiveName("zracohlium"), 0x444c2a);
	public static final Material materialIoximite = new Material(MiscUtils.createNonConflictiveName("ioximite"), 0x978cea);
	public static final Material materialMonolite = new Material(MiscUtils.createNonConflictiveName("monolite"), 0x4a74f0);

	public static final Material materialNahuatl = new Material(MiscUtils.createNonConflictiveName("nahuatl"), 0x3B2754);
	public static final Material materialSlimewood = new Material(MiscUtils.createNonConflictiveName("slimewood"), 0x96dd8f);
	public static final DelagateFluidMaterial materialSearedStone = new DelagateFluidMaterial(MiscUtils.createNonConflictiveName("searedstone"), 0x4f4a47);
	public static final Material materialSlimesteel = new Material(MiscUtils.createNonConflictiveName("slimesteel"), 0x47efea);

	//TODO
	// public static final Material materialQueensslime = new Material(Misc.createNonConflictiveName("queensslime"), 0x565808); //Need Custom
	// public static final Material materialHepatizon = new Material(Misc.createNonConflictiveName("hepatizon"), 0xf1ea3b);
	// public static final Material materialScorchedStone = new Material(Misc.createNonConflictiveName("scorchedstone"), 0x53453c);
	// public static final Material materialBloodbone = new Material(Misc.createNonConflictiveName("bloodbone"), 0xb80000);
	// public static final Material materialNecroticBone = new Material(Misc.createNonConflictiveName("necrobone"), 0x343434);
	// public static final Material materialBlazingBone = new Material(Misc.createNonConflictiveName("blazingbone"), 0xefc62f);

	public static final UniqueMaterial materialPlasma = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("plasma"), 0xff0000, "tconstruct:sword_blade",
			"tconstruct:broadsword");

	public static final UniqueMaterial materialShockwave = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("shockwave"), 0xa1ddd8,
			ConfigHandler.registerBetweenTinkerTools ? "moretcon:blswordblade" : "tconstruct:sword_blade",
			ConfigHandler.registerBetweenTinkerTools ? "moretcon:blsword" : "tconstruct:broadsword",
			() -> new ItemStack(BlockRegistry.ANIMATOR), "shockwave");

	public static final UniqueMaterial materialTriblade = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("triblade"), 0x6d6d6d, "tconstruct:knife_blade",
			"tconstruct:shuriken");

	public static final UniqueMaterial materialTrailblazer = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("trailblazer"), 0xff6c00, "tconstruct:knife_blade",
			"tconstruct:shuriken");

	public static final UniqueMaterial materialMirrored = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("mirrored"), 0xfafaff, "tconstruct:fletching",
			"tconstruct:arrow");

	public static final UniqueMaterial materialTechnoblade = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("technoblade"), 0xea8f8c, "tconstruct:sword_blade",
			"tconstruct:broadsword");

	public static final UniqueMaterial materialCrimson = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("crimson"), 0xaa0000, "tconstruct:tough_tool_rod",
			"plustic:katana");

	public static final UniqueMaterial materialEssencore = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("essencore"), 0x65c9ff, "tconstruct:pick_head",
			"tconstruct:pickaxe");

	public static final UniqueMaterial materialWormed = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("wormed"), 0xd99857, "tconstruct:arrow_head",
			"tconstruct:arrow",
			() -> new ItemStack(BlockRegistry.WEEDWOOD_WORKBENCH), "crafting_table");

	public static final UniqueMaterial materialCryosplinters = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("cryosplinters"), 0x91bbff, "tconstruct:arrow_head",
			"tconstruct:arrow");

	public static final UniqueMaterial materialSpaceTimeDisruption = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("spacetimedisruption"), 0x400080, "tconstruct:bow_limb",
			"tconstruct:crossbow");

	public static final UniqueMaterial materialAutoloader = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("autoloader"), 0xa34f49, "tconstruct:tough_tool_rod",
			"tconstruct:crossbow");

	public static final UniqueMaterial materialQuakestruck = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("quakestruck"), 0x2683bd, "tconstruct:large_plate",
			"tconstruct:hammer");

	public static final UniqueMaterial materialSkybolt = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("skybolt"), 0x3BB0FF, "tconstruct:sword_blade",
			"tconstruct:broadsword");

	public static final UniqueMaterial materialVengeance = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("vengeance"), 0x3a454a, "tconstruct:sign_head",
			"tconstruct:battlesign");

	public static final UniqueMaterial materialDematerializer = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("dematerializer"), 0xbae7ff, "tconstruct:bow_limb",
			"tconstruct:longbow");

	public static final UniqueMaterial materialShotgun = new UniqueMaterial(
			MiscUtils.createNonConflictiveName("shotgun"), 0xefefef, "tconstruct:tough_binding",
			"tconstruct:crossbow");
	
	private static void initMats() {
		BowMaterialStats whyWouldYouMakeABowOutOfThis = new BowMaterialStats(0.2f, 0.4f, -1f);

		if (CompatManager.tic3backport) {
			materialNahuatl.setCastable(false);
			materialNahuatl.setCraftable(false);
			materialNahuatl.addTrait(ModTraits.slicing, HEAD);
			materialNahuatl.addTrait(ModTraits.darkened, HEAD);
			materialNahuatl.addTrait(TinkerTraits.ecological, HEAD);
			materialNahuatl.addTrait(TinkerTraits.dense, HEAD);
			materialNahuatl.addTrait(TinkerTraits.ecological);
			materialNahuatl.addTrait(TinkerTraits.dense);
			TinkerRegistry.addMaterialStats(materialNahuatl, new HeadMaterialStats(350, 4.5f, 5f, 2));
			TinkerRegistry.addMaterialStats(materialNahuatl, new HandleMaterialStats(0.9f, 125));
			TinkerRegistry.addMaterialStats(materialNahuatl, new ExtraMaterialStats(75));
			TinkerRegistry.addMaterialStats(materialNahuatl, new BowMaterialStats(0.7f, 0.85f, 4f));
			TinkerRegistry.addMaterialStats(materialNahuatl, new ArrowShaftMaterialStats(1.2f, 32));
			CompositeRegistry.registerComposite(new CompositeData(() -> TinkerMaterials.wood, () -> materialNahuatl, () -> TinkerFluids.obsidian, false).setMultiplier(2));

			materialSlimewood.setCastable(false);
			materialSlimewood.setCraftable(false);
			materialSlimewood.addTrait(ModTraits.overgrowth, HEAD);
			materialSlimewood.addTrait(ModTraits.overslime, HEAD);
			materialSlimewood.addTrait(TinkerTraits.ecological, HEAD);
			materialSlimewood.addTrait(TinkerTraits.crumbling, HEAD);
			materialSlimewood.addTrait(TinkerTraits.slimeyGreen);
			materialSlimewood.addTrait(ModTraits.overslime);
			TinkerRegistry.addMaterialStats(materialSlimewood, new HeadMaterialStats(375, 4f, 1f, 1));
			TinkerRegistry.addMaterialStats(materialSlimewood, new HandleMaterialStats(1.3f, 125));
			TinkerRegistry.addMaterialStats(materialSlimewood, new ExtraMaterialStats(75));
			TinkerRegistry.addMaterialStats(materialSlimewood, new BowMaterialStats(1f, 0.95f, 2f));
			TinkerRegistry.addMaterialStats(materialSlimewood, new ArrowShaftMaterialStats(1.2f, 28));
			CompositeRegistry.registerComposite(() -> TinkerMaterials.wood, () -> materialSlimewood, () -> TinkerFluids.blueslime);

			// Overslime for the win!			
			TinkerMaterials.knightslime.addTrait(ModTraits.overslime, HEAD);
			TinkerMaterials.knightslime.addTrait(ModTraits.overcast, HEAD);
			TinkerMaterials.knightslime.addTrait(ModTraits.overslime);

			TinkerMaterials.slime.addTrait(ModTraits.overgrowth2, HEAD);
			TinkerMaterials.slime.addTrait(ModTraits.overslime, HEAD);
			TinkerMaterials.slime.addTrait(TinkerTraits.slimeyGreen, HEAD);
			TinkerMaterials.slime.addTrait(ModTraits.overgrowth);
			TinkerMaterials.slime.addTrait(ModTraits.overslime);

			TinkerMaterials.blueslime.addTrait(ModTraits.overgrowth2, HEAD);
			TinkerMaterials.blueslime.addTrait(ModTraits.overslime, HEAD);
			TinkerMaterials.blueslime.addTrait(TinkerTraits.slimeyBlue, HEAD);
			TinkerMaterials.blueslime.addTrait(ModTraits.overgrowth);
			TinkerMaterials.blueslime.addTrait(ModTraits.overslime);

			TinkerMaterials.magmaslime.addTrait(ModTraits.fireslime, HEAD);
			TinkerMaterials.magmaslime.addTrait(ModTraits.overgrowth);
			TinkerMaterials.magmaslime.addTrait(ModTraits.overslime, HEAD);
			TinkerMaterials.magmaslime.addTrait(ModTraits.overslime);

			materialSearedStone.addItem("blockSeared", 1, Material.VALUE_Ingot);
			materialSearedStone.setFluid(() -> TinkerFluids.searedStone);
			materialSearedStone.setCastable(true);
			materialSearedStone.setCraftable(true);
			materialSearedStone.setRepresentativeItem("blockSeared");
			materialSearedStone.addTrait(TinkerTraits.stonebound);
			materialSearedStone.addTrait(ModTraits.searing);
			materialSearedStone.addTrait(TinkerTraits.crude, HEAD);
			materialSearedStone.addTrait(ModTraits.searing2, HEAD);
			TinkerRegistry.addMaterialStats(materialSearedStone, new HeadMaterialStats(225, 1.5f, 6.5f, 1));
			TinkerRegistry.addMaterialStats(materialSearedStone, new HandleMaterialStats(0.85f, -25));
			TinkerRegistry.addMaterialStats(materialSearedStone, new ExtraMaterialStats(-15));
			TinkerRegistry.addMaterialStats(materialSearedStone, whyWouldYouMakeABowOutOfThis);
			
			materialSlimesteel.addCommonItems("Slimesteel");
			materialSlimesteel.setFluid(ModFluids.liquidSlimesteel);
			materialSlimesteel.setCastable(true);
			materialSlimesteel.setCraftable(false);
			materialSlimesteel.setRepresentativeItem("ingotSlimesteel");
			materialSlimesteel.addTrait(ModTraits.slimesharp, HEAD);
			materialSlimesteel.addTrait(ModTraits.overslime, HEAD);
			materialSlimesteel.addTrait(ModTraits.overslime);
			TinkerRegistry.addMaterialStats(materialSlimesteel, new HeadMaterialStats(1040, 2.5f, 6.0f, 3));
			TinkerRegistry.addMaterialStats(materialSlimesteel, new HandleMaterialStats(0.6f, 120));
			TinkerRegistry.addMaterialStats(materialSlimesteel, new ExtraMaterialStats(45));
			TinkerRegistry.addMaterialStats(materialSlimesteel, new BowMaterialStats(0.9f, 1.0f, 3f));
		}

		if (CompatManager.plustic) {
			TinkerRegistry.addMaterialStats(materialCrimson, new HandleMaterialStats(4f, 1024));
			materialCrimson.addTrait(ModTraits.bloodyArc);
			materialCrimson.addTrait(ModTraits.slicing);
		}

		if (CompatManager.easterEggs) {
			// Thank you for everything, old friend
			TinkerRegistry.addMaterialStats(materialTechnoblade, new HeadMaterialStats(12288, 8f, 15f, 5));
			materialTechnoblade.addTrait(TinkerTraits.baconlicious);
			materialTechnoblade.addTrait(ModTraits.bloodGodsBlessing);
		}

		if (CompatManager.loadMain) {
			materialFusionite.addItem("oreFusionite", 1, Material.VALUE_Ore());
			materialFusionite.setFluid(ModFluids.liquidFusionite);
			materialFusionite.addCommonItems("Fusionite");
			materialFusionite.setCastable(true);
			materialFusionite.setCraftable(false);
			materialFusionite.setRepresentativeItem("ingotFusionite");
			materialFusionite.addTrait(ModTraits.coldFire, HEAD);
			materialFusionite.addTrait(ModTraits.luminescent, HEAD);
			materialFusionite.addTrait(TinkerTraits.enderference, HEAD);
			materialFusionite.addTrait(TinkerTraits.alien);
			materialFusionite.addTrait(TinkerTraits.dense);
			materialFusionite.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialFusionite, new HeadMaterialStats(500, 5.0f, 8.0f, 6));
			TinkerRegistry.addMaterialStats(materialFusionite, new HandleMaterialStats(3.0f, 20));
			TinkerRegistry.addMaterialStats(materialFusionite, new ExtraMaterialStats(20));
			TinkerRegistry.addMaterialStats(materialFusionite, new ArrowShaftMaterialStats(3.0f, 20));
			TinkerRegistry.addMaterialStats(materialFusionite, new BowMaterialStats(0.6f, 1.0f, 3f));
			if (CompatManager.plustic) {
				TinkerRegistry.addMaterialStats(materialFusionite, new LaserMediumMaterialStats(10, 20));
				TinkerRegistry.addMaterialStats(materialFusionite, new BatteryCellMaterialStats(100000));
			}

			materialValasium.addItem("oreValasium", 1, Material.VALUE_Ore());
			materialValasium.setFluid(ModFluids.liquidValasium);
			materialValasium.addCommonItems("Valasium");
			materialValasium.setCastable(true);
			materialValasium.setCraftable(false);
			materialValasium.setRepresentativeItem("ingotValasium");
			materialValasium.addTrait(ModTraits.kineticBattery, HEAD);
			materialValasium.addTrait(ModTraits.shielding, HEAD);
			materialValasium.addTrait(TinkerTraits.alien, HEAD);
			materialValasium.addTrait(TinkerTraits.alien);
			materialValasium.addTrait(TinkerTraits.dense);
			if (CompatManager.plustic) {
				TinkerRegistry.addMaterialStats(materialValasium, new LaserMediumMaterialStats(15, 20));
				TinkerRegistry.addMaterialStats(materialValasium, new BatteryCellMaterialStats(2000));
			}
			TinkerRegistry.addMaterialStats(materialValasium, new HeadMaterialStats(1600, 20f, 16f, 8));
			TinkerRegistry.addMaterialStats(materialValasium, new HandleMaterialStats(4f, 60));
			TinkerRegistry.addMaterialStats(materialValasium, new ExtraMaterialStats(500));
			TinkerRegistry.addMaterialStats(materialValasium, new ArrowShaftMaterialStats(3f, 75));
			TinkerRegistry.addMaterialStats(materialValasium, new BowMaterialStats(0.7f, 1.7f, 12f));

			materialIrradium.addItem("oreIrradium", 1, Material.VALUE_Ore());
			materialIrradium.setFluid(ModFluids.liquidIrradium);
			materialIrradium.addCommonItems("Irradium");
			materialIrradium.setCastable(true);
			materialIrradium.setCraftable(false);
			materialIrradium.setRepresentativeItem("ingotIrradium");
			materialIrradium.addTrait(ModTraits.radioactive, HANDLE);
			materialIrradium.addTrait(ModTraits.luminescent, HANDLE);
			materialIrradium.addTrait(ModTraits.radioactive, EXTRA);
			materialIrradium.addTrait(ModTraits.luminescent, EXTRA);
			materialIrradium.addTrait(TinkerTraits.momentum);
			materialIrradium.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialIrradium, new HeadMaterialStats(700, 6f, 4f, 5));
			if (CompatManager.plustic) {
				TinkerRegistry.addMaterialStats(materialIrradium, new LaserMediumMaterialStats(8, 25));
				TinkerRegistry.addMaterialStats(materialIrradium, new BatteryCellMaterialStats(480000));
			}
			TinkerRegistry.addMaterialStats(materialIrradium, new HandleMaterialStats(3f, 40));
			TinkerRegistry.addMaterialStats(materialIrradium, new ExtraMaterialStats(40));
			TinkerRegistry.addMaterialStats(materialIrradium, new ArrowShaftMaterialStats(3f, 20));
			TinkerRegistry.addMaterialStats(materialIrradium, new BowMaterialStats(0.7f, 1.25f, 3f));

			materialSolsteel.setFluid(ModFluids.liquidSolsteel);
			materialSolsteel.addCommonItems("Solarsteel");
			materialSolsteel.setCastable(true);
			materialSolsteel.setCraftable(false);
			materialSolsteel.setRepresentativeItem("ingotSolarsteel");
			materialSolsteel.addTrait(TinkerTraits.flammable, HEAD);
			materialSolsteel.addTrait(TinkerTraits.autosmelt, HEAD);
			materialSolsteel.addTrait(ModTraits.luminescent, HEAD);
			materialSolsteel.addTrait(TinkerTraits.superheat);
			materialSolsteel.addTrait(TinkerTraits.dense);
			materialSolsteel.addTrait(ModTraits.luminescent);
			if (CompatManager.plustic) {
				TinkerRegistry.addMaterialStats(materialSolsteel, new LaserMediumMaterialStats(15, 20));
				TinkerRegistry.addMaterialStats(materialSolsteel, new BatteryCellMaterialStats(750000));
			}
			TinkerRegistry.addMaterialStats(materialSolsteel, new HeadMaterialStats(4500, 22f, 20f, 7));
			TinkerRegistry.addMaterialStats(materialSolsteel, new HandleMaterialStats(4f, 600));
			TinkerRegistry.addMaterialStats(materialSolsteel, new ExtraMaterialStats(600));
			TinkerRegistry.addMaterialStats(materialSolsteel, new ArrowShaftMaterialStats(3f, 50));
			TinkerRegistry.addMaterialStats(materialSolsteel, new BowMaterialStats(0.8f, 5.0f, 15f));

			materialTrichromadentium.addItem("oreTrichromadentium", 1, Material.VALUE_Ore());
			materialTrichromadentium.addCommonItems("Trichromadentium");
			materialTrichromadentium.setFluid(ModFluids.liquidTrichromadentium);
			materialTrichromadentium.setCastable(true);
			materialTrichromadentium.setCraftable(false);
			materialTrichromadentium.setRepresentativeItem("ingotTrichromadentium");
			materialTrichromadentium.addTrait(ModTraits.luminescent);
			materialTrichromadentium.addTrait(ModTraits.trichromic);
			materialTrichromadentium.addTrait(TinkerTraits.unnatural);
			materialTrichromadentium.addTrait(TinkerTraits.coldblooded);
			if (CompatManager.plustic) {
				TinkerRegistry.addMaterialStats(materialTrichromadentium, new LaserMediumMaterialStats(15, 20));
				TinkerRegistry.addMaterialStats(materialTrichromadentium, new BatteryCellMaterialStats(2000));
			}
			TinkerRegistry.addMaterialStats(materialTrichromadentium, new HeadMaterialStats(1800, 20f, 18f, 8));
			TinkerRegistry.addMaterialStats(materialTrichromadentium, new HandleMaterialStats(4f, 60));
			TinkerRegistry.addMaterialStats(materialTrichromadentium, new ExtraMaterialStats(500));
			TinkerRegistry.addMaterialStats(materialTrichromadentium, new ArrowShaftMaterialStats(3f, 75));
			TinkerRegistry.addMaterialStats(materialTrichromadentium, new BowMaterialStats(0.6f, 2.0f, 14f));

			materialAtronium.addItem("oreAtronium", 1, Material.VALUE_Ore());
			materialAtronium.addCommonItems("Atronium");
			materialAtronium.setFluid(ModFluids.liquidAtronium);
			materialAtronium.setCastable(true);
			materialAtronium.setCraftable(false);
			materialAtronium.setRepresentativeItem("ingotAtronium");
			materialAtronium.addTrait(TinkerTraits.lightweight);
			materialAtronium.addTrait(ModTraits.magicallyReactive);
			materialAtronium.addTrait(ModTraits.penetrant);
			materialAtronium.addTrait(ModTraits.etheralHarvest, HEAD);
			materialAtronium.addTrait(TinkerTraits.lightweight, HEAD);
			materialAtronium.addTrait(ModTraits.magicallyReactive, HEAD);
			materialAtronium.addTrait(ModTraits.penetrant, HEAD);
			TinkerRegistry.addMaterialStats(materialAtronium, new HeadMaterialStats(1500, 18f, 17f, 8));
			TinkerRegistry.addMaterialStats(materialAtronium, new HandleMaterialStats(3f, 180));
			TinkerRegistry.addMaterialStats(materialAtronium, new ExtraMaterialStats(750));
			TinkerRegistry.addMaterialStats(materialAtronium, new ArrowShaftMaterialStats(2f, 120));
			TinkerRegistry.addMaterialStats(materialAtronium, new BowMaterialStats(0.6f, 1.25f, 12f));

			materialEbonite.addItem("oreEbonite", 1, Material.VALUE_Ore());
			materialEbonite.setFluid(ModFluids.liquidEbonite);
			materialEbonite.addCommonItems("Ebonite");
			materialEbonite.setCastable(true);
			materialEbonite.setCraftable(false);
			materialEbonite.setRepresentativeItem("ingotEbonite");
			materialEbonite.addTrait(ModTraits.darkened, HEAD);
			materialEbonite.addTrait(ModTraits.luminescent, HEAD);
			materialEbonite.addTrait(TinkerTraits.poisonous, HEAD);
			materialEbonite.addTrait(ModTraits.bottomsEnd, HEAD);
			materialEbonite.addTrait(ModTraits.luminescent);
			materialEbonite.addTrait(TinkerTraits.dense);
			materialEbonite.addTrait(TinkerTraits.established);
			materialEbonite.materialTextColor = 0x544470;
			TinkerRegistry.addMaterialStats(materialEbonite, new HeadMaterialStats(750, 6.0f, 9.0f, 7));
			TinkerRegistry.addMaterialStats(materialEbonite, new HandleMaterialStats(2.5f, 60));
			TinkerRegistry.addMaterialStats(materialEbonite, new ExtraMaterialStats(25));
			TinkerRegistry.addMaterialStats(materialEbonite, new ArrowShaftMaterialStats(1.5f, 20));
			TinkerRegistry.addMaterialStats(materialEbonite, new BowMaterialStats(0.8f, 1.25f, 4f));
			if (CompatManager.plustic) {
				TinkerRegistry.addMaterialStats(materialEbonite, new LaserMediumMaterialStats(12, 20));
				TinkerRegistry.addMaterialStats(materialEbonite, new BatteryCellMaterialStats(120000));
			}

			materialSpaceTimeDisruption.addTrait(TinkerTraits.dense);
			materialSpaceTimeDisruption.addTrait(ModTraits.luminescent);
			materialSpaceTimeDisruption.addTrait(ModTraits.blinkdrawn);
			TinkerRegistry.addMaterialStats(materialSpaceTimeDisruption, new BowMaterialStats(Float.MAX_VALUE, 3f, 3f)); // big
			TinkerRegistry.addMaterialStats(materialSpaceTimeDisruption, new HeadMaterialStats(500, 10f, 8f, 6));

			materialVoidSpar.addItem("gemVoidSpar", 1, Material.VALUE_Ingot);
			materialVoidSpar.addItem("blockVoidSpar", 1, Material.VALUE_Block);
			materialVoidSpar.setCastable(false);
			materialVoidSpar.setCraftable(true);
			materialVoidSpar.setRepresentativeItem("gemVoidSpar");
			materialVoidSpar.addTrait(ModTraits.voidic, HEAD);
			materialVoidSpar.addTrait(ModTraits.bottomsEnd, HEAD);
			materialVoidSpar.addTrait(ModTraits.luminescent, HEAD);
			materialVoidSpar.addTrait(ModTraits.luminescent);
			materialVoidSpar.addTrait(TinkerTraits.dense);
			materialVoidSpar.addTrait(TinkerTraits.ecological);
			TinkerRegistry.addMaterialStats(materialVoidSpar, new HeadMaterialStats(300, 6f, 10f, 5));
			TinkerRegistry.addMaterialStats(materialVoidSpar, new HandleMaterialStats(2f, -50));
			TinkerRegistry.addMaterialStats(materialVoidSpar, new ExtraMaterialStats(2));
			TinkerRegistry.addMaterialStats(materialVoidSpar, new ArrowShaftMaterialStats(1f, 10));
			TinkerRegistry.addMaterialStats(materialVoidSpar, whyWouldYouMakeABowOutOfThis);

			materialGarstone.addItem("gemGarstone", 1, Material.VALUE_Ingot);
			materialGarstone.addItem("blockGarstone", 1, Material.VALUE_Block);
			materialGarstone.setCastable(false);
			materialGarstone.setCraftable(true);
			materialGarstone.setRepresentativeItem("gemGarstone");
			materialGarstone.addTrait(TinkerTraits.coldblooded, HEAD);
			materialGarstone.addTrait(ModTraits.luminescent, HEAD);
			materialGarstone.addTrait(TinkerTraits.jagged, HEAD);
			materialGarstone.addTrait(TinkerTraits.unnatural);
			materialGarstone.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialGarstone, new HeadMaterialStats(500, 6f, 10f, 5));
			TinkerRegistry.addMaterialStats(materialGarstone, new HandleMaterialStats(2f, -50));
			TinkerRegistry.addMaterialStats(materialGarstone, new ExtraMaterialStats(2));
			TinkerRegistry.addMaterialStats(materialGarstone, new ArrowShaftMaterialStats(1f, 10));
			TinkerRegistry.addMaterialStats(materialGarstone, whyWouldYouMakeABowOutOfThis);

			materialEchostone.addItem("gemEchostone", 1, Material.VALUE_Ingot);
			materialEchostone.addItem("blockEchostone", 1, Material.VALUE_Block);
			materialEchostone.setCastable(false);
			materialEchostone.setCraftable(true);
			materialEchostone.setRepresentativeItem("gemEchostone");
			materialEchostone.addTrait(TinkerTraits.unnatural);
			materialEchostone.addTrait(ModTraits.eularsWrath);
			materialEchostone.addTrait(ModTraits.afterimage, HEAD);
			materialEchostone.addTrait(ModTraits.luminescent, HEAD);
			materialEchostone.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialEchostone, new HeadMaterialStats(500, 6f, 10f, 5));
			TinkerRegistry.addMaterialStats(materialEchostone, new HandleMaterialStats(2f, -50));
			TinkerRegistry.addMaterialStats(materialEchostone, new ExtraMaterialStats(2));
			TinkerRegistry.addMaterialStats(materialEchostone, new ArrowShaftMaterialStats(1f, 10));
			TinkerRegistry.addMaterialStats(materialEchostone, whyWouldYouMakeABowOutOfThis);

			materialBloodstone.addItem("gemBloodstone", 1, Material.VALUE_Ingot);
			materialBloodstone.addItem("blockBloodstone", 1, Material.VALUE_Block);
			materialBloodstone.setCastable(false);
			materialBloodstone.setCraftable(true);
			materialBloodstone.setRepresentativeItem("gemBloodstone");
			materialBloodstone.addTrait(TinkerTraits.coldblooded, HEAD);
			materialBloodstone.addTrait(ModTraits.bottomsEnd, HEAD);
			materialBloodstone.addTrait(ModTraits.slicing, HEAD);
			materialBloodstone.addTrait(ModTraits.leeching);
			TinkerRegistry.addMaterialStats(materialBloodstone, new HeadMaterialStats(750, 7f, 12f, 6));
			TinkerRegistry.addMaterialStats(materialBloodstone, new HandleMaterialStats(1.125f, -35));
			TinkerRegistry.addMaterialStats(materialBloodstone, new ExtraMaterialStats(75));
			TinkerRegistry.addMaterialStats(materialBloodstone, new ArrowShaftMaterialStats(2.35f, 80));
			TinkerRegistry.addMaterialStats(materialBloodstone, whyWouldYouMakeABowOutOfThis);

			materialErythynite.addItem("gemErythynite", 1, Material.VALUE_Ingot);
			materialErythynite.addItem("blockErythynite", 1, Material.VALUE_Block);
			materialErythynite.setCastable(false);
			materialErythynite.setCraftable(true);
			materialErythynite.setRepresentativeItem("gemErythynite");
			materialErythynite.addTrait(TinkerTraits.unnatural, HEAD);
			materialErythynite.addTrait(ModTraits.hardcore, HEAD);
			materialErythynite.addTrait(ModTraits.luminescent, HEAD);
			materialErythynite.addTrait(ModTraits.leeching);
			materialErythynite.addTrait(ModTraits.weightless);
			materialErythynite.addTrait(TinkerTraits.enderference);
			materialErythynite.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialErythynite, new HeadMaterialStats(600, 7.5f, 10f, 7));
			TinkerRegistry.addMaterialStats(materialErythynite, new HandleMaterialStats(2.2f, 60));
			TinkerRegistry.addMaterialStats(materialErythynite, new ExtraMaterialStats(30));
			TinkerRegistry.addMaterialStats(materialErythynite, new ArrowShaftMaterialStats(1.5f, 20));
			if (CompatManager.plustic) {
				TinkerRegistry.addMaterialStats(materialErythynite, new LaserMediumMaterialStats(12, 20));
			}
			TinkerRegistry.addMaterialStats(materialErythynite, whyWouldYouMakeABowOutOfThis);

			materialGravitonium.addItem("oreGravitonium", 1, Material.VALUE_Ore());
			materialGravitonium.addItem("oreGravitoniumDense", 1, Material.VALUE_Ore() * 4);
			materialGravitonium.setFluid(ModFluids.liquidGravitonium);
			materialGravitonium.addCommonItems("Gravitonium");
			materialGravitonium.setCastable(true);
			materialGravitonium.setCraftable(false);
			materialGravitonium.setRepresentativeItem("ingotGravitonium");
			materialGravitonium.addTrait(ModTraits.hypergravity);
			materialGravitonium.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialGravitonium, new HeadMaterialStats(700, 16f, 12f, 5));
			if (CompatManager.plustic) {
				TinkerRegistry.addMaterialStats(materialGravitonium, new LaserMediumMaterialStats(12, 25));
				TinkerRegistry.addMaterialStats(materialGravitonium, new BatteryCellMaterialStats(480000));
			}
			TinkerRegistry.addMaterialStats(materialGravitonium, new HandleMaterialStats(3f, 400));
			TinkerRegistry.addMaterialStats(materialGravitonium, new ExtraMaterialStats(300));
			TinkerRegistry.addMaterialStats(materialGravitonium, new ArrowShaftMaterialStats(3f, 50));
			TinkerRegistry.addMaterialStats(materialGravitonium, new BowMaterialStats(0.5f, 1.5f, 4f));

			materialGallium.addCommonItems("Gallium");
			materialGallium.setFluid(ModFluids.liquidGallium);
			materialGallium.setCastable(true);
			materialGallium.setCraftable(true);
			materialGallium.setRepresentativeItem("ingotGallium");
			materialGallium.addTrait(TinkerTraits.aquadynamic);
			materialGallium.addTrait(ModTraits.liquid);
			materialGallium.addTrait(TinkerTraits.crumbling);
			materialGallium.materialTextColor = 0xadb7ba;
			TinkerRegistry.addMaterialStats(materialGallium, new HeadMaterialStats(100, 6f, 5f, 5));
			TinkerRegistry.addMaterialStats(materialGallium, new HandleMaterialStats(2f, -50));
			TinkerRegistry.addMaterialStats(materialGallium, new ExtraMaterialStats(2));
			TinkerRegistry.addMaterialStats(materialGallium, new ArrowShaftMaterialStats(1f, 10));
			TinkerRegistry.addMaterialStats(materialGallium, whyWouldYouMakeABowOutOfThis);

			materialRuneSteel.addCommonItems("RuneSteel");
			materialRuneSteel.setFluid(ModFluids.liquidRuneSteel);
			materialRuneSteel.setCastable(true);
			materialRuneSteel.setCraftable(false);
			materialRuneSteel.addTrait(ModTraits.magical);
			materialRuneSteel.addTrait(ModTraits.shielding);
			materialRuneSteel.setRepresentativeItem("ingotRunesteel");
			TinkerRegistry.addMaterialStats(materialRuneSteel, new HeadMaterialStats(900, 18f, 14f, 7));
			TinkerRegistry.addMaterialStats(materialRuneSteel, new HandleMaterialStats(4f, 60));
			TinkerRegistry.addMaterialStats(materialRuneSteel, new ExtraMaterialStats(60));
			TinkerRegistry.addMaterialStats(materialRuneSteel, new ArrowShaftMaterialStats(3f, 20));
			TinkerRegistry.addMaterialStats(materialRuneSteel, new BowMaterialStats(0.75f, 2.5f, 6f));

			materialEnderal.addItem("gemEnderal", 1, Material.VALUE_Ingot);
			materialEnderal.addItem("blockEnderal", 1, Material.VALUE_Block);
			materialEnderal.setCastable(false);
			materialEnderal.setCraftable(true);
			materialEnderal.setRepresentativeItem("gemEnderal");
			materialEnderal.addTrait(TinkerTraits.enderference);
			materialEnderal.addTrait(TinkerTraits.endspeed, PROJECTILE);
			materialEnderal.addTrait(TinkerTraits.enderference, HEAD);
			materialEnderal.addTrait(TinkerTraits.jagged, HEAD);
			materialEnderal.addTrait(ModTraits.pulsating, HEAD);
			materialEnderal.addTrait(ModTraits.luminescent, HEAD);
			materialEnderal.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialEnderal, new HeadMaterialStats(390, 6f, 10f, 5));
			TinkerRegistry.addMaterialStats(materialEnderal, new HandleMaterialStats(2f, -50));
			TinkerRegistry.addMaterialStats(materialEnderal, new ExtraMaterialStats(2));
			TinkerRegistry.addMaterialStats(materialEnderal, new ArrowShaftMaterialStats(1f, 10));
			TinkerRegistry.addMaterialStats(materialEnderal, whyWouldYouMakeABowOutOfThis);

			materialEnderexamite.setCastable(false);
			materialEnderexamite.setCraftable(false);
			materialEnderexamite.addTrait(TinkerTraits.slimeyBlue, HEAD);
			materialEnderexamite.addTrait(ModTraits.pulsating, HEAD);
			materialEnderexamite.addTrait(ModTraits.shielding, HEAD);
			materialEnderexamite.addTrait(TinkerTraits.crumbling);
			materialEnderexamite.addTrait(TinkerTraits.endspeed, PROJECTILE);
			materialEnderexamite.addTrait(ModTraits.resilient);
			TinkerRegistry.addMaterialStats(materialEnderexamite, new HeadMaterialStats(1300, 7f, 11f, 5));
			TinkerRegistry.addMaterialStats(materialEnderexamite, new HandleMaterialStats(2.25f, 20));
			TinkerRegistry.addMaterialStats(materialEnderexamite, new ExtraMaterialStats(12));
			TinkerRegistry.addMaterialStats(materialEnderexamite, new ArrowShaftMaterialStats(1f, 15));
			TinkerRegistry.addMaterialStats(materialEnderexamite, new BowMaterialStats(0.75f, 2.5f, 4f));
			CompositeRegistry.registerComposite(() -> materialEnderal, () -> materialEnderexamite, () -> TinkerFluids.knightslime);

			materialShadowglass.setCastable(false);
			materialShadowglass.setCraftable(false);
			materialShadowglass.addTrait(TinkerTraits.jagged, HEAD);
			materialShadowglass.addTrait(ModTraits.darkened, HEAD);
			materialShadowglass.addTrait(TinkerTraits.unnatural);
			materialShadowglass.addTrait(ModTraits.hardcore);
			TinkerRegistry.addMaterialStats(materialShadowglass, new HeadMaterialStats(1500, 8f, 12f, 7));
			TinkerRegistry.addMaterialStats(materialShadowglass, new HandleMaterialStats(2.3f, 20));
			TinkerRegistry.addMaterialStats(materialShadowglass, new ExtraMaterialStats(15));
			TinkerRegistry.addMaterialStats(materialShadowglass, new ArrowShaftMaterialStats(1.2f, 18));
			TinkerRegistry.addMaterialStats(materialShadowglass, new BowMaterialStats(2f, 0.9f, 6f));
			CompositeRegistry.registerComposite(() -> materialErythynite, () -> materialShadowglass, () -> ModFluids.liquidEbonite);

			TinkerRegistry.addMaterialStats(materialPlasma, new HeadMaterialStats(4096, 6f, 12f, 5));
			materialPlasma.addTrait(ModTraits.plasmatic);
			materialPlasma.addTrait(ModTraits.luminescent);

			TinkerRegistry.addMaterialStats(materialMirrored, new FletchingMaterialStats(0.95f, 3f));
			materialMirrored.addTrait(ModTraits.mirroring);

			TinkerRegistry.addMaterialStats(materialTriblade, new HeadMaterialStats(2056, 3f, 8f, 5));
			TinkerRegistry.addMaterialStats(materialTriblade, new ExtraMaterialStats(128));
			materialTriblade.addTrait(ModTraits.tripleshot);

			TinkerRegistry.addMaterialStats(materialTrailblazer, new HeadMaterialStats(2056 * 2, 6f, 18f, 7));
			TinkerRegistry.addMaterialStats(materialTrailblazer, new ExtraMaterialStats(512 * 2));
			materialTrailblazer.addTrait(ModTraits.aerialFlames);
			materialTrailblazer.addTrait(ModTraits.luminescent);

			materialIgniglomerate.addItem("gemIgniglomerate", 1, Material.VALUE_Ingot);
			materialIgniglomerate.addItem("blockIgniglomerate", 1, Material.VALUE_Block);
			materialIgniglomerate.setCastable(false);
			materialIgniglomerate.setCraftable(true);
			materialIgniglomerate.setRepresentativeItem("gemIgniglomerate");
			materialIgniglomerate.addTrait(ModTraits.hyperheat, HEAD);
			materialIgniglomerate.addTrait(ModTraits.luminescent, HEAD);
			materialIgniglomerate.addTrait(TinkerTraits.autosmelt, HANDLE);
			materialIgniglomerate.addTrait(ModTraits.luminescent, HANDLE);
			materialIgniglomerate.addTrait(TinkerTraits.autosmelt, EXTRA);
			materialIgniglomerate.addTrait(ModTraits.luminescent, EXTRA);
			materialIgniglomerate.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialIgniglomerate, new HeadMaterialStats(700, 6f, 7f, 7));
			TinkerRegistry.addMaterialStats(materialIgniglomerate, new HandleMaterialStats(1.25f, -10));
			TinkerRegistry.addMaterialStats(materialIgniglomerate, new ExtraMaterialStats(250));
			TinkerRegistry.addMaterialStats(materialIgniglomerate, new ArrowShaftMaterialStats(1f, 10));
			TinkerRegistry.addMaterialStats(materialIgniglomerate, whyWouldYouMakeABowOutOfThis);

			materialEtherstone.addItem("gemEtherstone", 1, Material.VALUE_Ingot);
			materialEtherstone.addItem("blockEtherstone", 1, Material.VALUE_Block);
			materialEtherstone.setCastable(false);
			materialEtherstone.setCraftable(true);
			materialEtherstone.setRepresentativeItem("gemEtherstone");
			materialEtherstone.addTrait(ModTraits.etheralHarvest, HEAD);
			materialEtherstone.addTrait(ModTraits.darkened, HEAD);
			materialEtherstone.addTrait(ModTraits.overdrive);
			materialEtherstone.addTrait(ModTraits.hardcore);
			materialEtherstone.addTrait(ModTraits.voidic);
			materialEtherstone.addTrait(ModTraits.luminescent, HEAD);
			materialEtherstone.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialEtherstone, new HeadMaterialStats(1450, 17.5f, 18f, 8));
			TinkerRegistry.addMaterialStats(materialEtherstone, new HandleMaterialStats(4f, -50));
			TinkerRegistry.addMaterialStats(materialEtherstone, new ExtraMaterialStats(500));
			TinkerRegistry.addMaterialStats(materialEtherstone, whyWouldYouMakeABowOutOfThis);

			TinkerRegistry.addMaterialStats(materialEssencore, new HeadMaterialStats(4096, 10f, 12f, 7));
			materialEssencore.addTrait(ModTraits.essentialObliteration);
			materialEssencore.addTrait(ModTraits.luminescent);

			materialElectarite.addItem("gemElectarite", 1, Material.VALUE_Ingot);
			materialElectarite.addItem("blockElectarite", 1, Material.VALUE_Block);
			materialElectarite.setCastable(false);
			materialElectarite.setCraftable(true);
			materialElectarite.setRepresentativeItem("gemElectarite");
			materialElectarite.addTrait(ModTraits.luminescent, HEAD);
			materialElectarite.addTrait(ModTraits.electrified, HEAD);
			materialElectarite.addTrait(TinkerTraits.enderference, HEAD);
			materialElectarite.addTrait(TinkerTraits.enderference);
			materialElectarite.addTrait(TinkerTraits.unnatural);
			materialElectarite.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialElectarite, new HeadMaterialStats(620, 6f, 7f, 5));
			TinkerRegistry.addMaterialStats(materialElectarite, new HandleMaterialStats(2.2f, 10));
			TinkerRegistry.addMaterialStats(materialElectarite, new ExtraMaterialStats(70));
			TinkerRegistry.addMaterialStats(materialElectarite, new ArrowShaftMaterialStats(1.2f, 10));
			TinkerRegistry.addMaterialStats(materialElectarite, whyWouldYouMakeABowOutOfThis);

			materialHallowsite.addCommonItems("Hallowsite");
			materialHallowsite.setFluid(ModFluids.liquidHallowsite);
			materialHallowsite.setCastable(true);
			materialHallowsite.setCraftable(false);
			materialHallowsite.setRepresentativeItem("ingotHallowsite");
			materialHallowsite.addTrait(ModTraits.haunted, HEAD);
			materialHallowsite.addTrait(ModTraits.soulforged2, HEAD);
			materialHallowsite.addTrait(ModTraits.soulforged);
			TinkerRegistry.addMaterialStats(materialHallowsite, new HeadMaterialStats(620, 6f, 7f, 5));
			TinkerRegistry.addMaterialStats(materialHallowsite, new HandleMaterialStats(2.2f, 10));
			TinkerRegistry.addMaterialStats(materialHallowsite, new ExtraMaterialStats(70));
			TinkerRegistry.addMaterialStats(materialHallowsite, new ArrowShaftMaterialStats(1.2f, 10));
			TinkerRegistry.addMaterialStats(materialHallowsite, new BowMaterialStats(0.8f, 1.4f, 1f));

			materialBlightsteel.addCommonItems("Blightsteel");
			materialBlightsteel.setFluid(ModFluids.liquidBlightsteel);
			materialBlightsteel.setCastable(true);
			materialBlightsteel.setCraftable(false);
			materialBlightsteel.setRepresentativeItem("ingotBlightsteel");
			materialBlightsteel.addTrait(ModTraits.withered, HEAD);
			materialBlightsteel.addTrait(ModTraits.blighted, HEAD);
			materialBlightsteel.addTrait(ModTraits.withered);
			materialBlightsteel.addTrait(ModTraits.soulforged);
			TinkerRegistry.addMaterialStats(materialBlightsteel, new HeadMaterialStats(1020, 6.5f, 8f, 6));
			TinkerRegistry.addMaterialStats(materialBlightsteel, new HandleMaterialStats(2.5f, 80));
			TinkerRegistry.addMaterialStats(materialBlightsteel, new ExtraMaterialStats(100));
			TinkerRegistry.addMaterialStats(materialBlightsteel, new ArrowShaftMaterialStats(1.5f, 125));
			TinkerRegistry.addMaterialStats(materialBlightsteel, new BowMaterialStats(1.2f, 1.3f, 0.8f));

			materialQuakestruck.addTrait(ModTraits.seismishock);
			TinkerRegistry.addMaterialStats(materialQuakestruck, new HeadMaterialStats(1800, 17.5f, 10f, 8));

			TinkerRegistry.addMaterialStats(materialCryosplinters, new HeadMaterialStats(2048, 6f, 16f, 5));
			materialCryosplinters.addTrait(ModTraits.hailshot);

			materialAutoloader.addTrait(ModTraits.autoloading);
			TinkerRegistry.addMaterialStats(materialAutoloader, new ExtraMaterialStats(1024));
			TinkerRegistry.addMaterialStats(materialAutoloader, new HandleMaterialStats(4f, 1024));

			materialSanguiseelium.addCommonItems("Sanguiseelium");
			materialSanguiseelium.setFluid(ModFluids.liquidSanguiseelium);
			materialSanguiseelium.setCastable(true);
			materialSanguiseelium.setCraftable(false);
			materialSanguiseelium.setRepresentativeItem("ingotSanguiseelium");
			materialSanguiseelium.addTrait(ModTraits.leeching, HEAD);
			materialSanguiseelium.addTrait(ModTraits.receptive, HEAD);
			materialSanguiseelium.addTrait(ModTraits.leeching);
			materialSanguiseelium.addTrait(ModTraits.soulforged);
			TinkerRegistry.addMaterialStats(materialSanguiseelium, new HeadMaterialStats(2004, 9f, 13f, 6));
			TinkerRegistry.addMaterialStats(materialSanguiseelium, new HandleMaterialStats(2.5f, 80));
			TinkerRegistry.addMaterialStats(materialSanguiseelium, new ExtraMaterialStats(100));
			TinkerRegistry.addMaterialStats(materialSanguiseelium, new ArrowShaftMaterialStats(1.5f, 125));
			TinkerRegistry.addMaterialStats(materialSanguiseelium, new BowMaterialStats(1.2f, 1.3f, 0.8f));

			TinkerRegistry.addMaterialStats(materialVengeance, new HeadMaterialStats(1024, 6f, 10f, 7));
			materialVengeance.addTrait(ModTraits.offense);

			materialZracohlium.addCommonItems("Zracohlium");
			materialZracohlium.setFluid(ModFluids.liquidZracohlium);
			materialZracohlium.setCastable(true);
			materialZracohlium.setCraftable(false);
			materialZracohlium.setRepresentativeItem("ingotZracohlium");
			materialZracohlium.addTrait(ModTraits.supercritical1, HEAD);
			materialZracohlium.addTrait(TinkerTraits.coldblooded, HEAD);
			materialZracohlium.addTrait(ModTraits.pyrophoric);
			materialZracohlium.addTrait(ModTraits.supercritical1);
			materialZracohlium.addTrait(ModTraits.radioactive);
			TinkerRegistry.addMaterialStats(materialZracohlium, new HeadMaterialStats(1200, 8f, 13.5f, 5));
			TinkerRegistry.addMaterialStats(materialZracohlium, new HandleMaterialStats(1.25f, 125));
			TinkerRegistry.addMaterialStats(materialZracohlium, new ExtraMaterialStats(90));
			TinkerRegistry.addMaterialStats(materialZracohlium, new ArrowShaftMaterialStats(1.5f, 125));
			TinkerRegistry.addMaterialStats(materialZracohlium, new BowMaterialStats(1.2f, 1.3f, 0.8f));

			TinkerRegistry.addMaterialStats(materialDematerializer, new BowMaterialStats(1f, 3.2f, 7f));
			TinkerRegistry.addMaterialStats(materialDematerializer, new HeadMaterialStats(2069, 10f, 8f, 6));
			materialDematerializer.addTrait(ModTraits.dematerializing);
			
			materialIoximite.setCastable(false);
			materialIoximite.setCraftable(false);
			materialIoximite.addTrait(ModTraits.voidic, HEAD);
			materialIoximite.addTrait(ModTraits.bottomsEnd, HEAD);
			materialIoximite.addTrait(ModTraits.plasmaMissiles,HEAD);
			materialIoximite.addTrait(ModTraits.plasmaMissiles);
			materialIoximite.addTrait(TinkerTraits.unnatural);
			materialIoximite.addTrait(TinkerTraits.alien);
			TinkerRegistry.addMaterialStats(materialIoximite, new HeadMaterialStats(1350, 7.5f, 11f, 6));
			TinkerRegistry.addMaterialStats(materialIoximite, new HandleMaterialStats(2.5f, 85));
			TinkerRegistry.addMaterialStats(materialIoximite, new ExtraMaterialStats(30));
			TinkerRegistry.addMaterialStats(materialIoximite, new ArrowShaftMaterialStats(2.5f, 85));
			TinkerRegistry.addMaterialStats(materialIoximite, new BowMaterialStats(2f, 1.2f, 3f));
			if (CompatManager.plustic) {
				TinkerRegistry.addMaterialStats(materialIoximite, new LaserMediumMaterialStats(10, 20));
				TinkerRegistry.addMaterialStats(materialIoximite, new BatteryCellMaterialStats(100000));
			}
			CompositeRegistry.registerComposite(() -> materialVoidSpar, () -> materialIoximite, () -> ModFluids.liquidFusionite);

			TinkerRegistry.addMaterialStats(materialShotgun, new ExtraMaterialStats(1024));
			materialShotgun.addTrait(ModTraits.polyshot); 
			
			materialMonolite.addItem("gemMonolite", 1, Material.VALUE_Ingot);
			materialMonolite.addItem("blockMonolite", 1, Material.VALUE_Block);
			materialMonolite.setCastable(false);
			materialMonolite.setCraftable(true);
			materialMonolite.setRepresentativeItem("gemMonolite");
			materialMonolite.addTrait(ModTraits.macrocrystaline);
			materialMonolite.addTrait(ModTraits.hardcore);
			materialMonolite.addTrait(ModTraits.luminescent);
			TinkerRegistry.addMaterialStats(materialMonolite, new HeadMaterialStats(1450, 14.5f, 14f, 6));
			TinkerRegistry.addMaterialStats(materialMonolite, new HandleMaterialStats(3f, -50));
			TinkerRegistry.addMaterialStats(materialMonolite, new ExtraMaterialStats(500));
			TinkerRegistry.addMaterialStats(materialMonolite, whyWouldYouMakeABowOutOfThis);
			TinkerRegistry.addMaterialStats(materialMonolite, new ArrowShaftMaterialStats(1.2f, 35));
		}
		if (CompatManager.aether_legacy) { // TODO add unique toolparts for various aether artifacts
			materialZanite.addItem("gemZanite", 1, Material.VALUE_Ingot);
			materialZanite.addItem("blockZanite", 1, Material.VALUE_Block);
			materialZanite.setCastable(false);
			materialZanite.setCraftable(true);
			materialZanite.setRepresentativeItem("gemZanite");
			materialZanite.addTrait(ModTraits.aetheric);
			materialZanite.addTrait(ModTraits.hardcore);
			materialZanite.addTrait(ModTraits.aetheric, HEAD);
			materialZanite.addTrait(ModTraits.treetap, HEAD);
			materialZanite.addTrait(TinkerTraits.jagged, HEAD);
			materialZanite.addTrait(ModTraits.hardcore, HEAD);
			TinkerRegistry.addMaterialStats(materialZanite, new HeadMaterialStats(210, 2.00f, 4.00f, 2));
			TinkerRegistry.addMaterialStats(materialZanite, new HandleMaterialStats(0.9f, 65));
			TinkerRegistry.addMaterialStats(materialZanite, new ExtraMaterialStats(50));
			TinkerRegistry.addMaterialStats(materialZanite, whyWouldYouMakeABowOutOfThis);

			materialSkyroot.addItem("plankWoodSkyroot", 1, Material.VALUE_Ingot);
			materialSkyroot.addItem("logWoodSkyroot", 1, Material.VALUE_Ingot * 4);
			materialSkyroot.addItem("stickWoodSkyroot", 1, Material.VALUE_Ingot / 2);
			materialSkyroot.setCastable(false);
			materialSkyroot.setCraftable(true);
			materialSkyroot.setRepresentativeItem("plankWoodSkyroot");
			materialSkyroot.addTrait(ModTraits.aetheric);
			materialSkyroot.addTrait(ModTraits.rootplicating, HEAD);
			materialSkyroot.addTrait(TinkerTraits.ecological, HEAD);
			materialSkyroot.addTrait(ModTraits.aetheric, HEAD);
			TinkerRegistry.addMaterialStats(materialSkyroot, new HeadMaterialStats(40, 2f, 2f, 0));
			TinkerRegistry.addMaterialStats(materialSkyroot, new HandleMaterialStats(1.2f, 25));
			TinkerRegistry.addMaterialStats(materialSkyroot, new ExtraMaterialStats(15));
			TinkerRegistry.addMaterialStats(materialSkyroot, new BowMaterialStats(0.6f, 1.1f, 2f));
			TinkerRegistry.addMaterialStats(materialSkyroot, new ArrowShaftMaterialStats(1.2f, 16));

			materialAmberwood.setCastable(false);
			materialAmberwood.setCraftable(false);
			materialAmberwood.addTrait(ModTraits.aetheric);
			materialAmberwood.addTrait(ModTraits.rootplicating, HEAD);
			materialAmberwood.addTrait(ModTraits.treetap, HEAD);
			materialAmberwood.addTrait(TinkerTraits.established, HEAD);
			materialAmberwood.addTrait(TinkerTraits.ecological);
			materialAmberwood.addTrait(TinkerTraits.writable);
			TinkerRegistry.addMaterialStats(materialAmberwood, new HeadMaterialStats(170, 4f, 4f, 2));
			TinkerRegistry.addMaterialStats(materialAmberwood, new HandleMaterialStats(1.2f, 125));
			TinkerRegistry.addMaterialStats(materialAmberwood, new ExtraMaterialStats(75));
			TinkerRegistry.addMaterialStats(materialAmberwood, new BowMaterialStats(0.7f, 1.6f, 3f));
			TinkerRegistry.addMaterialStats(materialAmberwood, new ArrowShaftMaterialStats(1.2f, 32));
			CompositeRegistry.registerComposite(() -> materialSkyroot, () -> materialAmberwood, () -> ModFluids.liquidGoldenAmber);

			materialArkenium.addCommonItems("Arkenium");
			materialArkenium.setFluid(ModFluids.liquidArkenium);
			materialArkenium.setCastable(true);
			materialArkenium.setCraftable(false);
			materialArkenium.addTrait(TinkerTraits.lightweight);
			materialArkenium.addTrait(TinkerTraits.holy, HEAD);
			materialArkenium.addTrait(TinkerTraits.sharp, HEAD);
			materialArkenium.addTrait(ModTraits.aetheric, HEAD);
			materialArkenium.addTrait(ModTraits.aetheric);
			materialArkenium.setRepresentativeItem("ingotArkenium");
			TinkerRegistry.addMaterialStats(materialArkenium, new HeadMaterialStats(1250, 10.0f, 5.25f, 4));
			TinkerRegistry.addMaterialStats(materialArkenium, new HandleMaterialStats(1.1f, 100));
			TinkerRegistry.addMaterialStats(materialArkenium, new ExtraMaterialStats(125));
			TinkerRegistry.addMaterialStats(materialArkenium, new ArrowShaftMaterialStats(3.5f, 25));
			TinkerRegistry.addMaterialStats(materialArkenium, new BowMaterialStats(0.5f, 2.75f, 3f));

			materialValkyrieMetal.addCommonItems("ValkyrieMetal");
			materialValkyrieMetal.setFluid(ModFluids.liquidValkyrieMetal);
			materialValkyrieMetal.setCastable(true);
			materialValkyrieMetal.setCraftable(false);
			materialValkyrieMetal.addTrait(ModTraits.reaching2, HEAD);
			materialValkyrieMetal.addTrait(ModTraits.treetap, HEAD);
			materialValkyrieMetal.addTrait(ModTraits.reaching);
			materialValkyrieMetal.addTrait(ModTraits.aetheric);
			materialValkyrieMetal.setRepresentativeItem("ingotValkyrieMetal");
			TinkerRegistry.addMaterialStats(materialValkyrieMetal, new HeadMaterialStats(1250, 10.0f, 5.25f, 4));
			TinkerRegistry.addMaterialStats(materialValkyrieMetal, new HandleMaterialStats(1.1f, 100));
			TinkerRegistry.addMaterialStats(materialValkyrieMetal, new ExtraMaterialStats(125));
			TinkerRegistry.addMaterialStats(materialValkyrieMetal, new ArrowShaftMaterialStats(3.5f, 25));
			TinkerRegistry.addMaterialStats(materialValkyrieMetal, new BowMaterialStats(0.5f, 2.75f, 3f));

			materialHolystone.addItem("holystone", 1, Material.VALUE_Ingot);
			materialHolystone.setCastable(false);
			materialHolystone.setCraftable(true);
			materialHolystone.setRepresentativeItem("holystone");
			materialHolystone.addTrait(TinkerTraits.cheapskate, HEAD);
			materialHolystone.addTrait(ModTraits.aetheric, HEAD);
			materialHolystone.addTrait(ModTraits.blessed, HEAD);
			materialHolystone.addTrait(ModTraits.aetheric);
			materialHolystone.addTrait(TinkerTraits.cheapskate);
			TinkerRegistry.addMaterialStats(materialHolystone, whyWouldYouMakeABowOutOfThis);
			TinkerRegistry.addMaterialStats(materialHolystone, new HeadMaterialStats(130, 3f, 3f, 1));
			TinkerRegistry.addMaterialStats(materialHolystone, new HandleMaterialStats(0.25f, -50));
			TinkerRegistry.addMaterialStats(materialHolystone, new ExtraMaterialStats(30));

			materialGravitite.addItem("blockGravitite", 1, Material.VALUE_Block);
			materialGravitite.addItem("gemGravitite", 1, Material.VALUE_Ingot);
			materialGravitite.setCastable(false);
			materialGravitite.setCraftable(true);
			materialGravitite.setRepresentativeItem("gemGravitite");
			materialGravitite.addTrait(TinkerTraits.insatiable);
			materialGravitite.addTrait(ModTraits.aetheric, HEAD);
			materialGravitite.addTrait(ModTraits.aetheric);
			materialGravitite.addTrait(ModTraits.antigravity, HEAD);
			materialGravitite.addTrait(ModTraits.treetap, HEAD);
			TinkerRegistry.addMaterialStats(materialGravitite, new HeadMaterialStats(950, 7.50f, 5.00f, 3));
			TinkerRegistry.addMaterialStats(materialGravitite, new HandleMaterialStats(0.9f, 90));
			TinkerRegistry.addMaterialStats(materialGravitite, new ExtraMaterialStats(90));
			TinkerRegistry.addMaterialStats(materialGravitite, whyWouldYouMakeABowOutOfThis);

			TinkerRegistry.addMaterialStats(materialSkybolt, new HeadMaterialStats(1070, 7.50f, 5.00f, 3));
			materialSkybolt.addTrait(ModTraits.boltforged);
		}
		if (CompatManager.twilightforest) { // TODO add carminite & more alloys
			materialIronwood.addCommonItems("Ironwood");
			materialIronwood.setCastable(true);
			materialIronwood.setFluid(ModFluids.liquidIronwood);
			materialIronwood.setCraftable(false);
			materialIronwood.setRepresentativeItem("ingotIronwood");
			materialIronwood.addTrait(TConstruct.twilit);
			materialIronwood.addTrait(ModTraits.shielding);
			materialIronwood.addTrait(TinkerTraits.ecological);
			TinkerRegistry.addMaterialStats(materialIronwood, new HeadMaterialStats(100, 10f, 5f, 4));
			TinkerRegistry.addMaterialStats(materialIronwood, new HandleMaterialStats(1f, 25));
			TinkerRegistry.addMaterialStats(materialIronwood, new ExtraMaterialStats(25));
			TinkerRegistry.addMaterialStats(materialIronwood, new ArrowShaftMaterialStats(1f, 1));
			TinkerRegistry.addMaterialStats(materialIronwood, new BowMaterialStats(0.75f, 2.75f, 3f));

			materialFerroherb.setCastable(false);
			materialFerroherb.setCraftable(false);
			materialFerroherb.addTrait(TConstruct.synergy);
			materialFerroherb.addTrait(TConstruct.twilit);
			materialFerroherb.addTrait(TinkerTraits.ecological);
			materialFerroherb.addTrait(TConstruct.twilit, HEAD);
			materialFerroherb.addTrait(TinkerTraits.ecological, HEAD);
			materialFerroherb.addTrait(TinkerTraits.sharp, HEAD);
			materialFerroherb.addTrait(TinkerTraits.splintering, HEAD);
			TinkerRegistry.addMaterialStats(materialFerroherb, new HeadMaterialStats(200, 10f, 7f, 4));
			TinkerRegistry.addMaterialStats(materialFerroherb, new HandleMaterialStats(1.125f, 100));
			TinkerRegistry.addMaterialStats(materialFerroherb, new ExtraMaterialStats(125));
			TinkerRegistry.addMaterialStats(materialFerroherb, new ArrowShaftMaterialStats(1f, 25));
			TinkerRegistry.addMaterialStats(materialFerroherb, new BowMaterialStats(0.7f, 2.75f, 4f));
			CompositeRegistry.registerComposite(() -> TConstruct.steeleaf, () -> materialFerroherb, () -> ModFluids.liquidIronwood);

			materialPenguinite.addCommonItems("Penguinite");
			materialPenguinite.setCastable(true);
			materialPenguinite.setFluid(ModFluids.liquidPenguinite);
			materialPenguinite.setCraftable(false);
			materialPenguinite.setRepresentativeItem("ingotPenguinite");
			materialPenguinite.addTrait(TConstruct.twilit);
			materialPenguinite.addTrait(TinkerTraits.coldblooded);
			materialPenguinite.addTrait(TinkerTraits.freezing);
			TinkerRegistry.addMaterialStats(materialPenguinite, new HeadMaterialStats(100, 10f, 7f, 4));
			TinkerRegistry.addMaterialStats(materialPenguinite, new HandleMaterialStats(1f, 25));
			TinkerRegistry.addMaterialStats(materialPenguinite, new ExtraMaterialStats(25));
			TinkerRegistry.addMaterialStats(materialPenguinite, new ArrowShaftMaterialStats(1f, 1));
			TinkerRegistry.addMaterialStats(materialPenguinite, new BowMaterialStats(0.7f, 1f, 2f));
		}

		if (CompatManager.thebetweenlands) {
			materialSyrmorite.addItem("oreSyrmorite", 1, Material.VALUE_Ore());
			materialSyrmorite.setFluid(ModFluids.liquidSyrmorite);
			materialSyrmorite.addCommonItems("Syrmorite");
			materialSyrmorite.setCastable(true);
			materialSyrmorite.setCraftable(false);
			materialSyrmorite.setRepresentativeItem("ingotSyrmorite");
			materialSyrmorite.addTrait(TinkerTraits.coldblooded);
			materialSyrmorite.addTrait(TinkerTraits.magnetic);
			TinkerRegistry.addMaterialStats(materialSyrmorite, new HeadMaterialStats(800, 5f, 4f, 2));
			TinkerRegistry.addMaterialStats(materialSyrmorite, new HandleMaterialStats(0.8f, 60));
			TinkerRegistry.addMaterialStats(materialSyrmorite, new ExtraMaterialStats(-25));
			TinkerRegistry.addMaterialStats(materialSyrmorite, new BowMaterialStats(0.7f, 1f, 3f));

			materialRotiron.setFluid(ModFluids.liquidRotiron);
			materialRotiron.addCommonItems("Rotiron");
			materialRotiron.setCastable(true);
			materialRotiron.setCraftable(false);
			materialRotiron.setRepresentativeItem("ingotRotiron");
			materialRotiron.addTrait(ModTraits.oxide, HEAD);
			materialRotiron.addTrait(ModTraits.rotten, HEAD);
			materialRotiron.addTrait(TinkerTraits.dense);
			materialRotiron.addTrait(TinkerTraits.magnetic);
			TinkerRegistry.addMaterialStats(materialRotiron, new HeadMaterialStats(850, 5.25f, 5f, 2));
			TinkerRegistry.addMaterialStats(materialRotiron, new HandleMaterialStats(1.125f, 45));
			TinkerRegistry.addMaterialStats(materialRotiron, new ExtraMaterialStats(-20));
			TinkerRegistry.addMaterialStats(materialRotiron, new BowMaterialStats(0.7f, 1f, 4f));

			materialSwampSteel.setFluid(ModFluids.liquidSwampSteel);
			materialSwampSteel.addCommonItems("Swampsteel");
			materialSwampSteel.setCastable(true);
			materialSwampSteel.setCraftable(false);
			materialSwampSteel.setRepresentativeItem("ingotSwampsteel");
			materialSwampSteel.addTrait(ModTraits.corroding, HEAD);
			materialSwampSteel.addTrait(TinkerTraits.dense, HEAD);
			materialSwampSteel.addTrait(TinkerTraits.established);
			materialSwampSteel.addTrait(TinkerTraits.heavy);
			TinkerRegistry.addMaterialStats(materialSwampSteel, new HeadMaterialStats(1200, 5.25f, 4.5f, 3));
			TinkerRegistry.addMaterialStats(materialSwampSteel, new HandleMaterialStats(0.9f, 80));
			TinkerRegistry.addMaterialStats(materialSwampSteel, new ExtraMaterialStats(-12));
			TinkerRegistry.addMaterialStats(materialSwampSteel, new BowMaterialStats(0.7f, 1f, 4f));

			materialOctine.addItem("oreOctine", 1, Material.VALUE_Ore());
			materialOctine.setFluid(ModFluids.liquidOctine);
			materialOctine.addCommonItems("Octine");
			materialOctine.setCastable(true);
			materialOctine.setCraftable(false);
			materialOctine.setRepresentativeItem("ingotOctine");
			materialOctine.addTrait(TinkerTraits.superheat);
			materialOctine.addTrait(ModTraits.burning);
			TinkerRegistry.addMaterialStats(materialOctine, new HeadMaterialStats(900, 5f, 4f, 2));
			TinkerRegistry.addMaterialStats(materialOctine, new HandleMaterialStats(1.25f, -50));
			TinkerRegistry.addMaterialStats(materialOctine, new ExtraMaterialStats(-25));
			TinkerRegistry.addMaterialStats(materialOctine, new BowMaterialStats(0.7f, 1f, 3f));

			materialValonite.addItem("gemValonite", 1, Material.VALUE_Ingot);
			materialValonite.addItem("blockValonite", 1, Material.VALUE_Block);
			materialValonite.addItem("nuggetValonite", 1, Material.VALUE_Nugget);
			materialValonite.setCastable(false);
			materialValonite.setCraftable(true);
			materialValonite.setRepresentativeItem("gemValonite");
			materialValonite.addTrait(TinkerTraits.dense);
			materialValonite.addTrait(ModTraits.shielding);
			materialValonite.addTrait(TinkerTraits.sharp);
			TinkerRegistry.addMaterialStats(materialValonite, new HeadMaterialStats(975, 6f, 6.125f, 3));
			TinkerRegistry.addMaterialStats(materialValonite, new HandleMaterialStats(1f, -75));
			TinkerRegistry.addMaterialStats(materialValonite, new ExtraMaterialStats(-25));
			TinkerRegistry.addMaterialStats(materialValonite, whyWouldYouMakeABowOutOfThis);

			materialEmberlight.setCastable(false);
			materialEmberlight.setCraftable(false);
			materialEmberlight.addTrait(TinkerTraits.dense);
			materialEmberlight.addTrait(TinkerTraits.sharp);
			materialEmberlight.addTrait(ModTraits.hardcore);
			materialEmberlight.addTrait(ModTraits.burning);
			materialEmberlight.addTrait(ModTraits.resilient);
			TinkerRegistry.addMaterialStats(materialEmberlight, new HeadMaterialStats(1200, 7.0f, 6.5f, 4));
			TinkerRegistry.addMaterialStats(materialEmberlight, new HandleMaterialStats(2.0f, 20));
			TinkerRegistry.addMaterialStats(materialEmberlight, new ExtraMaterialStats(12));
			CompositeRegistry.registerComposite(() -> materialValonite, () -> materialEmberlight, () -> ModFluids.liquidEmber);
			TinkerRegistry.addMaterialStats(materialEmberlight, whyWouldYouMakeABowOutOfThis);

			materialSlimyBone.addItem("gemSlimyBone", 1, Material.VALUE_Ingot);
			materialSlimyBone.addItem("blockSlimyBone", 1, Material.VALUE_Block);
			materialSlimyBone.setCastable(false);
			materialSlimyBone.setCraftable(true);
			materialSlimyBone.setRepresentativeItem("gemSlimyBone");
			materialSlimyBone.addTrait(TinkerTraits.splintering);
			materialSlimyBone.addTrait(TinkerTraits.cheap);
			materialSlimyBone.addTrait(TinkerTraits.cheapskate);
			materialSlimyBone.addTrait(TinkerTraits.crude);
			TinkerRegistry.addMaterialStats(materialSlimyBone, new HeadMaterialStats(275, 3f, 3f, 1));
			TinkerRegistry.addMaterialStats(materialSlimyBone, new HandleMaterialStats(1.1f, 25));
			TinkerRegistry.addMaterialStats(materialSlimyBone, new ExtraMaterialStats(5));
			TinkerRegistry.addMaterialStats(materialSlimyBone, whyWouldYouMakeABowOutOfThis);

			materialReedRope.addItem("ropeReed", 1, Material.VALUE_Ingot);
			materialReedRope.setCastable(false);
			materialReedRope.setCraftable(true);
			materialReedRope.setRepresentativeItem("ropeReed");
			materialReedRope.addTrait(TinkerTraits.ecological);
			materialReedRope.addTrait(TinkerTraits.aquadynamic);
			materialReedRope.addTrait(TinkerTraits.writable2);
			TinkerRegistry.addMaterialStats(materialReedRope, new BowStringMaterialStats(2f));
			TinkerRegistry.addMaterialStats(materialReedRope, new FletchingMaterialStats(0.85f, 0.35f));

			materialDragonFlyWing.addItem("itemDragonFlyWing", 1, Material.VALUE_Ingot);
			materialDragonFlyWing.setCastable(false);
			materialDragonFlyWing.setCraftable(true);
			materialDragonFlyWing.setRepresentativeItem("itemDragonFlyWing");
			materialDragonFlyWing.addTrait(TinkerTraits.lightweight);
			TinkerRegistry.addMaterialStats(materialDragonFlyWing, new FletchingMaterialStats(1f, 0.75f));

			materialAnglerTooth.addItem("itemAnglerTooth", 1, Material.VALUE_Ingot);
			materialAnglerTooth.setCastable(false);
			materialAnglerTooth.setCraftable(true);
			materialAnglerTooth.setRepresentativeItem("itemAnglerTooth");
			materialAnglerTooth.addTrait(TinkerTraits.aquadynamic);
			materialAnglerTooth.addTrait(TinkerTraits.jagged);
			TinkerRegistry.addMaterialStats(materialAnglerTooth, new HeadMaterialStats(128, 2f, 5f, 1));
			TinkerRegistry.addMaterialStats(materialAnglerTooth, whyWouldYouMakeABowOutOfThis);

			materialWeedwood.addItem("plankWoodWeedwood", 1, Material.VALUE_Ingot);
			materialWeedwood.addItem("logWoodWeedwood", 1, Material.VALUE_Ingot * 4);
			materialWeedwood.addItem("stickWoodWeedwood", 1, Material.VALUE_Ingot / 2);
			materialWeedwood.setCastable(false);
			materialWeedwood.setCraftable(true);
			materialWeedwood.setRepresentativeItem("plankWoodWeedwood");
			materialWeedwood.addTrait(TinkerTraits.ecological);
			TinkerRegistry.addMaterialStats(materialWeedwood, new HeadMaterialStats(40, 2f, 2f, 0));
			TinkerRegistry.addMaterialStats(materialWeedwood, new HandleMaterialStats(1.2f, 25));
			TinkerRegistry.addMaterialStats(materialWeedwood, new ExtraMaterialStats(15));
			TinkerRegistry.addMaterialStats(materialWeedwood, new BowMaterialStats(0.8f, 1.1f, 2f));
			TinkerRegistry.addMaterialStats(materialWeedwood, new ArrowShaftMaterialStats(1.2f, 16));

			TinkerRegistry.addMaterialStats(materialShockwave, new HeadMaterialStats(1256, 6f, 6.125f, 3));
			materialShockwave.addTrait(ModTraits.shockwaving);

			TinkerRegistry.addMaterialStats(materialWormed, new HeadMaterialStats(1024, 1f, 5f, 1));
			materialWormed.addTrait(ModTraits.wormed);
			
			materialAncientAlloy.setFluid(ModFluids.liquidAncientAlloy);
			materialAncientAlloy.addCommonItems("AncientAlloy");
			materialAncientAlloy.setCastable(true);
			materialAncientAlloy.setCraftable(false);
			materialAncientAlloy.setRepresentativeItem("ingotAncientAlloy");
			materialAncientAlloy.addTrait(TinkerTraits.dense, HEAD);
			materialAncientAlloy.addTrait(ModTraits.inertia, HEAD);
			materialAncientAlloy.addTrait(TinkerTraits.heavy);
			TinkerRegistry.addMaterialStats(materialAncientAlloy, new HeadMaterialStats(1000, 5.5f, 5.5f, 3));
			TinkerRegistry.addMaterialStats(materialAncientAlloy, new HandleMaterialStats(1f, 125));
			TinkerRegistry.addMaterialStats(materialAncientAlloy, new ExtraMaterialStats(40));
			TinkerRegistry.addMaterialStats(materialAncientAlloy, new BowMaterialStats(0.6f, 1.25f, 4f));
		}
	}

	public static void init() {
		initMats();

		if (CompatManager.plustic) {
			ModMaterials.registerMaterial(materialCrimson);
		}
		if (CompatManager.easterEggs) {
			ModMaterials.registerMaterial(materialTechnoblade);
		}
		if (CompatManager.loadMain) {
			ModMaterials.registerMaterial(materialZracohlium).toolforge();
			ModMaterials.registerMaterial(materialPlasma, null);
			ModMaterials.registerMaterial(materialFusionite).toolforge();
			ModMaterials.registerMaterial(materialValasium).toolforge();
			ModMaterials.registerMaterial(materialSpaceTimeDisruption, null);
			ModMaterials.registerMaterial(materialVoidSpar, "VoidSpar").toolforge();
			ModMaterials.registerMaterial(materialEnderal).toolforge();
			ModMaterials.registerMaterial(materialIrradium).toolforge();
			ModMaterials.registerMaterial(materialSolsteel).toolforge();
			ModMaterials.registerMaterial(materialGallium).toolforge();
			ModMaterials.registerMaterial(materialEnderexamite, null);
			ModMaterials.registerMaterial(materialGarstone).toolforge();
			ModMaterials.registerMaterial(materialRuneSteel).toolforge();
			ModMaterials.registerMaterial(materialGravitonium).toolforge();
			ModMaterials.registerMaterial(materialTrichromadentium).toolforge();
			ModMaterials.registerMaterial(materialTriblade, null);
			ModMaterials.registerMaterial(materialMirrored, null);
			ModMaterials.registerMaterial(materialTrailblazer, null);
			ModMaterials.registerMaterial(materialBloodstone).toolforge();
			ModMaterials.registerMaterial(materialEchostone).toolforge();
			ModMaterials.registerMaterial(materialIgniglomerate).toolforge();
			ModMaterials.registerMaterial(materialAtronium).toolforge();
			ModMaterials.registerMaterial(materialEbonite).toolforge();
			ModMaterials.registerMaterial(materialErythynite).toolforge();
			ModMaterials.registerMaterial(materialShadowglass, null);
			ModMaterials.registerMaterial(materialEtherstone).toolforge();
			ModMaterials.registerMaterial(materialMonolite).toolforge();
			ModMaterials.registerMaterial(materialEssencore, null);
			ModMaterials.registerMaterial(materialElectarite).toolforge();
			ModMaterials.registerMaterial(materialHallowsite).toolforge();
			ModMaterials.registerMaterial(materialQuakestruck, null);
			ModMaterials.registerMaterial(materialCryosplinters, null);
			ModMaterials.registerMaterial(materialBlightsteel).toolforge();
			ModMaterials.registerMaterial(materialSanguiseelium).toolforge();
			ModMaterials.registerMaterial(materialAutoloader, null);
			ModMaterials.registerMaterial(materialVengeance, null);
			ModMaterials.registerMaterial(materialDematerializer, null);
			ModMaterials.registerMaterial(materialIoximite, null);
			ModMaterials.registerMaterial(materialShotgun, null);
		}
		if (CompatManager.tic3backport) {
			ModMaterials.registerMaterial(materialNahuatl, null);
			ModMaterials.registerMaterial(materialSlimewood, null);
			ModMaterials.registerMaterial(materialSearedStone, null);
			ModMaterials.registerMaterial(materialSlimesteel, null);
		}

		if (CompatManager.twilightforest) {
			ModMaterials.registerMaterial(materialIronwood).toolforge();
			ModMaterials.registerMaterial(materialPenguinite).toolforge();
			ModMaterials.registerMaterial(materialFerroherb, null);
		}
		if (CompatManager.aether_legacy) {
			ModMaterials.registerMaterial(materialArkenium).toolforge();
			ModMaterials.registerMaterial(materialSkyroot, null);
			ModMaterials.registerMaterial(materialHolystone, null);
			ModMaterials.registerMaterial(materialZanite).toolforge();
			ModMaterials.registerMaterial(materialGravitite).toolforge();
			ModMaterials.registerMaterial(materialValkyrieMetal, "ValkyrieMetal").toolforge();
			ModMaterials.registerMaterial(materialAmberwood, null);
			ModMaterials.registerMaterial(materialSkybolt, null);
		}
		if (CompatManager.thebetweenlands) {
			ModMaterials.registerMaterial(materialShockwave, null);
			ModMaterials.registerMaterial(materialSyrmorite).toolforge();
			ModMaterials.registerMaterial(materialOctine).toolforge();
			ModMaterials.registerMaterial(materialValonite).toolforge();
			ModMaterials.registerMaterial(materialReedRope, null);
			ModMaterials.registerMaterial(materialDragonFlyWing, null);
			ModMaterials.registerMaterial(materialAnglerTooth, null);
			ModMaterials.registerMaterial(materialWeedwood, null);
			ModMaterials.registerMaterial(materialSlimyBone, "SlimyBone").toolforge();
			ModMaterials.registerMaterial(materialSwampSteel).toolforge();
			ModMaterials.registerMaterial(materialRotiron).toolforge();
			ModMaterials.registerMaterial(materialEmberlight, null);
			ModMaterials.registerMaterial(materialWormed, null);
			ModMaterials.registerMaterial(materialAncientAlloy).toolforge();

			MaterialUtils.readdTinkerMaterial(TinkerMaterials.bone);

		}
		MoreTConLogger.log("Loaded a total of " + totalMaterials + " different TConstruct Materials.");
	}

	public static MaterialIntegration registerMaterial(Material material) {
		String mat = material.getIdentifier().replaceFirst(ModInfo.MODID + ".", "");
		return registerMaterials(material, material.getFluid(), mat.substring(0, 1).toUpperCase() + mat.substring(1));
	}

	public static MaterialIntegration registerMaterial(Material material, String suffix) {
		return registerMaterials(material, material.getFluid(), suffix, suffix == null ? null : ("ingot" + suffix));
	}

	public static MaterialIntegration registerMaterial(Material material, String suffix, String... requiredOreDicts) {
		return registerMaterials(material, material.getFluid(), suffix, requiredOreDicts);
	}

	public static MaterialIntegration registerMaterials(Material material, Fluid fluid, String suffix, String... requiredOreDicts) {
		MaterialIntegration integration = new MTMaterialIntegration(material, fluid, suffix, requiredOreDicts.length == 0 ? new String[1] : requiredOreDicts);
		if (RegisterHelper.registerMaterial(integration, false)) {
			totalMaterials++;
		}
		return integration;
	}
}
