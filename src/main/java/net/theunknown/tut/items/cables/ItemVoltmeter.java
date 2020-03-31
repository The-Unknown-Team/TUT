package net.theunknown.tut.items.cables;

import net.theunknown.tut.tile.TileEntityPower;
import net.theunknown.tut.tile.TileEntitiyEletricFurnace;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumActionResult;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;

import JumpWatch.hypercore.cabels.tileentities.CableTileEntity;

public class ItemVoltmeter extends Item {
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY,
			float hitZ) {
		player.swingArm(hand);
		if (world.isRemote) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if (tileEntity instanceof CableTileEntity) {
				CableTileEntity cableEntity = (CableTileEntity) tileEntity;
				player.sendMessage(new TextComponentString("Current RF Flow: " + cableEntity.getCurrentPower() + " rf/t"));
			} else if (tileEntity instanceof TileEntityPower) {
				TileEntityPower Powerblock = (TileEntityPower) tileEntity;
				if (world.canBlockSeeSky(pos) && world.isDaytime()
						&& (!world.isRaining() && !world.isThundering() || !world.getBiome(pos).canRain())) {
					player.sendMessage(new TextComponentString("Current RF generation on block: " + Powerblock.getCurrentPower() + " rf/t"));
				} else {
					player.sendMessage(new TextComponentString("Current RF gemeration on block: 0 rf/t"));
				}
			} else if (tileEntity instanceof TileEntitiyEletricFurnace) {
				TileEntitiyEletricFurnace blockEntity = (TileEntitiyEletricFurnace) tileEntity;
				player.sendMessage(new TextComponentString("Current RF in block : " + blockEntity.getCurrentPower() + " rf/t"));
			}
		}
		return EnumActionResult.SUCCESS;
	}
}
