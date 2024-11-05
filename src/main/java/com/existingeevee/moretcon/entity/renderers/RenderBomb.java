package com.existingeevee.moretcon.entity.renderers;

import com.existingeevee.moretcon.entity.entities.EntityBomb;
import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RenderBomb extends RenderSnowball<EntityBomb> {

	public RenderBomb(RenderManager renderManagerIn) {
		super(renderManagerIn, Items.AIR, Minecraft.getMinecraft().getRenderItem());
	}

	@Override
	public void doRender(EntityBomb entity, double x, double y, double z, float entityYaw, float partialTicks) {
		double offsetMultiplier = 0;
		
		if (entity.isPrimed()) {
			double timeRemaining = entity.getTimeRemaining() - partialTicks;
			double explosionProgress = Math.min(1, Math.max(0, 1 - timeRemaining / entity.getTimeRemainingInitial()));
			offsetMultiplier += Math.pow(explosionProgress, 4) * 0.1d;
		}
		
		double xOffset = MiscUtils.randomN1T1() * offsetMultiplier;
		double yOffset = MiscUtils.randomN1T1() * offsetMultiplier + 0.125;
		double zOffset = MiscUtils.randomN1T1() * offsetMultiplier;
		
		super.doRender(entity, x + xOffset, y + yOffset, z + zOffset, entityYaw, partialTicks);
	}

	@Override
	public ItemStack getStackToRender(EntityBomb entityIn) {
		return entityIn.getArrowStack();
	}
}
