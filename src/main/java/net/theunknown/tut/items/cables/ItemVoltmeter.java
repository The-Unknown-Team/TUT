package net.theunknown.tut.items.cables;

import net.theunknown.tut.tile.TileEntityPower;

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
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ,
			EnumHand hand) {
		player.swingArm(hand);
		if (!world.isRemote) {
			player.sendMessage(new TextComponentString("Current RF Flow: "));
			TileEntity tileEntity = world.getTileEntity(pos);
			if (tileEntity instanceof CableTileEntity) {
				CableTileEntity cableEntity = (CableTileEntity) tileEntity;
				player.sendMessage(new TextComponentString("Current RF Flow: " + cableEntity.getCurrentPower() + " rf/t"));
			} else if (tileEntity instanceof TileEntityPower) {
				TileEntityPower Pow2erblock = (TileEntityPower) tileEntity;
				player.sendMessage(new TextComponentString("Current RF on block: " + Pow2erblock.getCurrentPower() + " rf/t"));
			} 
		}
		return EnumActionResult.SUCCESS;
	}
}
