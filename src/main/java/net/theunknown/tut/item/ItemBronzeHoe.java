
package net.theunknown.tut.item;

@ElementsTUT.ModElement.Tag
public class ItemBronzeHoe extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:bronzehoe")
	public static final Item block = null;

	public ItemBronzeHoe(ElementsTUT instance) {
		super(instance, 62);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemHoe(EnumHelper.addToolMaterial("BRONZEHOE", 1, 500, 4f, 0f, 2)) {

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("hoe", 1);
				return ret.keySet();
			}

		}.setUnlocalizedName("bronzehoe").setRegistryName("bronzehoe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tut:bronzehoe", "inventory"));
	}

}
