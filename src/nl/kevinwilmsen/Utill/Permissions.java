package nl.kevinwilmsen.Utill;

import org.bukkit.ChatColor;

/**
 * Made by Kevin Wilmsen
 * https://www.kevinwilmsen.nl
 *
 * @: info@kevinwilmsen.nl
 */
public class Permissions {

    public static String prefix = ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "[" + ChatColor.AQUA + "PlayerInfo" + ChatColor.DARK_GRAY + ChatColor.BOLD.toString() +  "] " ;

    public static String Lookup_own_stats = "playerinfo.view.own";

    public static String Lookup_other_stats = "playerinfo.view.other";

    public static String Lookup_own_armor = "playerinfo.armor.own";

    public static String Lookup_other_armor = "playerinfo.armor.other";

    public static String NoPermissionMSG = prefix + ChatColor.RED + "You dont have the permission to do this.";

    public static String ConsoleMSG = prefix + ChatColor.RED + "You can use this command only ingame.";

}
