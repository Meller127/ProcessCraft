package meller.processcraft;

import meller.processcraft.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ProcessCraftCreativeTab extends CreativeTabs {

	public ProcessCraftCreativeTab() 
	{
		super("tabProcessCraft");

	}
	
	@Override
	public Item getTabIconItem() 
	{
		return ModItems.exstop;
	}

}
