package net.theunknown.tut.tile;

import net.theunknown.tut.ModSettings;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.energy.IEnergyStorage;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class TileEntitiyEletricFurnace extends TileEntity implements ITickable, IEnergyStorage {
	int tick;
	public int energy = 0;
	public int storage = ModSettings.blockProperties.Furnacecapacity;
	public ItemStackHandler handler = new ItemStackHandler(3);
	private String customName;
	public int cookTime = storage;
	private ItemStack smelting = ItemStack.EMPTY;
	@Override
	public void update() {
	}

	@Override
	public boolean hasCapability(net.minecraftforge.common.capabilities.Capability<?> capability, net.minecraft.util.EnumFacing facing) {
		if (capability != null && capability.getName() == "net.minecraftforge.energy.IEnergyStorage") {
			return true;
		}
		return super.hasCapability(capability, facing);
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
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		NBTTagCompound tag = super.writeToNBT(compound);
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setInteger("CookTime", cookTime);
		compound.setInteger("GuiEnergy", energy);
		compound.setString("Name", getDisplayName().toString());
		return tag;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		this.cookTime = compound.getInteger("CookTime");
		this.energy = compound.getInteger("GuiEnergy");
		if (compound.hasKey("Name"))
			this.customName = compound.getString("Name");
	}

	public int getEnergyStored() {
		return this.energy;
	}

	public int getMaxEnergyStored() {
		return this.storage;
	}

	public boolean canExtract() {
		return false;
	}

	public boolean canReceive() {
		return true;
	}

	@Override
	public int extractEnergy(int extract, boolean simulate) {
		return 0;
	}

	@Override
	public int receiveEnergy(int receive, boolean sumulate) {
		// int amount = (receive >= this.energy) ? receive : this.energy;
		// this.energy += amount;
		// if (this.energy < 0)
		// this.energy = 0;
		return this.energy += receive;
		// return ModSettings.blockProperties.inputRate;
	}

	public int getCurrentPower() {
		return energy;
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentTranslation("container.electric_furnace");
	}

	public boolean isUsableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this
				? false
				: player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}

	public int getField(int id) {
		switch (id) {
			case 0 :
				return this.cookTime;
			case 1 :
				return this.energy;
			default :
				return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
			case 0 :
				this.cookTime = value;
				break;
			case 1 :
				this.energy = value;
		}
	}
}
