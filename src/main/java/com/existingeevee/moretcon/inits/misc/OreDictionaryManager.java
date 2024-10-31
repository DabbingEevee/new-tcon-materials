package com.existingeevee.moretcon.inits.misc;

import com.existingeevee.moretcon.config.ConfigHandler;
import com.existingeevee.moretcon.inits.ModBlocks;
import com.existingeevee.moretcon.inits.ModItems;
import com.existingeevee.moretcon.other.utils.CompatManager;
import com.gildedgames.the_aether.blocks.BlocksAether;
import com.gildedgames.the_aether.items.ItemsAether;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;
import thebetweenlands.common.item.misc.ItemMisc.EnumItemMisc;
import thebetweenlands.common.registries.BlockRegistry;
import twilightforest.block.TFBlocks;

public class OreDictionaryManager {
	public static void preInit() {
		registerOre("gemCoal", new ItemStack(Items.COAL));

		if (CompatManager.tic3backport) {
			registerOre("blockSlimesteel", ModBlocks.blockSlimesteel);
			registerOre("ingotSlimesteel", ModItems.ingotSlimesteel);
			registerOre("nuggetSlimesteel", ModItems.nuggetSlimesteel);

			if (ConfigHandler.shouldLoadDust) {
				registerOre("dustSlimesteel", ModItems.dustSlimesteel);
			}
		}	
		
		if (CompatManager.loadMain) {
			registerOre("blockFusionite", ModBlocks.blockFusionite);
			registerOre("oreFusionite", ModBlocks.oreFusionite);
			registerOre("oreFusionite", ModBlocks.oreBedrockFusionite);
			registerOre("ingotFusionite", ModItems.ingotFusionite);
			registerOre("nuggetFusionite", ModItems.nuggetFusionite);

			registerOre("blockTrichromadentium", ModBlocks.blockTrichromadentium);
			registerOre("ingotTrichromadentium", ModItems.ingotTrichromadentium);
			registerOre("nuggetTrichromadentium", ModItems.nuggetTrichromadentium);

			registerOre("blockValasium", ModBlocks.blockValasium);
			registerOre("ingotValasium", ModItems.ingotValasium);
			registerOre("nuggetValasium", ModItems.nuggetValasium);

			registerOre("blockAtronium", ModBlocks.blockAtronium);
			registerOre("ingotAtronium", ModItems.ingotAtronium);
			registerOre("nuggetAtronium", ModItems.nuggetAtronium);

			registerOre("blockGravitonium", ModBlocks.blockGravitonium);
			registerOre("oreGravitonium", ModBlocks.oreGravitonium);
			registerOre("oreGravitoniumDense", ModBlocks.oreGravitoniumDense);
			registerOre("ingotGravitonium", ModItems.ingotGravitonium);
			registerOre("nuggetGravitonium", ModItems.nuggetGravitonium);

			registerOre("blockSteel", ModBlocks.blockSteel);
			registerOre("ingotSteel", ModItems.ingotSteel);
			registerOre("nuggetSteel", ModItems.nuggetSteel);

			registerOre("blockGallium", ModBlocks.blockGallium);
			registerOre("oreGallium", ModBlocks.oreGallium);
			registerOre("ingotGallium", ModItems.ingotGallium);
			registerOre("nuggetGallium", ModItems.nuggetGallium);

			registerOre("blockRunesteel", ModBlocks.blockRuneSteel);
			registerOre("ingotRunesteel", ModItems.ingotRuneSteel);
			registerOre("nuggetRunesteel", ModItems.nuggetRuneSteel);

			registerOre("blockGarstone", ModBlocks.blockGarstone);
			registerOre("oreGarstone", ModBlocks.oreGarstone);
			registerOre("gemGarstone", ModItems.gemGarstone);

			registerOre("blockEnderal", ModBlocks.blockEnderal);
			registerOre("oreEnderal", ModBlocks.oreEnderal);
			registerOre("gemEnderal", ModItems.gemEnderal);

			registerOre("blockIrradium", ModBlocks.blockIrradium);
			registerOre("oreIrradium", ModBlocks.oreIrradium);
			registerOre("ingotIrradium", ModItems.ingotIrradium);
			registerOre("nuggetIrradium", ModItems.nuggetIrradium);

			registerOre("blockSolsteel", ModBlocks.blockSolsteel);
			registerOre("ingotSolsteel", ModItems.ingotSolsteel);
			registerOre("nuggetSolsteel", ModItems.nuggetSolsteel);

			registerOre("blockBlightsteel", ModBlocks.blockBlightsteel);
			registerOre("ingotBlightsteel", ModItems.ingotBlightsteel);
			registerOre("nuggetBlightsteel", ModItems.nuggetBlightsteel);

			registerOre("blockSolarsteel", ModBlocks.blockSolsteel);
			registerOre("ingotSolarsteel", ModItems.ingotSolsteel);
			registerOre("nuggetSolarsteel", ModItems.nuggetSolsteel);

			registerOre("blockEbonite", ModBlocks.blockEbonite);
			registerOre("oreEbonite", ModBlocks.oreEbonite);
			registerOre("ingotEbonite", ModItems.ingotEbonite);
			registerOre("nuggetEbonite", ModItems.nuggetEbonite);

			registerOre("blockSanguiseelium", ModBlocks.blockSanguiseelium);
			registerOre("ingotSanguiseelium", ModItems.ingotSanguiseelium);
			registerOre("nuggetSanguiseelium", ModItems.nuggetSanguiseelium);

			registerOre("blockVoidSpar", ModBlocks.blockVoidSpar);
			registerOre("gemVoidSpar", ModItems.gemVoidSpar);
			registerOre("oreVoidSpar", ModBlocks.oreVoidSpar);
			registerOre("oreVoidSpar", ModBlocks.oreNaturalVoidSpar);

			registerOre("blockBloodstone", ModBlocks.blockBloodstone);
			registerOre("gemBloodstone", ModItems.gemBloodstone);
			registerOre("oreBloodstone", ModBlocks.oreBloodstone);

			registerOre("blockEchostone", ModBlocks.blockEchostone);
			registerOre("gemEchostone", ModItems.gemEchostone);
			registerOre("oreEchostone", ModBlocks.oreEchostone);

			registerOre("blockIgniglomerate", ModBlocks.blockIgniglomerate);
			registerOre("gemIgniglomerate", ModItems.gemIgniglomerate);
			registerOre("oreIgniglomerate", ModBlocks.oreIgniglomerate);

			registerOre("blockErythynite", ModBlocks.blockErythynite);
			registerOre("gemErythynite", ModItems.gemErythynite);
			registerOre("oreErythynite", ModBlocks.oreErythynite);

			registerOre("blockEtherstone", ModBlocks.blockEtherstone);
			registerOre("gemEtherstone", ModItems.gemEtherstone);
			registerOre("oreEtherstone", ModBlocks.oreEtherstone);

			registerOre("blockElectarite", ModBlocks.blockElectarite);
			registerOre("gemElectarite", ModItems.gemElectarite);
			registerOre("oreElectarite", ModBlocks.oreElectarite);

			registerOre("blockHallowsite", ModBlocks.blockHallowsite);
			registerOre("oreHallowsite", ModBlocks.oreHallowsite);
			registerOre("ingotHallowsite", ModItems.ingotHallowsite);
			registerOre("nuggetHallowsite", ModItems.nuggetHallowsite);

			registerOre("blockZracohlium", ModBlocks.blockZracohlium);
			registerOre("oreZracohlium", ModBlocks.oreZracohlium);
			registerOre("ingotZracohlium", ModItems.ingotZracohlium);
			registerOre("nuggetZracohlium", ModItems.nuggetZracohlium);

			registerOre("blockMonolite", ModBlocks.blockMonolite);
			registerOre("gemMonolite", ModItems.gemMonolite);
			registerOre("oreMonolite", ModBlocks.oreMonolite);
			
			if (ConfigHandler.shouldLoadDust) {
				registerOre("dustIrradium", ModItems.dustIrradium);
				registerOre("dustValasium", ModItems.dustValasium);
				registerOre("dustSolarsteel", ModItems.dustSolarSteel);
				registerOre("dustSolsteel", ModItems.dustSolarSteel);
				registerOre("dustFusionite", ModItems.dustFusionite);
				registerOre("dustGallium", ModItems.dustGallium);
				registerOre("dustRuneSteel", ModItems.dustRuneSteel);
				registerOre("dustTrichromadentium", ModItems.dustTrichromadentium);
				registerOre("dustGravitonium", ModItems.dustGravitonium);
				registerOre("dustAtronium", ModItems.dustAtronium);
				registerOre("dustSteel", ModItems.dustSteel);
				registerOre("dustEbonite", ModItems.dustEbonite);
				registerOre("dustHallowsite", ModItems.dustHallowsite);
				registerOre("dustBlightsteel", ModItems.dustBlightsteel);
				registerOre("dustSanguiseelium", ModItems.dustSanguiseelium);
				registerOre("dustZracohlium", ModItems.dustZracohlium);
			}
		}

		if (CompatManager.twilightforest) {
			registerOre("blockPenguinite", ModBlocks.blockPenguinite);
			registerOre("ingotPenguinite", ModItems.ingotPenguinite);
			registerOre("nuggetPenguinite", ModItems.nuggetPenguinite);
			if (ConfigHandler.shouldLoadDustForCompatability && ConfigHandler.shouldLoadDust) {
				registerOre("dustPenguinite", ModItems.dustPenguinite);
				registerOre("dustFiery", ModItems.dustFiery);
				registerOre("dustIronwood", ModItems.dustIronwood);
				registerOre("dustKnightmetal", ModItems.dustKnightmetal);
			}
		}

		if (CompatManager.thebetweenlands && Loader.isModLoaded("thebetweenlands")) {
			registerOre("blockSwampsteel", ModBlocks.blockSwampSteel);
			registerOre("ingotSwampsteel", ModItems.ingotSwampSteel);
			registerOre("nuggetSwampsteel", ModItems.nuggetSwampSteel);

			registerOre("blockRotiron", ModBlocks.blockRotiron);
			registerOre("ingotRotiron", ModItems.ingotRotiron);
			registerOre("nuggetRotiron", ModItems.nuggetRotiron);

			registerOre("blockAncientAlloy", ModBlocks.blockAncientAlloy);
			registerOre("ingotAncientAlloy", ModItems.ingotAncientAlloy);
			registerOre("nuggetAncientAlloy", ModItems.nuggetAncientAlloy);

			registerOre("blockClay", ModBlocks.blockSiltClay);
			registerOre("clay", ModItems.itemSiltClay);
			registerOre("gravel", ModBlocks.blockCragravel);

			if (ConfigHandler.shouldLoadDustForCompatability && ConfigHandler.shouldLoadDust) {
				registerOre("dustOctine", ModItems.dustOctine);
				registerOre("dustSwampsteel", ModItems.dustSwampSteel);
				registerOre("dustRotiron", ModItems.dustRotiron);
				registerOre("dustSyrmorite", ModItems.dustSyrmorite);
				registerOre("dustAncientAlloy", ModItems.dustAncientAlloy);
			}
		}

		if (CompatManager.aether_legacy) {
			registerOre("blockArkenium", ModBlocks.blockArkenium);
			registerOre("oreArkenium", ModBlocks.oreArkenium);
			registerOre("ingotArkenium", ModItems.ingotArkenium);
			registerOre("nuggetArkenium", ModItems.nuggetArkenium);

			registerOre("blockValkyrieMetal", ModBlocks.blockValkyrieMetal);
			registerOre("ingotValkyrieMetal", ModItems.ingotValkyrieMetal);
			registerOre("nuggetValkyrieMetal", ModItems.nuggetValkyrieMetal);

			registerOre("blockGravitite", ModBlocks.blockGravitite);
			if (ConfigHandler.shouldLoadDustForCompatability && ConfigHandler.shouldLoadDust) {
				registerOre("dustArkenium", ModItems.dustArkenium);
				registerOre("dustValkyrieMetal", ModItems.dustValkyrieMetal);
			}
		}
	}

