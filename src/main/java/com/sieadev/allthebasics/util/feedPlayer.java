package com.sieadev.allthebasics.util;

import com.sieadev.allthebasics.util.text.messageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class feedPlayer {
    public static void feedPlayer(Player p, String t){
        if (!p.hasPermission("atb.feed")){
            p.sendMessage(messageBuilder.noPermission);
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
        p.sendMessage(ChatColor.YELLOW + "You fed §r" + target.getDisplayName());
        target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " fed you.");
    }
}
