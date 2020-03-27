
package net.theunknown.tut.item;

@ElementsTUT.ModElement.Tag
public class ItemDreadFlint extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:dreadflint")
	public static final Item block = null;

	public ItemDreadFlint(ElementsTUT instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tut:dreadflint", "inventory"));
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			setMaxDamage(0);
			maxStackSize = 64;
			setUnlocalizedName("dreadflint");
			setRegistryName("dreadflint");
			setCreativeTab(TabTut.tab);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			return 1F;
		}

	}

}
