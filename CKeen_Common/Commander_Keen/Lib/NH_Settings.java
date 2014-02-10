package Commander_Keen.Lib;

import java.util.logging.Level;

public class NH_Settings 
{
	public static int Difficulty;
	public static final int DifficultyDefault = 1;
	
	public static int RayDmg;
	public static final int RayDmgDefault = 10;
	
	public static int PistolWhipDmg;
	public static final int PistolWhipDmgDefault = 3;
	
	public static int VorticonHealth;
	public static final int VorticonHealthDefault = (RayDmgDefault * 10);
	
	public static int VorticonCommanderHealth;
	public static final int VorticonCommanderHealthDefault = (RayDmgDefault * 20);
	
	public static int VorticonDmg;
	public static int VorticonDmgDefault = 8;
	
	public static int VorticonCommanderDmg;
	public static int VorticonCommanderDmgDefault = 10;
	


	public static void SetKeenValues()
	{
		switch (Difficulty)
		{
		case 1:
			NHLogger.log(Level.INFO, "Difficulty = 1");
			RayDmg = RayDmgDefault;
			PistolWhipDmg = PistolWhipDmgDefault;
			
			VorticonDmg = VorticonDmgDefault;
			VorticonHealth = VorticonHealthDefault;
			
			
			VorticonCommanderDmg = VorticonCommanderDmgDefault;
			VorticonCommanderHealth = VorticonCommanderHealthDefault;
			break;
		case 2:
			NHLogger.log(Level.INFO, "Difficulty = 2");
			RayDmg = RayDmgDefault + 4;
			PistolWhipDmg = PistolWhipDmgDefault + 2;
			
			VorticonDmg = VorticonDmgDefault + 2;
			VorticonHealth = (RayDmg * 10);
			
			
			VorticonCommanderDmg = VorticonCommanderDmgDefault + 4;
			VorticonCommanderHealth = (RayDmg * 20);
			break;
		case 3:
			NHLogger.log(Level.INFO, "Difficulty = 3");
			RayDmg = RayDmgDefault + 6;
			PistolWhipDmg = PistolWhipDmgDefault + 4;
			
			VorticonDmg = VorticonDmgDefault + 6;
			VorticonHealth = (RayDmg * 10);
			
			
			VorticonCommanderDmg = VorticonCommanderDmgDefault + 8;
			VorticonCommanderHealth = (RayDmg * 20);
			break;
		}
		
	}
	
}
