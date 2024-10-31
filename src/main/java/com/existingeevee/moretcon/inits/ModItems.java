package com.existingeevee.moretcon.inits;

import com.existingeevee.moretcon.config.ConfigHandler;
import com.existingeevee.moretcon.item.ItemBase;
import com.existingeevee.moretcon.item.ItemCompositeRep;
import com.existingeevee.moretcon.item.ItemDebugTool;
import com.existingeevee.moretcon.item.ItemNonflamable;
import com.existingeevee.moretcon.item.ItemReforgeStone;
import com.existingeevee.moretcon.other.ICustomSlotRenderer.GlowType;
import com.existingeevee.moretcon.other.ModTabs;
import com.existingeevee.moretcon.other.utils.CompatManager;
import com.existingeevee.moretcon.other.utils.RegisterHelper;

import net.minecraft.item.Item;

public class ModItems {
	public static int totalItems;
	/*---------------------------------------*/

	//Metals
	public static final Item nuggetHallowsite = new ItemBase("nuggetHallowsite");
	public static final Item ingotHallowsite = new ItemBase("ingotHallowsite");
	public static final Item dustHallowsite = new ItemBase("dustHallowsite");

	public static final Item nuggetSanguiseelium = new ItemBase("nuggetSanguiseelium");
	public static final Item ingotSanguiseelium = new ItemBase("ingotSanguiseelium");
	public static final Item dustSanguiseelium = new ItemBase("dustSanguiseelium");

	public static final Item nuggetFusionite = new ItemBase("nuggetFusionite", 0x0000ff);
	public static final Item ingotFusionite = new ItemBase("ingotFusionite", GlowType.OVAL, 0x0000ff);
	public static final Item dustFusionite = new ItemBase("dustFusionite", GlowType.CIRCLE_BIG, 0x0000ff);

	public static final Item nuggetValasium = new ItemBase("nuggetValasium");
	public static final Item ingotValasium = new ItemBase("ingotValasium");
	public static final Item dustValasium = new ItemBase("dustValasium");

	public static final Item nuggetRotiron = new ItemBase("nuggetRotiron");
	public static final Item ingotRotiron = new ItemBase("ingotRotiron");
	public static final Item dustRotiron = new ItemBase("dustRotiron");

	public static final Item nuggetSwampSteel = new ItemBase("nuggetSwampSteel");
	public static final Item ingotSwampSteel = new ItemBase("ingotSwampSteel");
	public static final Item dustSwampSteel = new ItemBase("dustSwampSteel");

	public static final Item ingotGallium = new ItemBase("ingotGallium");
	public static final Item nuggetGallium = new ItemBase("nuggetGallium");
	public static final Item dustGallium = new ItemBase("dustGallium");

	public static final Item nuggetIrradium = new ItemBase("nuggetIrradium", 0x00ed00);
	public static final Item dustIrradium = new ItemBase("dustIrradium", GlowType.CIRCLE_BIG, 0x00ed00);
	public static final Item ingotIrradium = new ItemBase("ingotIrradium", GlowType.OVAL, 0x00ed00);

	public static final Item ingotGravitonium = new ItemBase("ingotGravitonium", GlowType.OVAL, 0x00a000);
	public static final Item nuggetGravitonium = new ItemBase("nuggetGravitonium", 0x00a000);
	public static final Item dustGravitonium = new ItemBase("dustGravitonium", GlowType.CIRCLE_BIG, 0x00a000);

	public static final Item ingotRuneSteel = new ItemBase("ingotRuneSteel");
	public static final Item dustRuneSteel = new ItemBase("dustRuneSteel");
	public static final Item nuggetRuneSteel = new ItemBase("nuggetRuneSteel");

	public static final Item nuggetSolsteel = new ItemNonflamable("nuggetSolarSteel").withColor(0xffb200).withType(GlowType.EXTREME);
	public static final Item ingotSolsteel = new ItemNonflamable("ingotSolarSteel").withColor(0xffb200).withType(GlowType.EXTREME);
	public static final Item dustSolarSteel = new ItemNonflamable("dustSolarSteel").withColor(0xffb200).withType(GlowType.EXTREME);

	public static final Item ingotValkyrieMetal = new ItemBase("ingotValkyrieMetal");
	public static final Item nuggetValkyrieMetal = new ItemBase("nuggetValkyrieMetal");
	public static final Item dustValkyrieMetal = new ItemBase("dustValkyrieMetal");

	public static final Item nuggetPenguinite = new ItemBase("nuggetPenguinite");
	public static final Item ingotPenguinite = new ItemBase("ingotPenguinite");
	public static final Item dustPenguinite = new ItemBase("dustPenguinite");

	public static final Item ingotArkenium = new ItemBase("ingotArkenium");
	public static final Item nuggetArkenium = new ItemBase("nuggetArkenium");
	public static final Item dustArkenium = new ItemBase("dustArkenium");

	public static final Item ingotAtronium = new ItemBase("ingotAtronium");
	public static final Item nuggetAtronium = new ItemBase("nuggetAtronium");
	public static final Item dustAtronium = new ItemBase("dustAtronium");

