package net.theunknown.tut.procedure;

import net.theunknown.tut.item.ItemBronzeIngot;
import net.theunknown.tut.ElementsTUT;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

@ElementsTUT.ModElement.Tag
public class ProcedureMaincommandCommandExecuted extends ElementsTUT.ModElement {
	public ProcedureMaincommandCommandExecuted(ElementsTUT instance) {
		super(instance, 68);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MaincommandCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemBronzeIngot.block, (int) (1));
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
	}
}
