package net.theunknown.tut.procedure;

import net.theunknown.tut.block.BlockDeadLog;
import net.theunknown.tut.block.BlockDeadGrass;
import net.theunknown.tut.ElementsTUT;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

@ElementsTUT.ModElement.Tag
public class ProcedureDeadLogUpdateTick extends ElementsTUT.ModElement {
	public ProcedureDeadLogUpdateTick(ElementsTUT instance) {
		super(instance, 38);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DeadLogUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DeadLogUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DeadLogUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DeadLogUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockDeadGrass.block.getDefaultState().getBlock()))
				|| ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockDeadLog.block.getDefaultState()
						.getBlock()))
						|| ((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockDeadLog.block.getDefaultState()
								.getBlock()))
								|| ((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockDeadLog.block
										.getDefaultState().getBlock()))
										|| ((!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockDeadLog.block
												.getDefaultState().getBlock()))
												|| (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)))
														.getBlock() == BlockDeadLog.block.getDefaultState().getBlock())))))))) {
			world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock().dropBlockAsItem(world, new BlockPos((int) x, (int) y, (int) z),
					world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), 1);
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
		}
	}
}
