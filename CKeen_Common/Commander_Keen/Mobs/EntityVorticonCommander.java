package Commander_Keen.Mobs;

import Commander_Keen.commander_keen;
import Commander_Keen.Lib.NH_Settings;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityVorticonCommander extends EntityMob
{

	private static final ItemStack defaultHeldItem = new ItemStack(Item.stick, 1);

	 public EntityVorticonCommander(World par1World)
	 {
		 
		 super(par1World);

	     this.tasks.addTask(0, new EntityAISwimming(this));
	     this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
	     this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
	     this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
	     this.tasks.addTask(4, new EntityAIMoveThroughVillage(this, 1.0D, false));
	     this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
	     this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	     this.tasks.addTask(6, new EntityAILookIdle(this));
	     this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	     this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	     
	     this.experienceValue = 10;
	 }
	 
	 @Override
    protected void applyEntityAttributes()
    {
		 super.applyEntityAttributes();
	     this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.24D);
	     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(NH_Settings.VorticonCommanderDmg);
	     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(NH_Settings.VorticonCommanderHealth);
    }
	 
	 protected boolean isAIEnabled()
	 {
		 return true;
	 }

	 public ItemStack getHeldItem() 
	 {
		 return defaultHeldItem;
	 }
	 public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData)
	    {
	        par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);

	        this.tasks.addTask(0, new EntityAISwimming(this));
		    this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		    this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
		    this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
		    this.tasks.addTask(4, new EntityAIMoveThroughVillage(this, 1.0D, false));
		    this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		    this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		    this.tasks.addTask(6, new EntityAILookIdle(this));
		    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	            
	        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(4.0D);
	   	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
		    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(NH_Settings.VorticonCommanderDmg);
		    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(NH_Settings.VorticonCommanderHealth);

	        return par1EntityLivingData;
	    }
	 
	 protected int getDropItemId()
	 {
		 return commander_keen.Ray.itemID;
	 }
}
