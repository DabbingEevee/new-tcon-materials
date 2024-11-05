package com.existingeevee.moretcon.traits;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.existingeevee.moretcon.MoreTCon;
import com.existingeevee.moretcon.other.utils.CompatManager;
import com.existingeevee.moretcon.other.utils.RegisterHelper;
import com.existingeevee.moretcon.traits.modifiers.Betweenified;
import com.existingeevee.moretcon.traits.modifiers.Crushing;
import com.existingeevee.moretcon.traits.modifiers.Debug;
import com.existingeevee.moretcon.traits.modifiers.Gem;
import com.existingeevee.moretcon.traits.modifiers.ModExtraTrait2;
import com.existingeevee.moretcon.traits.modifiers.Shocked;
import com.existingeevee.moretcon.traits.modifiers.Tarred;
import com.existingeevee.moretcon.traits.modifiers.Valonite;
import com.existingeevee.moretcon.traits.modifiers.internal.ModExtraTraitDisplay2;
import com.existingeevee.moretcon.traits.modifiers.misc.MatterReconstructionGel;
import com.existingeevee.moretcon.traits.modifiers.misc.RefilOverslime;
import com.existingeevee.moretcon.traits.traits.Aetheric;
import com.existingeevee.moretcon.traits.traits.Afterimage;
import com.existingeevee.moretcon.traits.traits.AntiGravity;
import com.existingeevee.moretcon.traits.traits.Approximate;
import com.existingeevee.moretcon.traits.traits.Blighted;
import com.existingeevee.moretcon.traits.traits.BottomsEnd;
import com.existingeevee.moretcon.traits.traits.Burning;
import com.existingeevee.moretcon.traits.traits.ColdFire;
import com.existingeevee.moretcon.traits.traits.Corroding;
import com.existingeevee.moretcon.traits.traits.Cryogenics;
import com.existingeevee.moretcon.traits.traits.Darkened;
import com.existingeevee.moretcon.traits.traits.Electrified;
import com.existingeevee.moretcon.traits.traits.EulersWrath;
import com.existingeevee.moretcon.traits.traits.Fireslime;
import com.existingeevee.moretcon.traits.traits.Hardcore;
import com.existingeevee.moretcon.traits.traits.Haunted;
import com.existingeevee.moretcon.traits.traits.HelpfulRadiation;
import com.existingeevee.moretcon.traits.traits.HyperGravity;
import com.existingeevee.moretcon.traits.traits.Hyperheat;
import com.existingeevee.moretcon.traits.traits.Inertia;
import com.existingeevee.moretcon.traits.traits.KineticBattery;
import com.existingeevee.moretcon.traits.traits.Leeching;
import com.existingeevee.moretcon.traits.traits.Liquid;
import com.existingeevee.moretcon.traits.traits.Luminescent;
import com.existingeevee.moretcon.traits.traits.Macrocrystaline;
import com.existingeevee.moretcon.traits.traits.Magical;
import com.existingeevee.moretcon.traits.traits.MagicallyReactive;
import com.existingeevee.moretcon.traits.traits.Overdrive;
import com.existingeevee.moretcon.traits.traits.Overgrowth;
import com.existingeevee.moretcon.traits.traits.Overslime;
import com.existingeevee.moretcon.traits.traits.Oxide;
import com.existingeevee.moretcon.traits.traits.Penetrant;
import com.existingeevee.moretcon.traits.traits.PlasmaMissiles;
import com.existingeevee.moretcon.traits.traits.Pulsating;
import com.existingeevee.moretcon.traits.traits.Pyrophoric;
import com.existingeevee.moretcon.traits.traits.Reaching;
import com.existingeevee.moretcon.traits.traits.Receptive;
import com.existingeevee.moretcon.traits.traits.Resilient;
import com.existingeevee.moretcon.traits.traits.Rootplicating;
import com.existingeevee.moretcon.traits.traits.Rotten;
import com.existingeevee.moretcon.traits.traits.Searing;
import com.existingeevee.moretcon.traits.traits.ShockAura;
import com.existingeevee.moretcon.traits.traits.SkysBlessing;
import com.existingeevee.moretcon.traits.traits.Slicing;
import com.existingeevee.moretcon.traits.traits.Slimesharp;
import com.existingeevee.moretcon.traits.traits.Soulforged;
import com.existingeevee.moretcon.traits.traits.Supercritical;
import com.existingeevee.moretcon.traits.traits.Treetap;
import com.existingeevee.moretcon.traits.traits.Tricromatic;
import com.existingeevee.moretcon.traits.traits.Voidic;
import com.existingeevee.moretcon.traits.traits.Withered;
import com.existingeevee.moretcon.traits.traits.abst.AttributeTrait;
import com.existingeevee.moretcon.traits.traits.abst.DummyTrait;
import com.existingeevee.moretcon.traits.traits.internal.PolyshotProj;
import com.existingeevee.moretcon.traits.traits.unique.AerialFlame;
import com.existingeevee.moretcon.traits.traits.unique.Autoloading;
import com.existingeevee.moretcon.traits.traits.unique.Blinkdrawn;
import com.existingeevee.moretcon.traits.traits.unique.BloodGodsBlessing;
import com.existingeevee.moretcon.traits.traits.unique.BloodyArc;
import com.existingeevee.moretcon.traits.traits.unique.Boltforged;
import com.existingeevee.moretcon.traits.traits.unique.Dematerializing;
import com.existingeevee.moretcon.traits.traits.unique.EssentialObliteration;
import com.existingeevee.moretcon.traits.traits.unique.Hailshot;
import com.existingeevee.moretcon.traits.traits.unique.ImpactDetonated;
import com.existingeevee.moretcon.traits.traits.unique.Mirroring;
import com.existingeevee.moretcon.traits.traits.unique.Offense;
import com.existingeevee.moretcon.traits.traits.unique.Plasmatic;
import com.existingeevee.moretcon.traits.traits.unique.Polyshot;
import com.existingeevee.moretcon.traits.traits.unique.Seismishock;
import com.existingeevee.moretcon.traits.traits.unique.Shockwaving;
import com.existingeevee.moretcon.traits.traits.unique.TripleShot;
import com.existingeevee.moretcon.traits.traits.unique.Wormed;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.shared.TinkerCommons;
import thebetweenlands.common.capability.circlegem.CircleGemType;
import thebetweenlands.common.registries.ItemRegistry;
import xyz.phanta.tconevo.item.ItemMaterial;

