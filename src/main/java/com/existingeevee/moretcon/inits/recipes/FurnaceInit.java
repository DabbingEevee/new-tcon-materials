package com.existingeevee.moretcon.inits.recipes;

import com.existingeevee.moretcon.config.ConfigHandler;
import com.existingeevee.moretcon.inits.ModBlocks;
import com.existingeevee.moretcon.inits.ModItems;
import com.existingeevee.moretcon.other.BiValue;
import com.existingeevee.moretcon.other.utils.CompatManager;
import com.existingeevee.moretcon.other.utils.RegisterHelper;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import twilightforest.item.TFItems;

public class FurnaceInit {
	public static void init() {

		for (BiValue<Block, ItemStack> val : RegisterHelper.oreDrops) {
			GameRegistry.addSmelting(val.getA(), val.getB(), 10);
		}

		if (CompatManager.twilightforest) {
			initTF();
		}
		if (CompatManager.loadMain) {
			initMain();
		}
		if (CompatManager.aether_legacy) {
			initAL();
		}
	}

	public static void initTF() {
		if (ConfigHandler.shouldLoadDust && ConfigHandler.shouldLoadDustForCompatability) {
			GameRegistry.addSmelting(new ItemStack(ModItems.dustKnightmetal, 1), new ItemStack(TFItems.knightmetal_ingot, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustFiery, 1), new ItemStack(TFItems.fiery_ingot, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustPenguinite, 1), new ItemStack(ModItems.ingotPenguinite, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustIronwood, 1), new ItemStack(TFItems.ironwood_ingot, 1), 0F);
		}
	}

	public static void initMain() {
		if (ConfigHandler.shouldLoadDust) {
			GameRegistry.addSmelting(new ItemStack(ModItems.dustFusionite, 1), new ItemStack(ModItems.ingotFusionite, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustValasium, 1), new ItemStack(ModItems.ingotValasium, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustIrradium, 1), new ItemStack(ModItems.ingotIrradium, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustSolarSteel, 1), new ItemStack(ModItems.ingotSolsteel, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustGallium, 1), new ItemStack(ModItems.ingotGallium, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustRuneSteel, 1), new ItemStack(ModItems.ingotRuneSteel, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustGravitonium, 1), new ItemStack(ModItems.ingotGravitonium, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustTrichromadentium, 1), new ItemStack(ModItems.ingotTrichromadentium, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustAtronium, 1), new ItemStack(ModItems.ingotAtronium, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustSteel, 1), new ItemStack(ModItems.ingotSteel, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustHallowsite, 1), new ItemStack(ModItems.ingotHallowsite, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustBlightsteel, 1), new ItemStack(ModItems.ingotBlightsteel, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustZracohlium, 1), new ItemStack(ModItems.ingotZracohlium, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustSlimesteel, 1), new ItemStack(ModItems.ingotSlimesteel, 1), 0F);
		}
		if (ConfigHandler.unfracturedBedrockObtainable) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.blockCobbledBedrock, 1), new ItemStack(Blocks.BEDROCK, 1), 0F);
		}
		GameRegistry.addSmelting(new ItemStack(ModItems.rawSteel, 1), new ItemStack(ModItems.ingotSteel, 1), 0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.oreGravitoniumDense, 1), new ItemStack(ModItems.ingotGravitonium, 4), 0F);
	}

	public static void initAL() {
		if (ConfigHandler.shouldLoadDust && ConfigHandler.shouldLoadDustForCompatability) {
			GameRegistry.addSmelting(new ItemStack(ModItems.dustArkenium, 1), new ItemStack(ModItems.ingotArkenium, 1), 0F);
			GameRegistry.addSmelting(new ItemStack(ModItems.dustValkyrieMetal, 1), new ItemStack(ModItems.ingotValkyrieMetal, 1), 0F);
		}
	}
}
