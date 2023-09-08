package com.sieadev.allthebasics.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class burnPlayer {
    public static void  burnPlayer(Player p, String t){
        if (!p.hasPermission("atb.burn")){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        if (t == null){
            p.setFireTicks(40);
            p.sendMessage(ChatColor.YELLOW + "You lit yourself on fire.");
            return;
        }

        Player target = getPlayerFromString.getPlayerFromString(p, t);

        if (target == null){
            return;
        }

        target.setFireTicks(40);
        p.sendMessage(ChatColor.YELLOW + "You lit " + target.getDisplayName() + ChatColor.YELLOW + " on fire");
        target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " lit you on fire.");
    }

}