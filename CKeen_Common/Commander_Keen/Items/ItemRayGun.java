package Commander_Keen.Items;

import java.util.logging.Level;

import Commander_Keen.Commander_KeenTab;
import Commander_Keen.commander_keen;
import Commander_Keen.Entities.EntityRay;
import Commander_Keen.Lib.NHLogger;
import Commander_Keen.Lib.NH_Settings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRayGun extends Item 
{
	public ItemRayGun(int ID)
	{
		super(ID);
		this.canRepair=false;
		this.setUnlocalizedName("Ray Gun");
		this.setCreativeTab(Commander_KeenTab.KeenTab);
		this.setMaxDamage(NH_Settings.PistolWhipDmg);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
	
		NHLogger.log(Level.INFO, "Using Item");
		
		if(par3EntityPlayer.capabilities.isCreativeMode)
		{
			NHLogger.log(Level.INFO, "Creative Mode Is On");
		}
		
		if(par3EntityPlayer.inventory.hasItem(commander_keen.Ray.itemID))
		{
			NHLogger.log(Level.INFO,"Has Ray");
		}
		
		if(par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.consumeInventoryItem(commander_keen.Ray.itemID)) 
		{

				NHLogger.log(Level.INFO, "Fire");
				par2World.spawnEntityInWorld(new EntityRay(par2World, par3EntityPlayer));	
		}
		// par1ItemStack.damageItem(100, par3EntityPlayer);
       return par1ItemStack;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(commander_keen.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