public class ModTraits {
	public static BloodGodsBlessing bloodGodsBlessing = new BloodGodsBlessing();
	public static EssentialObliteration essentialObliteration = new EssentialObliteration();
	public static Plasmatic plasmatic = new Plasmatic();
	public static TripleShot tripleshot = new TripleShot();
	public static BloodyArc bloodyArc = new BloodyArc();
	public static AerialFlame aerialFlames = new AerialFlame();
	public static Blinkdrawn blinkdrawn = new Blinkdrawn();
	public static Mirroring mirroring = new Mirroring();
	public static Seismishock seismishock = new Seismishock();
	public static Hailshot hailshot = new Hailshot();
	public static Autoloading autoloading = new Autoloading();
	public static Boltforged boltforged = new Boltforged();
	public static Dematerializing dematerializing = new Dematerializing();

	public static KineticBattery kineticBattery = new KineticBattery();
	public static Hyperheat hyperheat = new Hyperheat();
	public static ColdFire coldFire = new ColdFire();
	public static Tricromatic trichromic = new Tricromatic();
	public static HelpfulRadiation radioactive = new HelpfulRadiation();
	public static Voidic voidic = new Voidic();
	public static Pulsating pulsating = new Pulsating();
	public static Liquid liquid = new Liquid();
	public static Resilient resilient = new Resilient();
	public static Magical magical = new Magical();
	public static Hardcore hardcore = new Hardcore();
	public static HyperGravity hypergravity = new HyperGravity();
	public static BottomsEnd bottomsEnd = new BottomsEnd();
	public static Slicing slicing = new Slicing();
	public static Leeching leeching = new Leeching();
	public static Afterimage afterimage = new Afterimage();
	public static MagicallyReactive magicallyReactive = new MagicallyReactive();
	public static Penetrant penetrant = new Penetrant();
	public static Darkened darkened = new Darkened();
	public static DummyTrait etheralHarvest = new DummyTrait("etheralharvest", 0);
	public static Luminescent luminescent = new Luminescent("luminescent", 0);
	public static AttributeTrait weightless = new AttributeTrait("weightless", 0, new AttributeModifier(UUID.fromString("aed073df-79af-4de9-b62c-44b5fcc4df1d"), "weightless", 1.00, 2), SharedMonsterAttributes.ATTACK_SPEED);
	public static AttributeTrait shielding = new AttributeTrait("shielding", 0, new AttributeModifier(UUID.fromString("aed073df-79af-4de9-b62c-44b5fcc44fef"), "shielding", 4, 0), SharedMonsterAttributes.ARMOR).setWorksInOffhand(true);
	public static Overdrive overdrive = new Overdrive();
	public static Overslime overslime = new Overslime();
	public static DummyTrait overcast = new DummyTrait("overcast", 0);
	public static Overgrowth overgrowth = new Overgrowth(1);
	public static Overgrowth overgrowth2 = new Overgrowth(2);
	public static Fireslime fireslime = new Fireslime();
	public static Electrified electrified = new Electrified();
	public static Haunted haunted = new Haunted();
	public static Soulforged soulforged = new Soulforged(1);
	public static Soulforged soulforged2 = new Soulforged(2);
	public static Withered withered = new Withered();
	public static Blighted blighted = new Blighted();
	public static Receptive receptive = new Receptive();
	public static Offense offense = new Offense();
	public static Reaching reaching = new Reaching(1);
	public static Reaching reaching2 = new Reaching(2);
	public static Supercritical supercritical1 = new Supercritical(1);
	public static Supercritical supercritical2 = new Supercritical(2);
	public static Aetheric aetheric = new Aetheric();
	public static Rootplicating rootplicating = new Rootplicating();
	public static SkysBlessing blessed = new SkysBlessing();
	public static Treetap treetap = new Treetap();
	public static Pyrophoric pyrophoric = new Pyrophoric();
	public static Searing searing = new Searing(1);
	public static Searing searing2 = new Searing(2);
	public static EulersWrath eularsWrath = new EulersWrath();
	public static PlasmaMissiles plasmaMissiles = new PlasmaMissiles();
	public static Approximate approximate = new Approximate(1);
	public static Approximate approximate2 = new Approximate(2);
	public static Slimesharp slimesharp = new Slimesharp();
	public static Polyshot polyshot = new Polyshot();
	public static Macrocrystaline macrocrystaline = new Macrocrystaline();
	public static ImpactDetonated impactDetonated = new ImpactDetonated();
	public static Cryogenics cryogenics = new Cryogenics();
	public static ShockAura shockingAura = new ShockAura();
	
