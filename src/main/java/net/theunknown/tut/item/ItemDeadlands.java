
package net.theunknown.tut.item;

public class ItemDeadlands extends Item {

	@GameRegistry.ObjectHolder("tut:deadlands")
	public static final Item block = null;

	public ItemDeadlands() {
		super();
		this.maxStackSize = 1;
		setMaxDamage(64);
		setCreativeTab(TabTut.tab);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer entity, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY,
			float hitZ) {
		pos = pos.offset(facing);
		ItemStack itemstack = entity.getHeldItem(hand);
		if (!entity.canPlayerEdit(pos, facing, itemstack)) {
			return EnumActionResult.FAIL;
		} else {
			if (world.isAirBlock(pos))
				WorldDeadlands.portal.portalSpawn(world, pos);

			itemstack.damageItem(1, entity);
			return EnumActionResult.SUCCESS;
		}
	}
}
