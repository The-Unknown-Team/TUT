
package net.theunknown.tut.item;

@ElementsTUT.ModElement.Tag
public class ItemInvarPickaxe extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:invarpickaxe")
	public static final Item block = null;

	public ItemInvarPickaxe(ElementsTUT instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("INVARPICKAXE", 3, 750, 7f, 1f, 2)) {

			{
				this.attackSpeed = -2.8f;
			}

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 3);
				return ret.keySet();
			}

		}.setUnlocalizedName("invarpickaxe").setRegistryName("invarpickaxe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tut:invarpickaxe", "inventory"));
	}

}
