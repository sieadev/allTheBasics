package com.sieadev.allthebasics.util;

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
}
