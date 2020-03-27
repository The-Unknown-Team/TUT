
package net.theunknown.tut.creativetab;

import net.theunknown.tut.item.ItemProcessingCircuit;
import net.theunknown.tut.ElementsTUT;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

@ElementsTUT.ModElement.Tag
public class TabTut extends ElementsTUT.ModElement {
	public TabTut(ElementsTUT instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabtut") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemProcessingCircuit.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
