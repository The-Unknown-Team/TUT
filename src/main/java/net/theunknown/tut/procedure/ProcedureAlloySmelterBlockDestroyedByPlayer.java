package net.theunknown.tut.procedure;

import net.theunknown.tut.block.BlockAlloySmelterFurnace;
import net.theunknown.tut.ElementsTUT;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

@ElementsTUT.ModElement.Tag
public class ProcedureAlloySmelterBlockDestroyedByPlayer extends ElementsTUT.ModElement {
	public ProcedureAlloySmelterBlockDestroyedByPlayer(ElementsTUT instance) {
		super(instance, 56);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AlloySmelterBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AlloySmelterBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AlloySmelterBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AlloySmelterBlockDestroyedByPlayer!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockAlloySmelterFurnace.block.getDefaultState()
				.getBlock())) {
			world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)).getBlock().dropBlockAsItem(world,
					new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)), 1);
			world.setBlockToAir(new BlockPos((int) (x + 1), (int) y, (int) z));
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == BlockAlloySmelterFurnace.block.getDefaultState()
				.getBlock())) {
			world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)).getBlock().dropBlockAsItem(world,
					new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)), 1);
			world.setBlockToAir(new BlockPos((int) (x - 1), (int) y, (int) z));
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockAlloySmelterFurnace.block.getDefaultState()
				.getBlock())) {
			world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))).getBlock().dropBlockAsItem(world,
					new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))), 1);
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) (z - 1)));
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockAlloySmelterFurnace.block.getDefaultState()
				.getBlock())) {
			world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))).getBlock().dropBlockAsItem(world,
					new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))), 1);
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) (z + 1)));
		}
	}
}
