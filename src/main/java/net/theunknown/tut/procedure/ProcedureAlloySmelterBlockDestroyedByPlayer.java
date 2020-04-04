package net.theunknown.tut.procedure;

import net.theunknown.tut.ElementsTUT;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.IProperty;

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
		if ((((new Object() {
			public EnumFacing getEnumFacing(BlockPos pos) {
				try {
					IBlockState _bs = world.getBlockState(pos);
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing"))
							return _bs.getValue((PropertyDirection) prop);
					}
					return EnumFacing.NORTH;
				} catch (Exception e) {
					return EnumFacing.NORTH;
				}
			}
		}.getEnumFacing(new BlockPos((int) x, (int) y, (int) z))) == EnumFacing.SOUTH) || ((new Object() {
			public EnumFacing getEnumFacing(BlockPos pos) {
				try {
					IBlockState _bs = world.getBlockState(pos);
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing"))
							return _bs.getValue((PropertyDirection) prop);
					}
					return EnumFacing.NORTH;
				} catch (Exception e) {
					return EnumFacing.NORTH;
				}
			}
		}.getEnumFacing(new BlockPos((int) x, (int) y, (int) z))) == EnumFacing.NORTH))) {
			world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))).getBlock().dropBlockAsItem(world,
					new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))), 1);
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) (z - 1)));
			world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))).getBlock().dropBlockAsItem(world,
					new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))), 1);
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) (z + 1)));
		}
		if ((((new Object() {
			public EnumFacing getEnumFacing(BlockPos pos) {
				try {
					IBlockState _bs = world.getBlockState(pos);
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing"))
							return _bs.getValue((PropertyDirection) prop);
					}
					return EnumFacing.NORTH;
				} catch (Exception e) {
					return EnumFacing.NORTH;
				}
			}
		}.getEnumFacing(new BlockPos((int) x, (int) y, (int) z))) == EnumFacing.WEST) || ((new Object() {
			public EnumFacing getEnumFacing(BlockPos pos) {
				try {
					IBlockState _bs = world.getBlockState(pos);
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing"))
							return _bs.getValue((PropertyDirection) prop);
					}
					return EnumFacing.NORTH;
				} catch (Exception e) {
					return EnumFacing.NORTH;
				}
			}
		}.getEnumFacing(new BlockPos((int) x, (int) y, (int) z))) == EnumFacing.EAST))) {
			world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)).getBlock().dropBlockAsItem(world,
					new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)), 1);
			world.setBlockToAir(new BlockPos((int) (x - 1), (int) y, (int) z));
			world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)).getBlock().dropBlockAsItem(world,
					new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)), 1);
			world.setBlockToAir(new BlockPos((int) (x + 1), (int) y, (int) z));
		}
	}
}
