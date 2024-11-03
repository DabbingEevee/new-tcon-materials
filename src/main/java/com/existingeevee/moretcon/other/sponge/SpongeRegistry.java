package com.existingeevee.moretcon.other.sponge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

import com.existingeevee.moretcon.ModInfo;
import com.existingeevee.moretcon.inits.misc.ModSponges;
import com.existingeevee.moretcon.inits.misc.OreDictionaryManager;
import com.existingeevee.moretcon.item.ItemBase;
import com.existingeevee.moretcon.other.ModTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.smeltery.CastingRecipe;

public class SpongeRegistry {
	private SpongeRegistry() {
	}

	private static final Map<String, SpongeRecipe> RECIPES = new HashMap<>();

	public static void registerRecipes(Register<IRecipe> event) {
		for (Entry<String, SpongeRecipe> s : RECIPES.entrySet()) {
			String id = "spongerecipe_" + s.getKey();
			IRecipe recipe = new ShapelessRecipes(id, new ItemStack(s.getValue().result, 1, 1),
					NonNullList.from(
							Ingredient.fromStacks(ItemStack.EMPTY),
							Ingredient.fromStacks(new ItemStack(ModSponges.gravitoniumSponge)),
							s.getValue().getSeed()
					));
			event.getRegistry().register(recipe.setRegistryName(new ResourceLocation(ModInfo.MODID, id)));
		}
	}

	public static void postInit() {
		for (Entry<String, SpongeRecipe> s : RECIPES.entrySet()) {

			for (String ore : s.getValue().resultOreDict) {
				OreDictionaryManager.registerOre(ore, s.getValue().result);
			}

			GameRegistry.addSmelting(new ItemStack(s.getValue().result, 1), s.getValue().smeltResult.copy(), 0F);
			int i = 1;

			for (SpongeStep s2 : s.getValue().steps) {
				ItemStack input = new ItemStack(s.getValue().result, 1, i);
				ItemStack output = new ItemStack(s.getValue().result, 1, 0);
				if (i != s.getValue().steps.length) {
					output = new ItemStack(s.getValue().result, 1, i + 1);
				}
				TinkerRegistry.registerBasinCasting(new CastingRecipe(output, RecipeMatch.of(input, 1), s2.getFluidStack(), 200, true, true));
				i++;
			}
		}
	}

	public static GravitoniumSpongeItem getSponge(SpongeRecipe sponge) {
		return new GravitoniumSpongeItem(sponge);
	}

	public static SpongeRecipe createSpongeRecipe(String recipeName, String resultOreDict, ItemStack smeltResult, ItemStack seed, SpongeStep... steps) {
		return new SpongeRecipe(recipeName, resultOreDict, smeltResult, Ingredient.fromStacks(seed), steps);
	}

	public static SpongeRecipe createSpongeRecipe(String recipeName, String resultOreDict, ItemStack smeltResult, Ingredient seed, SpongeStep... steps) {
		return new SpongeRecipe(recipeName, resultOreDict, smeltResult, seed, steps);
	}

	public static SpongeStep createSpongeStep(Supplier<Fluid> fluid, int amount) {
		return new SpongeStep(fluid, amount);
	}

	public static class SpongeRecipe {
		public SpongeStep[] steps;
		private List<String> resultOreDict = new ArrayList<>();
		private ItemStack smeltResult;
		private String recipeName;
		private GravitoniumSpongeItem result;
		private Ingredient seed;

		public SpongeRecipe(String recipeName, String resultOreDict, ItemStack smeltResult, Ingredient seed, SpongeStep... steps) {
			this.resultOreDict.add(resultOreDict);
			this.smeltResult = smeltResult;
			this.steps = steps;
			this.recipeName = recipeName;
			this.seed = seed;
		}

		public ItemStack getSmeltResult() {
			return smeltResult;
		}

		public void setSmeltResult(ItemStack smeltResult) {
			this.smeltResult = smeltResult;
		}

		public List<String> getResultOreDict() {
			return resultOreDict;
		}

		public SpongeRecipe addResultOreDict(String resultOreDict) {
			this.resultOreDict.add(resultOreDict);
			return this;
		}

		public int getStepAmount() {
			return steps.length;
		}

		public boolean isSeed(ItemStack input) {
			return seed.test(input);
		}

		public Ingredient getSeed() {
			return seed;
		}

		public ArrayList<SpongeStep> getSteps() {
			ArrayList<SpongeStep> steps = new ArrayList<>();
			steps.addAll(steps);
			return steps;
		}
	}

	public static class SpongeStep {
		private final Supplier<Fluid> fluid;
		private final int amount;

		public SpongeStep(Supplier<Fluid> fluid, int amount) {
			this.fluid = fluid;
			this.amount = amount;
		}

		public Fluid getFluid() {
			return fluid.get();
		}

		public int getAmount() {
			return amount;
		}

		public FluidStack getFluidStack() {
			return new FluidStack(fluid.get(), amount);
		}
	}

	public static class GravitoniumSpongeItem extends ItemBase {

		public SpongeRecipe recipe;

		private GravitoniumSpongeItem(SpongeRecipe recipe) {
			super("item" + recipe.recipeName + "sponge");
			this.recipe = recipe;
			this.recipe.result = this;
			this.setHasSubtypes(true);
			this.setMaxDamage(0);
			this.setTab(ModTabs.moarTConMisc);
			RECIPES.put(recipe.recipeName, recipe);
		}

		public SpongeRecipe getRecipe() {
			return recipe;
		}

		@Override
		public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
			if (this.isInCreativeTab(tab)) {
				items.add(new ItemStack(this, 1, 0));
			}
		}

		@Override
		public String getItemStackDisplayName(ItemStack stack) {
			if (stack.getMetadata() == 0) {
				return I18n.translateToLocal("spongestatus.completed.name") + " " + I18n.translateToLocal("spongerecipe." + recipe.recipeName + ".name") + " " + I18n.translateToLocal(ModSponges.gravitoniumSponge.getUnlocalizedName() + ".name");
			}

			if (stack.getMetadata() == 1) {
				return I18n.translateToLocal("spongestatus.empty.name") + " " + I18n.translateToLocal("spongerecipe." + recipe.recipeName + ".name") + " " + I18n.translateToLocal(ModSponges.gravitoniumSponge.getUnlocalizedName() + ".name");
			}

			return I18n.translateToLocal("spongestatus.partial.name") + " (" + I18n.translateToLocal("sponge.step.name") + " " + (stack.getMetadata() - 1) + ") " + I18n.translateToLocal("spongerecipe." + recipe.recipeName + ".name") + " " + I18n.translateToLocal(ModSponges.gravitoniumSponge.getUnlocalizedName() + ".name");
		}

		@Override
		public CreativeTabs getTab() {
			return tab;
		}
	}
}
