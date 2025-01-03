package com.existingeevee.moretcon.inits;

import com.existingeevee.moretcon.block.blocktypes.BlockBase;
import com.existingeevee.moretcon.block.blocktypes.BlockElectarite;
import com.existingeevee.moretcon.block.blocktypes.BlockEtheralBase;
import com.existingeevee.moretcon.block.blocktypes.BlockFallingBase;
import com.existingeevee.moretcon.block.blocktypes.HotBlockBase;
import com.existingeevee.moretcon.block.blocktypes.RadiationBlockBase;
import com.existingeevee.moretcon.block.blocktypes.unique.BlockGravitoniumFaucet;
import com.existingeevee.moretcon.block.blocktypes.unique.BlockIgniglomerateCluster;
import com.existingeevee.moretcon.block.blocktypes.unique.BlockVoidColumn;
import com.existingeevee.moretcon.block.blocktypes.unique.BlockVoidCore;
import com.existingeevee.moretcon.block.blocktypes.unique.BlockVoidPrismBottom;
import com.existingeevee.moretcon.block.blocktypes.unique.BlockVoidPrismTop;
import com.existingeevee.moretcon.block.ore.BlockBedrockOre;
import com.existingeevee.moretcon.block.ore.BlockBedrockOreMetal;
import com.existingeevee.moretcon.block.ore.BlockEtheralOre;
import com.existingeevee.moretcon.block.ore.BlockOre;
import com.existingeevee.moretcon.block.ore.BlockOreMetal;
import com.existingeevee.moretcon.other.ModTabs;
import com.existingeevee.moretcon.other.MoreTConLogger;
import com.existingeevee.moretcon.other.utils.CompatManager;
import com.existingeevee.moretcon.other.utils.RegisterHelper;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static int totalBlocks;
	/*---------------------------------------*/
	public static final Block blockFusionite = ((BlockBase) new BlockBase("blockFusionite", Material.IRON, 3).setHardness(10).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreFusionite = ((BlockBase) new BlockOreMetal("oreFusionite", 4, ModItems.ingotFusionite).setHardness(7.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block oreBedrockFusionite = ((BlockBase) new BlockBedrockOreMetal("oreBedrockFusionite", 4, ModItems.ingotFusionite).setHardness(7.5f).setResistance(Float.MAX_VALUE).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockIrradium = ((BlockBase) new RadiationBlockBase("blockIrradium", Material.IRON, 3).setHardness(10).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreIrradium = ((BlockBase) new BlockOreMetal("oreIrradium", 2, ModItems.ingotIrradium).setHardness(7.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockSolsteel = ((BlockBase) new HotBlockBase("blockSolarSteel", Material.IRON, 3).setCanBurn(false).setHardness(10).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockPenguinite = ((BlockBase) new BlockBase("blockPenguinite", Material.IRON, 3).setHardness(10).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreVoidSpar = ((BlockBase) new BlockOre("oreVoidSpar", 3, ModItems.gemVoidSpar, 3).setHardness(7.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block oreNaturalVoidSpar = ((BlockBase) new BlockBedrockOre("oreNaturalVoidSpar", 4, ModItems.gemVoidSpar, 1, 1).setHardness(50).setResistance(Float.MAX_VALUE).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockVoidSpar = ((BlockBase) new BlockBase("blockVoidSpar", Material.IRON, 4).setHardness(10).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreEnderal = ((BlockBase) new BlockOre("oreEnderal", 4, ModItems.gemEnderal, 1).setHardness(9.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockEnderal = ((BlockBase) new BlockBase("blockEnderal", Material.IRON, 5).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockGarstone = ((BlockBase) new BlockBase("blockGarstone", Material.IRON, 5).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreGarstone = ((BlockBase) new BlockOre("oreGarstone", 4, ModItems.gemGarstone, 1).setHardness(9.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockRuneSteel = ((BlockBase) new BlockBase("blockRuneSteel", Material.IRON, 5).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockGallium = ((BlockBase) new BlockBase("blockGallium", Material.IRON, 5).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreGallium = ((BlockBase) new BlockOreMetal("oreGallium", 5, ModItems.ingotGallium).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block oreArkenium = ((BlockBase) new BlockOreMetal("oreArkenium", 2, ModItems.ingotArkenium).setHardness(7.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockArkenium = ((BlockBase) new BlockBase("blockArkenium", Material.IRON, 2).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockSteel = ((BlockBase) new BlockBase("blockSteel", Material.IRON, 1).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockGravitite = ((BlockBase) new BlockBase("blockGravitite", Material.IRON, 3).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockValkyrieMetal = ((BlockBase) new BlockBase("blockValkyrieMetal", Material.IRON, 3).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockTrichromadentium = (new BlockBase("blockTrichromadentium", Material.IRON, 6).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockAtronium = (new BlockBase("blockAtronium", Material.IRON, 6).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block oreGravitonium = ((BlockBase) new BlockOreMetal("oreGravitonium", 4, ModItems.ingotGravitonium).setHardness(9.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block oreGravitoniumDense = ((BlockBase) new BlockBase("oreGravitoniumDense", Material.ROCK, 4).setHardness(9.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockGravitonium = (new BlockBase("blockGravitonium", Material.IRON, 4).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockSwampSteel = (new BlockBase("blockSwampSteel", Material.IRON, 4).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockRotiron = (new BlockBase("blockRotiron", Material.IRON, 3).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block oreBloodstone = ((BlockBase) new BlockBedrockOre("oreBloodstone", 4, ModItems.gemBloodstone, 1, 1).setHardness(50).setResistance(Float.MAX_VALUE).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockBloodstone = ((BlockBase) new BlockBase("blockBloodstone", Material.IRON, 5).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreEchostone = ((BlockBase) new BlockOre("oreEchostone", 5, ModItems.gemEchostone, 1).setHardness(9.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockEchostone = ((BlockBase) new BlockBase("blockEchostone", Material.IRON, 6).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreIgniglomerate = ((BlockBase) new BlockIgniglomerateCluster().setCanBurn(false).setHardness(9.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false).setLightLevel(1);
	public static final Block blockIgniglomerate = ((BlockBase) new HotBlockBase("blockIgniglomerate", Material.IRON, 6).setCanBurn(false).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true).setLightLevel(1);
	public static final Block oreEbonite = ((BlockBase) new BlockBedrockOreMetal("oreEbonite", 5, ModItems.ingotEbonite).setHardness(7.5f).setResistance(Float.MAX_VALUE).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockEbonite = ((BlockBase) new BlockBase("blockEbonite", Material.IRON, 5).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreErythynite = ((BlockBase) new BlockOre("oreErythynite", 5, ModItems.gemErythynite, 1).setHardness(9.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false).setLightLevel(1);
	public static final Block blockErythynite = ((BlockBase) new BlockBase("blockErythynite", Material.IRON, 6).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true).setLightLevel(3);
	public static final Block oreEtherstone = (new BlockEtheralOre("oreEtherstone", 8, ModItems.gemEtherstone).setHardness(40).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockEtherstone = ((BlockBase) new BlockBase("blockEtherstone", Material.IRON, 8).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true).setLightLevel(0.5f);
	public static final Block oreElectarite = (new BlockOre("oreElectarite", 4, ModItems.gemElectarite).setHardness(12).setResistance(0).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockElectarite = ((BlockBase) new BlockElectarite("blockElectarite", Material.IRON, 4).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreHallowsite = (new BlockOreMetal("oreHallowsite", 4, ModItems.ingotHallowsite).setHardness(12).setResistance(0).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockHallowsite = ((BlockBase) new BlockBase("blockHallowsite", Material.IRON, 4).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockAncientAlloy = (new BlockBase("blockAncientAlloy", Material.IRON, 4).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockValasium = ((BlockBase) new BlockBase("blockValasium", Material.IRON, 6).setHardness(10).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockBlightsteel = ((BlockBase) new BlockBase("blockBlightsteel", Material.IRON, 6).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockSanguiseelium = ((BlockBase) new BlockBase("blockSanguiseelium", Material.IRON, 6).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreZracohlium = ((BlockBase) new BlockOreMetal("oreZracohlium", 5, ModItems.ingotZracohlium).setHardness(9.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false);
	public static final Block blockZracohlium = ((BlockBase) new BlockBase("blockZracohlium", Material.IRON, 5).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block blockSlimesteel = ((BlockBase) new BlockBase("blockSlimesteel", Material.IRON, 3).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true);
	public static final Block oreMonolite = (new BlockOre("oreMonolite", 5, ModItems.gemMonolite).setHardness(12).setResistance(0).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockMonolite = ((BlockBase) new BlockBase("blockMonolite", Material.IRON, 5).setHardness(12).setResistance(20).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(true).setLightLevel(0.5f);

	public static final Block oreGeodesium = ((BlockBase) new BlockOreMetal("oreGeodesium", 6, ModItems.carbonPile).setHardness(9.5f).setResistance(10).setCreativeTab(ModTabs.moarTConMaterials)).canBeBeacon(false); //TODO 
	
	public static final Block blockOtherstone = (new BlockEtheralBase("blockOtherstone", Material.ROCK, 1).setHardness(30).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockCobbledBedrock = (new BlockBase("blockCobbledBedrock", Material.ROCK, 4).setResistance(Float.MAX_VALUE).setHardness(40).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockCobbledBetweenBedrock = (new BlockBase("blockCobbledBetweenBedrock", Material.ROCK, 4).setResistance(Float.MAX_VALUE).setHardness(40).setCreativeTab(ModTabs.moarTConMaterials));
	public static final Block blockBrokenSand = (new BlockFallingBase("blockBrokenSand", Material.SAND, 0).setHarvestLevelC("shovel", 0).setSoundType(SoundType.SAND).setHardness(10).setCreativeTab(ModTabs.moarTConMaterials));
	
	//Block
	
	public static final Block blockGravitoniumFaucet = new BlockGravitoniumFaucet();
	public static final Block blockCragravel = ((BlockBase) new BlockFallingBase("blockCragravel", Material.GROUND, 0).setHarvestLevelC("shovel", 0).setHardness(0.6f).setResistance(0.6f)).canBeBeacon(false).setCreativeTab(ModTabs.moarTConMisc);
	public static final Block blockSiltClay = ((BlockBase) new BlockBase("blockSiltClay", Material.CLAY, 0).setHarvestLevelC("shovel", 0).setHardness(0.6f).setResistance(0.6f)).canBeBeacon(false).setCreativeTab(ModTabs.moarTConMisc);

	public static final Block blockVoidPrismTop = new BlockVoidPrismTop().setHardness(10).setResistance(20);
	public static final Block blockVoidPrismBottom = new BlockVoidPrismBottom().setHardness(10).setResistance(20);
	public static final Block blockVoidColumn = new BlockVoidColumn().setHardness(10).setResistance(20);
	public static final Block blockVoidCore = new BlockVoidCore();

	/*---------------------------------------*/

	public static void registerBlocks(Block... block) {
		for (Block i : block) {
			ModBlocks.addBlock(i);
		}
	}

	public static void init() {
		ModBlocks.registerBlocks(
				blockGravitoniumFaucet
		//FYI these will be back in the future. just not now.
		//blockVoidPrismTop,
		//blockVoidPrismBottom,
		//blockVoidColumn,
		//blockVoidCore
		);
		
		if (CompatManager.tic3backport) {
			ModBlocks.registerBlocks(
					blockSlimesteel
			);
		}

		if (CompatManager.loadMain) {
			ModBlocks.registerBlocks(
					/**-------------------------------------**/
					blockFusionite,
					oreBedrockFusionite,
					oreFusionite,
					blockValasium,
					blockIrradium,
					oreIrradium,
					blockSolsteel,
					oreVoidSpar,
					blockVoidSpar,
					oreNaturalVoidSpar,
					oreEnderal,
					blockEnderal,
					blockGarstone,
					oreGarstone,
					blockGallium,
					oreGallium,
					blockRuneSteel,
					blockTrichromadentium,
					oreGravitonium,
					oreGravitoniumDense,
					blockGravitonium,
					blockSteel,
					oreBloodstone,
					blockBloodstone,
					oreEchostone,
					blockEchostone,
					oreIgniglomerate,
					blockIgniglomerate,
					blockAtronium,
					oreEbonite,
					blockEbonite,
					oreErythynite,
					blockErythynite,
					oreEtherstone,
					blockEtherstone,
					oreElectarite,
					blockElectarite,
					oreHallowsite,
					blockHallowsite,
					blockBlightsteel,
					blockSanguiseelium,
					oreZracohlium,
					blockZracohlium,
					oreMonolite,
					blockMonolite,
					oreGeodesium,
					/**-------------------------------------**/
					blockCobbledBedrock,
					blockOtherstone,
					blockBrokenSand);
		}
		if (CompatManager.twilightforest) {
			ModBlocks.registerBlocks(
					/**-------------------------------------**/
					blockPenguinite
			/**-------------------------------------**/
			);
		}

		if (CompatManager.thebetweenlands) {
			ModBlocks.registerBlocks(
					/**-------------------------------------**/
					blockSiltClay,
					blockCragravel,
					blockSwampSteel,
					blockRotiron,
					blockAncientAlloy,
					blockCobbledBetweenBedrock
			/**-------------------------------------**/
			);
		}
		if (CompatManager.easterEggs) {
			ModBlocks.registerBlocks(
			/**-------------------------------------**/

			/**-------------------------------------**/
			);
		}
		if (CompatManager.aether_legacy) {
			ModBlocks.registerBlocks(
					/**-------------------------------------**/
					oreArkenium,
					blockArkenium,
					blockGravitite,
					blockValkyrieMetal
			/**-------------------------------------**/
			);
		}
		ModTileEntities.init();
		MoreTConLogger.log("Loaded a total of " + totalBlocks + " different blocks.");

	}

	private static void addBlock(Block block) {

		RegisterHelper.registerBlock(block);
		totalBlocks++;
	}
}
