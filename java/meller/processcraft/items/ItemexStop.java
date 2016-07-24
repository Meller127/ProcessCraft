package meller.processcraft.items;

import meller.processcraft.ProcessCraftCreativeTab;
import meller.processcraft.Processcraft;
import meller.processcraft.Reference;
import net.minecraft.item.Item;

public class ItemexStop extends Item {
	
	public ItemexStop() 
	{
		setUnlocalizedName(Reference.ProcesscraftItems.EXSTOP.getUnlocalizedName());
		setRegistryName(Reference.ProcesscraftItems.EXSTOP.getRegistryName());
		setCreativeTab(Processcraft.CREATIVE_TAB);
	}

}
