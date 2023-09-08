package com.sieadev.allthebasics.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class suicidePlayer {
    public static void  suicidePlayer(Player p){
    if (!p.hasPermission("atb.suicide")){
        p.sendMessage("§cYou don't have the required permissions to use this command.");
        return;
    }
    p.setHealth(0);
    p.sendMessage(ChatColor.YELLOW + "You killed yourself.");

}
}
