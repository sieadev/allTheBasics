package com.sieadev.allthebasics.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.PlayerInventory;

public class repairItem {

    public static void repairItem(Player p) {
        if (!p.hasPermission("atb.repairItem")) {
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        ItemStack i = p.getInventory().getItemInMainHand();
        ItemMeta l = i.getItemMeta();
        if (l == null){
            p.sendMessage("§cYou need to be holding an Item");
            return;}



        i.setDurability((short) 100);
    }
}

