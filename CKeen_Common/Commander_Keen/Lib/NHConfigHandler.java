package Commander_Keen.Lib;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class NHConfigHandler 
{

	public static void init(File configFile) 
	{
		Configuration config = new Configuration(configFile);
		
		config.load();
		NH_IDs.MarsDirtID =config.getBlock("Mars Dirt", NH_IDs.MarsDirtIDDefault).getInt();
		NH_IDs.MarsStoneID =config.getBlock("Mars Stone", NH_IDs.MarsStoneIDDefault).getInt();
		NH_IDs.KeenBlockID =config.getBlock("Keen Blocks", NH_IDs.KeenBlockIDDefault).getInt();
		NH_IDs.KeenBlockTwoID =config.getBlock("Keen Blocks Two", NH_IDs.KeenBlockTwoIDDefault).getInt();
		NH_IDs.MarsPortalID =config.getBlock("Portal Block", NH_IDs.MarsPortalIDDefault).getInt();
		
		//Blocks - EXAMPLE: DL_RPG_IDs.TanquiteOreBlockID = config.getBlock("Tanquite Ore", DL_RPG_IDs.TanquiteOreBlockIDDefault).getInt();

		//Items - EXAMPLE: 
		NH_IDs.KeyCardRedID = config.getItem("Red Key Card", NH_IDs.KeyCardRedIDDefault).getInt() - 256;
		NH_IDs.KeyCardYellowID = config.getItem("Yellow Key Card", NH_IDs.KeyCardYellowIDDefault).getInt() - 256;
		NH_IDs.KeyCardGreenID = config.getItem("Green Key Card", NH_IDs.KeyCardGreenIDDefault).getInt() - 256;
		NH_IDs.KeyCardBlueID = config.getItem("Blue Key Card", NH_IDs.KeyCardBlueIDDefault).getInt() - 256;
		
		NH_IDs.PogoStickID = config.getItem("Pogo Stick", NH_IDs.PogoStickIDDefault).getInt() - 256;
		NH_IDs.RayGunID = config.getItem("Ray Gun", NH_IDs.RayGunIDDefault).getInt() - 256;
		NH_IDs.RayID = config.getItem("Ray", NH_IDs.RayIDDefault).getInt() - 256;
		
		NH_IDs.JoystickID = config.getItem("Joystick", NH_IDs.JoystickIDDefault).getInt() - 256;
		NH_IDs.CarBatteryID = config.getItem("Car Battery", NH_IDs.CarBatteryIDDefault).getInt() - 256;
		NH_IDs.VacuumCleanerID = config.getItem("Vacuum Cleaner", NH_IDs.VacuumCleanerIDDefault).getInt() - 256;
		NH_IDs.EverclearID = config.getItem("Everclear", NH_IDs.EverclearIDDefault).getInt() - 256;
		
		NH_IDs.LollipopID = config.getItem("Lollipop", NH_IDs.LollipopIDDefault).getInt() - 256;
		NH_IDs.SodaID = config.getItem("Soda", NH_IDs.SodaIDDefault).getInt() - 256;
		NH_IDs.PizzaID = config.getItem("Pizza", NH_IDs.PizzaIDDefault).getInt() - 256;
		NH_IDs.ComicBookID = config.getItem("Comic Book", NH_IDs.ComicBookIDDefault).getInt() - 256;
		NH_IDs.TeddyBearID = config.getItem("Teddy Bear", NH_IDs.TeddyBearIDDefault).getInt() - 256;
		
		NH_Settings.Difficulty = config.get("Difficulty","Diiculty", NH_Settings.DifficultyDefault,"1 = Easy, 2 = Normal, 3 = Hard").getInt();
		//Other - EXAMPLE: DL_RPG_Settings.CombustionOreMaxHight = config.get("Ore Combustion", "Max Hight", DL_RPG_Settings.CombustionOreMaxHightDefault, "Min 0 - Max 256").getInt();
		
		config.save();
		
	}
}