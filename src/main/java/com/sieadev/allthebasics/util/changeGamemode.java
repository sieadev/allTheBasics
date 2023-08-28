package com.sieadev.allthebasics.util;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class changeGamemode {
    public static void changeGamemode(Player p, String t, GameMode gm){
        if (!p.hasPermission("atb.gamemode." + gm.name())){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        if (t == null){
            p.setGameMode(gm);
            p.sendMessage(ChatColor.YELLOW + "You switched to Gamemode " + ChatColor.GOLD + ChatColor.BOLD + gm.name().toUpperCase());
            return;
        }


        Player target = getPlayerFromString.getPlayerFromString(p, t);
        if (target == null){
            return;
        }

        target.setGameMode(gm);
        p.sendMessage(ChatColor.YELLOW + "You set §r" + p.getDisplayName() + ChatColor.YELLOW + "'s Gamemode to &6" + ChatColor.BOLD + gm.name().toUpperCase());
        target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " set your Gamemote to &6" + ChatColor.BOLD + gm.name().toUpperCase());
    }
}
