
package net.theunknown.tut.block;

@ElementsTUT.ModElement.Tag
public class BlockIrradiatedStone extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:irradiatedstone")
	public static final Block block = null;

	public BlockIrradiatedStone(ElementsTUT instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("irradiatedstone"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("tut:irradiatedstone", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("irradiatedstone");
			setSoundType(SoundType.STONE);

			setHarvestLevel("pickaxe", 2);

			setHardness(2.5F);
			setResistance(50F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabTut.tab);

		}

	}

}
