package com.sieadev.allthebasics.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class kickPlayer {
    public static void  kickAllPlayers(Player p){
        if (!p.hasPermission("atb.kickall")){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        for(Player p2 : Bukkit.getServer().getOnlinePlayers()){
            p2.kickPlayer("§cYou have been kicked!");
        }
    }

    public static void kickPlayer(Player p, String t){
        if (!(p.hasPermission("atb.kickplayer") || p.hasPermission("atb.kickall"))){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        if (t == null){
            p.kickPlayer("You kicked yourself");
            return;
        }

        Player target = getPlayerFromString.getPlayerFromString(p, t);

        if (target == null){
            return;
        }

        target.kickPlayer("§cYou have been kicked!");
        p.sendMessage(ChatColor.YELLOW + "You kicked §r" + target.getDisplayName());
    }

}
