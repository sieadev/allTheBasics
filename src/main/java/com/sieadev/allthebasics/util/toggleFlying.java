package com.sieadev.allthebasics.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class toggleFlying {
    public static void toggleFlying(Player p, String t){
        if (!p.hasPermission("atb.fly")){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        if (t == null){
            if (!p.hasPermission("atb.flying")){
                p.setFlying(true);
                p.sendMessage(ChatColor.YELLOW + "You enabled flying for yourself.");
                return;
            }
            p.setFlying(false);
            p.sendMessage(ChatColor.YELLOW + "You disabled flying for yourself.");
            return;
        }

        Player target = getPlayerFromString.getPlayerFromString(p, t);

        if (target == null){
            return;
        }

        if (!target.hasPermission("atb.flying")){
            target.setFlying(true);
            p.sendMessage(ChatColor.YELLOW + "You enabled flying for §r" + target.getDisplayName());
            target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " enabled flying for you you.");
            return;
        }
        target.setFlying(false);
        p.sendMessage(ChatColor.YELLOW + "You disabled flying for §r" + target.getDisplayName());
        target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " disabled flying for you you.");
    }
}
