package com.sieadev.allthebasics.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class feedPlayer {
    public static void feedPlayer(Player p, String t){
        if (!(p.hasPermission("rank.admin") || p.hasPermission("administration.feed"))){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        if (t == null){
            p.setFoodLevel(20);
            p.sendMessage(ChatColor.YELLOW + "You fed yourself.");
            return;
        }

        Player target = getPlayerFromString.getPlayerFromString(p, t);

        if (target == null){
            return;
        }

        target.setFoodLevel(20);
        p.sendMessage(ChatColor.YELLOW + "You fed " + p.getDisplayName());
        target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " fed you.");
    }
}
