package net.theunknown.tut.procedure;

import net.theunknown.tut.utils.GuiHandler;
import net.theunknown.tut.items.cables.Testpowercable;
import net.theunknown.tut.items.cables.ItemVoltmeter;
import net.theunknown.tut.items.cables.ItemTestpowercable;
import net.theunknown.tut.TUT;
import net.theunknown.tut.ElementsTUT;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.model.ModelLoader;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import JumpWatch.hypercore.cabels.tileentities.CableTileEntity;

@ElementsTUT.ModElement.Tag
public class ProcedureCommonProxy extends ElementsTUT.ModElement {
	public ProcedureCommonProxy(ElementsTUT instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
	}

	@Override
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(TUT.instance, new GuiHandler());
	}

	public void registerModel(Item item, int metadata) {
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		GameRegistry.registerTileEntity(CableTileEntity.class, "testpower_cable");
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(this.testpower_cable);
		GameRegistry.registerTileEntity(CableTileEntity.class, "testpower_cable");
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(this.itestpower_cable);
		event.getRegistry().registerAll(this.voltmeter);
	}
	static Block testpower_cable = new Testpowercable(Material.CLOTH).setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
			.setUnlocalizedName("testpower_cable").setRegistryName("testpower_cable");
	static Item itestpower_cable = new ItemTestpowercable(testpower_cable).setRegistryName("testpower_cable").setUnlocalizedName("testpower_cable");
	static Item voltmeter = new ItemVoltmeter().setRegistryName("voltmeter").setUnlocalizedName("voltmeter")
			.setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setMaxStackSize(1);
}
