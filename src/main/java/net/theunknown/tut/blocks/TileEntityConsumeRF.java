package net.mcreator.tut.blocks;

import net.minecraftforge.fml.common.Optional;

import net.minecraft.util.EnumFacing;

import cofh.redstoneflux.api.IEnergyReceiver;
import net.minecraft.tileentity.TileEntity;

@Optional.Interface(iface = "cofh.redstoneflux.api.IEnergyReceiver", modid = "redstoneflux", striprefs = true)
public class TileEntityConsumeRF extends TileEntity implements IEnergyReceiver {
	@Override
	public boolean canConnectEnergy(EnumFacing from) {
		return true;
	}

	@Override
	public int getEnergyStored(EnumFacing from) {
		return Integer.MAX_VALUE;
	}

	@Override
	public int getMaxEnergyStored(EnumFacing from) {
		return Integer.MAX_VALUE;
	}

	@Override
	public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) {
		return 30000;
	}
}
