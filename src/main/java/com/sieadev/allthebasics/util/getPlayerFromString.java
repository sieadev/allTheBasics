package com.sieadev.allthebasics.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getServer;

public class getPlayerFromString {
    public Player getPlayerFromString(Player p, String target){
        try {
            Player t = getServer().getPlayerExact(target);
            return t;
        } catch (NullPointerException e){
            OfflinePlayer offlinet = getOfflinePlayer(target);
            if (offlinet == null){
                p.sendMessage(ChatColor.RED + "This Player does not exist.");
            }
            p.sendMessage(ChatColor.RED + "This Player is offline.");
            return null;
        }

    }
    public Player getPlayerFromStringNoPlayer(String target){
        try {
            Player t = getServer().getPlayerExact(target);
            return t;
        } catch (NullPointerException e){
            OfflinePlayer offlinet = getOfflinePlayer(target);
            if (offlinet == null){
                return null;
            }
            return null;
        }

    }
    public static OfflinePlayer getOfflinePlayer(String name) {
        for(OfflinePlayer player : Bukkit.getOfflinePlayers()) {
            if(player.getName().equals(name)) return player;
        }
        return null;
    }
}
