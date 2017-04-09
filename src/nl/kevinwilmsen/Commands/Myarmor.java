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
public class Myarmor implements CommandExecutor {

    public static String prefix = ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "[" + ChatColor.AQUA + "PlayerInfo" + ChatColor.DARK_GRAY + ChatColor.BOLD.toString() +  "] " ;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {


if(sender instanceof Player) {
    if (cmd.getName().equalsIgnoreCase("myarmor")) {
        Player p = (Player) sender;
        if (sender.hasPermission(Permissions.Lookup_own_armor)) {

            p.sendMessage(ChatColor.YELLOW + "-=-=-=-=-=-=-=-" + ChatColor.AQUA + " Player" + ChatColor.DARK_AQUA + "Info " + ChatColor.YELLOW + "-=-=-=-=-=-=-=-");
            p.sendMessage(ChatColor.GOLD + "Name: " + ChatColor.WHITE + p.getDisplayName());

            if (p.getInventory().getHelmet() != null) {
                p.sendMessage(ChatColor.GOLD + "Helmet: " + ChatColor.WHITE + p.getInventory().getHelmet().getType());
            } else {
                p.sendMessage(ChatColor.GOLD + "Helmet: " + ChatColor.WHITE + " No Helmet");
            }

            if (p.getInventory().getChestplate() != null) {
                p.sendMessage(ChatColor.GOLD + "Chestplate: " + ChatColor.WHITE + p.getInventory().getChestplate().getType());
            } else {
                p.sendMessage(ChatColor.GOLD + "Chestplate: " + ChatColor.WHITE + " No Chestplate");
            }

            if (p.getInventory().getLeggings() != null) {
                p.sendMessage(ChatColor.GOLD + "Leggings: " + ChatColor.WHITE + p.getInventory().getLeggings().getType());
            } else {
                p.sendMessage(ChatColor.GOLD + "Leggings: " + ChatColor.WHITE + " No Leggings");
            }

            if (p.getInventory().getBoots() != null) {
                p.sendMessage(ChatColor.GOLD + "Boots: " + ChatColor.WHITE + p.getInventory().getBoots().getType());
            } else {
                p.sendMessage(ChatColor.GOLD + "Boots: " + ChatColor.WHITE + " No Boots");
            }

            p.sendMessage(" ");
            p.sendMessage(ChatColor.GOLD + "Health: " + ChatColor.WHITE + Math.round(p.getHealth()) + ChatColor.DARK_RED + ChatColor.BOLD + "/" + ChatColor.WHITE + p.getMaxHealth());
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