	public static final Item ingotEbonite = new ItemBase("ingotEbonite", GlowType.OVAL, 0x270339);
	public static final Item nuggetEbonite = new ItemBase("nuggetEbonite", 0x270339);
	public static final Item dustEbonite = new ItemBase("dustEbonite", GlowType.CIRCLE_BIG, 0x270339);

	public static final Item ingotSlimesteel = new ItemBase("ingotSlimesteel");
	public static final Item nuggetSlimesteel = new ItemBase("nuggetSlimesteel");
	public static final Item dustSlimesteel = new ItemBase("dustSlimesteel");
	
	public static final Item carbonPile = new ItemBase("carbonPile").setTab(ModTabs.moarTConMisc);
	public static final Item ingotSteel = new ItemBase("ingotSteel");
	public static final Item nuggetSteel = new ItemBase("nuggetSteel");
	public static final Item dustSteel = new ItemBase("dustSteel");
	public static final Item rawSteel = new ItemBase("rawSteel").setTab(ModTabs.moarTConMisc);

	public static final Item ingotTrichromadentium = new ItemBase("ingotTrichromadentium", GlowType.OVAL, 0xffffff);
	public static final Item nuggetTrichromadentium = new ItemBase("nuggetTrichromadentium", 0xffffff);
	public static final Item dustTrichromadentium = new ItemBase("dustTrichromadentium", GlowType.CIRCLE_BIG, 0xffffff);

	public static final Item ingotBlightsteel = new ItemBase("ingotBlightsteel");
	public static final Item nuggetBlightsteel = new ItemBase("nuggetBlightsteel");
	public static final Item dustBlightsteel = new ItemBase("dustBlightsteel");

	public static final Item ingotZracohlium = new ItemBase("ingotZracohlium");
	public static final Item nuggetZracohlium = new ItemBase("nuggetZracohlium");
	public static final Item dustZracohlium = new ItemBase("dustZracohlium");

	public static final Item ingotAncientAlloy = new ItemBase("ingotAncientAlloy");
	public static final Item nuggetAncientAlloy = new ItemBase("nuggetAncientAlloy");
	public static final Item dustAncientAlloy = new ItemBase("dustAncientAlloy");
	public static final Item itemAncientScrap = new ItemBase("itemAncientScrap");
	public static final Item itemAncientSlag = new ItemBase("itemAncientSlag");

	public static final Item dustIronwood = new ItemBase("dustIronwood");

	public static final Item dustFiery = new ItemBase("dustFiery");

	public static final Item dustKnightmetal = new ItemBase("dustKnightmetal");

	public static final Item dustOctine = new ItemBase("dustOctine");

	public static final Item dustSyrmorite = new ItemBase("dustSyrmorite");

	//Gems
	public static final Item gemVoidSpar = new ItemBase("gemVoidSpar", 0x7e15ff);
	public static final Item gemEnderal = new ItemBase("gemEnderal", GlowType.CIRCLE_BIG, 0x2b0082);
	public static final Item gemGarstone = new ItemBase("gemGarstone", GlowType.OVAL, 0xff0000);
	public static final Item gemBloodstone = new ItemBase("gemBloodstone");
	public static final Item gemEchostone = new ItemBase("gemEchostone", 0x00725a);
	public static final Item gemIgniglomerate = new ItemNonflamable("gemIgniglomerate").withColor(0xda6540).withType(GlowType.EXTREME);
	public static final Item gemErythynite = new ItemBase("gemErythynite", GlowType.CIRCLE_BIG, 0x32ff00);
	public static final Item gemEtherstone = new ItemBase("gemEtherstone", GlowType.CIRCLE_BIG, 0xffff00);
	public static final Item gemElectarite = new ItemBase("gemElectarite", GlowType.CIRCLE_BIG, 0x6666ff);
	public static final Item gemMonolite = new ItemBase("gemMonolite", GlowType.CIRCLE_BIG, 0x4a74f0);

	//Ingriedients
	public static final Item itemSiltClay = new ItemBase("itemSiltClay").setTab(ModTabs.moarTConMisc);
	public static final Item spaceTimeDisruptionPowder = new ItemBase("spaceTimeDisruptionPowder", GlowType.CIRCLE_BIG, 0).setTab(ModTabs.moarTConMisc);
	public static final Item hydrogenRichRedstonePowder = new ItemBase("hydrogenRichRedstonePowder", GlowType.CIRCLE_BIG, 0xff0000).setTab(ModTabs.moarTConMisc);
	public static final Item crushedShockwaveSword = new ItemBase("crushedShockwaveSword").setTab(ModTabs.moarTConMisc);
	public static final Item matterReconstructionGel = new ItemBase("matterReconstructionGel").setTab(ModTabs.moarTConMisc);
	public static final Item sulfurBucketSyrmorite = new ItemBase("sulfurBucketSyrmorite").setTab(ModTabs.moarTConMisc).setMaxStackSize(1);
	public static final Item sulfurBucketIron = new ItemBase("sulfurBucketIron").setTab(ModTabs.moarTConMisc).setMaxStackSize(1);
	public static final Item betweenicCore = new ItemBase("betweenicCore", 0x3a2f24).setTab(ModTabs.moarTConMisc);
	public static final Item solidLightning = new ItemBase("solidLightning", 0xb4e5ff).setTab(ModTabs.moarTConMisc);

