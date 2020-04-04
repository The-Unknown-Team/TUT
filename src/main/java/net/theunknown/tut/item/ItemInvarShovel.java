
package net.theunknown.tut.item;

@ElementsTUT.ModElement.Tag
public class ItemInvarShovel extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:invarshovel")
	public static final Item block = null;

	public ItemInvarShovel(ElementsTUT instance) {
		super(instance, 66);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("INVARSHOVEL", 1, 750, 7f, 0f, 2)) {

			{
				this.attackSpeed = -3f;
			}

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 1);
				return ret.keySet();
			}

		}.setUnlocalizedName("invarshovel").setRegistryName("invarshovel").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tut:invarshovel", "inventory"));
	}

}
