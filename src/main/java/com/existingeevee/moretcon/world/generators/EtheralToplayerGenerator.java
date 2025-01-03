package com.existingeevee.moretcon.world.generators;

import com.existingeevee.math.noise.SimplexNoiseGenerator;
import com.existingeevee.moretcon.inits.ModBlocks;
import com.existingeevee.moretcon.world.WorldGenModifier;
import com.existingeevee.moretcon.world.WorldgenContext;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class EtheralToplayerGenerator extends WorldGenModifier {
	public static final SimplexNoiseGenerator ETHERAL_GENERATOR = new SimplexNoiseGenerator(7, 0.2f, 0.025f, 0); // dL = 0.5

	@Override
	public void generate(IChunkGenerator chunkGenerator, IChunkProvider chunkProvider, WorldgenContext ctx) {
		World world = ctx.world;
		int chunkX = ctx.chunkX;
		int chunkZ = ctx.chunkZ;

		if (!(world.provider.getDimensionType().getId() == DimensionType.THE_END.getId())) {
			return;
		}

		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = i + chunkX * 16 + 8;
				int z = j + chunkZ * 16 + 8;

				if (x * x + z * z < 500 * 500) {
					continue;
				}

				double d = ETHERAL_GENERATOR.generateOctavedSimplexNoise(x, z, world.getSeed());

				if (d > 0.5) {
					BlockPos pos = new BlockPos(i + chunkX * 16 + 8, 200, j + chunkZ * 16 + 8);
					if (isAir(world, pos)) {
						world.setBlockState(pos, ModBlocks.blockOtherstone.getDefaultState(), 2);
					}
				}
				if (d > 0.75) {
					BlockPos pos = new BlockPos(i + chunkX * 16 + 8, 201, j + chunkZ * 16 + 8);
					if (isAir(world, pos)) {
						world.setBlockState(pos, ModBlocks.blockOtherstone.getDefaultState(), 2);
					}

					pos = new BlockPos(i + chunkX * 16 + 8, 199, j + chunkZ * 16 + 8);
					if (isAir(world, pos)) {
						world.setBlockState(pos, ModBlocks.blockOtherstone.getDefaultState(), 2);
					}
				}
			}
		}
	}

	private static boolean isAir(World world, BlockPos pos) {
		IBlockState iblockstate = world.getBlockState(pos);
		Block block = iblockstate.getBlock();

		return block.isAir(iblockstate, world, pos);
	}
}
