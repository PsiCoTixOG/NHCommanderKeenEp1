package Commander_Keen.WorldGen.Blocks;



import java.util.List;
import java.util.Random;

import Commander_Keen.Commander_KeenTab;
import Commander_Keen.commander_keen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockMarsDirt extends Block 
{

	public BlockMarsDirt(int par1) 
	{
		super(par1, Material.ground);
		this.setUnlocalizedName("Mars Dirt");
		this.setCreativeTab(Commander_KeenTab.KeenTab);
		this.setHardness(30F);
		
	}
	
	@SideOnly(Side.CLIENT)

	private Icon[] icons;
	      
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	       icons = new Icon[1];
	            
	       for(int i = 0; i < icons.length; i++)
	       {
	        icons[i] = par1IconRegister.registerIcon(commander_keen.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
	       }
	}
	@SideOnly(Side.CLIENT)

	public Icon getIcon(int par1, int par2)
	{
	       return icons[par2];
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)

	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int var4 = 0; var4 < 1; ++var4)
	    {
	        par3List.add(new ItemStack(par1, 1, var4));
	    }
	}
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	return this.blockID;
    }
	
	public int damageDropped(int par1)
	{
	    return par1;
	}
}
