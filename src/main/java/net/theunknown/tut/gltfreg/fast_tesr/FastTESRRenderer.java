package net.mcreator.tut.gltfreg.fast_tesr;

import net.minecraftforge.client.model.animation.FastTESR;
import net.minecraftforge.client.MinecraftForgeClient;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;

import net.mcreator.tut.tut;
import net.mcreator.tut.gltfreg.IModelReloadListener;

import com.cout970.modelloader.api.ModelLoaderApi;
import com.cout970.modelloader.api.ModelEntry;

public class FastTESRRenderer extends FastTESR<FastTESRTile> implements IModelReloadListener {
	public static final FastTESRRenderer INSTANCE = new FastTESRRenderer();

	private FastTESRRenderer() {
	}
	private IBakedModel model;

	@Override
	public void renderTileEntityFast(FastTESRTile te, double x, double y, double z, float partialTicks, int destroyStage, float partial,
			BufferBuilder renderer) {
		BlockRendererDispatcher blockRenderer = Minecraft.getMinecraft().getBlockRendererDispatcher();
		BlockPos pos = te.getPos();
		IBlockAccess world = MinecraftForgeClient.getRegionRenderCache(te.getWorld(), pos);
		IBlockState state = world.getBlockState(pos);
		renderer.setTranslation(x - pos.getX(), y - pos.getY(), z - pos.getZ());
		blockRenderer.getBlockModelRenderer().renderModel(world, model, state, pos, renderer, false);
	}

	@Override
	public void reloadModels() {
		ModelResourceLocation modelId = new ModelResourceLocation(tut.MODID + ":fast_tesr_block", "normal");
		ModelEntry entry = ModelLoaderApi.INSTANCE.getModelEntry(modelId);
		model = entry.getBaked();
		if (model == null) {
			throw new IllegalStateException("Model not found: " + modelId);
		}
	}
}
