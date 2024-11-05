package com.existingeevee.moretcon.effects;

import com.existingeevee.moretcon.ModInfo;
import com.existingeevee.moretcon.other.utils.MiscUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionCharged extends Potion {
	private final ResourceLocation potionIcon;

	public PotionCharged() {
		super(true, 0x34bdeb);
		setRegistryName("charged");
		setPotionName(MiscUtils.createNonConflictiveName("charged"));
		potionIcon = new ResourceLocation(ModInfo.MODID + ":textures/other/charged.png");
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		int j = 25 >> amplifier;

		if (j > 0) {
			return duration % j == 0;
		} else {
			return true;
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
	public void performEffect(EntityLivingBase entity, int amplifier) {
		entity.attackEntityFrom(new DamageSource("charged_zap"), amplifier / 4f + 1);
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
	
	@SubscribeEvent
	public void onDamage(LivingHurtEvent event) {
		if (event.getEntityLiving().isPotionActive(this)) {
			int amplifier = event.getEntityLiving().getActivePotionEffect(this).getAmplifier() + 1;
			event.setAmount(event.getAmount() * (1 + 0.25f * amplifier));
		}
	}
}
