package com.sieadev.allthebasics.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class healPlayer {
    public static void heal(Player p, String t){
        if (!(p.hasPermission("atb.healPlayer"))){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        if (t == null){
            double missingHealth = p.getMaxHealth() - p.getHealth();
            if (missingHealth == 0){
                p.sendMessage(ChatColor.YELLOW + "You are already at maximum health: " + "§c" + p.getHealth() + "§c❤");
                return;
            }
            p.sendMessage(ChatColor.YELLOW + "You healed yourself for §c" + Math.round(missingHealth) + "§c❤");
            return;
        }

        Player target = getPlayerFromString.getPlayerFromString(p, t);

        if (target == null){
            return;
        }

        double missingHealth = (target.getMaxHealth() - target.getHealth());

        if (missingHealth == 0){
            p.sendMessage(ChatColor.YELLOW + "This Player is already at maximum health: " + "§c" + p.getHealth() + "§c❤");
            return;
        }

        target.setHealth(target.getMaxHealth());
        p.sendMessage(ChatColor.YELLOW + "You healed §r" + target.getDisplayName() + ChatColor.YELLOW + " for §c" + Math.round(missingHealth) + "§c❤");
        target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " healed you for §c" + Math.round(missingHealth) + "§c❤");
    }
}
