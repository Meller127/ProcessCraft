package meller.processcraft.gui;

import meller.processcraft.client.gui.GuiTileCrusher;
import meller.processcraft.guicontainer.TileCrusherContainer;
import meller.processcraft.tile.TileCrusher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public static final int MOD_TILE_ENTITY_GUI = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == MOD_TILE_ENTITY_GUI)
			return new TileCrusherContainer(player.inventory, (TileCrusher) world.getTileEntity(new BlockPos(x, y ,z)));
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == MOD_TILE_ENTITY_GUI)
            return new GuiTileCrusher(player.inventory, (TileCrusher) world.getTileEntity(new BlockPos(x, y, z)));
		
		return null;
	}

}