	public static PolyshotProj polyshotProj = new PolyshotProj();

	public static AntiGravity antigravity;

	public static Gem modRedGem;
	public static Gem modGreenGem;
	public static Gem modBlueGem;
	public static Shocked modShocked;
	public static Valonite modValonite;
	public static Tarred modTarred;
	public static Betweenified modBetweenified;

	public static Corroding corroding;

	public static Crushing modCrushing;

	public static Debug modDebug;

	public static Shockwaving shockwaving;
	public static Rotten rotten;
	public static Oxide oxide;
	public static Wormed wormed;
	public static Burning burning; // TODO move away from bl
	public static Inertia inertia;

	public static MatterReconstructionGel repair;

	static {
		if (CompatManager.thebetweenlands) {
			shockwaving = new Shockwaving();
			rotten = new Rotten();
			corroding = new Corroding();
			modBetweenified = new Betweenified();
			oxide = new Oxide();
			wormed = new Wormed();
			burning = new Burning();
			inertia = new Inertia();
		}
		if (CompatManager.aether_legacy) {
			antigravity = new AntiGravity();
		}
	}

	private static void registerModifier(IModifier... mod) {
		for (IModifier i : mod) {
			RegisterHelper.registerModifier(i);
		}
	}

	public static void init() {
		if (CompatManager.loadMain) {
			modDebug = new Debug();
			repair = new MatterReconstructionGel();
			modCrushing = new Crushing();
			registerModifier(
					modCrushing);
		}
		if (CompatManager.thebetweenlands) {
			modRedGem = new Gem(CircleGemType.CRIMSON, ItemRegistry.CRIMSON_MIDDLE_GEM, 0xFF0000);
			modGreenGem = new Gem(CircleGemType.GREEN, ItemRegistry.GREEN_MIDDLE_GEM, 0x00FF00);
			modBlueGem = new Gem(CircleGemType.AQUA, ItemRegistry.AQUA_MIDDLE_GEM, 0x0000FF);
			modShocked = new Shocked();
			modValonite = new Valonite();
			modTarred = new Tarred();
			registerModifier(
					modRedGem,
					modGreenGem,
					modBlueGem,
					modValonite,
					modTarred,
					modShocked);

		}
	}

