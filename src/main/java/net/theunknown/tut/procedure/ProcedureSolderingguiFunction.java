package net.theunknown.tut.procedure;

import net.theunknown.tut.ElementsTUT;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.tileentity.TileEntity;

@ElementsTUT.ModElement.Tag
public class ProcedureSolderingguiFunction extends ElementsTUT.ModElement {
	public ProcedureSolderingguiFunction(ElementsTUT instance) {
		super(instance, 26);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SolderingguiFunction!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SolderingguiFunction!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SolderingguiFunction!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SolderingguiFunction!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			if (inv instanceof TileEntityLockableLoot)
				((TileEntityLockableLoot) inv).decrStackSize((int) (0), (int) (1));
		}
		{
			TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			if (inv instanceof TileEntityLockableLoot)
				((TileEntityLockableLoot) inv).decrStackSize((int) (1), (int) (1));
		}
		{
			TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			if (inv instanceof TileEntityLockableLoot)
				((TileEntityLockableLoot) inv).decrStackSize((int) (2), (int) (1));
		}
		{
			TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			if (inv instanceof TileEntityLockableLoot)
				((TileEntityLockableLoot) inv).decrStackSize((int) (3), (int) (1));
		}
		{
			TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			if (inv instanceof TileEntityLockableLoot)
				((TileEntityLockableLoot) inv).decrStackSize((int) (4), (int) (1));
		}
	}
}
