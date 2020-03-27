
package net.theunknown.tut.block;

@ElementsTUT.ModElement.Tag
public class BlockUranium238Ore extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:uranium238ore")
	public static final Block block = null;

	public BlockUranium238Ore(ElementsTUT instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("uranium238ore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("tut:uranium238ore", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("uranium238ore");
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
