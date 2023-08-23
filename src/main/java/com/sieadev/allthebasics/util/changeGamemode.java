package com.sieadev.allthebasics.util;

import org.bukkit.entity.Player;

public class changeGamemode {
    public static void changeGamemode(Player p, String t){
        if (p.hasPermission("")){
            //fix this later
            return;
        }
        Player target = getPlayerFromString.getPlayerFromString(p, t);
        if (target == null){
            return;
        }
    }
}
