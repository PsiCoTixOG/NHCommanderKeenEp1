package Commander_Keen.Render;

import Commander_Keen.commander_keen;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderVorticonCommander extends RenderLiving 
{

    private static final ResourceLocation Texture = new ResourceLocation(commander_keen.modid + ":" + "textures/entity/VorticonCommander.png");  //refers to:assets/yourmod/textures/entity/yourtexture.png

    public RenderVorticonCommander(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return Texture;
    }
}
