package Commander_Keen.Items;

import Commander_Keen.Commander_KeenTab;
import Commander_Keen.commander_keen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemKeyCardYellow extends Item 
{
	public ItemKeyCardYellow(int ID)
	{
		super(ID);
		this.setUnlocalizedName("Yellow Key Card");
		this.setCreativeTab(Commander_KeenTab.KeenTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(commander_keen.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
}
