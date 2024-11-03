package com.existingeevee.moretcon;

import com.existingeevee.moretcon.compat.betweenlands.BLRecipes;
import com.existingeevee.moretcon.compat.betweenlands.EventWatcherBL;
import com.existingeevee.moretcon.compat.betweenlands.IBetweenTinkerTool;
import com.existingeevee.moretcon.config.ConfigHandler;
import com.existingeevee.moretcon.inits.ModBlocks;
import com.existingeevee.moretcon.inits.ModFluidBlocks;
import com.existingeevee.moretcon.inits.ModFluids;
import com.existingeevee.moretcon.inits.ModItems;
import com.existingeevee.moretcon.inits.ModMaterials;
import com.existingeevee.moretcon.inits.ModPotions;
import com.existingeevee.moretcon.inits.ModReforges;
import com.existingeevee.moretcon.inits.misc.ModSponges;
import com.existingeevee.moretcon.inits.misc.OreDictionaryManager;
import com.existingeevee.moretcon.inits.recipes.FurnaceInit;
import com.existingeevee.moretcon.inits.recipes.MiscRecipes;
import com.existingeevee.moretcon.inits.recipes.OreRecipes;
import com.existingeevee.moretcon.inits.recipes.ReforgeRecipes;
import com.existingeevee.moretcon.inits.recipes.SmelteryInit;
import com.existingeevee.moretcon.inits.recipes.UniqueToolpartRecipes;
import com.existingeevee.moretcon.materials.CompositeRegistry;
import com.existingeevee.moretcon.materials.MTMaterialIntegration;
import com.existingeevee.moretcon.materials.UniqueMaterial;
import com.existingeevee.moretcon.other.EventWatcherMain;
import com.existingeevee.moretcon.other.ModTabs;
import com.existingeevee.moretcon.other.fires.CustomFireEffect;
import com.existingeevee.moretcon.other.fires.CustomFireHelper;
import com.existingeevee.moretcon.other.fixes.ExtremeToolDurabilityFix;
import com.existingeevee.moretcon.other.sponge.SpongeRegistry;
import com.existingeevee.moretcon.other.utils.ArrowReferenceHelper;
import com.existingeevee.moretcon.other.utils.CompatManager;
import com.existingeevee.moretcon.other.utils.MaterialUtils;
import com.existingeevee.moretcon.other.utils.MiscUtils;
import com.existingeevee.moretcon.other.utils.ReequipHack;
import com.existingeevee.moretcon.other.utils.RegisterHelper;
import com.existingeevee.moretcon.other.utils.SoundHandler;
import com.existingeevee.moretcon.proxy.CommonProxy;
import com.existingeevee.moretcon.reforges.ReforgeHandler;
import com.existingeevee.moretcon.traits.ModTraits;
import com.existingeevee.moretcon.world.MoreTConWorldGen;
//import net.minecraftforge.fml.common.event.;

import net.minecraft.block.Block;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ranged.IProjectile;
import slimeknights.tconstruct.library.utils.Tags;
import thebetweenlands.common.handler.OverworldItemHandler;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = ModInfo.DEPENDANCY)
public class MoreTCon {

	@Instance
	public static MoreTCon instance;

	@SidedProxy(serverSide = "com.existingeevee.moretcon.proxy.CommonProxy", clientSide = "com.existingeevee.moretcon.proxy.ClientProxy")
	public static CommonProxy proxy;

	static {
		CustomFireEffect.init();
		MinecraftForge.EVENT_BUS.register(MoreTCon.class);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		CompatManager.init();
		SoundHandler.registerInit();
		NetworkHandler.init();
		ConfigHandler.init(event);
		ModTabs.init();
		ModPotions.init();
		GameRegistry.registerWorldGenerator(new MoreTConWorldGen(), 10);
		ModFluids.init();
		ModFluidBlocks.init();
		ModBlocks.init();
		ModMaterials.init();
		ModItems.init();
		ModSponges.init();
		for (MaterialIntegration integration : RegisterHelper.moreTConIntegrations) {
			integration.preInit();
		}
		MaterialUtils.completeReadds();
		MinecraftForge.EVENT_BUS.register(CustomFireHelper.class);
		MinecraftForge.EVENT_BUS.register(ArrowReferenceHelper.class);
		MinecraftForge.EVENT_BUS.register(ReforgeHandler.class);
		ModTraits.init();
		ModReforges.init();

		OreDictionaryManager.preInit();

		proxy.preInit();

	} 

	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		for (MaterialIntegration integration : RegisterHelper.moreTConIntegrations) {
			integration.registerFluidBlock(registry);
		}
	}

	@SubscribeEvent
	public static void registerRecipes(Register<IRecipe> event) {
		OreDictionaryManager.init();

		IForgeRegistry<IRecipe> registry = event.getRegistry();

		OreRecipes.init(event);
		UniqueToolpartRecipes.init(event);
		ReforgeRecipes.init(event);

		SpongeRegistry.registerRecipes(event);

		if (CompatManager.thebetweenlands) {
			BLRecipes.init(event);
		}

		// add the tool forge recipes from all integrations
		for (MaterialIntegration integration : RegisterHelper.moreTConIntegrations) {
			integration.registerToolForgeRecipe(registry);
		}

		MiscRecipes.init(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		FurnaceInit.init();
		SpongeRegistry.postInit();

		for (MaterialIntegration integration : RegisterHelper.moreTConIntegrations) {
			if (integration instanceof MTMaterialIntegration) {
				((MTMaterialIntegration) integration).refreshFluid();
			}
		}

		proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
		if (CompatManager.thebetweenlands && ConfigHandler.weakenToolsInBetweenLands) {
			blackListTinkerTools();
		}

		SmelteryInit.init();
		if (CompatManager.thebetweenlands) {
			BLRecipes.postInit();
		}

		if (CompatManager.thebetweenlands) {
			MinecraftForge.EVENT_BUS.register(new EventWatcherBL());
		}
		MinecraftForge.EVENT_BUS.register(new EventWatcherMain());
		for (MaterialIntegration integration : RegisterHelper.moreTConIntegrations) {
			integration.integrate();
		}
		if (ConfigHandler.maxToolDurability >= 0) {
			MinecraftForge.EVENT_BUS.register(new ExtremeToolDurabilityFix());
		}
		UniqueMaterial.onPostInit();
		CompositeRegistry.onPostInit();

		ModTraits.postInit();
		
		//You're welcome!
		ReequipHack.registerIgnoredKey(Tags.TOOL_DATA); 
		ReequipHack.registerIgnoredKey(Tags.TINKER_EXTRA); 
		ReequipHack.registerIgnoredKey(Tags.BASE_MODIFIERS);
	}

	@EventHandler
	public void loadComplete(FMLLoadCompleteEvent event) {
		MiscUtils.init();
		ReequipHack.registerIgnoredKey(Tags.TOOL_DATA);
	}

	private static void blackListTinkerTools() {
		OverworldItemHandler.TOOL_BLACKLIST.put(new ResourceLocation(ModInfo.MODID, "tinker_blacklist"), stack -> {
			if (stack.getItem() instanceof ToolCore) {
				if (stack.getTagCompound().getBoolean("moretcon.betweenified")) {
					return false;
				}
				return !(stack.getItem() instanceof IBetweenTinkerTool || stack.getItem() instanceof IProjectile);
			}
			return false;
		});
	}

	public static MoreTCon getInstance() {
		return instance;
	}
}

//ally of both trait
//move recipes away from fusionite
//swee is bozo