package Commander_Keen.Blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemKeenBlockTwo extends ItemBlock
{

	public ItemKeenBlockTwo(int par1) 
	{
		super(par1);
		this.setHasSubtypes(true);
		
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
	       String name = "";
	       switch(itemstack.getItemDamage())
	       {
	             case 0:
	             {
	            	 name = "Purple Brick2";
	            	 break;
	             }
	             case 1:
	             {
	            	 name = "Purple Brick3";
	            	 break;
	             }
	             case 2:
	             {
	            	 name = "Purple Brick4";
	            	 break;
	             }
	             default: name = "broken";
	       }
	       return getUnlocalizedName() + "." + name;
	}
	
	

	public int getMetadata(int par1)

	{
	      return par1;
	}
}
