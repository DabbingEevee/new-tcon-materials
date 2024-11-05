package com.existingeevee.moretcon.entity.entities;

import java.util.List;

import com.existingeevee.moretcon.client.actions.BombAction;
import com.google.common.collect.Multimap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.Constants.NBT;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ranged.ILauncher;
import slimeknights.tconstruct.library.tools.ranged.IProjectile;
import slimeknights.tconstruct.library.traits.IProjectileTrait;
import slimeknights.tconstruct.library.utils.AmmoHelper;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class EntityBomb extends EntityProjectileBase {

	private static final DataParameter<Boolean> PRIMED = EntityDataManager.createKey(EntityBomb.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> TIME_REMAINING = EntityDataManager.createKey(EntityBomb.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> TIME_REMAINING_INITIAL = EntityDataManager.createKey(EntityBomb.class, DataSerializers.VARINT);

	Vec3d stuckPos = null;

	public EntityBomb(World world) {
		super(world);
	}

	public EntityBomb(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityBomb(World world, EntityPlayer player, float speed, float inaccuracy, ItemStack stack, ItemStack launchingStack) {
		super(world, player, speed, inaccuracy, 1f, stack, launchingStack);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tags) {
		super.writeEntityToNBT(tags);

		tags.setBoolean("Primed", this.isPrimed());
		tags.setInteger("Fuse", this.getTimeRemaining());
		tags.setInteger("FuseInitial", this.getTimeRemainingInitial());

		if (stuckPos != null) {
			NBTTagCompound pos = new NBTTagCompound();
			pos.setDouble("X", stuckPos.x);
			pos.setDouble("Y", stuckPos.y);
			pos.setDouble("Z", stuckPos.z);
			tags.setTag("StuckPos", pos);
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tags) {
		super.readEntityFromNBT(tags);

		this.setPrimed(tags.getBoolean("Primed"));
		this.dataManager.set(TIME_REMAINING, tags.getInteger("Fuse"));
		this.dataManager.set(TIME_REMAINING_INITIAL, tags.getInteger("FuseInitial"));

		if (tags.hasKey("StuckPos", NBT.TAG_COMPOUND)) {
			NBTTagCompound pos = tags.getCompoundTag("StuckPos");
			stuckPos = new Vec3d(pos.getDouble("X"), pos.getDouble("Y"), pos.getDouble("Z"));
		} else {
			this.stuckPos = null;
		}
	}

	@Override
	protected void playHitBlockSound(float speed, IBlockState state) {

	}
	
	@Override
	protected void init() {
		setSize(0.2f, 0.2f);

		this.dataManager.register(PRIMED, false);
		this.dataManager.register(TIME_REMAINING, 10);
		this.dataManager.register(TIME_REMAINING_INITIAL, 10);
		
		this.pickupStatus = PickupStatus.DISALLOWED;
	}

	@Override
	public double getGravity() {
		return 0.1;
	}

	@Override
	public double getSlowdown() {
		return 0.05f;
	}

	@Override
	protected void playHitEntitySound() {

	}

	public int getTimeRemaining() {
		return this.dataManager.get(TIME_REMAINING);
	}

	public int getTimeRemainingInitial() {
		return this.dataManager.get(TIME_REMAINING_INITIAL);
	}

	public void onHitEntity(RayTraceResult raytraceResult) {
		this.ticksInAir = 0;

		if (raytraceResult.entityHit != null) {
			this.motionX = 0;
			this.motionY = 0;
			this.motionZ = 0;
			this.velocityChanged = true;
			stuckPos = raytraceResult.hitVec;
		}

		playHitEntitySound();
		this.setPrimed(true);
	}

	@Override
	public void onUpdate() {
		this.pickupStatus = PickupStatus.DISALLOWED;

		super.onUpdate();

		if (stuckPos != null) {
			this.posX = stuckPos.x;
			this.posY = stuckPos.y;
			this.posZ = stuckPos.z;

			this.prevPosX = stuckPos.x;
			this.prevPosY = stuckPos.y;
			this.prevPosZ = stuckPos.z;
		}

		if (this.isPrimed()) {
			if (getTimeRemaining() > 0) {
				this.dataManager.set(TIME_REMAINING, getTimeRemaining() - 1);
			} else {
				this.explode();
			}
		}
		
		if (world.isRemote) {
			world.spawnParticle(EnumParticleTypes.FLAME, true, posX, posY + 0.6, posZ, 0, 0, 0);
		}
	}

	public void setFuse(int fuse) {
		this.dataManager.set(TIME_REMAINING, fuse);
		this.dataManager.set(TIME_REMAINING_INITIAL, fuse);
	}

	public void explode() {
		ItemStack item = tinkerProjectile.getItemStack();
		if (item.getItem() instanceof ToolCore && this.shootingEntity instanceof EntityLivingBase) {
			EntityLivingBase attacker = (EntityLivingBase) this.shootingEntity;
			ItemStack inventoryItem = AmmoHelper.getMatchingItemstackFromInventory(tinkerProjectile.getItemStack(), attacker, false);

			if (tinkerProjectile.getItemStack().hasTagCompound() && tinkerProjectile.getItemStack().getTagCompound().getBoolean("PreventInvLink")) {
				inventoryItem = ItemStack.EMPTY;
			}

			if (inventoryItem.isEmpty() || inventoryItem.getItem() != item.getItem()) {
				// backup, use saved itemstack
				inventoryItem = item;
			}

			double radius = getDoubleTag(item, "Radius");

			AxisAlignedBB box = new AxisAlignedBB(posX, posY, posZ, posX, posY, posZ).grow(radius);
			List<EntityLivingBase> entities = this.world.getEntitiesWithinAABB(EntityLivingBase.class, box, e -> e != attacker);

			for (EntityLivingBase e : entities) {
				ItemStack launcher = tinkerProjectile.getLaunchingStack();
				boolean hit = false;

				// for the sake of dealing damage we always ensure that the impact itemstack has
				// the correct broken state
				// since the ammo stack can break while the arrow travels/if it's the last arrow
				boolean brokenStateDiffers = ToolHelper.isBroken(inventoryItem) != ToolHelper.isBroken(item);
				if (brokenStateDiffers) {
					toggleBroken(inventoryItem);
				}

				Multimap<String, AttributeModifier> projectileAttributes = null;
				// remove stats from held items
				if (!getEntityWorld().isRemote) {
					unequip(attacker, EntityEquipmentSlot.OFFHAND);
					unequip(attacker, EntityEquipmentSlot.MAINHAND);

					// apply stats from projectile
					if (item.getItem() instanceof IProjectile) {
						projectileAttributes = ((IProjectile) item.getItem()).getProjectileAttributeModifier(inventoryItem);

						if (launcher.getItem() instanceof ILauncher) {
							((ILauncher) launcher.getItem()).modifyProjectileAttributes(projectileAttributes, tinkerProjectile.getLaunchingStack(), tinkerProjectile.getItemStack(), tinkerProjectile.getPower());
						}

						// factor in power
						projectileAttributes.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
								new AttributeModifier(PROJECTILE_POWER_MODIFIER, "Weapon damage multiplier", tinkerProjectile.getPower(), 2));

						attacker.getAttributeMap().applyAttributeModifiers(projectileAttributes);
					}
					// deal the damage
					hit = !dealDamage(0, inventoryItem, attacker, e);
					if (!hit) {
						for (IProjectileTrait trait : tinkerProjectile.getProjectileTraits()) {
							trait.afterHit(this, getEntityWorld(), inventoryItem, attacker, e, 0);
						}

						// if on fire, set the entity on fire, like vanilla arrows
						if (this.isBurning() && !(e instanceof EntityEnderman)) {
							e.setFire(5);
						}
					}
					if (brokenStateDiffers) {
						toggleBroken(inventoryItem);
					}

					// remove stats from projectile
					// apply stats from projectile
					if (item.getItem() instanceof IProjectile) {
						assert projectileAttributes != null;
						attacker.getAttributeMap().removeAttributeModifiers(projectileAttributes);
					}

					// readd stats from held items
					equip(attacker, EntityEquipmentSlot.MAINHAND);
					equip(attacker, EntityEquipmentSlot.OFFHAND);
				}
			}
		}

		if (!world.isRemote && world instanceof WorldServer) {
			new BombAction().run(world, posX, posY, posZ, new NBTTagCompound());
			this.world.playSound(null, this.getPosition(), SoundEvents.ENTITY_FIREWORK_LARGE_BLAST, SoundCategory.PLAYERS, 2, 0.2f);
			((WorldServer) world).spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, posX, posY, posZ, 0, 0, 0, 0, 0, new int[0]);
		}

		this.setDead();
	}

	@Override
	public void onHitBlock(RayTraceResult raytraceResult) {
		super.onHitBlock(raytraceResult);
		this.setPrimed(true);
	}

	public void setPrimed(boolean primed) {
		if (!world.isRemote && primed && !isPrimed()) {
			this.world.playSound(null, this.getPosition(), SoundEvents.BLOCK_DISPENSER_FAIL, SoundCategory.PLAYERS, 2, 1.5f);
		}
		
		this.dataManager.set(PRIMED, primed);
	}

	public boolean isPrimed() {
		return this.dataManager.get(PRIMED);
	}

	@Override
	public ItemStack getArrowStack() {
		return tinkerProjectile.getItemStack();
	}

	static double getDoubleTag(ItemStack stack, String key) {
		NBTTagCompound tag = TagUtil.getToolTag(stack);
		return tag.getDouble(key);
	}

	static double getIntTag(ItemStack stack, String key) {
		NBTTagCompound tag = TagUtil.getToolTag(stack);
		return tag.getInteger(key);
	}

	private void unequip(EntityLivingBase entity, EntityEquipmentSlot slot) {
		ItemStack stack = entity.getItemStackFromSlot(slot);
		if (!stack.isEmpty()) {
			entity.getAttributeMap().removeAttributeModifiers(stack.getAttributeModifiers(slot));
		}
	}

	private void equip(EntityLivingBase entity, EntityEquipmentSlot slot) {
		ItemStack stack = entity.getItemStackFromSlot(slot);
		if (!stack.isEmpty()) {
			entity.getAttributeMap().applyAttributeModifiers(stack.getAttributeModifiers(slot));
		}
	}

	private void toggleBroken(ItemStack stack) {
		NBTTagCompound tag = TagUtil.getToolTag(stack);
		tag.setBoolean(Tags.BROKEN, !tag.getBoolean(Tags.BROKEN));
		TagUtil.setToolTag(stack, tag);
	}

}
