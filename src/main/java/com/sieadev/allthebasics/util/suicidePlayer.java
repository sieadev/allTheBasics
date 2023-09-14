package com.sieadev.allthebasics.util;

import com.sieadev.allthebasics.util.text.messageBuilder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class suicidePlayer {
    public static void  suicidePlayer(Player p){
    if (!p.hasPermission("atb.suicide")){
        p.sendMessage(messageBuilder.noPermission);
        return;
    }
    p.setHealth(0);
    p.sendMessage(ChatColor.YELLOW + "You killed yourself.");

}
}
