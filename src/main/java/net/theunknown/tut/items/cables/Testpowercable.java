package net.mcreator.tut.items.cables;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.material.Material;
import net.minecraft.block.ITileEntityProvider;

import javax.annotation.Nullable;

import java.util.List;

import JumpWatch.hypercore.utils.EnumCableType;
import JumpWatch.hypercore.cabels.tileentities.CableTileEntity;
import JumpWatch.hypercore.cabels.BaseCableBlock;

public class Testpowercable extends BaseCableBlock implements ITileEntityProvider {

	public Testpowercable(Material materialIn) {
		super(materialIn);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		// TODO Auto-generated method stub
		return new CableTileEntity();
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		CableTileEntity tileEntity = (CableTileEntity) world.getTileEntity(pos);
		if (tileEntity != null) {
			tileEntity.init(EnumCableType.C20, false);
		}
		super.onBlockPlacedBy(world, pos, state, placer, stack);
	}

}

