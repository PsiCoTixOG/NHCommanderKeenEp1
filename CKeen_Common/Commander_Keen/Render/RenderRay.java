package Commander_Keen.Render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import Commander_Keen.commander_keen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;

public class RenderRay extends RenderSnowball 
{

		private Icon icon;

		public RenderRay(Item Item) 
		{
			super(Item);
		}
		
		public RenderRay(Item item, int par2) 
		{
			super(item, par2);
		}
		
		@Override
		public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
		{
			ResourceLocation iconLocation = new ResourceLocation(commander_keen.modid + ":textures/entity/Ray Ammo.png");
					
		    if (iconLocation != null)
		    {
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
	        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	        GL11.glScalef(0.5F, 0.5F, 0.5F);
			this.bindTexture(iconLocation);
			Tessellator tessellator = Tessellator.instance;
			
			this.func_77026_a(tessellator, icon);
	        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	        GL11.glPopMatrix();
	    }
		
		    
		}
		
		private void func_77026_a(Tessellator par1Tessellator, Icon par2Icon)
	    {
	        float f = 1;
	        float f1 = 2;
	        float f2 = 1;
	        float f3 = 2;
	        float f4 = 1.0F;
	        float f5 = 0.5F;
	        float f6 = 0.25F;
	        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	        par1Tessellator.startDrawingQuads();
	        par1Tessellator.setNormal(0.0F, 1.0F, 0.0F);
	        par1Tessellator.addVertexWithUV((double)(0.0F - f5), (double)(0.0F - f6), 0.0D, (double)f, (double)f3);
	        par1Tessellator.addVertexWithUV((double)(f4 - f5), (double)(0.0F - f6), 0.0D, (double)f1, (double)f3);
	        par1Tessellator.addVertexWithUV((double)(f4 - f5), (double)(f4 - f6), 0.0D, (double)f1, (double)f2);
	        par1Tessellator.addVertexWithUV((double)(0.0F - f5), (double)(f4 - f6), 0.0D, (double)f, (double)f2);
	        par1Tessellator.draw();
	    }
		
		public void registerIcons(IconRegister par1IconRegister)
		{
		    this.icon = par1IconRegister.registerIcon(commander_keen.modid + ":textures/entity/Ray Ammo.png");
		}

	}

