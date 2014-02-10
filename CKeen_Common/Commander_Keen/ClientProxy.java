package Commander_Keen;

import Commander_Keen.Entities.*;
import Commander_Keen.Render.*;
import Commander_Keen.Mobs.*;
import Commander_Keen.Mobs.Model.*;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderers() 
	{
		//NOOB HAUSE - Commander Keen
		//Ray Gun Projectile - NOT IMPLAMENTED
		RenderingRegistry.registerEntityRenderingHandler(EntityRay.class, new RenderRay(commander_keen.Ray));
		
		
		//NOOB HAUS - Commander Keen
		//Vorticon
		RenderingRegistry.registerEntityRenderingHandler(EntityVorticon.class, new RenderVorticon(new ModelVorticon(), 0.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityVorticonCommander.class, new RenderVorticonCommander(new ModelVorticonCommander(), 0.0F));
		
	}

	@Override
	public void initSounds() 
	{

	}

}
