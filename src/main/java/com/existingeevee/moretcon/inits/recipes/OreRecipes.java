package com.existingeevee.moretcon.inits.recipes;

import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent.Register;

public class OreRecipes {

	public static void init(Register<IRecipe> event) {
		MiscUtils.registerBlockNuggetIngotRecipeOre("Rotiron", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Irradium", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Gallium", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Atronium", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Steel", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Trichromadentium", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Gravitonium", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Solsteel", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Fusionite", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Runesteel", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Ebonite", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Valasium", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Hallowsite", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("AncientAlloy", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Blightsteel", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Sanguiseelium", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Zracohlium", event);

		MiscUtils.register9x9Recipes("gemBloodstone", "blockBloodstone", event);
		MiscUtils.register9x9Recipes("gemEchostone", "blockEchostone", event);
		MiscUtils.register9x9Recipes("gemIgniglomerate", "blockIgniglomerate", event);
		MiscUtils.register9x9Recipes("gemVoidSpar", "blockVoidSpar", event);
		MiscUtils.register9x9Recipes("gemGarstone", "blockGarstone", event);
		MiscUtils.register9x9Recipes("gemEnderal", "blockEnderal", event);
		MiscUtils.register9x9Recipes("gemErythynite", "blockErythynite", event);
		MiscUtils.register9x9Recipes("gemEtherstone", "blockEtherstone", event);
		MiscUtils.register9x9Recipes("gemElectarite", "blockElectarite", event);
		
		MiscUtils.registerBlockNuggetIngotRecipeOre("Slimesteel", event);
		
		MiscUtils.register9x9Recipes("gemMonolite", "blockMonlite", event);

		MiscUtils.registerBlockNuggetIngotRecipeOre("Penguinite", event);

		MiscUtils.registerBlockNuggetIngotRecipeOre("Swampsteel", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Rotiron", event);

		MiscUtils.registerBlockNuggetIngotRecipeOre("ValkyrieMetal", event);
		MiscUtils.registerBlockNuggetIngotRecipeOre("Arkenium", event);

		MiscUtils.register9x9Recipes("gemGravitite", "blockGravitite", event);
	}

}
