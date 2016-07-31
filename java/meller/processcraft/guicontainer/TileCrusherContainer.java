package meller.processcraft.guicontainer;

import meller.processcraft.tile.TileCrusher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class TileCrusherContainer extends Container
{
	private TileCrusher te;
	private IInventory playerInv;
	
	public TileCrusherContainer(IInventory playerInv, TileCrusher te)
	{
		this.te = te;
		this.playerInv = playerInv;
		
		// Tile Entity, Slot 0-8, Slot IDs 0-8
	    for (int y = 0; y < 1; ++y) {
	        for (int x = 0; x < 2; ++x) {
	            this.addSlotToContainer(new Slot(te, x + y * 2, 45 + x * 71, 35 + y * 18));
	        }
	    }

	    // Player Inventory, Slot 9-35, Slot IDs 9-35
	    for (int y = 0; y < 3; ++y) {
	        for (int x = 0; x < 9; ++x) {
	            this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
	        }
	    }

	    // Player Inventory, Slot 0-8, Slot IDs 36-44
	    for (int x = 0; x < 9; ++x) {
	        this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
	    }

	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return this.te.isUseableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
	{
		ItemStack previous = null;
	    Slot slot = (Slot) this.inventorySlots.get(index);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (index < 9) {
	            // From TE Inventory to Player Inventory
	            if (!this.mergeItemStack(current, 9, 45, true))
	                return null;
	        } else {
	            // From Player Inventory to TE Inventory
	            if (!this.mergeItemStack(current, 0, 9, false))
	                return null;
	        }

	        if (current.stackSize == 0)
	            slot.putStack((ItemStack) null);
	        else
	            slot.onSlotChanged();

	        if (current.stackSize == previous.stackSize)
	            return null;
	        slot.onPickupFromSlot(playerIn, current);
	    }
	    return previous;
	}

}
