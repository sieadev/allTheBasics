package com.sieadev.allthebasics.util;

import com.sieadev.allthebasics.util.text.messageBuilder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class toggleFlying {
    public static void toggleFlying(Player p, String t){
        if (!p.hasPermission("atb.fly")){
            p.sendMessage(messageBuilder.noPermission);
            return;
        }

        if (t == null){
            if (!p.getAllowFlight()){
                p.setAllowFlight(true);
                p.sendMessage(ChatColor.YELLOW + "You enabled flying for yourself.");
                return;
            }
            p.setAllowFlight(false);
            p.sendMessage(ChatColor.YELLOW + "You disabled flying for yourself.");
            return;
        }

        Player target = getPlayerFromString.getPlayerFromString(p, t);

        if (target == null){
            return;
        }

        if (!target.getAllowFlight()){
            target.setAllowFlight(true);
            p.sendMessage(ChatColor.YELLOW + "You enabled flying for §r" + target.getDisplayName());
            target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " enabled flying for you.");
            return;
        }
        target.setAllowFlight(false);
        p.sendMessage(ChatColor.YELLOW + "You disabled flying for §r" + target.getDisplayName());
        target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " disabled flying for you.");
    }
}
