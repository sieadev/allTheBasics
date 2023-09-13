package com.sieadev.allthebasics.util;

import com.sieadev.allthebasics.util.text.messageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class kickPlayer {
    public static void  kickAllPlayers(Player p){
        if (!p.hasPermission("atb.kickall")){
            p.sendMessage(messageBuilder.noPermission);
            return;
        }

        for(Player p2 : Bukkit.getServer().getOnlinePlayers()){
            p2.kickPlayer("§cYou have been kicked!");
        }
    }

    public static void kickPlayer(Player p, String t){
        if (!(p.hasPermission("atb.kickplayer") || p.hasPermission("atb.kickall"))){
            p.sendMessage(messageBuilder.noPermission);
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
