package nl.kevinwilmsen.Commands;

import nl.kevinwilmsen.Utill.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Made by Kevin Wilmsen
 * https://www.kevinwilmsen.nl
 *
 * @: info@kevinwilmsen.nl
 */
public class Myinfo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {


    if(sender instanceof Player) {
        if (cmd.getName().equalsIgnoreCase("myinfo")) {
            Player p = (Player) sender;
            if (sender.hasPermission(Permissions.Lookup_own_stats)) {

                p.sendMessage(ChatColor.YELLOW + "-=-=-=-=-=-=-=-" + ChatColor.AQUA + " Player" + ChatColor.DARK_AQUA + "Info " + ChatColor.YELLOW + "-=-=-=-=-=-=-=-");
                p.sendMessage(ChatColor.GOLD + "Displayname: " + ChatColor.WHITE + p.getDisplayName());
                p.sendMessage(ChatColor.GOLD + "UUID: " + ChatColor.WHITE + p.getUniqueId());
                p.sendMessage(ChatColor.GOLD + "Health: " + ChatColor.WHITE + Math.round(p.getHealth()) + ChatColor.DARK_RED + ChatColor.BOLD + "/" + ChatColor.WHITE + p.getMaxHealth());
                p.sendMessage(ChatColor.GOLD + "Food: " + ChatColor.WHITE + p.getFoodLevel());
                p.sendMessage(ChatColor.GOLD + "Gamemode: " + ChatColor.WHITE + p.getGameMode());
                p.sendMessage(ChatColor.GOLD + "Flying: " + ChatColor.WHITE + p.isFlying());

                if (p.getInventory().getItemInMainHand().getAmount() >= 2) {
                    p.sendMessage(ChatColor.GOLD + "Current Item in Hand: " + ChatColor.WHITE + p.getInventory().getItemInMainHand().getAmount() +
                            ChatColor.DARK_RED + ChatColor.BOLD + " X " + ChatColor.WHITE + p.getInventory().getItemInMainHand().getType());
                } else {
                    p.sendMessage(ChatColor.GOLD + "Current Item in Hand: " + ChatColor.WHITE + p.getInventory().getItemInMainHand().getType());
                }
                p.sendMessage(ChatColor.YELLOW + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            } else {
                sender.sendMessage(Permissions.NoPermissionMSG);
            }
        }
    } else {
        sender.sendMessage(Permissions.ConsoleMSG);
    }


        return false;
    }
}
