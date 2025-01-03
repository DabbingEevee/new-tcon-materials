package com.existingeevee.moretcon.world.generators;

import com.existingeevee.math.noise.SimplexNoiseGenerator;
import com.existingeevee.moretcon.inits.ModBlocks;
import com.existingeevee.moretcon.world.WorldGenModifier;
import com.existingeevee.moretcon.world.WorldgenContext;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class HelltopIslandsGenerator extends WorldGenModifier {
	public static final SimplexNoiseGenerator HELLTOP_ISLANDS_GENERATOR = new SimplexNoiseGenerator(7, 0.6f, 0.00275f, -0.8);

	@Override
	public void generate(IChunkGenerator chunkGenerator, IChunkProvider chunkProvider, WorldgenContext ctx) {
		World world = ctx.world;
		int chunkX = ctx.chunkX;
		int chunkZ = ctx.chunkZ;

		if (world.provider.getDimensionType().getId() != DimensionType.NETHER.getId()) {
			return;
		}

		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = i + chunkX * 16 + 8;
				int z = j + chunkZ * 16 + 8;

				double noise = HELLTOP_ISLANDS_GENERATOR.generateOctavedSimplexNoise(x, z, world.getSeed()) * 1d;

				double expFactor = -4.0e-6; // -(2/1000)^2
				double mulFactor = -50;

				double delX = 2500 - i;
				double delY = 2500 - j;

				noise += mulFactor * Math.pow(Math.E, expFactor * (delX * delX + delY * delY));

				if (noise < -0.5)
					continue;

				int height = noiseToHeight(noise);
				for (int y = 128; y < 128 + height; y++) {
					BlockPos pos = new BlockPos(x, y, z);
					if (!canReplace(world, pos))
						continue;
					if (noise < -0.2) {
						world.setBlockState(pos, ModBlocks.blockBrokenSand.getDefaultState(), 2);
					} else {
						if (y == 128 + height - 1) {
							world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState(), 2);
						} else {
							world.setBlockState(pos, Blocks.PURPLE_GLAZED_TERRACOTTA.getDefaultState(), 2);
						}
					}
				}
			}
		}
	}

	private static int noiseToHeight(double noise) { // TODO mess with this
		return (int) Math.ceil((noise + 0.5) * 15 + 0.01);
	}

	private static boolean canReplace(World world, BlockPos pos) {
		IBlockState iblockstate = world.getBlockState(pos);
		Block block = iblockstate.getBlock();

		return block.isAir(iblockstate, world, pos) || block instanceof BlockBush; // i hate the stupid mushrooms grahhhh
	}
}
