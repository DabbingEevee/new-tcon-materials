package com.existingeevee.moretcon.inits.recipes;

import org.apache.commons.lang3.tuple.Pair;

import com.existingeevee.moretcon.config.ConfigHandler;
import com.existingeevee.moretcon.inits.ModItems;
import com.existingeevee.moretcon.inits.ModMaterials;
import com.existingeevee.moretcon.materials.UniqueMaterial;
import com.existingeevee.moretcon.other.RecipeHelper;
import com.existingeevee.moretcon.other.ingredient.TinkerPartIngredient;
import com.gildedgames.the_aether.items.ItemsAether;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.tools.TinkerMaterials;

public class UniqueToolpartRecipes {

	public static void init(Register<IRecipe> event) {
		if (ConfigHandler.shouldAllowEasterEggItems) {
			if (canRegisterUniqueRecipe(ModMaterials.materialTechnoblade)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("techno_recipe", ModMaterials.materialTechnoblade.getUniqueToolPart(),
								new String[] {
										" GS",
										"NPG",
										"DN "
								},
								Pair.of('S', new OreIngredient("netherStar")),
								Pair.of('G', new OreIngredient("gemGarstone")),
								Pair.of('N', new OreIngredient("ingotBrickNether")),
								Pair.of('G', new OreIngredient("ingotGallium")),
								Pair.of('D', new OreIngredient("blockDiamond")),
								Pair.of('P', new TinkerPartIngredient(TinkerMaterials.pigiron, "tconstruct:sword_blade"))));
			}
		}

