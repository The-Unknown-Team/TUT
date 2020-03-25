package net.theunknown.tut.gltfreg.blockstateless_block;

import net.theunknown.tut.gltfreg.IModelRegisterer;
import net.theunknown.tut.TUT;

import net.minecraftforge.client.model.ModelLoader;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import com.cout970.modelloader.api.ModelLoaderApi;

public class BlockstatelessBlock extends Block implements IModelRegisterer {
	public BlockstatelessBlock() {
		super(Material.ROCK);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setUnlocalizedName("blockstateless_block");
		setRegistryName(TUT.MODID, "blockstateless_block");
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

	@Override
	public void registerModels() {
		ResourceLocation registryName = getRegistryName();
		if (registryName == null) {
			throw new IllegalStateException("Block doesn't have a registry name: " + this.getClass());
		}
		ModelResourceLocation blockModel = new ModelResourceLocation(registryName, "normal");
		ModelResourceLocation itemModel = new ModelResourceLocation(registryName, "inventory");
		ResourceLocation modelLocation = new ResourceLocation(TUT.MODID, "models/block/blockstateless_block.gltf");
		ModelLoaderApi.INSTANCE.registerModel(blockModel, modelLocation, true);
		ModelLoaderApi.INSTANCE.registerModel(itemModel, modelLocation, true);
		// Register item model
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, itemModel);
	}
}
