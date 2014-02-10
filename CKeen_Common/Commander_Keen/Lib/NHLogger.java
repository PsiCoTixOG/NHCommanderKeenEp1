package Commander_Keen.Lib;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class NHLogger 
{
private static Logger logger = Logger.getLogger("COMMANDER KEEN");

public static void init() {
logger.setParent(FMLLog.getLogger());
}

public static void log(Level logLevel, String message) {
logger.log(logLevel, message);
}
}