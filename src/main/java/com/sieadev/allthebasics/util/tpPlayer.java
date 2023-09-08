package com.sieadev.allthebasics.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class tpPlayer {
    public static void tpPlayer(Player p, String t, String t2){
        if (!p.hasPermission("atb.teleport")){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        Player target = getPlayerFromString.getPlayerFromString(p, t);
        if (target == null){
            return;
        }

        if (t2 == null){
            p.teleport(target);
            p.sendMessage(ChatColor.YELLOW + "You teleported yourself to §r" + target.getDisplayName());
            return;
        }

        Player target2 = getPlayerFromString.getPlayerFromString(p, t2);
        if (target2 == null){
            return;
        }

        target.teleport(target2);
        p.sendMessage(ChatColor.YELLOW + "You teleported §r" + target.getDisplayName() + ChatColor.YELLOW +" to §r" + target2.getDisplayName());
    }

    public static void tpAllPlayers(Player p) {
        if (!p.hasPermission("atb.teleportall")) {
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }
        int playercound = 0;

        for(Player p2 : Bukkit.getServer().getOnlinePlayers()){
            p2.teleport(p);
            p2.sendMessage("§eYou have been teleported to §r" + p.getDisplayName());
            playercound++;
        }
        p.sendMessage("§eYou teleported §r" +playercound + " §eplayers to your location!§r");
    }
}

