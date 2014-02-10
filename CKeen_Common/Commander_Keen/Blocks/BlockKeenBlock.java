package Commander_Keen.Blocks;



import java.util.List;

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

public class BlockKeenBlock extends Block 
{

	public BlockKeenBlock(int par1) 
	{
		super(par1, Material.rock);
		this.setUnlocalizedName("Keen Block");
		this.setCreativeTab(Commander_KeenTab.KeenTab);
		
	}
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	      
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		   int NumTextures = 17;
	       icons = new Icon[NumTextures];
	            
	       for(int i = 0; i < icons.length; i++)
	       {
	        icons[i] = par1IconRegister.registerIcon(commander_keen.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
	       }
	}
	@SideOnly(Side.CLIENT)

	public Icon getIcon(int par1, int par2)
	{	
		switch (par2)
		{
			case 0:
			{
				switch(par1)
                {
                       case 0:
                             return icons[3];
                       case 1:
                             return icons[3];
                       default:
                             return icons[0];
                }
			}
			
			case 1:
			{
				switch(par1)
                {
                       case 0:
                             return icons[3];
                       case 1:
                             return icons[3];
                       default:
                             return icons[1];
                }
			}
			case 2:
			{
				switch(par1)
                {
                       case 2:
                             return icons[3];
                       case 3:
                             return icons[3];
                       default:
                             return icons[2];
                }
			}
			case 3:
			{			
				return icons[4];
			}
			case 4:
			{
				return icons[5];
			}
			case 5:
			{
				return icons[6];
			}
			case 6:
			{
				return icons[7];
			}
			case 7:
			{
				return icons[8];
			}
			case 8:
			{
				return icons[9];
			}
			case 9:
			{
				return icons[10];
			}
			case 10:
			{
				return icons[11];
			}
			case 11:
			{
				return icons[12];
			}
			case 12:
			{
				return icons[13];
			}
			case 13:
			{
				return icons[14];
			}
			case 14:
			{
				return icons[15];
			}
			case 15:
			{
				return icons[16];
			}
		}
	       return icons[par2];
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)

	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		int NumItems = 16;
	    for (int var4 = 0; var4 < NumItems; ++var4)
	    {
	        par3List.add(new ItemStack(par1, 1, var4));
	    }
	}
	
	public int damageDropped(int par1)
	{
	    return par1;
	}
}
