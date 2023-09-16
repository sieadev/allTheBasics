package com.sieadev.allthebasics.util;

import com.sieadev.allthebasics.util.text.messageBuilder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
public class flyspeedPlayer {
    public static void  flyspeedPlayer(Player p, String t){
    if (!p.hasPermission("atb.flyspeed")){
        p.sendMessage(messageBuilder.noPermission);
        return;
    }

    if (t == null){
        p.setFlySpeed(1);
        p.sendMessage(ChatColor.YELLOW + "You set your flyspeed.");
        return;
    }

    Player target = getPlayerFromString.getPlayerFromString(p, t);

    if (target == null){
        return;
    }

    target.setFireTicks(100);
    p.sendMessage(ChatColor.YELLOW + "You set §r" + target.getDisplayName() + ChatColor.YELLOW + "'s flyspeed");
    target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " set your flyspeed.");
}
}
