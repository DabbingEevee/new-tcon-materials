package com.existingeevee.moretcon.traits.traits;

import java.lang.reflect.Field;
import java.util.Map;

import com.existingeevee.moretcon.entity.entities.EntityBomb;
import com.existingeevee.moretcon.inits.ModPotions;
import com.existingeevee.moretcon.other.utils.MiscUtils;
import com.existingeevee.moretcon.traits.traits.abst.IBombTrait;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class ShockAura extends AbstractTrait implements IBombTrait {

	public static final Field reapplicationDelayMap$EntityAreaEffectCloud = ObfuscationReflectionHelper.findField(EntityAreaEffectCloud.class, "field_184504_g");
	public static final Field durationOnUse$EntityAreaEffectCloud = ObfuscationReflectionHelper.findField(EntityAreaEffectCloud.class, "field_184509_av");

	public ShockAura() {
		super(MiscUtils.createNonConflictiveName("shock_aura"), 0xffffff);
	}

	@Override
	public void onDetonate(ItemStack tool, World world, EntityBomb bomb, EntityLivingBase attacker) {
		if (world.isRemote)
			return;
		EntityAreaEffectCloud cloud = new EntityAreaEffectCloud(world, bomb.posX, bomb.posY, bomb.posZ);
		cloud.setColor(0xAA0000);
		cloud.addEffect(new PotionEffect(MobEffects.GLOWING, 200, 0));
		cloud.addEffect(new PotionEffect(ModPotions.charged, 200, 3));
		cloud.setOwner(attacker);
		cloud.setRadiusOnUse(0);
		cloud.setDuration(5 * 20);
		cloud.setRadiusPerTick(0f);
		cloud.setRadius(4f);
		try {
			@SuppressWarnings("unchecked")
			Map<Entity, Integer> reapplicationDelayMap = (Map<Entity, Integer>) reapplicationDelayMap$EntityAreaEffectCloud.get(cloud);
			reapplicationDelayMap.put(attacker, Integer.MAX_VALUE); // doesnt attack the thrower
			durationOnUse$EntityAreaEffectCloud.set(cloud, 0);
		} catch (IllegalArgumentException | IllegalAccessException e) {
		}
		world.spawnEntity(cloud);
	}
}