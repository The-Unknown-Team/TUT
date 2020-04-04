
package net.theunknown.tut.item;

@ElementsTUT.ModElement.Tag
public class ItemInvarAxe extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:invaraxe")
	public static final Item block = null;

	public ItemInvarAxe(ElementsTUT instance) {
		super(instance, 65);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {

		}.setUnlocalizedName("invaraxe").setRegistryName("invaraxe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tut:invaraxe", "inventory"));
	}

	private static class ItemToolCustom extends ItemTool {

		private static final Set<Block> effective_items_set = com.google.common.collect.Sets
				.newHashSet(new Block[]{Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN,
						Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE});

		protected ItemToolCustom() {
			super(EnumHelper.addToolMaterial("INVARAXE", 1, 750, 7f, 8f, 2), effective_items_set);
			this.attackDamage = 8f;

			this.attackSpeed = -3f;
		}

		@Override
		public float getDestroySpeed(ItemStack stack, IBlockState state) {
			Material material = state.getMaterial();
			return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE
					? super.getDestroySpeed(stack, state)
					: this.efficiency;
		}

	}

}
