package Commander_Keen.WorldGen.Biomes;

import Commander_Keen.commander_keen;
import Commander_Keen.Lib.NH_IDs;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeMarsDarkSide  extends BiomeGenBase
{
	public BiomeMarsDarkSide(int par1)
	{
	super(par1);
	this.minHeight = 0.1F;
	this.maxHeight = 0.6F;
	this.spawnableMonsterList.clear();
	this.spawnableCreatureList.clear();
	this.topBlock = ((byte)commander_keen.MarsStone.blockID);
	this.fillerBlock = ((byte)commander_keen.MarsStone.blockID);
	this.setBiomeName("Mars Dark Side");

	}
}
