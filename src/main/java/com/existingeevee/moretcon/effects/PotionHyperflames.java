package com.existingeevee.moretcon.effects;

import com.existingeevee.moretcon.ModInfo;
import com.existingeevee.moretcon.other.fires.CustomFireHelper;
import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionHyperflames extends Potion {
	private final ResourceLocation potionIcon;

	public PotionHyperflames() {
		super(true, 0xff7777);
		setRegistryName("hyperflames");
		setPotionName(MiscUtils.createNonConflictiveName("hyperflames"));
		potionIcon = new ResourceLocation(ModInfo.MODID + ":textures/other/coldflames.png");
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onDamage(LivingHurtEvent event) {
		if (event.getSource().isFireDamage() && event.getEntityLiving().isPotionActive(this)) {
			event.setAmount(event.getAmount() * (event.getEntityLiving().getActivePotionEffect(this).getAmplifier() + 1));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isBeneficial() {
		return false;
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public boolean shouldRenderInvText(PotionEffect effect) {
		return true;
	}

	@Override
	public boolean shouldRenderHUD(PotionEffect effect) {
		return true;
	}

	@Override
	public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMapIn,
			int amplifier) {
	}

	@Override
	public void performEffect(EntityLivingBase entity, int amplifier) {
		if (!entity.isBurning() && (CustomFireHelper.getBurningInfo(entity) == null || CustomFireHelper.getBurningInfo(entity).isInvalid())) {
			entity.setFire(1);
		}
	}

	@Override
	public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMapIn,
			int amplifier) {
		super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		if (mc.currentScreen != null) {
			mc.getTextureManager().bindTexture(potionIcon);
			Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.getTextureManager().bindTexture(potionIcon);
		Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}
}
