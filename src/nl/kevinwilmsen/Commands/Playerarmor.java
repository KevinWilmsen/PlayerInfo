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
 *
 * @: info@kevinwilmsen.nl
 */
public class Playerarmor implements CommandExecutor {

    public static String prefix = ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "[" + ChatColor.AQUA + "PlayerInfo" + ChatColor.DARK_GRAY + ChatColor.BOLD.toString() +  "] " ;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

            if(cmd.getName().equalsIgnoreCase("playerarmor")){
                if(sender.hasPermission(Permissions.Lookup_other_armor)){

                    if (args.length < 1) {
                        sender.sendMessage(prefix + ChatColor.WHITE + "Use /playerarmor <player>");
                        return true;
                    }

                    final Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (target == null) {
                        sender.sendMessage(prefix + ChatColor.WHITE + "Could not find player " + ChatColor.RED + args[0] + ChatColor.WHITE + " maybe he is not online or maybe you make a typo.");
                        return true;
                    }

                    sender.sendMessage(ChatColor.YELLOW + "-=-=-=-=-=-=-=-" + ChatColor.AQUA + " Player" + ChatColor.DARK_AQUA + "Info " + ChatColor.YELLOW + "-=-=-=-=-=-=-=-");
                    sender.sendMessage(ChatColor.GOLD + "Name: " + ChatColor.WHITE + target.getDisplayName());

                    if(target.getInventory().getHelmet() != null){
                        sender.sendMessage(ChatColor.GOLD + "Helmet: " + ChatColor.WHITE + target.getInventory().getHelmet().getType());
                    } else {
                        sender.sendMessage(ChatColor.GOLD + "Helmet: " + ChatColor.WHITE + " No Helmet");
                    }

                    if(target.getInventory().getChestplate() != null){
                        sender.sendMessage(ChatColor.GOLD + "Chestplate: " + ChatColor.WHITE + target.getInventory().getChestplate().getType());
                    }else {
                        sender.sendMessage(ChatColor.GOLD + "Chestplate: " + ChatColor.WHITE + " No Chestplate");
                    }

                    if(target.getInventory().getLeggings() != null){
                        sender.sendMessage(ChatColor.GOLD + "Leggings: " + ChatColor.WHITE + target.getInventory().getLeggings().getType());
                    }else {
                        sender.sendMessage(ChatColor.GOLD + "Leggings: " + ChatColor.WHITE + " No Leggings");
                    }

                    if(target.getInventory().getBoots() != null){
                        sender.sendMessage(ChatColor.GOLD + "Boots: " + ChatColor.WHITE + target.getInventory().getBoots().getType());
                    } else {
                        sender.sendMessage(ChatColor.GOLD + "Boots: " + ChatColor.WHITE + " No Boots");
                    }

                    sender.sendMessage(" ");
                    sender.sendMessage(ChatColor.GOLD + "Health: " + ChatColor.WHITE + Math.round(target.getHealth()) + ChatColor.DARK_RED + ChatColor.BOLD + "/" + ChatColor.WHITE + target.getMaxHealth());
                    sender.sendMessage(ChatColor.YELLOW + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                } else{
                    sender.sendMessage(Permissions.NoPermissionMSG);
                }
            }
        return false;
    }
}
