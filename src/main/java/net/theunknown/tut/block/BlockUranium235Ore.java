
package net.theunknown.tut.block;

@ElementsTUT.ModElement.Tag
public class BlockUranium235Ore extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:uranium235ore")
	public static final Block block = null;

	public BlockUranium235Ore(ElementsTUT instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("uranium235ore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("tut:uranium235ore", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("uranium235ore");
			setSoundType(SoundType.STONE);

			setHarvestLevel("pickaxe", 3);

			setHardness(3F);
			setResistance(100F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabTut.tab);

		}

	}

}
