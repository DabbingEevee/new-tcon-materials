package com.existingeevee.moretcon.inits.recipes;

import org.apache.commons.lang3.tuple.Pair;

import com.existingeevee.moretcon.config.ConfigHandler;
import com.existingeevee.moretcon.inits.ModMaterials;
import com.existingeevee.moretcon.inits.ModTools;
import com.existingeevee.moretcon.other.RecipeHelper;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.oredict.OreIngredient;

public class ExplosiveChargeRecipes {

	public static void init(Register<IRecipe> event) {
		if (ConfigHandler.enableBomb) {
			event.getRegistry().register(
					RecipeHelper.createRecipe("gunpowder_charge", ModTools.explosiveCharge.getItemstackWithMaterial(
							ModMaterials.materialGunpowder),
							
							new String[] {
									" G ",
									"GTG",
									" G "
							},
							Pair.of('G', new OreIngredient("gunpowder")),
							Pair.of('T', Ingredient.fromItem(Item.getItemFromBlock(Blocks.TNT)))));
			
			event.getRegistry().register(
					RecipeHelper.createRecipe("icy_charge", ModTools.explosiveCharge.getItemstackWithMaterial(
							ModMaterials.materialIcy),
							
							new String[] {
									"IPI",
									"PTP",
									"IPI"
							},
							Pair.of('I', Ingredient.fromItem(Item.getItemFromBlock(Blocks.ICE))),
							Pair.of('P', Ingredient.fromItem(Item.getItemFromBlock(Blocks.PACKED_ICE))),
							Pair.of('T', Ingredient.fromItem(Item.getItemFromBlock(Blocks.TNT)))));
			
			event.getRegistry().register(
					RecipeHelper.createRecipe("redstone_charge", ModTools.explosiveCharge.getItemstackWithMaterial(
							ModMaterials.materialRedstone),
							
							new String[] {
									"IPI",
									"PTP",
									"IPI"
							},
							Pair.of('I', new OreIngredient("dustRedstone")),
							Pair.of('P',new OreIngredient("blockRedstone")),
							Pair.of('T', Ingredient.fromItem(Item.getItemFromBlock(Blocks.TNT)))));
			
			event.getRegistry().register(
					RecipeHelper.createRecipe("glowstone_charge", ModTools.explosiveCharge.getItemstackWithMaterial(
							ModMaterials.materialGlowstone),
							
							new String[] {
									"IPI",
									"PTP",
									"IPI"
							},
							Pair.of('I', new OreIngredient("dustGlowstone")),
							Pair.of('P',new OreIngredient("glowstone")),
							Pair.of('T', Ingredient.fromItem(Item.getItemFromBlock(Blocks.TNT)))));
			
			event.getRegistry().register(
					RecipeHelper.createRecipe("fusionite_charge", ModTools.explosiveCharge.getItemstackWithMaterial(
							ModMaterials.materialFusionite),
							
							new String[] {
									" P ",
									"PTP",
									" P "
							},
							Pair.of('P',new OreIngredient("dustFusionite")),
							Pair.of('T', Ingredient.fromItem(Items.BLAZE_POWDER))));
			
			event.getRegistry().register(
					RecipeHelper.createRecipe("igniglomerate_charge", ModTools.explosiveCharge.getItemstackWithMaterial(
							ModMaterials.materialIgniglomerate),
							
							new String[] {
									"III",
									"ITI",
									"III"
							},
							Pair.of('I', new OreIngredient("gemIgniglomerate")),
							Pair.of('T', Ingredient.fromItem(Items.FIRE_CHARGE))));
			
			event.getRegistry().register(
					RecipeHelper.createRecipe("zracohlium_charge", ModTools.explosiveCharge.getItemstackWithMaterial(
							ModMaterials.materialZracohlium),
							
							new String[] {
									"IEI",
									"EZE",
									"IEI"
							},
							Pair.of('Z', new OreIngredient("ingotZracohlium")),
							Pair.of('E',new OreIngredient("ingotEbonite")),
							Pair.of('I',new OreIngredient("dustZracohlium"))));
		}
	}
}
