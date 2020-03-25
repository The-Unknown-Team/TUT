package net.mcreator.tut.gltfreg.simple_block_model;

import net.minecraftforge.client.model.ModelLoader;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import net.mcreator.tut.tut;
import net.mcreator.tut.gltfreg.IModelRegisterer;

public class SimpleBlock extends Block implements IModelRegisterer {
	public SimpleBlock() {
		super(Material.ROCK);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setUnlocalizedName("simple_block");
		setRegistryName(tut.MODID, "simple_block");
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
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
