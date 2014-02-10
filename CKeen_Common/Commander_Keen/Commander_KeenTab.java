package Commander_Keen;
 
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
 
public class Commander_KeenTab extends CreativeTabs
{

public static CreativeTabs KeenTab = new Commander_KeenTab(CreativeTabs.getNextID(), "KeenTab");
 
public Commander_KeenTab(int par1, String par2Str)
   {
     super(par1, par2Str);
 }
 

 public ItemStack getIconItemStack()
 {
	return new ItemStack(commander_keen.KeyCardRed); //Joy stick
 }

}
