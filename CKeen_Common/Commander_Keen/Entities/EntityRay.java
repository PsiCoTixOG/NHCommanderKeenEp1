package Commander_Keen.Entities;

import Commander_Keen.Lib.NH_Settings;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityRay extends EntityThrowable
{

	public EntityRay(World par1World) 
	{
		super(par1World);
	}
	 public EntityRay(World par1World, EntityLivingBase par2EntityLivingBase)
	 {
	     super(par1World, par2EntityLivingBase);
	 }

	 public EntityRay(World par1World, double par2, double par4, double par6)
	 {
		 super(par1World, par2, par4, par6);
		 setSpeed();
	 }

	 @Override
	 protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	    {
	        if (par1MovingObjectPosition.entityHit != null)
	        {
	            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), NH_Settings.RayDmg);
	        }

	        if (!this.worldObj.isRemote)
	        {
	            this.setDead();
	        }
	    }
	 
	 private void setSpeed()
	 {
		 setThrowableHeading(this.motionX, this.motionY, this.motionZ, 2.0F, 1.0F);
	 }

	 @Override
	 protected float getGravityVelocity() 
	 {
		 return 0;
	 }

}
