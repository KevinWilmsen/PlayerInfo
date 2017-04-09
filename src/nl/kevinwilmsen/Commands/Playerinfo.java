package nl.kevinwilmsen.Commands;

import nl.kevinwilmsen.Utill.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Made by Kevin Wilmsen
 * https://www.kevinwilmsen.nl
 * @: info@kevinwilmsen.nl
 */
public class Playerinfo implements CommandExecutor {

    public static String prefix = ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "[" + ChatColor.AQUA + "PlayerInfo" + ChatColor.DARK_GRAY + ChatColor.BOLD.toString() +  "] " ;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {


        if(cmd.getName().equalsIgnoreCase("PlayerInfo")){
            if(sender.hasPermission(Permissions.Lookup_other_stats)) {

                if (args.length < 1) {
                    sender.sendMessage(prefix + ChatColor.WHITE + "Use /playerinfo <player>");
                    return true;
                }

                final Player target = Bukkit.getServer().getPlayer(args[0]);

                if (target == null) {
                    sender.sendMessage(prefix + ChatColor.WHITE + "Could not find player " + ChatColor.RED + args[0] + ChatColor.WHITE + " maybe he is not online or maybe you make a typo.");
                    return true;
                }

                sender.sendMessage(ChatColor.YELLOW + "-=-=-=-=-=-=-=-" + ChatColor.AQUA + " Player" + ChatColor.DARK_AQUA + "Info " + ChatColor.YELLOW + "-=-=-=-=-=-=-=-");
                sender.sendMessage(ChatColor.GOLD + "Displayname: " + ChatColor.WHITE + target.getDisplayName());
                sender.sendMessage(ChatColor.GOLD + "UUID: " + ChatColor.WHITE + target.getUniqueId());
                sender.sendMessage(ChatColor.GOLD + "Health: " + ChatColor.WHITE + Math.round(target.getHealth()) + ChatColor.DARK_RED + ChatColor.BOLD + "/" + ChatColor.WHITE + target.getMaxHealth());
                sender.sendMessage(ChatColor.GOLD + "Food: " + ChatColor.WHITE + target.getFoodLevel());
                sender.sendMessage(ChatColor.GOLD + "Gamemode: " + ChatColor.WHITE + target.getGameMode());
                sender.sendMessage(ChatColor.GOLD + "Flying: " + ChatColor.WHITE + target.isFlying());

                if (target.getInventory().getItemInMainHand().getAmount() >= 2) {
                    sender.sendMessage(ChatColor.GOLD + "Current Item in Hand: " + ChatColor.WHITE + target.getInventory().getItemInMainHand().getAmount() +
                            ChatColor.DARK_RED + ChatColor.BOLD + " X " + ChatColor.WHITE + target.getInventory().getItemInMainHand().getType());
                } else {
                    sender.sendMessage(ChatColor.GOLD + "Current Item in Hand: " + ChatColor.WHITE + target.getInventory().getItemInMainHand().getType());
                }
                sender.sendMessage(ChatColor.YELLOW + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            }
            else
            {
                sender.sendMessage(Permissions.NoPermissionMSG);
            }



        }


        return false;
    }
}
