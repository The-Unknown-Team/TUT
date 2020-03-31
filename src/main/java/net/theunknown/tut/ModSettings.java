package net.theunknown.tut;

import net.minecraftforge.common.config.Config;

@Config(modid = TUT.MODID)
public class ModSettings {
	public static final BlockProperties blockProperties = new BlockProperties();
	public static class BlockProperties {
		@Config.Comment({"How much RF/T the solar panel produces. [default: 2]"})
		public int RFpertick = 2;
		@Config.Comment({"How much RF the solar panel can contain. [default: 40000]"})
		public int EnergyCapacity = 40000;
		@Config.Comment({"How much RF it can outout to other blocks per tick. [default: 40]"})
		public int transferRate = 40;
		@Config.Comment({"How much RF the Energy Furnace can contain. [default: 40000]"})
		public int Furnacecapacity = 40000;
		@Config.Comment({"How much RF the Energy Furnace can take in. [default:500]"})
		public int inputRate = 500;
	}
}
