package net.theunknown.tut.utils;

import net.theunknown.tut.tile.TileEntitiyEletricFurnace;
import net.theunknown.tut.blocks.guis.GuiElectricFurnace;
import net.theunknown.tut.blocks.container.ContainerElectricFurnace;
import net.theunknown.tut.Ids;

import net.minecraftforge.fml.common.network.IGuiHandler;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Ids.GUI_ELECTRIC_FURNACE)
			return new ContainerElectricFurnace(player.inventory, (TileEntitiyEletricFurnace) world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Ids.GUI_ELECTRIC_FURNACE)
			return new GuiElectricFurnace(player.inventory, (TileEntitiyEletricFurnace) world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}
}
