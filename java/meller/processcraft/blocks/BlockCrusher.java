package meller.processcraft.blocks;

import meller.processcraft.Processcraft;
import meller.processcraft.Reference;
import meller.processcraft.tile.TileCrusher;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCrusher extends Block implements ITileEntityProvider
{
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	
	private BlockPos pos;
	
	public BlockCrusher() 
	{
		super(Material.IRON);
		setUnlocalizedName(Reference.ProcesscraftBlocks.CRUSHER.getUnlocalizedName());
		setRegistryName(Reference.ProcesscraftBlocks.CRUSHER.getRegistryName());
		setHardness(1.5F);
		setHarvestLevel("pickaxe", 2);
		setResistance(20F);
		this.setCreativeTab(Processcraft.CREATIVE_TAB);
		this.isBlockContainer = true;
		
		setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	public BlockPos getPos() 
	{
		pos = this.getPos();
		return pos;
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) 
	{
		world.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(pos, placer)), 2);
	}
	
	public static EnumFacing getFacingFromEntity(BlockPos clickedBlock, EntityLivingBase entity)
	{
		return EnumFacing.getFacingFromVector(
				(float) (entity.posX - clickedBlock.getX()), 
				(float) (entity.posY - clickedBlock.getY()), 
				(float) (entity.posZ - clickedBlock.getZ()));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{

		return state.getValue(FACING).getIndex();
	}
	
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, FACING);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileCrusher();
	}
	
	@Override
	public boolean hasTileEntity() 
	{
		return true;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) 
	{
		TileCrusher te = (TileCrusher) world.getTileEntity(pos);
	    InventoryHelper.dropInventoryItems(world, pos, te);
	    super.breakBlock(world, pos, state);
	}
}