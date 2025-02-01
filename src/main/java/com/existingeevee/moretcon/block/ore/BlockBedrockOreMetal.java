package com.existingeevee.moretcon.block.ore;

import com.existingeevee.moretcon.traits.ModTraits;

import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;
import net.minecraftforge.fml.common.eventhandler.EventPriority;

public class BlockBedrockOreMetal extends BlockOreMetal {

	public BlockBedrockOreMetal(String name, int harvest, Item toDrop) {
		super(name, harvest, toDrop);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
		if (entity instanceof net.minecraft.entity.boss.EntityDragon) {
			return false;
		} else if ((entity instanceof EntityWither) || (entity instanceof EntityWitherSkull)) {
			return false;
		}
		return true;
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		return Float.MAX_VALUE * 0.99f;
	}

	@Override
	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.BLOCK;
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onBlockStrength(PlayerEvent.BreakSpeed event) {
		if (event.getState().getBlock().equals(this)) {
			if (ToolHelper.isBroken(event.getEntityPlayer().getHeldItemMainhand())) {
				return;
			}

			if (ToolHelper.getTraits(event.getEntityPlayer().getHeldItemMainhand()).stream()
					.anyMatch(t -> t.getIdentifier().equals(ModTraits.bottomsEnd.identifier))) {
				float speed = event.getNewSpeed();
				float hardness = (float) Math.max(Math.pow(10, -1000000), this.blockHardness);
				float overkill = Float.MAX_VALUE * 0.99f;
				float good = speed / hardness;
				event.setNewSpeed(overkill * good);
			} else {
				event.setNewSpeed(0);
			}
		}
	}

}
