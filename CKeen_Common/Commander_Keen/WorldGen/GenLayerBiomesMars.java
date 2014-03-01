package Commander_Keen.WorldGen;


import Commander_Keen.commander_keen;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;


public class GenLayerBiomesMars extends GenLayer 
{

	protected BiomeGenBase[] allowedBiomes = {commander_keen.MarsPlains, commander_keen.MarsHighlands, commander_keen.MarsDarkSide, commander_keen.MarsDarkHighlands};

	public GenLayerBiomesMars(long seed, GenLayer genlayer) {
	super(seed);
	this.parent = genlayer;
	}

	public GenLayerBiomesMars(long seed) {
	super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
	int[] dest = IntCache.getIntCache(width*depth);

	for (int dz=0; dz<depth; dz++)
	{
	for (int dx=0; dx<width; dx++)
	{
	this.initChunkSeed(dx+x, dz+z);
	dest[(dx+dz*width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
	}
	}
	return dest;
	}
	}


