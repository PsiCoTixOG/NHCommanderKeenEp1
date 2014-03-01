package Commander_Keen.WorldGen.Biomes;

import Commander_Keen.Lib.NH_IDs;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeMarsDarkHighlands  extends BiomeGenBase
{
	public BiomeMarsDarkHighlands(int par1)
	{
	super(par1);
	this.minHeight = 0.3F;
	this.maxHeight = 1.5F;
	this.spawnableMonsterList.clear();
	this.spawnableCreatureList.clear();
	this.topBlock = ((byte)NH_IDs.MarsStoneID);
	this.fillerBlock = ((byte)NH_IDs.MarsStoneID);
	this.setBiomeName("Mars Dark Highlands");

	}
}
