
package net.theunknown.tut.block;

@ElementsTUT.ModElement.Tag
public class BlockAlloySmelterFurnace extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:alloysmelterfurnace")
	public static final Block block = null;

	public BlockAlloySmelterFurnace(ElementsTUT instance) {
		super(instance, 51);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("alloysmelterfurnace"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("tut:alloysmelterfurnace", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("alloysmelterfurnace");
			setSoundType(SoundType.STONE);

			setHarvestLevel("pickaxe", 1);

			setHardness(2F);
			setResistance(50F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabTut.tab);

		}

		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(Blocks.FURNACE, (int) (1));
		}

		@Override
		public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
			return false;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(Blocks.FURNACE, (int) (1)));
		}

	}

}
