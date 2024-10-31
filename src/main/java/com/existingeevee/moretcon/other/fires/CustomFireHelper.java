package com.existingeevee.moretcon.other.fires;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.existingeevee.moretcon.ModInfo;
import com.existingeevee.moretcon.NetworkHandler;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomFireHelper {

	private static Map<Integer, CustomFireInfo> customBurning = new HashMap<>();

	private static boolean dirty = false;

	public static void setAblaze(EntityLivingBase entity, CustomFireInfo info) {
		customBurning.put(entity.getEntityId(), info);
		entity.extinguish();
		if (!entity.world.isRemote) {
			entity.getEntityData().setTag(ModInfo.MODID + ".fire", info.asTag());
			dirty = true;
		}
	}

	public static void setAblaze(EntityLivingBase entity, CustomFireEffect effect, int time) {
		setAblaze(entity, new CustomFireInfo(effect, time, false));
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onRenderLivingEvent(RenderLivingEvent.Pre<?> event) {
		if (event.getEntity().world.isRemote) {
			if (customBurning.get(event.getEntity().getEntityId()) != null) {
				CustomFireInfo info = customBurning.get(event.getEntity().getEntityId());
				if (info == null || info.isInvalid()) {
					return;
				}
				info.effect.render(event);
			}
		}
	}

	public static void hookRenderCustomFire(float partialTick) {
		if (Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().world != null) {
			if (customBurning.get(Minecraft.getMinecraft().player.getEntityId()) != null) {
				CustomFireInfo info = customBurning.get(Minecraft.getMinecraft().player.getEntityId());
				if (info.isInvalid()) {
					return;
				}

				Tessellator tessellator = Tessellator.getInstance();
				BufferBuilder bufferbuilder = tessellator.getBuffer();
				GlStateManager.color(1.0F, 1.0F, 1.0F, 0.9F);
				GlStateManager.depthFunc(519);
				GlStateManager.depthMask(false);
				GlStateManager.enableBlend();
				GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

				for (int i = 0; i < 2; ++i) {
					GlStateManager.pushMatrix();
					TextureAtlasSprite textureatlassprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(info.effect.two.toString());
					Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
					float f1 = textureatlassprite.getMinU();
					float f2 = textureatlassprite.getMaxU();
					float f3 = textureatlassprite.getMinV();
					float f4 = textureatlassprite.getMaxV();
					GlStateManager.translate((-(i * 2 - 1)) * 0.24F, -0.3F, 0.0F);
					GlStateManager.rotate((i * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
					bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
					bufferbuilder.pos(-0.5D, -0.5D, -0.5D).tex(f2, f4).endVertex();
					bufferbuilder.pos(0.5D, -0.5D, -0.5D).tex(f1, f4).endVertex();
					bufferbuilder.pos(0.5D, 0.5D, -0.5D).tex(f1, f3).endVertex();
					bufferbuilder.pos(-0.5D, 0.5D, -0.5D).tex(f2, f3).endVertex();
					tessellator.draw();
					GlStateManager.popMatrix();
				}

				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				GlStateManager.disableBlend();
				GlStateManager.depthMask(true);
				GlStateManager.depthFunc(515);
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onClientTickEvent(TickEvent.ClientTickEvent event) {
		if (Minecraft.getMinecraft().world != null && event.phase == Phase.END) {
			for (Entity e : new ArrayList<>(Minecraft.getMinecraft().world.loadedEntityList)) {
				if (e instanceof EntityLivingBase) {
					EntityLivingBase entity = (EntityLivingBase) e;
					if (customBurning.get(entity.getEntityId()) != null) {
						CustomFireInfo info = customBurning.get(entity.getEntityId());
						if (info == null || info.effect == null) {
							continue;
						}
						if (!info.effect.effect(entity, info.time)) {
							info.forcedInvalid = true;
						}
					}
				}
			}
		}

	}

	@SubscribeEvent
	public static void onRespawn(PlayerRespawnEvent event) {
		if (!event.isEndConquered() && customBurning.get(event.player.getEntityId()) != null) {
			event.player.getEntityData().removeTag(ModInfo.MODID + ".fire");
			customBurning.remove(event.player.getEntityId());
			dirty = true;
		}
	}

	private static Set<Integer> validList = new HashSet<>();

	@SubscribeEvent
	public static void finishTicking(TickEvent.ServerTickEvent event) {
		if (event.phase != Phase.END) {
			return;
		}

		customBurning.keySet().retainAll(validList);
		validList = new HashSet<>();
	}

	@SubscribeEvent
	public static void onEntityTick(TickEvent.WorldTickEvent event) {
		if (event.phase != Phase.END) {
			return;
		}

		for (Entity e : new ArrayList<>(event.world.loadedEntityList)) {
			if (e instanceof EntityLivingBase) {
				EntityLivingBase entity = (EntityLivingBase) e;
				if (customBurning.get(entity.getEntityId()) != null) {
					CustomFireInfo info = customBurning.get(entity.getEntityId());
					if (info.effect == null) {
						continue;
					}
					if (!info.effect.effect(entity, info.time)) {
						info.forcedInvalid = true;
					}
				}
			}
		}

		if (event.world.isRemote) {
			return;
		}

		for (Entity e : new ArrayList<>(event.world.loadedEntityList)) {
			if (e instanceof EntityLivingBase) {
				EntityLivingBase entity = (EntityLivingBase) e;
				if (e.getEntityData().hasKey(ModInfo.MODID + ".fire", NBT.TAG_COMPOUND)) {
					try {
						CustomFireInfo info = new CustomFireInfo(e.getEntityData().getCompoundTag(ModInfo.MODID + ".fire")).decrementTime();
						if (entity.isBurning() || info.isInvalid() || (customBurning.get(entity.getEntityId()) != null && customBurning.get(entity.getEntityId()).isInvalid())) {
							customBurning.remove(entity.getEntityId());
							entity.getEntityData().removeTag(ModInfo.MODID + ".fire");
							dirty = true;
							continue;
						}
						validList.add(entity.getEntityId());
						setAblaze(entity, info);
						dirty = true;
					} catch (NullPointerException npe) {

					}
				}
			}
		}

		if (dirty) {
			dirty = false;
			SyncCustomFiresMessage msg = new SyncCustomFiresMessage();
			msg.customBurningData = customBurning;
			NetworkHandler.HANDLER.sendToAll(msg);
		}
	}

	public static CustomFireInfo getBurningInfo(EntityLivingBase entity) {
		if (customBurning.get(entity.getEntityId()) != null) {
			return customBurning.get(entity.getEntityId());
		}
		if (entity.getEntityData().hasKey(ModInfo.MODID + ".fire", NBT.TAG_COMPOUND) && !entity.world.isRemote) {
			NBTTagCompound data = entity.getEntityData().getCompoundTag(ModInfo.MODID + ".fire");
			String fireEffect = data.getString("type");
			int time = data.getInteger("time");
			if (time > 0 && CustomFireEffect.registeredEffects.get(fireEffect) != null) {
				setAblaze(entity, CustomFireEffect.registeredEffects.get(fireEffect), time);
				return customBurning.get(entity.getEntityId());
			}
		}
		return null;
	}

	public static class SyncCustomFiresMessage implements IMessage, IMessageHandler<SyncCustomFiresMessage, IMessage> {
		Map<Integer, CustomFireInfo> customBurningData = new HashMap<>();

		@Override
		public IMessage onMessage(SyncCustomFiresMessage message, MessageContext ctx) {
			customBurning = message.customBurningData;
			return null;
		}

		@Override
		public void fromBytes(ByteBuf buf) {
			Map<Integer, CustomFireInfo> newCustomBurningData = new HashMap<>();
			try {
				int len = buf.readInt();
				for (int i = 0; i < len; i++) {
					int eid = buf.readInt();
					int time = buf.readInt();
					int strLen = buf.readByte();
					String effect = new StringBuilder(strLen).append(buf.readCharSequence(strLen, StandardCharsets.UTF_8)).toString();
					if (CustomFireEffect.registeredEffects.get(effect) != null) {
						newCustomBurningData.put(eid, new CustomFireInfo(CustomFireEffect.registeredEffects.get(effect), time, false));
					}
				}
			} catch (Throwable t) {
				return;
			}
			customBurningData = newCustomBurningData;
		}

		@Override
		public void toBytes(ByteBuf buf) {
			int len = customBurningData.entrySet().stream().filter(p -> !p.getValue().isInvalid()).mapToInt(i -> 1) .sum();
			buf.writeInt(len);
			for (Entry<Integer, CustomFireInfo> e : customBurningData.entrySet()) {
				if (e.getValue().isInvalid()) {
					continue;
				}
				buf.writeInt(e.getKey());
				buf.writeInt(e.getValue().time);
				buf.writeByte(e.getValue().getEffect().id.length());
				buf.writeCharSequence(e.getValue().getEffect().id, StandardCharsets.UTF_8);
			}
		}
	}
}
