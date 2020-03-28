
package net.theunknown.tut.item;

@ElementsTUT.ModElement.Tag
public class ItemTinIngot extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:tiningot")
	public static final Item block = null;

	public ItemTinIngot(ElementsTUT instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tut:tiningot", "inventory"));
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			setMaxDamage(0);
			maxStackSize = 64;
			setUnlocalizedName("tiningot");
			setRegistryName("tiningot");
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
