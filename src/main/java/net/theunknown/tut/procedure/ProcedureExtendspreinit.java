package net.theunknown.tut.procedure;

import net.theunknown.tut.gltfreg.simple_block_model.SimpleBlock;
import net.theunknown.tut.gltfreg.fast_tesr.FastTESRTile;
import net.theunknown.tut.gltfreg.fast_tesr.FastTESRRenderer;
import net.theunknown.tut.gltfreg.fast_tesr.FastTESRBlock;
import net.theunknown.tut.gltfreg.blockstateless_block.BlockstatelessBlock;
import net.theunknown.tut.gltfreg.animated_block.AnimatedTile;
import net.theunknown.tut.gltfreg.animated_block.AnimatedRenderer;
import net.theunknown.tut.gltfreg.animated_block.AnimatedBlock;
import net.theunknown.tut.ElementsTUT;

import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.ModelBakeEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;

import com.cout970.modelloader.api.ModelLoaderApi;

@ElementsTUT.ModElement.Tag
public class ProcedureExtendspreinit extends ElementsTUT.ModElement {
	public ProcedureExtendspreinit(ElementsTUT instance) {
		super(instance, 42);
	}
	public static final String MODID = "tut";
	public static final String VERSION = "1.0.0";
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		ModelLoaderApi.INSTANCE.registerDomain(MODID);
	}

	@SubscribeEvent
	public void onBlockRegistryCreated(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> reg = event.getRegistry();
		// Registers all blocks
		reg.register(new SimpleBlock());
		reg.register(new BlockstatelessBlock());
		reg.register(new FastTESRBlock());
		reg.register(new AnimatedBlock());
	}

	@SubscribeEvent
	public void onItemRegistryCreated(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> reg = event.getRegistry();
		// Registers all items and itemblocks
		reg.register(createItemBlock(ModBlocks.simpleBlock));
		reg.register(createItemBlock(ModBlocks.blockstatelessBlock));
		reg.register(createItemBlock(ModBlocks.fastTESRBlock));
		reg.register(createItemBlock(ModBlocks.animatedBlock));
		// At this point all blocks and items are registered so it's safe to
		// register the models
		// they need to be registered here because model loading happens before
		// init
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			ModBlocks.simpleBlock.registerModels();
			ModBlocks.blockstatelessBlock.registerModels();
			ModBlocks.fastTESRBlock.registerModels();
			ModBlocks.animatedBlock.registerModels();
			// Register all TileEntitySpecialRender
			ClientRegistry.bindTileEntitySpecialRenderer(FastTESRTile.class, FastTESRRenderer.INSTANCE);
			ClientRegistry.bindTileEntitySpecialRenderer(AnimatedTile.class, AnimatedRenderer.INSTANCE);
		}
	}

	@SubscribeEvent
	public void onRegistryReload(ModelBakeEvent event) {
		FastTESRRenderer.INSTANCE.reloadModels();
		AnimatedRenderer.INSTANCE.reloadModels();
	}

	private ItemBlock createItemBlock(Block block) {
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		return item;
	}
	@ObjectHolder(MODID)
	public static class ModBlocks {
		@ObjectHolder("simple_block")
		public static final SimpleBlock simpleBlock = null;
		@ObjectHolder("blockstateless_block")
		public static final BlockstatelessBlock blockstatelessBlock = null;
		@ObjectHolder("fast_tesr_block")
		public static final FastTESRBlock fastTESRBlock = null;
		@ObjectHolder("animated_block")
		public static final AnimatedBlock animatedBlock = null;
	}
}
