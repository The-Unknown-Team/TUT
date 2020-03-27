
package net.theunknown.tut.block;

@ElementsTUT.ModElement.Tag
public class BlockDreadGravel extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:dreadgravel")
	public static final Block block = null;

	public BlockDreadGravel(ElementsTUT instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("dreadgravel"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("tut:dreadgravel", "inventory"));

	}

	public static class BlockCustom extends BlockFalling {

		public BlockCustom() {
			super(Material.GROUND);

			setUnlocalizedName("dreadgravel");
			setSoundType(SoundType.GROUND);

			setHarvestLevel("shovel", 1);

			setHardness(0.6F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabTut.tab);

		}

		@Override
		public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer entity, boolean willHarvest) {
			boolean retval = super.removedByPlayer(state, world, pos, entity, willHarvest);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();

				ProcedureDreadGravelBlockDestroyedByPlayer.executeProcedure($_dependencies);
			}
			return retval;
		}

	}

}
