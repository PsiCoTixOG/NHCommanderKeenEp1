package Commander_Keen;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import Commander_Keen.Items.*;
import Commander_Keen.Lib.*;
import Commander_Keen.Mobs.*;
import Commander_Keen.WorldGen.*;
import Commander_Keen.WorldGen.Biomes.*;
import Commander_Keen.WorldGen.Blocks.*;
import Commander_Keen.Blocks.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="NOOBHAUS_CommanderKeen", name="Commander Keen", version="0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class commander_keen
{
	public static final String modid = "NOOBHAUS_CommanderKeen";
	
	
	@SidedProxy( clientSide = "Commander_Keen.ClientProxy", serverSide = "Commander_Keen.CommonProxy")
	public static CommonProxy proxy;
	
	public static int dimensionId = 9;
	
	//NOOB HAUS: Entity ID start
	static int startEntityId = 4000;
	
	//NOOB HAUS: Item Declarations
	//Keys
	public static Item KeyCardRed;
	public static Item KeyCardYellow;
	public static Item KeyCardGreen;
	public static Item KeyCardBlue;
	
	//Tools
	public static Item PogoStick; //Always jumping + super jump
	public static Item RayGun;
	public static Item Ray; // Projectile and Ammo Item

	//Ship parts (Sends to Mars or Returns To The Over World)
	public static Item Joystick;
	public static Item CarBattery;
	public static Item VacuumCleaner;
	public static Item Everclear;

	//Point Items
	public static Item Lollipop; //100 points
	public static Item Soda; //200 points
	public static Item Pizza; //500 points
	public static Item ComicBook; //1000 points
	public static Item TeddyBear; //5000 points
	
	//NOOB HAUS: Blocks for Mars Terrain Generation
	public static Block MarsDirt; //Also Known as all the world blocks (Dirt, Stone, Cobblestone, Mars, Iron, Gold, Coal, Diamond, Ruby) 
	public static Block MarsStone;
	public static Block KeenBlock; //Also Known as all the Creative/structural blocks
	public static Block KeenBlockTwo;//More Creative/Structrual blocks

	public static Block MarsPortal;
	
	public static final BiomeGenBase MarsPlains = new BiomeMarsPlains(25);
	public static final BiomeGenBase MarsDarkSide = new BiomeMarsDarkSide(26);
	public static final BiomeGenBase MarsHighlands = new BiomeMarsHighlands(27);
	public static final BiomeGenBase MarsDarkHighlands = new BiomeMarsDarkHighlands(28);
	
	//NOOB HAUS: Material Reg
	static EnumArmorMaterial matSpaceSuit = EnumHelper.addArmorMaterial("SpaceSuit", 25, new int[] { 3, 8, 6, 3 }, 10);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		NHLogger.init();
		NHLogger.log(Level.INFO, "Logger Loaded");
		
		NHConfigHandler.init(event.getSuggestedConfigurationFile());
		NHLogger.log(Level.INFO, "Config Loaded");
		
		proxy.initRenderers();
		NHLogger.log(Level.INFO, "Renderers Loaded");
		
		NH_Settings.SetKeenValues();
		NHLogger.log(Level.INFO, "Damage And Health Set");
		
		//proxy.initSounds();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		//NOOB HAUS: Moved all the ID's to it's own class located in lib
		NHLogger.log(Level.INFO, "AWESOME");
		
		//NOOB HAUS: Register Creative Tab
		LanguageRegistry.instance().addStringLocalization("itemGroup.KeenTab", "en_US", "KeenTab");
		
		//NOOB HAUS: Register World
		DimensionManager.registerProviderType(commander_keen.dimensionId, WorldProviderMars.class, false);
		DimensionManager.registerDimension(commander_keen.dimensionId, commander_keen.dimensionId);
		
		//NOOB HAUS: Items
		//Keys
		KeyCardRed = new ItemKeyCardRed(NH_IDs.KeyCardRedID);
		LanguageRegistry.addName(KeyCardRed,"Red Key Card");
		
		KeyCardYellow = new ItemKeyCardYellow(NH_IDs.KeyCardYellowID);
		LanguageRegistry.addName(KeyCardYellow,"Yellow Key Card");
		
		KeyCardGreen = new ItemKeyCardGreen(NH_IDs.KeyCardGreenID);
		LanguageRegistry.addName(KeyCardGreen,"Green Key Card");
		
		KeyCardBlue = new ItemKeyCardBlue(NH_IDs.KeyCardBlueID);
		LanguageRegistry.addName(KeyCardGreen,"Green Key Card");
		
		
		//Tools
		PogoStick = new ItemPogoStick(NH_IDs.PogoStickID);
		LanguageRegistry.addName(PogoStick, "Pogo Stick");
		
		RayGun = new ItemRayGun(NH_IDs.RayGunID);
		LanguageRegistry.addName(RayGun, "Ray Gun");
		
		Ray = new ItemRay(NH_IDs.RayID);
		LanguageRegistry.addName(Ray,"Ray Ammo");

		//Ship parts (Sends to Mars or Returns To The Over World)
		Joystick = new ItemJoystick(NH_IDs.JoystickID);
		LanguageRegistry.addName(Joystick,"Joystick");
		
		CarBattery = new ItemCarBattery(NH_IDs.CarBatteryID);
		LanguageRegistry.addName(CarBattery,"Car Battery");
		
		VacuumCleaner = new ItemVacuumCleaner(NH_IDs.VacuumCleanerID);
		LanguageRegistry.addName(VacuumCleaner,"Vacuum Cleaner");
		
		Everclear = new ItemEverclear(NH_IDs.EverclearID);
		LanguageRegistry.addName(Everclear, "Everclear");

		//Point Items
		Lollipop = new ItemLollipop(NH_IDs.LollipopID); //100 points
		LanguageRegistry.addName(Lollipop,"Lollipop");
		
		Soda = new ItemSoda(NH_IDs.SodaID); //200 points
		LanguageRegistry.addName(Soda,"Soda");
		
		Pizza = new ItemPizza(NH_IDs.PizzaID); //500 points
		LanguageRegistry.addName(Pizza,"Pizza");
		
		ComicBook = new ItemComicBook(NH_IDs.ComicBookID); //1000 points
		LanguageRegistry.addName(ComicBook,"Comic Book");
		
		TeddyBear = new ItemTeddyBear(NH_IDs.TeddyBearID); //5000 points
		LanguageRegistry.addName(TeddyBear,"Teddy Bear");
		
		//NOOB HAUS: Block Registration
		//Portal Block (Currently for testing only: should be replaced by a spaceship tile entity
		MarsPortal = new BlockMarsPortal(NH_IDs.MarsPortalID);
		GameRegistry.registerBlock(MarsPortal, modid+ (MarsPortal.getUnlocalizedName().substring(5)));
		
		//Terrain Block Base (Meta data Block)
		MarsDirt = new BlockMarsDirt(NH_IDs.MarsDirtID);
		GameRegistry.registerBlock(MarsDirt, ItemMarsDirt.class, modid + (MarsDirt.getUnlocalizedName().substring(5)));
		
		MarsStone = new BlockMarsStone(NH_IDs.MarsStoneID);
		GameRegistry.registerBlock(MarsStone, ItemMarsStone.class, modid + (MarsStone.getUnlocalizedName().substring(5)));
		//NOOB HAUS: Terrain Block Names
		LanguageRegistry.addName(new ItemStack(MarsDirt,1,0), "Mars Dirt");
		
		LanguageRegistry.addName(new ItemStack(MarsStone,1,0), "Mars Stone");
		LanguageRegistry.addName(new ItemStack(MarsStone,1,1), "Mars Cobblestone");
		LanguageRegistry.addName(new ItemStack(MarsStone,1,2), "Mars Gold");
		LanguageRegistry.addName(new ItemStack(MarsStone,1,3), "Mars Iron");
		LanguageRegistry.addName(new ItemStack(MarsStone,1,4), "Mars Coal");
		LanguageRegistry.addName(new ItemStack(MarsStone,1,5), "Mars Diamond");
		
		//Creative/Base Blocks (Meta Data Block)
		KeenBlock = new BlockKeenBlock(NH_IDs.KeenBlockID);
		GameRegistry.registerBlock(KeenBlock, ItemKeenBlock.class, modid+ (KeenBlock.getUnlocalizedName().substring(5)));
		KeenBlockTwo = new BlockKeenBlockTwo(NH_IDs.KeenBlockTwoID);
		GameRegistry.registerBlock(KeenBlockTwo, ItemKeenBlockTwo.class, modid+ (KeenBlockTwo.getUnlocalizedName().substring(5)));
		
		//NOOB HAUS:Creative Block Names
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,0), "Support");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,1), "Support Top");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,2), "Support Botton");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,3), "Red Metal");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,4), "Yellow Metal");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,5), "Blue Metal");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,6), "Green Metal");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,7), "Mars Temple Wall");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,8), "Black Metal");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,9), "White Metal");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,10),"Purple Plate");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,11),"Blue Plate");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,12),"Red Plate");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,13),"Green Plate");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,14),"Yellow Plate");
		LanguageRegistry.addName(new ItemStack(KeenBlock,1,15),"Purple Brick1"); //NEED TO MAKE A NEW BLOCK FOR THE NEXT BATCH
		LanguageRegistry.addName(new ItemStack(KeenBlockTwo,1,0),"Purple Brick2");
		LanguageRegistry.addName(new ItemStack(KeenBlockTwo,1,1),"Purple Brick3");
		LanguageRegistry.addName(new ItemStack(KeenBlockTwo,1,2),"Purple Brick4");
		
		//NOOB HAUS: Block Harvest Levels
		MinecraftForge.setBlockHarvestLevel(MarsDirt, 0, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(MarsStone, 0, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MarsStone, 1, "pickaxe", 1);
		
		//NOOB HAUS: Entity Registration
		EntityRegistry.registerModEntity(EntityVorticon.class, "Vorticon", 2, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("entity.NOOBHAUS_CommanderKeen.Vorticon.name", "Vorticon");
		
		EntityRegistry.registerModEntity(EntityVorticonCommander.class, "Vorticon Commander", 3, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("entity.NOOBHAUS_CommanderKeen.Vorticon Commander.name", "Vorticon Commander");
		
		//NOOB HAUS: Reg for Overworld Spawn IF Enabled in Config - PENDING
		EntityRegistry.addSpawn(EntityVorticon.class, 10, 2, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills });
		//V0.0.3 - Bugfix fix duplicate spawn reg
		//V0.0.3 - updated Spawn Settings for Commander to be rare
		EntityRegistry.addSpawn(EntityVorticonCommander.class, 3, 1, 2, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills });
		
		//NOOB HAUS: Spawn Eggs - Cuz why the heck not ?
		registerEntityEgg(EntityVorticon.class, 5845696, 2303701);
		registerEntityEgg(EntityVorticonCommander.class, 5845696, 2360401);
		
	}
	
	public static int getUniqueEntityId()
	{
		do 
		{
			startEntityId += 1;
		}
		while (EntityList.getStringFromID(startEntityId) != null);

	return startEntityId;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void registerEntityEgg(Class entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(Integer.valueOf(id), entity);
		EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, primaryColor, secondaryColor));
	}

}
