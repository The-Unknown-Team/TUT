package net.theunknown.tut.procedure;

import net.theunknown.tut.block.BlockDeadLog;
import net.theunknown.tut.block.BlockDeadGrass;
import net.theunknown.tut.ElementsTUT;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

@ElementsTUT.ModElement.Tag
public class ProcedureDeadLogNeighbourBlockChanges extends ElementsTUT.ModElement {
	public ProcedureDeadLogNeighbourBlockChanges(ElementsTUT instance) {
		super(instance, 37);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DeadLogNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DeadLogNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DeadLogNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DeadLogNeighbourBlockChanges!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockDeadGrass.block.getDefaultState().getBlock())
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockDeadLog.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockDeadLog.block.getDefaultState()
								.getBlock())
								|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockDeadLog.block
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockDeadLog.block
												.getDefaultState().getBlock())
												|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)))
														.getBlock() == BlockDeadLog.block.getDefaultState().getBlock()))))))) {
			if (((new Object() {
				public boolean getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "playerplaced")) != (true))) {
				world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock().dropBlockAsItem(world,
						new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), 1);
				world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == BlockDeadLog.block.getDefaultState()
						.getBlock())) {
					world.destroyBlock(new BlockPos((int) (x + 1), (int) (y + 1), (int) z), false);
					world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z)).getBlock().dropBlockAsItem(world,
							new BlockPos((int) (x + 1), (int) (y + 1), (int) z),
							world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z)), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) (y + 1), (int) z));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == BlockDeadLog.block.getDefaultState()
						.getBlock())) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z)).getBlock().dropBlockAsItem(world,
							new BlockPos((int) (x - 1), (int) (y + 1), (int) z),
							world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z)), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) (y + 1), (int) z));
					world.destroyBlock(new BlockPos((int) (x - 1), (int) (y + 1), (int) z), false);
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == BlockDeadLog.block.getDefaultState()
						.getBlock())) {
					world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)), false);
					world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) (y + 1), (int) (z - 1)),
							world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == BlockDeadLog.block.getDefaultState()
						.getBlock())) {
					world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)), false);
					world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) (y + 1), (int) (z + 1)),
							world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockDeadLog.block.getDefaultState()
						.getBlock())) {
					world.destroyBlock(new BlockPos((int) (x + 1), (int) y, (int) z), false);
					world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)).getBlock().dropBlockAsItem(world,
							new BlockPos((int) (x + 1), (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) y, (int) z));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == BlockDeadLog.block.getDefaultState()
						.getBlock())) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)).getBlock().dropBlockAsItem(world,
							new BlockPos((int) (x - 1), (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) y, (int) z));
					world.destroyBlock(new BlockPos((int) (x - 1), (int) y, (int) z), false);
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockDeadLog.block.getDefaultState()
						.getBlock())) {
					world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), false);
					world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) (z - 1)), world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) x, (int) y, (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockDeadLog.block.getDefaultState()
						.getBlock())) {
					world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z + 1)), false);
					world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) (z + 1)), world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) x, (int) y, (int) (z + 1)));
				}
			}
		}
	}
}
