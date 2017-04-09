package nl.kevinwilmsen;

import java.util.logging.Logger;

import nl.kevinwilmsen.Commands.Myarmor;
import nl.kevinwilmsen.Commands.Myinfo;
import nl.kevinwilmsen.Commands.Playerarmor;
import nl.kevinwilmsen.Commands.Playerinfo;
import nl.kevinwilmsen.Utill.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Made by Kevin Wilmsen
 * https://www.kevinwilmsen.nl
 * @: info@kevinwilmsen.nl
 */
public class Main extends JavaPlugin {

    public final Logger l = Logger.getLogger("Minecraft");

@Override
    public void onEnable(){
    l.info("-----------------------------------------------------");
    l.info("PlayerInfo is now Running");
    l.info("");
    l.info("Version: " + getDescription().getVersion());
    l.info("Author: " + getDescription().getAuthors());
    l.info("Website: " + getDescription().getWebsite());
    l.info("-----------------------------------------------------");
    Commands();
    Metrics metrics = new Metrics(this);
}
@Override
    public void onDisable(){
    l.info("-----------------------------------------------------");
    l.info("PlayerInfo is Shutdown");
    l.info("-----------------------------------------------------");
}

private void Commands(){
    getCommand("Playerinfo").setExecutor(new Playerinfo());
    getCommand("myinfo").setExecutor(new Myinfo());
    getCommand("myarmor").setExecutor(new Myarmor());
    getCommand("playerarmor").setExecutor(new Playerarmor());
}

}
