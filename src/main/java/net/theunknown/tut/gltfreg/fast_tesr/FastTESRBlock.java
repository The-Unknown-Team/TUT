package net.mcreator.tut.gltfreg.fast_tesr;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.Block;

import net.mcreator.tut.tut;
import net.mcreator.tut.gltfreg.IModelRegisterer;

import javax.annotation.Nullable;

import com.cout970.modelloader.api.ModelLoaderApi;

public class FastTESRBlock extends Block implements IModelRegisterer, ITileEntityProvider {
	public FastTESRBlock() {
		super(Material.ROCK);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setUnlocalizedName("fast_tesr_block");
		setRegistryName(tut.MODID, "fast_tesr_block");
		GameRegistry.registerTileEntity(FastTESRTile.class, getRegistryName());
	}

	/*
	 * This method disables the default block rendering, so only the
	 * FastTESRRenderer will be shown
	 */
	@Override
	public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
		return false;
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new FastTESRTile();
	}

	@Override
	public void registerModels() {
		ResourceLocation registryName = getRegistryName();
		if (registryName == null) {
			throw new IllegalStateException("Block doesn't have a registry name: " + this.getClass());
		}
		ModelResourceLocation blockModel = new ModelResourceLocation(registryName, "normal");
		ModelResourceLocation itemModel = new ModelResourceLocation(registryName, "inventory");
		ResourceLocation modelLocation = new ResourceLocation(tut.MODID, "models/block/fast_tesr_block.gltf");
		ModelLoaderApi.INSTANCE.registerModel(blockModel, modelLocation, true);
		ModelLoaderApi.INSTANCE.registerModel(itemModel, modelLocation, true);
		// Register item model
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, itemModel);
	}
}