	public static void postInit() {
		if (CompatManager.tic3backport) {
			if (TinkerCommons.matSlimeCrystalGreen != null) {
				new RefilOverslime("green", 50).addItem(TinkerCommons.matSlimeCrystalGreen, 1, 1);
			}
			if (TinkerCommons.matSlimeCrystalBlue != null) {
				new RefilOverslime("blue", 75).addItem(TinkerCommons.matSlimeCrystalBlue, 1, 1);
			}
			if (TinkerCommons.matSlimeCrystalMagma != null) {
				new RefilOverslime("magma", 150).addItem(TinkerCommons.matSlimeCrystalMagma, 1, 1);
			}

			if (Loader.isModLoaded("tconevo")) {
				new RefilOverslime("pink", 200).addItem(ItemMaterial.Type.PINK_SLIME_CRYSTAL.newStack(1), 1, 1);
			}
		}

		registerExtraTraitModifiers();
		if (MoreTCon.proxy.isClient()) {
			registerModifier(new ModExtraTraitDisplay2());
		}
	}

	private static Map<String, ModExtraTrait2> extraTraitLookup = new HashMap<>();
	public static List<Modifier> extraTraitMods;

	private static void registerExtraTraitModifiers() {
		TinkerRegistry.getAllMaterials().forEach(ModTraits::registerExtraTraitModifiers);
		extraTraitMods = Lists.newArrayList(extraTraitLookup.values());
	}

	private static void registerExtraTraitModifiers(Material material) {
		TinkerRegistry.getTools().forEach(tool -> registerExtraTraitModifiers(material, tool));
	}

	private static void registerExtraTraitModifiers(Material material, ToolCore tool) {
		tool.getRequiredComponents().forEach(pmt -> registerExtraTraitModifiers(material, tool, pmt));
	}

	private static void registerExtraTraitModifiers(Material material, ToolCore tool, PartMaterialType partMaterialType) {
		partMaterialType.getPossibleParts().forEach(part -> registerExtraTraitModifiers(material, tool, partMaterialType, part));
	}

	@SuppressWarnings("unchecked")
	private static <T extends Item & IToolPart> void registerExtraTraitModifiers(Material material, ToolCore tool, PartMaterialType partMaterialType, IToolPart toolPart) {
		if (toolPart instanceof Item) {
			Collection<ITrait> traits = partMaterialType.getApplicableTraitsForMaterial(material);
			if (!traits.isEmpty()) {
				// we turn it into a set to remove duplicates, reducing the total amount of
				// modifiers created by roughly 25%!
				final Collection<ITrait> traits2 = ImmutableSet.copyOf(traits);
				String identifier = ModExtraTrait2.generateIdentifier(material, traits2);
				ModExtraTrait2 mod = extraTraitLookup.computeIfAbsent(identifier, id -> new ModExtraTrait2(material, traits2, identifier));
				mod.addCombination(tool, (T) toolPart);
			}
		}
	}
}
