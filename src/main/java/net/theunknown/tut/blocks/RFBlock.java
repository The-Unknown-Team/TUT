package net.mcreator.tut.blocks;

import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.material.Material;
import net.minecraft.block.ITileEntityProvider;

import javax.annotation.Nullable;

import java.util.List;

public class RFBlock extends BlockBase implements ITileEntityProvider {
	public final static String INTERNAL_NAME = "rf_block";

	public RFBlock() {
		super(Material.IRON, INTERNAL_NAME);
		setUnlocalizedName(INTERNAL_NAME);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityConsumeRF();
    }

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
	}
	
}
