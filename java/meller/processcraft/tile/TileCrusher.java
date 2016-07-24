package meller.processcraft.tile;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import scala.reflect.internal.Trees.This;

public class TileCrusher extends TileEntity implements ITickable
{	
	
	private ItemStack itemStack;
	private ArrayList arrayList = new ArrayList();
	private int aint;
	private boolean aBoolean;
	private int clickTimes;
	
	private BlockPos pos = this.getPos();
	

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		 super.writeToNBT(nbt);
		 nbt.setInteger("clickTimes", clickTimes);
		 return nbt;
		 
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) 
	{
		super.readFromNBT(nbt);
		this.clickTimes = nbt.getInteger("clickTimes");
	
	}

	@Override
	public void update() 
	{
		
	}
}
