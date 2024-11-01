package com.existingeevee.moretcon.world.generators;

import java.util.Random;

import com.existingeevee.math.Triangle;
import com.existingeevee.moretcon.inits.ModBlocks;
import com.existingeevee.moretcon.world.IBlockStateProvider;
import com.existingeevee.moretcon.world.WorldGenModifier;
import com.existingeevee.moretcon.world.WorldgenContext;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class MonoliteGenerator extends WorldGenModifier {

	protected static final double TWO_PI_OVER_THREE = Math.PI * 2 / 3;
	
	@Override
	public void generate(IChunkGenerator chunkGenerator, IChunkProvider chunkProvider, WorldgenContext ctx) {
		World world = ctx.world;
		Random random = ctx.rand;

		if (world.provider.getDimensionType().getId() != DimensionType.THE_END.getId() || peekNextInt(random, 250) != 0) {
			return;
		}
		
		IBlockStateProvider provider = provider(random);

		int size = random.nextInt(20) + 45;
		int widthCoefficient = random.nextInt(5) + 5;
		double rot = random.nextDouble() * TWO_PI_OVER_THREE;
		
		double cosRot1 = Math.cos(rot), sinRot1 = Math.sin(rot);
		double cosRot2 = Math.cos(rot + TWO_PI_OVER_THREE), sinRot2 = Math.sin(rot + TWO_PI_OVER_THREE);
		double cosRot3 = Math.cos(rot - TWO_PI_OVER_THREE), sinRot3 = Math.sin(rot - TWO_PI_OVER_THREE);
		
		BlockPos origin = new BlockPos(
				random.nextInt(16) + ctx.chunkX * 16 + 8, 
				255 - size - random.nextInt(70), 
				random.nextInt(16) + ctx.chunkZ * 16 + 8);

		for (int i = 0; i < size; i++) {
			BlockPos cur = origin.up(i);
			double width = widthAtSlice(i / 1d / (size - 1)) * widthCoefficient;
			
			double x1 = width * cosRot1, z1 = width * sinRot1;
			double x2 = width * cosRot2, z2 = width * sinRot2;
			double x3 = width * cosRot3, z3 = width * sinRot3;
			
			Triangle slice = new Triangle(x1, z1, x2, z2, x3, z3);
			
			int iterSize = (int) (Math.ceil(width / 2) + 1);
			
			for (int j = -iterSize; j <= iterSize; j++) {
				boolean started = false;
				for (int k = -iterSize; k <= iterSize; k++) {
					if (slice.contains(j, k)) {
						BlockPos pos = cur.add(j, 0, k);
						world.setBlockState(pos, provider.getNextBlock(random), 2);
						started = true;
					} else if (started) {
						break;
					}
				}
			}
		}
	}

	// 0 is bottom. 1 is top
	public double widthAtSlice(double sliceHeight) {
		if (sliceHeight < 0.5) {
			return sliceHeight * 2;
		} else {
			return - sliceHeight * 2 + 2;
		}
	}

	private static IBlockStateProvider provider(Random random) {
		return new IBlockStateProvider.RandomBlockStateProvider(
				new IBlockStateProvider.ConstantBlockStateProvider(Blocks.END_STONE.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(Blocks.END_STONE.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(Blocks.END_STONE.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(Blocks.END_STONE.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(Blocks.END_STONE.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(Blocks.END_STONE.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(Blocks.END_STONE.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(Blocks.END_STONE.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(Blocks.END_STONE.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(Blocks.END_STONE.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(ModBlocks.oreMonolite.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(ModBlocks.oreMonolite.getDefaultState()),
				new IBlockStateProvider.ConstantBlockStateProvider(ModBlocks.oreEchostone.getDefaultState())
								
				);
	}
}
