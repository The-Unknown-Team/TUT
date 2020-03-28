package net.theunknown.tut.blocks;

import net.theunknown.tut.tile.TileEntityPower;

import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.material.Material;
import net.minecraft.block.ITileEntityProvider;

import javax.annotation.Nullable;

import java.util.List;

public class RFPower extends BlockBase implements ITileEntityProvider {
	public final static String INTERNAL_NAME = "rf_power";
	public RFPower() {
		super(Material.IRON, INTERNAL_NAME);
		setUnlocalizedName(INTERNAL_NAME);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityPower();
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
	}
}
