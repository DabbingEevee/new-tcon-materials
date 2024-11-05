package com.existingeevee.moretcon.traits.traits.abst;

import com.existingeevee.moretcon.entity.entities.EntityBomb;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.ITrait;

public interface IBombTrait extends ITrait {

	default void onDetonate(ItemStack tool, World world, EntityBomb bomb, EntityLivingBase attacker) {

	}

}
