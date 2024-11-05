package com.existingeevee.moretcon.client.actions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleFirework.Overlay;
import net.minecraft.nbt.NBTBase;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BombAction extends ClientAction {

	private static final Constructor<Overlay> __init__$Overlay = ObfuscationReflectionHelper.findConstructor(Overlay.class, World.class, double.class, double.class, double.class);

	@Override
	@SideOnly(Side.CLIENT)
	public void runAsClient(World world, double x, double y, double z, NBTBase data) {
		try {
			Minecraft.getMinecraft().effectRenderer.addEffect(__init__$Overlay.newInstance(world, x, y, z));
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
		}
	}
}
