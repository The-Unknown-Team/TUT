package net.theunknown.tut.procedure;

import net.theunknown.tut.TUT;
import net.theunknown.tut.ElementsTUT;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.theunknown.tut.items.cables.Testpowercable;
import net.theunknown.tut.items.cables.ItemTestpowercable;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;

@ElementsTUT.ModElement.Tag
public class ProcedureClientProxy extends ElementsTUT.ModElement {
	public ProcedureClientProxy(ElementsTUT instance) {
		super(instance, 40);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		super.init(event);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(ProcedureCommonProxy.testpower_cable), 0,
				new ModelResourceLocation(TUT.MODID + ":testpower_cable", "inventory"));
		// Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TheImmersiveTech.voltmeter,
		// 0, new ModelResourceLocation(TheImmersiveTech.MODID + ":voltmeter",
		// "inventory"));
	}
}
