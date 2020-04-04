
package net.theunknown.tut.item;

@ElementsTUT.ModElement.Tag
public class ItemInvarHoe extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:invarhoe")
	public static final Item block = null;

	public ItemInvarHoe(ElementsTUT instance) {
		super(instance, 67);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemHoe(EnumHelper.addToolMaterial("INVARHOE", 1, 750, 7f, 0f, 2)) {

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("hoe", 1);
				return ret.keySet();
			}

		}.setUnlocalizedName("invarhoe").setRegistryName("invarhoe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tut:invarhoe", "inventory"));
	}

}
