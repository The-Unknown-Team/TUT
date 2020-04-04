package net.theunknown.tut.procedure;

import net.theunknown.tut.ElementsTUT;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;

@ElementsTUT.ModElement.Tag
public class ProcedureUraniniteCableRedstoneOn extends ElementsTUT.ModElement {
	public ProcedureUraniniteCableRedstoneOn(ElementsTUT instance) {
		super(instance, 31);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UraniniteCableRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UraniniteCableRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UraniniteCableRedstoneOn!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UraniniteCableRedstoneOn!");
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
				_tileEntity.getTileData().setBoolean("on", (true));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		{
			TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			if (inv != null && (inv instanceof TileEntityLockableLoot)) {
				ItemStack _setstack = new ItemStack(Blocks.STONE, (int) (1), 0);
				_setstack.setCount(64);
				((TileEntityLockableLoot) inv).setInventorySlotContents((int) (0), _setstack);
			}
		}
	}
}
