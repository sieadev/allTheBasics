package com.sieadev.allthebasics.util;

import com.sieadev.allthebasics.util.text.messageBuilder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class setitemnameUtil {
    public static void setitemname(Player p, String name) {
        if (!p.hasPermission("atb.setitemname")) {
            p.sendMessage(messageBuilder.noPermission);
            return;
        }


        ItemStack i = p.getInventory().getItemInMainHand();
        ItemMeta l = i.getItemMeta();
        if (l == null){
            p.sendMessage("§cYou need to be holding an Item");
            return;}

        name = ChatColor.translateAlternateColorCodes('&', name);
        l.setDisplayName(name);
        i.setItemMeta(l);
    }
}
