
package net.theunknown.tut.item;

@ElementsTUT.ModElement.Tag
public class ItemBronzeShovel extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:bronzeshovel")
	public static final Item block = null;

	public ItemBronzeShovel(ElementsTUT instance) {
		super(instance, 61);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("BRONZESHOVEL", 1, 500, 6.5f, -0.5f, 2)) {

			{
				this.attackSpeed = -3f;
			}

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 1);
				return ret.keySet();
			}

		}.setUnlocalizedName("bronzeshovel").setRegistryName("bronzeshovel").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tut:bronzeshovel", "inventory"));
	}

}
