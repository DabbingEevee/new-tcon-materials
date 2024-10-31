package com.existingeevee.moretcon.config;

import java.io.File;

import com.existingeevee.moretcon.ModInfo;
import com.existingeevee.moretcon.other.MoreTConLogger;
import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	public static File configFile;

	public static Configuration config;

	public static boolean shouldAllowEasterEggItems = true;
	public static boolean shouldAllowTwilightForest = true;
	public static boolean shouldAllowIceAndFire = false;
	public static boolean shouldAllowPlusTiC = true;
	public static boolean shouldAllowBetweenLands = true;
	public static boolean shouldAllowMainContent = true;
	public static boolean shouldAllowOreDictionary = true;
	public static boolean shouldAllowCrossCompat = true;
	public static boolean shouldAllowAether = true;
	public static boolean shouldAllowBaubles = true;
	public static boolean shouldAllowConstructsArmory = true;
	public static boolean shouldAllowTiC3ContentBackport = true;

	public static boolean shouldLoadDust = true;
	public static boolean shouldLoadDustForCompatability = true;

	public static boolean disableOreGen = false;

	public static boolean weakenToolsInBetweenLands = true;
	public static boolean registerBetweenTinkerTools = true;

	public static String[] blacklist = { "moretcon.example" };

	public static boolean middleGemsRequireModifierSlots = true;

	public static int maxToolDurability = (int) Math.pow(2, 15) - 1;

	public static int decayingEffectEntityID = 8690001;
	public static int plasmaBoltEntityID = 8690002;

	public static boolean shouldDurabilityCapNonProjectiles = true;

	public static int hyperheatMaximumStack = 4;

	public static ResourceLocation trichromicRed = new ResourceLocation("minecraft:strength");
	public static ResourceLocation trichromicGreen = new ResourceLocation("none");
	public static ResourceLocation trichromicBlue = new ResourceLocation("none");

	public static int trichromicRedLvl = 1;
	public static int trichromicGreenLvl = 1;
	public static int trichromicBlueLvl = 1;

	public static String[] removeUniqueToolpartRecipes = { "moretcon.uniqueexample" };

	public static boolean enableGauntlet = true;
	public static boolean enableRing = true;

	public static boolean unfracturedBedrockObtainable = true;

	public static boolean inertiaOnlyWorksOnAdvancedTools = false;

	public static boolean invasiveWorldgen = true;

	public static void initConfig(File file) {
		config = new Configuration(file, ModInfo.VERSION);

		config.load();

		String category;

		category = "Allow Loading";
		config.addCustomCategoryComment(category, "Allows the loading of certain mod compatibilities.");
		ConfigHandler.shouldAllowTwilightForest = config.getBoolean("twilightforest", category, true, "Set to \"false\" if you don't want to allow Twilight Forest compatibility to load.");
		ConfigHandler.shouldAllowIceAndFire = config.getBoolean("iceandfire", category, true, "[NYI] Set to \"false\" if you don't want to allow Ice and Fire compatibility to load.");
		ConfigHandler.shouldAllowPlusTiC = config.getBoolean("plustic", category, true, "Set to \"false\" if you don't want to allow PlusTiC compatibility to load.");
		ConfigHandler.shouldAllowBetweenLands = config.getBoolean("thebetweenlands", category, true, "Set to \"false\" if you don't want to allow Betweenlands compatibility to load.");
		ConfigHandler.shouldAllowEasterEggItems = config.getBoolean("jokes", category, true, "Set to \"false\" if you don't want to allow Easter Eggs and Jokes to load.");
		ConfigHandler.shouldAllowCrossCompat = config.getBoolean("crosscompat", category, true, "[NYI] Set to \"false\" if you don't want to allow cross compatibility between mods to load.");
		ConfigHandler.shouldAllowMainContent = config.getBoolean("main", category, true, "Set to \"false\" if you don't want to allow things from the main mod to load.");
		ConfigHandler.shouldAllowAether = config.getBoolean("aether_legacy", category, true, "Set to \"false\" if you don't want to allow Aether compatibility to load.");
		ConfigHandler.shouldAllowBaubles = config.getBoolean("baubles", category, true, "Set to \"false\" if you don't want to allow Baubles compatibility to load. (FYI disabling this may leave leave some items without recipes)");
		ConfigHandler.shouldAllowOreDictionary = config.getBoolean("oredict", category, true, "[NYI] Set to \"false\" if you don't want to allow oredict compatibility to load.");
		ConfigHandler.shouldAllowTiC3ContentBackport = config.getBoolean("tic3backport", category, true, "Set to \"false\" if you don't want to allow backported content from Tinker's Construct 3 to load.");

		category = "Misc";
		config.addCustomCategoryComment(category, "Tweak the miscellaneous values/content of the mod");
		ConfigHandler.shouldLoadDust = config.getBoolean("allowdust", category, true, "Set to \"true\" if you want to load dust.");
		ConfigHandler.enableGauntlet = config.getBoolean("enablegauntlet", category, true, "Set to \"false\" if you want to disable the gauntlet tool.");
		ConfigHandler.enableRing = config.getBoolean("enablering", category, true, "Set to \"false\" if you want to disable the ring tool.");
		ConfigHandler.shouldLoadDustForCompatability = config.getBoolean("compatdust", category, true, "Set to \"false\" if you do not want to load dust for other mods.");
		ConfigHandler.weakenToolsInBetweenLands = config.getBoolean("weakennonbetweentinkers", category, true, "Set to \"false\" if you do not want to weaken non BetweenTinker tinker items.");
		ConfigHandler.registerBetweenTinkerTools = config.getBoolean("registerBetweenTinkerTools".toLowerCase(), category, true, "Set to \"false\" if you do not want to  BetweenTinker tinker items to be loaded.");
		ConfigHandler.middleGemsRequireModifierSlots = config.getBoolean("middleGemsRequireModifierSlots".toLowerCase(), category, true, "Set to \"false\" if you do not want to Betweenlands middle gems to cost modifier slots.");
		String triRed = config.getString("trichromic_red", category, "minecraft:strength;1", "Set to a potion effect to affect trichromic color effect.");
		String triGreen = config.getString("trichromic_green", category, "none;0", "Set to a potion effect to affect trichromic color effect, or \"none\" for default effect.");
		String triBlue = config.getString("trichromic_blue", category, "none;0", "Set to a potion effect to affect trichromic color effect, or \"none\" for default effect.");
		
		unfracturedBedrockObtainable = config.getBoolean("unfracturedbedrockobtainable", category, unfracturedBedrockObtainable, "Whether or not regular (typically unbreakable) bedrock should be obtainable.");
		ConfigHandler.inertiaOnlyWorksOnAdvancedTools = config.getBoolean("inertiaOnlyWorksOnAdvancedTools".toLowerCase(), category, false, "Set to \"true\" if you do not want inertia (betweenlands greataxe/greatsword trait) to function on basic tools.");

		try {
			ConfigHandler.trichromicRed = new ResourceLocation(triRed.split(";")[0]);
			ConfigHandler.trichromicRedLvl = Integer.parseInt(triRed.split(";")[1]);
		} catch (NumberFormatException e) {
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		try {
			ConfigHandler.trichromicGreen = new ResourceLocation(triGreen.split(";")[0]);
			ConfigHandler.trichromicGreenLvl = Integer.parseInt(triGreen.split(";")[1]);
		} catch (NumberFormatException e) {
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		try {
			ConfigHandler.trichromicBlue = new ResourceLocation(triBlue.split(";")[0]);
			ConfigHandler.trichromicBlueLvl = Integer.parseInt(triBlue.split(";")[1]);
		} catch (NumberFormatException e) {
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		hyperheatMaximumStack = config.getInt("hyperheatmaximumstack", category, 4, 1, 127, "The maximum stack of Hyper Heat that is allowed");

		category = "Worldgen";
		ConfigHandler.disableOreGen = config.getBoolean("disableoregen", category, false, "Set to \"true\" if you want to remove world generation");
		ConfigHandler.invasiveWorldgen  = config.getBoolean("invasiveworldgen", category, true, "Set to \"false\" if you want to disable more invasive worldgen aspects. (IE new biomes ect.)");
		
		category = "Durability Issue Fix";
		config.addCustomCategoryComment(category, "A category dedicated to fixing the strange behavior of tools with durability greater than (2 ^ 15 - 1)");

		ConfigHandler.maxToolDurability = config.getInt("maxtooldurability", category, (int) Math.pow(2, 15) - 1, -1, Integer.MAX_VALUE, "Set to \"-1\" if you do not want to cap tool durability. Values higher than 32767 may cause tool durability issues upon relog, values higher than 65535 will break projectiles entities.");
		ConfigHandler.shouldDurabilityCapNonProjectiles = config.getBoolean("shoulddurabilitycapnonprojectiles", category, true, "Set to \"false\" if you do not want the durability cap to affect non-projectile tools.");

		category = "Blacklist";
		config.addCustomCategoryComment(category, "Remove some of the added materials. Example: \"" + MiscUtils.createNonConflictiveName("fusionite") + "\"");
		ConfigHandler.blacklist = config.getStringList("blacklist", category, new String[] { MiscUtils.createNonConflictiveName("example") }, "Add materials to blacklist");

		ConfigHandler.removeUniqueToolpartRecipes = config.getStringList("uniquereciperemoval", category, new String[] { MiscUtils.createNonConflictiveName("unqiueexample") }, "Add Unique Toolpart recipe to blacklist");

		category = "IDs";
		config.addCustomCategoryComment(category, "A category dedicated to a list of ID's of various things which may cause errors if they are not unique");
		ConfigHandler.decayingEffectEntityID = config.getInt("decayingEffectEntityID".toLowerCase(), category, 8690001, Integer.MIN_VALUE, Integer.MAX_VALUE, "Decaying Effect Entity ID");
		ConfigHandler.plasmaBoltEntityID = config.getInt("plasmaBoltEntityID".toLowerCase(), category, 8690002, Integer.MIN_VALUE, Integer.MAX_VALUE, "Plasma Bolt Entity ID");
		config.save();

		MoreTConLogger.log("Finished Reading Config.");
	}

	public static void init(FMLPreInitializationEvent event) {
		configFile = new File(event.getModConfigurationDirectory() + "/" + ModInfo.MODID);
		configFile.mkdirs();
		initConfig(new File(configFile.getPath(), ModInfo.MODID + ".cfg"));
	}
}
