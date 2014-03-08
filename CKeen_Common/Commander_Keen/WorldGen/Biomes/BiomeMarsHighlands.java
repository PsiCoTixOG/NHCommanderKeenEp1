package Commander_Keen.WorldGen.Biomes;

import Commander_Keen.commander_keen;
import Commander_Keen.Lib.NH_IDs;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeMarsHighlands  extends BiomeGenBase
{
	public BiomeMarsHighlands(int par1)
	{
	super(par1);
	this.minHeight = 0.3F;
	this.maxHeight = 1.5F;
	this.spawnableMonsterList.clear();
	this.spawnableCreatureList.clear();
	this.topBlock = ((byte)commander_keen.MarsDirt.blockID);
	this.fillerBlock = ((byte)commander_keen.MarsStone.blockID);
	this.setBiomeName("Mars Highlands");

	}
}
