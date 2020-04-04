package net.theunknown.tut.procedure;

import net.theunknown.tut.block.BlockUraniniteCable;
import net.theunknown.tut.ElementsTUT;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;

@ElementsTUT.ModElement.Tag
public class ProcedureUraniniteCableUpdateTick extends ElementsTUT.ModElement {
	public ProcedureUraniniteCableUpdateTick(ElementsTUT instance) {
		super(instance, 33);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UraniniteCableUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UraniniteCableUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UraniniteCableUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UraniniteCableUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((new Object() {
			public int getAmount(BlockPos pos, int sltid) {
				TileEntity inv = world.getTileEntity(pos);
				if (inv instanceof TileEntityLockableLoot) {
					ItemStack stack = ((TileEntityLockableLoot) inv).getStackInSlot(sltid);
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) == 64)) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) (y + 1), (int) z));
					if (inv != null && (inv instanceof TileEntityLockableLoot)) {
						ItemStack _setstack = new ItemStack(Blocks.STONE, (int) (1), 0);
						_setstack.setCount(64);
						((TileEntityLockableLoot) inv).setInventorySlotContents((int) (0), _setstack);
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) (y - 1), (int) z));
					if (inv != null && (inv instanceof TileEntityLockableLoot)) {
						ItemStack _setstack = new ItemStack(Blocks.STONE, (int) (1), 0);
						_setstack.setCount(64);
						((TileEntityLockableLoot) inv).setInventorySlotContents((int) (0), _setstack);
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) (x + 1), (int) y, (int) z));
					if (inv != null && (inv instanceof TileEntityLockableLoot)) {
						ItemStack _setstack = new ItemStack(Blocks.STONE, (int) (1), 0);
						_setstack.setCount(64);
						((TileEntityLockableLoot) inv).setInventorySlotContents((int) (0), _setstack);
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) (x - 1), (int) y, (int) z));
					if (inv != null && (inv instanceof TileEntityLockableLoot)) {
						ItemStack _setstack = new ItemStack(Blocks.STONE, (int) (1), 0);
						_setstack.setCount(64);
						((TileEntityLockableLoot) inv).setInventorySlotContents((int) (0), _setstack);
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z - 1)));
					if (inv != null && (inv instanceof TileEntityLockableLoot)) {
						ItemStack _setstack = new ItemStack(Blocks.STONE, (int) (1), 0);
						_setstack.setCount(64);
						((TileEntityLockableLoot) inv).setInventorySlotContents((int) (0), _setstack);
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z + 1)));
					if (inv != null && (inv instanceof TileEntityLockableLoot)) {
						ItemStack _setstack = new ItemStack(Blocks.STONE, (int) (1), 0);
						_setstack.setCount(64);
						((TileEntityLockableLoot) inv).setInventorySlotContents((int) (0), _setstack);
					}
				}
			}
		} else {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) (y + 1), (int) z));
					if (inv instanceof TileEntityLockableLoot)
						((TileEntityLockableLoot) inv).decrStackSize((int) (0), (int) (64));
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) (y - 1), (int) z));
					if (inv instanceof TileEntityLockableLoot)
						((TileEntityLockableLoot) inv).decrStackSize((int) (0), (int) (64));
				}
			}
			if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) (x + 1), (int) y, (int) z));
					if (inv instanceof TileEntityLockableLoot)
						((TileEntityLockableLoot) inv).decrStackSize((int) (0), (int) (64));
				}
			}
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) (x - 1), (int) y, (int) z));
					if (inv instanceof TileEntityLockableLoot)
						((TileEntityLockableLoot) inv).decrStackSize((int) (0), (int) (64));
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z - 1)));
					if (inv instanceof TileEntityLockableLoot)
						((TileEntityLockableLoot) inv).decrStackSize((int) (0), (int) (64));
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockUraniniteCable.block.getDefaultState()
					.getBlock())) {
				{
					TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z + 1)));
					if (inv instanceof TileEntityLockableLoot)
						((TileEntityLockableLoot) inv).decrStackSize((int) (0), (int) (64));
				}
			}
		}
	}
}
