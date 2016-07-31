package meller.processcraft.client.gui;

import meller.processcraft.guicontainer.TileCrusherContainer;
import meller.processcraft.tile.TileCrusher;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiTileCrusher extends GuiContainer
{

	private IInventory playerInv;
	private TileCrusher te;

	public GuiTileCrusher(IInventory playerInv, TileCrusher te) 
	{
		super(new TileCrusherContainer(playerInv, te));
		
		this.playerInv = playerInv;
		this.te = te;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
	    this.mc.getTextureManager().bindTexture(new ResourceLocation("proc:textures/gui/tile_crusher.png"));
	    this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		//String s = this.te.getDisplayName().getUnformattedText();
	    //this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);            //#404040
	    //this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);      //#404040
	}

}
