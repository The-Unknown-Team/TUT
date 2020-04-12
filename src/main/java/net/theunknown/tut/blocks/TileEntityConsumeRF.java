package net.theunknown.tut.blocks;

import net.minecraftforge.fml.common.Optional;

import net.minecraft.util.EnumFacing;
import net.minecraft.tileentity.TileEntity;

import cofh.redstoneflux.api.IEnergyReceiver;

@Optional.Interface(iface = "cofh.redstoneflux.api.IEnergyReceiver", modid = "redstoneflux", striprefs = true)
public class TileEntityConsumeRF extends TileEntity implements IEnergyReceiver {
	@Override
	public boolean canConnectEnergy(EnumFacing from) {
		return true;
	}

	@Override
	public int getEnergyStored(EnumFacing from) {
		return 0;
	}

	@Override
	public int getMaxEnergyStored(EnumFacing from) {
		return 30;
	}

	@Override
	public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) {
		return 30000;
	}
}