	//Modifier items
	public static final Item betweenifiedModifier = new ItemBase("betweenifiedModifier").setTab(ModTabs.moarTConMisc);
	public static final Item crushingModifier = new ItemBase("crushingModifier").setTab(ModTabs.moarTConMisc);

	//Reforge stones
	public static final Item reforgeHeavy = new ItemReforgeStone("reforgeheavy", () -> ModReforges.reforgeHeavy);
	public static final Item reforgeSharpened = new ItemReforgeStone("reforgesharpened", () -> ModReforges.reforgeSharpened);
	public static final Item reforgeConsistant = new ItemReforgeStone("reforgeconsistant", () -> ModReforges.reforgeConsistant);

	/*---------------------------------------*/

	public static void registerItems(Item... items) {
		for (Item i : items) {
			ModItems.addItem(i);
		}
	}

	public static void init() {
		ModItems.registerItems(
				new ItemCompositeRep(),
				new ItemDebugTool()
		);

		if (CompatManager.tic3backport) {
			ModItems.registerItems(
					ingotSlimesteel,
					nuggetSlimesteel
			);
			if (ConfigHandler.shouldLoadDust) {
				ModItems.registerItems(
						dustSlimesteel
				);
			}
		}

		if (CompatManager.loadMain) {
			ModItems.registerItems(
					ingotFusionite,
					nuggetFusionite,

					ingotValasium,
					nuggetValasium,

					ingotIrradium,
					nuggetIrradium,

					ingotSolsteel,
					nuggetSolsteel,

					ingotGallium,
					nuggetGallium,

					ingotSteel,
					nuggetSteel,

					ingotGravitonium,
					nuggetGravitonium,

					ingotRuneSteel,
					nuggetRuneSteel,

					ingotTrichromadentium,
					nuggetTrichromadentium,

					ingotAtronium,
					nuggetAtronium,

					ingotEbonite,
					nuggetEbonite,

					ingotHallowsite,
					nuggetHallowsite,

					ingotBlightsteel,
					nuggetBlightsteel,

					ingotSanguiseelium,
					nuggetSanguiseelium,

					ingotZracohlium,
					nuggetZracohlium,

					gemVoidSpar,
					gemEnderal,
					gemGarstone,
					gemBloodstone,
					gemEchostone,
					gemIgniglomerate,
					gemErythynite,
					gemEtherstone,
					gemElectarite,
					gemMonolite,

					crushingModifier,
					matterReconstructionGel,
					carbonPile,
					rawSteel,
					spaceTimeDisruptionPowder,
					hydrogenRichRedstonePowder,
					solidLightning,

					reforgeHeavy,
					reforgeSharpened,
					reforgeConsistant
			);
			if (ConfigHandler.shouldLoadDust) {
				ModItems.registerItems(
						dustFusionite,
						dustValasium,
						dustIrradium,
						dustSolarSteel,
						dustGallium,
						dustSteel,
						dustGravitonium,
						dustRuneSteel,
						dustTrichromadentium,
						dustAtronium,
						dustEbonite,
						dustHallowsite,
						dustBlightsteel,
						dustSanguiseelium,
						dustZracohlium
						);
			}
		}
		if (CompatManager.twilightforest) {
			ModItems.registerItems(
					nuggetPenguinite,
					ingotPenguinite);
			if (ConfigHandler.shouldLoadDust && ConfigHandler.shouldLoadDustForCompatability) {
				ModItems.registerItems(
						dustPenguinite,
						dustIronwood,
						dustFiery,
						dustKnightmetal);
			}
		}

		if (CompatManager.thebetweenlands) {
			ModItems.registerItems(
					ingotRotiron,
					nuggetRotiron,

					ingotSwampSteel,
					nuggetSwampSteel,

					ingotAncientAlloy,
					nuggetAncientAlloy,
					itemAncientScrap,
					itemAncientSlag,

					itemSiltClay,
					crushedShockwaveSword,

					sulfurBucketSyrmorite,
					sulfurBucketIron,

					betweenifiedModifier,
					betweenicCore

			);
			if (ConfigHandler.shouldLoadDust && ConfigHandler.shouldLoadDustForCompatability) {
				ModItems.registerItems(
						dustOctine,
						dustSyrmorite,
						dustRotiron,
						dustSwampSteel,
						dustAncientAlloy

						);
			}

		}

		if (CompatManager.aether_legacy) {
			ModItems.registerItems(
					ingotArkenium,
					nuggetArkenium,
					ingotValkyrieMetal,
					nuggetValkyrieMetal);
			if (ConfigHandler.shouldLoadDust && ConfigHandler.shouldLoadDustForCompatability) {
				ModItems.registerItems(
						dustArkenium,
						dustValkyrieMetal);
			}

		}
		//Logging.log("Loaded a total of " + totalItems + " different items.");
	}

	private static void addItem(Item item) {
		RegisterHelper.registerItem(item);
		totalItems++;
	}
}
