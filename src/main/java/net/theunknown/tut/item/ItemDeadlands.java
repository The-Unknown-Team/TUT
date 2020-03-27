
package net.theunknown.tut.item;

import net.theunknown.tut.world.WorldDeadlands;
import net.theunknown.tut.creativetab.TabTut;

import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;

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
