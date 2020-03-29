package net.theunknown.tut.tile;

import net.theunknown.tut.ModSettings;

import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityPower extends TileEntity implements ITickable, IEnergyStorage {
	public int energy = 0;
	public int capacity = ModSettings.blockProperties.EnergyCapacity;
	public int maxReceive = 0;
	private boolean alreadyUpdated = false;
	private boolean canProducePower;
	public int rfPerTick = ModSettings.blockProperties.RFpertick;
	public int maxExtract = ModSettings.blockProperties.transferRate;
	public int energyReceived = Math.min(capacity - energy, Math.min(this.rfPerTick, 31));
	public static final Capability<IEnergyStorage> ENERGY_HANDLER = null;
	private int tempPower = 0;
	private int currentPower = 0;
	@Override
	public void update() {
		currentPower = tempPower;
		if (!this.world.isRemote) {
			if (world.getTotalWorldTime() % 20 == 0) {
				if (!alreadyUpdated)
					alreadyUpdated = true;
				if (canProducePower = (world.canBlockSeeSky(pos.up()) && world.isDaytime())
						&& ((!world.isRaining() && !world.isThundering()) || !world.getBiome(pos).canRain()))
					;
				else
					canProducePower = false;
			}
			if (alreadyUpdated) {
				if (canProducePower) {
					energy += energyReceived;
					tempPower += energyReceived;
				}
			}
		}
	}

	public int getCurrentPower() {
		return this.currentPower;
	}

	@Override
	public int extractEnergy(int extract, boolean simulate) {
		int amount = (extract <= this.energy) ? extract : this.energy;
		this.energy -= amount;
		if (this.energy < 0)
			this.energy = 0;
		return amount;
	}

	@Override
	public boolean hasCapability(net.minecraftforge.common.capabilities.Capability<?> capability, net.minecraft.util.EnumFacing facing) {
		if (capability != null && capability.getName() == "net.minecraftforge.energy.IEnergyStorage") {
			return true;
		}
		return super.hasCapability(capability, facing);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		if (compound.hasKey("EnergyStored"))
			this.energy = compound.getInteger("EnergyStored");
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		NBTTagCompound tag = super.writeToNBT(compound);
		tag.setInteger("EnergyStored", this.energy);
		return tag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing) {
		if (capability != null && capability.getName() == "net.minecraftforge.energy.IEnergyStorage") {
			return (T) this;
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public int getEnergyStored() {
		return this.energy;
	}

	@Override
	public int getMaxEnergyStored() {
		return this.capacity;
	}

	@Override
	public int receiveEnergy(int receive, boolean sumulate) {
		return 0;
	}

	@Override
	public boolean canExtract() {
		return true;
	}

	@Override
	public boolean canReceive() {
		return false;
	}
}
