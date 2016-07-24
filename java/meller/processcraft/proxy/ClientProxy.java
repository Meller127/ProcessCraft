package meller.processcraft.proxy;

import meller.processcraft.init.ModBlocks;
import meller.processcraft.init.ModItems;
import meller.processcraft.init.ModTileEntities;

public class ClientProxy implements CommonProxy {

	@Override
	public void init() 
	{
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
}
