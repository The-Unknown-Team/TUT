package net.theunknown.tut.procedure;

import net.theunknown.tut.blocks.TileEntityConsumeRF;
import net.theunknown.tut.blocks.RFBlock;
import net.theunknown.tut.TUT;
import net.theunknown.tut.ElementsTUT;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.block.Block;

@Mod.EventBusSubscriber
@GameRegistry.ObjectHolder(TUT.MODID)
@ElementsTUT.ModElement.Tag
public class ProcedureSomething extends ElementsTUT.ModElement {
	public ProcedureSomething(ElementsTUT instance) {
		super(instance, 43);
	}
	@GameRegistry.ObjectHolder(RFBlock.INTERNAL_NAME)
	private static RFBlock rfBlock;
	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new RFBlock());
	}

	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerTileEntity(TileEntityConsumeRF.class, new ResourceLocation(TUT.MODID, "tileentity_consume_rf"));
	}

	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(rfBlock.createItemBlock());
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onRegisterModels(ModelRegistryEvent event) {
		rfBlock.registerItemModel(Item.getItemFromBlock(rfBlock));
	}
}
