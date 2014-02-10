package Commander_Keen.WorldGen.Biomes;

import Commander_Keen.Lib.NH_IDs;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeMarsPlains  extends BiomeGenBase
{
	public BiomeMarsPlains(int par1)
	{
	super(par1);
	this.minHeight = 0.1F;
	this.maxHeight = 0.6F;
	this.spawnableMonsterList.clear();
	this.spawnableCreatureList.clear();
	this.topBlock = ((byte)NH_IDs.MarsDirtID);
	this.fillerBlock = ((byte)NH_IDs.MarsStoneID);
	this.setBiomeName("Mars Plains");

	}
}
