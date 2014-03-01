package Commander_Keen.WorldGen;

import Commander_Keen.commander_keen;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderMars extends WorldProvider
{
	public void registerWorldChunkManager()
	{
	/** tells Minecraft to use our new WorldChunkManager **/
	this.worldChunkMgr = new WorldChunkMangerMars(worldObj.getSeed(), terrainType);
	this.hasNoSky = false;
	}
	
	@Override
	/** Dimension Name **/
	public String getDimensionName()
	{
	return "KeenMars";
	}
	
	public static WorldProvider getProviderForDimension(int id)
	{
	return DimensionManager.createProviderFor(commander_keen.dimensionId);
	}
	
	/** Welcome message **/
	public String getWelcomeMessage()
	{
	return "Welcome To Mars Commander Keen";
	}
	
	/** What chunk provider to use **/
	public IChunkProvider createChunkGenerator()
	{
	return new ChunkProviderMars(worldObj, worldObj.getSeed(), true);
	}
	
	/** Can player re-spawn here **/
	public boolean canRespawnHere()
	{
	return false;
	}
	
	/** Set user message **/
	// not sure if this works any more ?
	protected synchronized String setUserMessage(String par1Str)
	{
	return "Building Tutorial Dimension";
	}

	/** Determines the dimension the player will be respawned in **/
	public int getRespawnDimension(EntityPlayerMP player)
	{
	return 0;
	}

	/** Dimension Movement speed **/
	public double getMovementFactor()
	{
	return 10.0;
	}
}
