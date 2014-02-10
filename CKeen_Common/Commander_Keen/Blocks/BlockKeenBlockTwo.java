package Commander_Keen.Blocks;



import java.util.List;

import Commander_Keen.Commander_KeenTab;
import Commander_Keen.commander_keen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDirt;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockKeenBlockTwo extends BlockDirt 
{

	public BlockKeenBlockTwo(int par1) 
	{
		super(par1);
		this.setUnlocalizedName("Keen Block Two");
		this.setCreativeTab(Commander_KeenTab.KeenTab);
		
	}
	
	@SideOnly(Side.CLIENT)

	private Icon[] icons;
	
	
	      
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		   int NumTextures = 3;
	       icons = new Icon[NumTextures];
	            
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
		int NumItems = 3;
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
