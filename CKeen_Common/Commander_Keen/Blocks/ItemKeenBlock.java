package Commander_Keen.Blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemKeenBlock extends ItemBlock
{

	public ItemKeenBlock(int par1) 
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
	                    name = "Support";
	                    break;
	             }
	             case 1:
	             {
	                    name = "Support Top";
	                    break;
	             }
	             case 2:
	             {
	                    name = "Support Bottom";
	                    break;
	             }
	             case 3:
	             {
	            	 	name = "Red Metal";
	            	 	break;
	             }
	             case 4:
	             {
	            	 name = "Yellow Metal";
	            	 break;
	             }
	             case 5:
	             {
	            	 name = "Blue Metal";
	            	 break;
	             }
	             case 6:
	             {
	            	 name = "Green Metal";
	            	 break;
	             }
	             case 7:
	             {
	            	 name = "Mars Temple Wall";
	            	 break;
	             }
	             case 8:
	             {
	            	 name = "Black Metal";
	            	 break;
	             }
	             case 9:
	             {
	            	 name = "White Metal";
	            	 break;
	             }
	             case 10:
	             {
	            	 name = "Purple Plate";
	            	 break;
	             }
	             case 11:
	             {
	            	 name = "Blue Plate";
	            	 break;
	             }
	             case 12:
	             {
	            	 name = "Red Plate";
	            	 break;
	             }
	             case 13:
	             {
	            	 name = "Green Plate";
	            	 break;
	             }
	             case 14:
	             {
	            	 name = "Yellow Plate";
	            	 break;
	             }
	             case 15:
	             {
	            	 name = "Purple Brick1";
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