	public static void init() {
		if (CompatManager.twilightforest) {
			registerOre("blockIronwood", new ItemStack(TFBlocks.block_storage, 1, 0));
		}

		if (CompatManager.thebetweenlands) {
			registerOre("ropeReed", EnumItemMisc.SWAMP_REED_ROPE.create(1));
			registerOre("itemDragonFlyWing", EnumItemMisc.DRAGONFLY_WING.create(1));
			registerOre("itemAnglerTooth", EnumItemMisc.ANGLER_TOOTH.create(1));
			registerOre("gemSulfur", EnumItemMisc.SULFUR.create(1));
			registerOre("plankWoodWeedwood", BlockRegistry.WEEDWOOD_PLANKS);
			registerOre("logWoodWeedwood", BlockRegistry.LOG_WEEDWOOD);
			registerOre("logWoodWeedwood", new ItemStack(Item.getItemFromBlock(BlockRegistry.LOG_WEEDWOOD), 1, 12));
			registerOre("logWoodWeedwood", BlockRegistry.WEEDWOOD);
			registerOre("stickWoodWeedwood", EnumItemMisc.WEEDWOOD_STICK.create(1));
			registerOre("blockSlimyBone", BlockRegistry.SLIMY_BONE_BLOCK);
			registerOre("gemSlimyBone", EnumItemMisc.SLIMY_BONE.create(1));
			registerOre("dripTar", EnumItemMisc.TAR_DRIP.create(1));
		}
		if (CompatManager.aether_legacy) {
			registerOre("holystone", BlocksAether.holystone);
			registerOre("plankWoodSkyroot", BlocksAether.skyroot_plank);
			registerOre("logWoodSkyroot", new ItemStack(BlocksAether.aether_log, 1, 0));
			registerOre("stickWoodSkyroot", ItemsAether.skyroot_stick);
			registerOre("gemGravitite", BlocksAether.enchanted_gravitite);
		}
	}

	public static void registerOre(String strName, ItemStack... itemStack) {
		for (ItemStack i : itemStack) {
			OreDictionary.registerOre(strName, i);
		}
	}

	public static void registerOre(String strName, Item... items) {
		for (Item i : items) {
			OreDictionary.registerOre(strName, i);
		}
	}

	public static void registerOre(String strName, Block... blocks) {
		for (Block b : blocks) {
			OreDictionary.registerOre(strName, b);
		}
	}
}
