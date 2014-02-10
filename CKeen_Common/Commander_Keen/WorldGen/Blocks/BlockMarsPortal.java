package Commander_Keen.WorldGen.Blocks;

import java.util.Random;

import Commander_Keen.Commander_KeenTab;
import Commander_Keen.commander_keen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockMarsPortal extends BlockPortal 
{

	public BlockMarsPortal(int par1) 
	{
		super(par1);
		this.setUnlocalizedName("Mars Portal");
		this.setCreativeTab(Commander_KeenTab.KeenTab);
		
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
