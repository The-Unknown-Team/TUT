package net.theunknown.tut.blocks;

import net.theunknown.tut.tile.TileEntitiyEletricFurnace;
import net.theunknown.tut.TUT;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.ITileEntityProvider;

import javax.annotation.Nullable;

import java.util.List;

public class BlockElectricFurnace extends BlockBase implements ITileEntityProvider {
	public final static String INTERNAL_NAME = "electric_furnace";
	public BlockElectricFurnace() {
		super(Material.IRON, INTERNAL_NAME);
		setUnlocalizedName(INTERNAL_NAME);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitiyEletricFurnace();
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntitiyEletricFurnace) {
				playerIn.openGui(TUT.instance, 4, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
		}
		return true;
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntitiyEletricFurnace tileentity = (TileEntitiyEletricFurnace) worldIn.getTileEntity(pos);
		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(0)));
		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(1)));
		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(2)));
		super.breakBlock(worldIn, pos, state);
	}
}
