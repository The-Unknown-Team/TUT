
package net.theunknown.tut.world.biome;

import net.theunknown.tut.block.BlockDeadGrass;
import net.theunknown.tut.ElementsTUT;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Blocks;

import java.util.Random;

@ElementsTUT.ModElement.Tag
public class BiomeDeadlandsPlains extends ElementsTUT.ModElement {
	@GameRegistry.ObjectHolder("tut:deadlandsplains")
	public static final BiomeGenCustom biome = null;
	public BiomeDeadlandsPlains(ElementsTUT instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Deadlands Plains").setRainfall(0.5F).setBaseHeight(0.1F).setHeightVariation(0.2F).setTemperature(0.5F));
			setRegistryName("deadlandsplains");
			topBlock = BlockDeadGrass.block.getDefaultState();
			fillerBlock = Blocks.DIRT.getStateFromMeta(1);
			decorator.generateFalls = false;
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 4;
			decorator.grassPerChunk = 4;
			decorator.deadBushPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