		if (ConfigHandler.enableBomb) {
			if (canRegisterUniqueRecipe(ModMaterials.materialImpact)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("impact_recipe", ModMaterials.materialImpact.getUniqueToolPart(),
								new String[] {
										"RER",
										"FCF",
										"RER"
								},
								Pair.of('E', new OreIngredient("gemElectarite")),
								Pair.of('F', new OreIngredient("ingotFusionite")),
								Pair.of('C', Ingredient.fromItem(Items.END_CRYSTAL)),
								Pair.of('R', new OreIngredient("dustRedstone"))));
			}
		}
		
		if (ConfigHandler.shouldAllowPlusTiC) {
			if (canRegisterUniqueRecipe(ModMaterials.materialCrimson)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("crimson_recipe", ModMaterials.materialCrimson.getUniqueToolPart(),
								new String[] {
										"ACG",
										"CBC",
										"OCA"
								},
								Pair.of('A', new OreIngredient("ingotGallium")),
								Pair.of('G', new OreIngredient("gemGarstone")),
								Pair.of('C', new OreIngredient("slimeballBlood")),
								Pair.of('B', new TinkerPartIngredient(ModMaterials.materialBloodstone, "tconstruct:tough_tool_rod")),
								Pair.of('O', new TinkerPartIngredient(TinkerMaterials.bone, "tconstruct:tough_tool_rod"))));
			}
		}

		if (ConfigHandler.shouldAllowAether) {
			if (canRegisterUniqueRecipe(ModMaterials.materialSkybolt)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("skybolt_recipe", ModMaterials.materialSkybolt.getUniqueToolPart(),
								new String[] {
										" AL",
										"AGA",
										"LA "
								},
								Pair.of('A', Ingredient.fromStacks(new ItemStack(ItemsAether.golden_amber))),
								Pair.of('L', Ingredient.fromStacks(new ItemStack(ItemsAether.lightning_sword, 1, OreDictionary.WILDCARD_VALUE))),
								Pair.of('G', new TinkerPartIngredient(ModMaterials.materialGravitite, "tconstruct:sword_blade"))));
			}
		}

		if (ConfigHandler.shouldAllowMainContent) {
			if (canRegisterUniqueRecipe(ModMaterials.materialPlasma)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("plasma_recipe", ModMaterials.materialPlasma.getUniqueToolPart(),
								new String[] {
										"IBI",
										"GPG",
										"IEI"
								},
								Pair.of('I', new OreIngredient("ingotIron")),
								Pair.of('B', new OreIngredient("blockGarstone")),
								Pair.of('P', new OreIngredient("dustPrismarine")),
								Pair.of('E', Ingredient.fromStacks(new ItemStack(Blocks.BEACON))),
								Pair.of('G', new OreIngredient("gemGarstone"))));
			}
			if (canRegisterUniqueRecipe(ModMaterials.materialTrailblazer)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("trailblazer_recipe", ModMaterials.materialTrailblazer.getUniqueToolPart(),
								new String[] {
										" SF",
										"WPS",
										"BW "
								},
								Pair.of('S', new OreIngredient("blockSolsteel")),
								Pair.of('F', new OreIngredient("blockFusionite")),
								Pair.of('W', new TinkerPartIngredient(TinkerMaterials.firewood, "tconstruct:knife_blade")),
								Pair.of('P', new TinkerPartIngredient(ModMaterials.materialIgniglomerate, "tconstruct:knife_blade")),
								Pair.of('B', Ingredient.fromStacks(new ItemStack(Blocks.BEACON)))));
			}
			if (canRegisterUniqueRecipe(ModMaterials.materialTriblade)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("triblade_recipe", ModMaterials.materialTriblade.getUniqueToolPart(),
								new String[] {
										"W W",
										"VM ",
										"BVW"
								},
								Pair.of('W', Ingredient.fromStacks(new ItemStack(Items.SKULL, 1, 1))),
								Pair.of('V', new OreIngredient("blockVoidSpar")),
								Pair.of('M', new OreIngredient("blockMonolite")),
								Pair.of('B', new OreIngredient("boneWithered"))));
			}

			if (canRegisterUniqueRecipe(ModMaterials.materialMirrored)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("mirrored_recipe", ModMaterials.materialMirrored.getUniqueToolPart(),
								new String[] {
										"RGR",
										"GFG",
										"RGR"
								},
								Pair.of('G', new OreIngredient("ingotGallium")),
								Pair.of('R', new OreIngredient("nuggetRunesteel")),
								Pair.of('F', new TinkerPartIngredient(TinkerMaterials.feather, "tconstruct:fletching"))));
			}

			if (canRegisterUniqueRecipe(ModMaterials.materialEssencore)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("essencore_recipe", ModMaterials.materialEssencore.getUniqueToolPart(),
								new String[] {
										"GFN",
										"FRF",
										"NFG"
								},
								Pair.of('G', new OreIngredient("ingotGallium")),
								Pair.of('F', new OreIngredient("ingotFusionite")),
								Pair.of('N', new OreIngredient("nuggetFusionite")),
								Pair.of('R', new OreIngredient("ingotRunesteel"))));
			}

			if (canRegisterUniqueRecipe(ModMaterials.materialSpaceTimeDisruption)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("spacetimedisruption_recipe", ModMaterials.materialSpaceTimeDisruption.getUniqueToolPart(),
								new String[] {
										"PVP",
										"EFE",
										"PVP"
								},
								Pair.of('P', Ingredient.fromStacks(new ItemStack(ModItems.spaceTimeDisruptionPowder))),
								Pair.of('V', new TinkerPartIngredient(ModMaterials.materialVoidSpar, "tconstruct:bow_limb")),
								Pair.of('E', new TinkerPartIngredient(ModMaterials.materialEchostone, "tconstruct:bow_limb")),
								Pair.of('F', new TinkerPartIngredient(ModMaterials.materialFusionite, "tconstruct:bow_limb"))));
			}

			if (canRegisterUniqueRecipe(ModMaterials.materialQuakestruck)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("quakestruck_recipe", ModMaterials.materialQuakestruck.getUniqueToolPart(),
								new String[] {
										"OFO",
										"EIE",
										"OFO"
								},
								Pair.of('E', new OreIngredient("gemElectarite")),
								Pair.of('I', new TinkerPartIngredient(ModMaterials.materialIgniglomerate, "tconstruct:large_plate")),
								Pair.of('O', new TinkerPartIngredient(TinkerMaterials.obsidian, "tconstruct:large_plate")),
								Pair.of('F', new OreIngredient("ingotFusionite"))));
			}

			if (canRegisterUniqueRecipe(ModMaterials.materialCryosplinters)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("cryosplinters_recipe", ModMaterials.materialCryosplinters.getUniqueToolPart(),
								new String[] {
										"FIG",
										"IHV",
										"GVV"
								},
								Pair.of('G', new OreIngredient("gunpowder")),
								Pair.of('F', new OreIngredient("ingotFusionite")),
								Pair.of('V', new OreIngredient("ingotValasium")),
								Pair.of('H', new TinkerPartIngredient(ModMaterials.materialElectarite, "tconstruct:arrow_head")),
								Pair.of('I', Ingredient.fromStacks(new ItemStack(Blocks.PACKED_ICE)))));
			}

			if (canRegisterUniqueRecipe(ModMaterials.materialAutoloader)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("autoloader_recipe", ModMaterials.materialAutoloader.getUniqueToolPart(),
								new String[] {
										"RRD",
										"GSR",
										"PGR"
								},
								Pair.of('R', new OreIngredient("dustRedstone")),
								Pair.of('G', new OreIngredient("ingotGallium")),
								Pair.of('D', Ingredient.fromStacks(new ItemStack(Blocks.DISPENSER))),
								Pair.of('P', Ingredient.fromStacks(new ItemStack(Blocks.PISTON))),
								Pair.of('S', new TinkerPartIngredient(TinkerMaterials.steel, "tconstruct:tough_tool_rod"))));
			}

			if (canRegisterUniqueRecipe(ModMaterials.materialVengeance)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("vengeance_recipe", ModMaterials.materialVengeance.getUniqueToolPart(),
								new String[] {
										"RSR",
										"GIG",
										"RSR"
								},
								Pair.of('R', new OreIngredient("ingotRunesteel")),
								Pair.of('G', new OreIngredient("ingotGallium")),
								Pair.of('S', new TinkerPartIngredient(TinkerMaterials.steel, "tconstruct:knife_blade")),
								Pair.of('I', new TinkerPartIngredient(ModMaterials.materialIrradium, "tconstruct:sign_head"))));
			}

			if (canRegisterUniqueRecipe(ModMaterials.materialDematerializer)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("dematerializer_recipe", ModMaterials.materialDematerializer.getUniqueToolPart(),
								new String[] {
										" LE",
										"LRS",
										"ES "
								},
								Pair.of('L', Ingredient.fromItem(ModItems.solidLightning)),
								Pair.of('S', new OreIngredient("netherStar")),
								Pair.of('E', new TinkerPartIngredient(ModMaterials.materialElectarite, "tconstruct:bow_limb")),
								Pair.of('R',  Ingredient.fromStacks(new ItemStack(Blocks.END_ROD)))));
			}
			
			if (canRegisterUniqueRecipe(ModMaterials.materialShotgun)) {
				event.getRegistry().register(
						RecipeHelper.createRecipe("shotgun_recipe", ModMaterials.materialShotgun.getUniqueToolPart(),
								new String[] {
										"VV ",
										" ZV",
										"T V"
								},
								Pair.of('Z', new TinkerPartIngredient(ModMaterials.materialZracohlium, "tconstruct:tough_binding")),
								Pair.of('V', new OreIngredient("ingotValasium")),
								Pair.of('T',  Ingredient.fromStacks(new ItemStack(Blocks.TNT)))));
			}
		}
	}

	public static boolean canRegisterUniqueRecipe(UniqueMaterial umat) {
		if ((umat == null) || umat.getUniqueToolPart().isEmpty() || !TinkerRegistry.getAllMaterials().contains(umat)) {
			return false;
		}
		for (String s : ConfigHandler.removeUniqueToolpartRecipes) {
			if (s.equals(umat.getIdentifier())) {
				return false;
			}
		}
		return true;
	}

}
