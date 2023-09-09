package com.sieadev.allthebasics.util;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class setitemnameUtil {
    public static void setitemname(Player p, String name) {
        if (!p.hasPermission("atb.setitemname")) {
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        ItemStack i = p.getInventory().getItemInMainHand();
        ItemMeta l = i.getItemMeta();
        l.setDisplayName(name);
        i.setItemMeta(l);
    }
}
