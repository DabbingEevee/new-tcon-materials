package com.existingeevee.moretcon.tools.tooltypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import com.existingeevee.moretcon.entity.entities.EntityBomb;
import com.existingeevee.moretcon.inits.ModMaterials;
import com.existingeevee.moretcon.inits.ModTools;
import com.existingeevee.moretcon.other.utils.MiscUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import slimeknights.tconstruct.library.materials.AbstractMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ProjectileNBT;
import slimeknights.tconstruct.library.tools.ranged.ProjectileCore;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.TinkerTools;

public class Bomb extends ProjectileCore implements MaterialTypes {

	public static final String EXPLOSIVE_CHARGE = MiscUtils.createNonConflictiveName("explosive_charge");

	public Bomb() {
		super(
				PartMaterialType.head(ModTools.shrapnel),
				PartMaterialType.extra(ModTools.smallPlate),
				PartMaterialType.handle(TinkerTools.largePlate),
				PartMaterialType.handle(TinkerTools.largePlate),
				new PartMaterialType(ModTools.explosiveCharge, EXPLOSIVE_CHARGE));

		this.addCategory(Category.NO_MELEE, Category.PROJECTILE, Category.AOE);
		this.setUnlocalizedName(MiscUtils.createNonConflictiveName("bomb"));

		TinkerRegistry.registerToolForgeCrafting(this);
		
		this.durabilityPerAmmo = 25;
	}

	@Override
	public int[] getRepairParts() {
		return new int[] { 0 };
	}

	@Override
	public float damagePotential() {
		return 0.5f;
	}

	@Override
	public String getItemStackDisplayName(@Nonnull ItemStack stack) {
		List<Material> materials = TinkerUtil.getMaterialsFromTagList(TagUtil.getBaseMaterialsTagList(stack));
		Set<Material> nameMaterials = Sets.newLinkedHashSet();

		for (int index : getRepairParts()) {
			if (index < materials.size()) {
				nameMaterials.add(materials.get(index));
			}
		}

		if (4 < materials.size()) {
			nameMaterials.add(materials.get(4)); // charge
		}
		
		return Material.getCombinedItemName(I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name").trim(), nameMaterials);
	}

	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemStackIn = playerIn.getHeldItem(hand);
		if (ToolHelper.isBroken(itemStackIn)) {
			return ActionResult.newResult(EnumActionResult.FAIL, itemStackIn);
		}
		playerIn.getCooldownTracker().setCooldown(itemStackIn.getItem(), 20);

		if (!worldIn.isRemote) {
			boolean usedAmmo = useAmmo(itemStackIn, playerIn);
			EntityProjectileBase projectile = getProjectile(itemStackIn, itemStackIn, worldIn, playerIn, 2.1f, 0f, 1f, usedAmmo);
			worldIn.spawnEntity(projectile);

			worldIn.playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_FIREWORK_LAUNCH, SoundCategory.PLAYERS, 2, 1.5f);
		}

		return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
	}

	@Override
	public ProjectileNBT buildTagData(List<Material> materials) {
		BombNBT data = new BombNBT();

		data.head(materials.get(0).getStatsOrUnknown(HEAD));
		data.extra(materials.get(1).getStatsOrUnknown(EXTRA));
		data.handle(materials.get(2).getStatsOrUnknown(HANDLE), materials.get(3).getStatsOrUnknown(HANDLE));
		data.charge(materials.get(4).getStatsOrUnknown(EXPLOSIVE_CHARGE));

		data.accuracy = 1f; // nuh uh
		return data;
	}

	@Override
	public EntityProjectileBase getProjectile(ItemStack stack, ItemStack launcher, World world, EntityPlayer player, float speed, float inaccuracy, float progress, boolean usedAmmo) {
		inaccuracy *= ProjectileNBT.from(stack).accuracy;
		EntityBomb bomb = new EntityBomb(world, player, speed, inaccuracy, getProjectileStack(stack, world, player, usedAmmo), launcher);
		bomb.setFuse(TagUtil.getToolTag(stack).getInteger("FuseTime"));
		return bomb;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if (this.isInCreativeTab(tab)) {
			for (Material main : TinkerRegistry.getAllMaterials()) {
				List<Material> mats = new ArrayList<>();

				if (main.hasStats(MaterialTypes.HEAD) &&
						main.hasStats(MaterialTypes.HANDLE) &&
						main.hasStats(MaterialTypes.EXTRA)) {

					mats.add(main);
					mats.add(main);
					mats.add(main);
					mats.add(main);
					mats.add(ModMaterials.materialGunpowder);

					ItemStack tool = buildItem(mats);
					// only valid ones
					if (hasValidMaterials(tool)) {
						subItems.add(tool);
						if (!Config.listAllToolMaterials) {
							break;
						}
					}
				}
			}
		}
	}

	public static class BombNBT extends ProjectileNBT {
		public double radius;
		public int fuseTime;

		public BombNBT charge(ExplosiveMaterialStats... explosives) {
			double rad = 0;
			int fus = 0;
			for (ExplosiveMaterialStats explosive : explosives) {
				if (explosive != null) {
					rad += explosive.radius;
					fus += explosive.fuseTime;
				}
			}
			this.radius += rad / explosives.length;
			this.fuseTime += Math.round(fus / explosives.length);
			return this;
		}

		@Override
		public void read(NBTTagCompound tag) {
			super.read(tag);
			this.radius = tag.getDouble("Radius");
			this.fuseTime = tag.getInteger("FuseTime");
		}

		@Override
		public void write(NBTTagCompound tag) {
			super.write(tag);
			tag.setDouble("Radius", radius);
			tag.setInteger("FuseTime", fuseTime);
		}
	}

	public static class ExplosiveMaterialStats extends AbstractMaterialStats {

		public final static String LOC_Radius = "stat.explosive.radius.name";
		public final static String LOC_FuseTime = "stat.explosive.fuse_time.name";

		public final static String LOC_RadiusDesc = "stat.explosive.radius.desc";
		public final static String LOC_FuseTimeDesc = "stat.explosive.fuse_time.desc";

		public double radius;
		public int fuseTime;

		public ExplosiveMaterialStats(double radius, int fuseTime) {
			super(EXPLOSIVE_CHARGE);
			this.radius = radius;
			this.fuseTime = fuseTime;
		}

		@Override
		public List<String> getLocalizedInfo() {
			return ImmutableList.of(formatRadius(radius),
					formatFuseTime(fuseTime));
		}

		@Override
		public List<String> getLocalizedDesc() {
			return ImmutableList.of(Util.translate(LOC_RadiusDesc),
					Util.translate(LOC_FuseTimeDesc));
		}

		public static String formatRadius(double radius) {
			return formatNumber(LOC_Radius, HeadMaterialStats.COLOR_Attack, (float) radius);
		}

		public static String formatFuseTime(int fuseTime) {
			return formatNumber(LOC_FuseTime, HeadMaterialStats.COLOR_Durability, fuseTime / 20f) +
					HeadMaterialStats.COLOR_Durability + "s" + TextFormatting.RESET;
		}
	}
}
