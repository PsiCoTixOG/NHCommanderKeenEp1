package Commander_Keen.WorldGen.Blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMarsStone extends ItemBlock
{

	public ItemMarsStone(int par1) 
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
	                 name = "Mars Stone";
	                 break;
	             }
	             case 1:
	             {
	            	 name = "Mars Cobblestone";
	            	 break;
	             }
	             case 2:
	             {
	            	 name = "Mars Gold";
	            	 break;
	             }
	             case 3:
	             {
	            	 name = "Mars Iron";
	            	 break;
	             }
	             case 4:
	             {
	            	 name = "Mars Coal";
	            	 break;
	             }
	             case 5:
	             {
	            	 name = "Mars Diamond";
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
