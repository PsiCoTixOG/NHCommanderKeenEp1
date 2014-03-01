package Commander_Keen.WorldGen.Blocks;

import java.util.Random;

import Commander_Keen.Commander_KeenTab;
import Commander_Keen.commander_keen;
import Commander_Keen.WorldGen.TeleporterMars;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockMarsPortal extends BlockPortal 
{

	public BlockMarsPortal(int par1) 
	{
		super(par1);
		this.setUnlocalizedName("Mars Portal");
		this.setCreativeTab(Commander_KeenTab.KeenTab);
		
	}
	
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
           if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP)))
           {
                  EntityPlayerMP player = (EntityPlayerMP) par5Entity;
                  MinecraftServer mServer = MinecraftServer.getServer();
                  if (player.timeUntilPortal > 0)
                  {
                        player.timeUntilPortal = 10;
                  }
                  else if (player.dimension != commander_keen.dimensionId)
                  {
                        player.timeUntilPortal = 10;
                        player.mcServer.getConfigurationManager().transferPlayerToDimension(player, commander_keen.dimensionId, new TeleporterMars(mServer.worldServerForDimension(commander_keen.dimensionId)));
                  }
                  else
                  {
                        player.timeUntilPortal = 10;
                        player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterMars(mServer.worldServerForDimension(0)));
                  }
           }
    }
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
	/** Change these to your portal frame and Portal block **/
	if ((par1World.getBlockId(par2, par3 - 1, par4) != commander_keen.MarsDirt.blockID) || (!tryToCreatePortal(par1World, par2, par3, par4)))
	{
	if ((!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4)))
	{
	par1World.setBlockToAir(par2, par3, par4);
	}
	else
	{
	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, tickRate(par1World) + par1World.rand.nextInt(10));
	}
	}
	}
	/**
	* Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
	*/
	public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
	{
	byte b0 = 0;
	byte b1 = 0;
	if (par1World.getBlockId(par2 - 1, par3, par4) == commander_keen.MarsDirt.blockID || par1World.getBlockId(par2 + 1, par3, par4) == commander_keen.MarsDirt.blockID)
	{
	b0 = 1;
	}
	if (par1World.getBlockId(par2, par3, par4 - 1) == commander_keen.MarsDirt.blockID || par1World.getBlockId(par2, par3, par4 + 1) == commander_keen.MarsDirt.blockID)
	{
	b1 = 1;
	}
	if (b0 == b1)
	{
	return false;
	}
	else
	{
	if (par1World.getBlockId(par2 - b0, par3, par4 - b1) == 0)
	{
	par2 -= b0;
	par4 -= b1;
	}
	int l;
	int i1;
	for (l = -1; l <= 2; ++l)
	{
	for (i1 = -1; i1 <= 3; ++i1)
	{
	         boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
	         if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
	         {
	         int j1 = par1World.getBlockId(par2 + b0 * l, par3 + i1, par4 + b1 * l);
	         if (flag)
	         {
	         if (j1 !=commander_keen.MarsDirt.blockID)
	         {
	         return false;
	         }
	         }
	         else if (j1 != 0 && j1 != commander_keen.MarsStone.blockID)
	         {
	         return false;
	         }
	         }
	}
	}
	for (l = 0; l < 2; ++l)
	{
	for (i1 = 0; i1 < 3; ++i1)
	{
	         par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, commander_keen.MarsPortal.blockID, 0, 2);
	}
	}
	return true;
	}
	}
	
	@SideOnly(Side.CLIENT)
	private Icon icons;
	      
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	        icons = par1IconRegister.registerIcon(commander_keen.modid + ":" + (this.getUnlocalizedName().substring(5)));	       
	}
	@SideOnly(Side.CLIENT)

	public Icon getIcon(int par1, int par2)
	{
	       return icons;
	}

	@SideOnly(Side.CLIENT)
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	return this.blockID;
    }

}
