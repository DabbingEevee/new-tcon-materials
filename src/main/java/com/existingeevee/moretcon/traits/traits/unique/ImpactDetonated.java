package com.existingeevee.moretcon.traits.traits.unique;

import com.existingeevee.moretcon.other.utils.MiscUtils;
import com.existingeevee.moretcon.tools.tooltypes.Bomb.BombNBT;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants.NBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;

public class ImpactDetonated extends AbstractTrait {

	public ImpactDetonated() {
		super(MiscUtils.createNonConflictiveName("impact_detonated"), 0);
	}

	@Override
	public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
		return newDamage + 3;
	}

	@Override
	public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
		super.applyEffect(rootCompound, modifierTag);
		NBTTagCompound tag = TagUtil.getToolTag(rootCompound);
		if (tag.hasKey("FuseTime", NBT.TAG_INT)) {
			BombNBT nbt = new BombNBT(TagUtil.getToolTag(rootCompound));
			nbt.fuseTime = 0;
			nbt.attack *= 0.75;
			TagUtil.setToolTag(rootCompound, nbt.get());
		}
	}
}