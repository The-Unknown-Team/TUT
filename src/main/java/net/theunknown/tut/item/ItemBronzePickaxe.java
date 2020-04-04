
package net.theunknown.tut.item;

@ElementsTUT.ModElement.Tag
public class ItemBronzePickaxe extends ElementsTUT.ModElement {

	@GameRegistry.ObjectHolder("tut:bronzepickaxe")
	public static final Item block = null;

	public ItemBronzePickaxe(ElementsTUT instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("BRONZEPICKAXE", 3, 500, 6.5f, 0.5f, 2)) {

			{
				this.attackSpeed = -2.8f;
			}

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 3);
				return ret.keySet();
			}

		}.setUnlocalizedName("bronzepickaxe").setRegistryName("bronzepickaxe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tut:bronzepickaxe", "inventory"));
	}

}
