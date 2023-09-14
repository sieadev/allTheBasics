package com.sieadev.allthebasics.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class blindPlayer {

    public static void blindPlayer(Player p, String t) {
        if (!p.hasPermission("atb.blind")) {
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        if (t == null) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 1));
            p.sendMessage(ChatColor.YELLOW + "You blinded yourself.");
            return;
        }

        Player target = getPlayerFromString.getPlayerFromString(p, t);

        if (target == null) {
            return;
        }

        target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 0, false,
                false));
        p.sendMessage(ChatColor.YELLOW + "You blinded §r" + target.getDisplayName());
        target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " blinded you.");
    }
}