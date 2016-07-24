package meller.processcraft.init;

import meller.processcraft.Reference;
import meller.processcraft.items.ItemexStop;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item exstop;
	
	public static void init ()
	{
		exstop = new ItemexStop();
	}
	
	public static void register()
	{
		GameRegistry.register(exstop);
	}

	public static void registerRenders()
	{
		registerRender(exstop);
	}
	
	private static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
