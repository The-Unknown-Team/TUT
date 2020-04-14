package net.theunknown.tut.tile;

import net.theunknown.tut.blocks.recipes.CrusherRecipes;
import net.theunknown.tut.ModSettings;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ITickable;
import net.minecraft.util.EnumFacing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class TileEntityElectricCrusher extends TileEntity implements ITickable, IEnergyStorage {
	int tick;
	public int energy = 0;
	public int storage = ModSettings.crusherProperties.Crushercapacity;
	public int forevery = ModSettings.crusherProperties.foreach;
	public int lube = ModSettings.crusherProperties.lube;
	public ItemStackHandler handler = new ItemStackHandler(2);
	private String customName;
	protected FluidStack fluid;
	public int cookTime;
	protected int capacity = 0;
	private ItemStack smelting = ItemStack.EMPTY;
	protected FluidTank tank = new FluidTank(3000);
	private boolean needsUpdate = false;
	public int dontbother;
	private int updateTimer = 0;
	protected boolean canFill = true;
	@Override
	public void update() {
		tick++;
		if (tick > 20)
			tick = 0;
		if (tick == 0) {
			// System.out.println("Fluid is: " + tank.getFluid());
			// System.out.println("The amount is: " + tank.getFluidAmount());
		}
		ItemStack[] inputs = new ItemStack[]{handler.getStackInSlot(0)};
		if (energy >= forevery) {
			if (tank.getFluidAmount() > lube) {
				if (cookTime > 0) {
					cookTime++;
					energy -= forevery;
					if (cookTime == 100) {
						if (handler.getStackInSlot(1).getCount() > 0) {
							handler.getStackInSlot(1).grow(1);
						} else {
							handler.insertItem(1, smelting, false);
						}
						smelting = ItemStack.EMPTY;
						cookTime = 0;
						return;
					}
				} else {
					if (!inputs[0].isEmpty()) {
						ItemStack output = CrusherRecipes.getInstance().getEletricResult(inputs[0]);
						if (!output.isEmpty()) {
							smelting = output;
							tank.drain(lube, true);
							cookTime++;
							inputs[0].shrink(1);
							handler.setStackInSlot(0, inputs[0]);
						}
					}
				}
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (facing == EnumFacing.DOWN && capability == CapabilityEnergy.ENERGY)
			return (T) this;
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
			return (T) tank;
		return super.getCapability(capability, facing);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY)
			return true;
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
			return true;
		return super.hasCapability(capability, facing);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setInteger("CookTime", cookTime);
		compound.setInteger("GuiEnergy", energy);
		compound.setString("Name", getDisplayName().toString());
		compound.setInteger("EnergyStored", this.energy);
		tank.writeToNBT(compound);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		this.cookTime = compound.getInteger("CookTime");
		this.energy = compound.getInteger("GuiEnergy");
		tank.readFromNBT(compound);
		if (compound.hasKey("EnergyStored"))
			this.energy = compound.getInteger("EnergyStored");
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
		// int amount = (receive <= this.energy) ? receive : this.energy;
		// this.energy += amount;
		// if (this.energy < 0)
		// this.energy = 0;
		int amount = this.energy += receive;
		if (this.energy > storage) {
			this.energy = storage;
		}
		return amount;
		// return this.energy += receive;
		// return ModSettings.blockProperties.inputRate;
	}

	public int getCurrentPower() {
		return energy;
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentTranslation("container.electric_crusher");
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
	//////////////// FLUID PART/////////////////////
	/*
	 * public boolean apply(FluidTank tank, IItemHandler inventory, boolean consume)
	 * { }
	 */
}
