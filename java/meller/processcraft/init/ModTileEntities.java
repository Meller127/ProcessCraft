package meller.processcraft.init;

import meller.processcraft.tile.TileCrusher;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileCrusher.class, "blockcrusher");
	}
}
