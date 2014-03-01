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
