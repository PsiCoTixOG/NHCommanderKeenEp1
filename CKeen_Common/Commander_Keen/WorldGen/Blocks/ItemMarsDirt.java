package Commander_Keen.WorldGen.Blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMarsDirt extends ItemBlock
{

	public ItemMarsDirt(int par1) 
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
	                 name = "Mars Dirt";
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
