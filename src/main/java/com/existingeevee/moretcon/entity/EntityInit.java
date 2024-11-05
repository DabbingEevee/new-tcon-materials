package com.existingeevee.moretcon.entity;

import com.existingeevee.moretcon.ModInfo;
import com.existingeevee.moretcon.MoreTCon;
import com.existingeevee.moretcon.config.ConfigHandler;
import com.existingeevee.moretcon.entity.entities.EntityBomb;
import com.existingeevee.moretcon.entity.entities.EntityDecayingEffect;
import com.existingeevee.moretcon.entity.entities.EntityPlasmaBolt;
import com.existingeevee.moretcon.entity.renderers.RenderBomb;
import com.existingeevee.moretcon.entity.renderers.RenderDecayingEffect;
import com.existingeevee.moretcon.entity.renderers.RenderPlasmaBolt;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	public static void init() {
		registerEntity("decaying_effect", EntityDecayingEffect.class, ConfigHandler.decayingEffectEntityID, 50);
		registerEntity("plasma_bolt", EntityPlasmaBolt.class, ConfigHandler.plasmaBoltEntityID, 50);
		registerEntity("bomb", EntityBomb.class, ConfigHandler.bombEntityID, 50);
	}

	public static void initClient() {
		registerRenderer(EntityDecayingEffect.class, RenderDecayingEffect::new);
		registerRenderer(EntityPlasmaBolt.class, RenderPlasmaBolt::new);
		registerRenderer(EntityBomb.class, RenderBomb::new);
	}

	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range) {
		EntityRegistry.registerModEntity(new ResourceLocation(ModInfo.MODID + ":" + name), entity,
				name + "_" + ModInfo.MODID, id, MoreTCon.instance, range, 1, true);
	}
/*
	private static void registerArrow(String name, Class<? extends Entity> entity, int id) {
		EntityRegistry.registerModEntity(new ResourceLocation(ModInfo.MODID + ":" + name), entity,
				name + "_" + ModInfo.MODID, id, MoreTCon.instance, 64, 20, true);
	}

	private static void registerProjectile(String name, int id, Class<? extends Entity> entity, Item item) {
		EntityRegistry.registerModEntity(new ResourceLocation(ModInfo.MODID + ":" + name), entity,
				name + "_" + ModInfo.MODID, id, MoreTCon.instance, 64, 10, true);
	}*/

	public static <T extends Entity> void registerRenderer(Class<T> entity, IRenderFactory<T> renderFactory) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory);
	}
}
