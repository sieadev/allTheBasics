package com.sieadev.allthebasics.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class homeUtility {

    public static void setHome(Player p, Location location, Plugin plugin){
        if (!p.hasPermission("atb.home.set")){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }
        //Get Player uuid
        String uuid = p.getUniqueId().toString();
        ConfigUtil config = new ConfigUtil(plugin, "homes.yml");
        config.getConfig().set(uuid, location);
        config.save();
        String coordiantes = "" + location.getX() + location.getY() + location.getZ();
        p.sendMessage("&eYou set your home at §1" + coordiantes);
    }

    public static Location getHome(Player p,  Plugin plugin){
        String uuid = p.getUniqueId().toString();
        ConfigUtil config = new ConfigUtil(plugin, "homes.yml");
        Location location = config.getConfig().getLocation(uuid);
        return location;
    }

    public static void teleportHome(Player p , Plugin plugin){
        Location location = getHome(p, plugin);
        if (p.hasPermission("atb.home.teleport")){
            if (location == null){
                p.sendMessage("§cYou don't have a home location set! §e/sethome");
                return;
            }
            p.teleport(location);
            p.sendMessage("§" + "eYou teleported home.");
        }
        else{
            findHome(p, plugin);
        }
    }

    public static void findHome(Player p, Plugin plugin){
        Location location = getHome(p, plugin);
        if (p.hasPermission("atb.home.find")){
            if (location == null){
                p.sendMessage("§cYou don't have a home location set! §e/sethome");
                return;
            }
            String coordiantes = "§9x§e" + location.getX() + "§9y§e" + location.getY() + "§9z§e" + location.getZ();
            p.sendMessage("§eYour home is at " + coordiantes);
        }
        else{
            p.sendMessage("§cYou don't have the required permissions to use this command.");
        }
    }
}
