package net.theunknown.tut.procedure;

import net.theunknown.tut.ElementsTUT;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;

@ElementsTUT.ModElement.Tag
public class ProcedureUraniniteCableRedstoneOff extends ElementsTUT.ModElement {
	public ProcedureUraniniteCableRedstoneOff(ElementsTUT instance) {
		super(instance, 32);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UraniniteCableRedstoneOff!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UraniniteCableRedstoneOff!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UraniniteCableRedstoneOff!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UraniniteCableRedstoneOff!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			IBlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().setBoolean("on", (false));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		{
			TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			if (inv instanceof TileEntityLockableLoot)
				((TileEntityLockableLoot) inv).decrStackSize((int) (0), (int) (64));
		}
	}
}
