package com.sieadev.allthebasics.util;

import com.sieadev.allthebasics.util.text.messageBuilder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.PlayerInventory;

public class repairItem {

    public static void repairItem(Player p) {
        if (!p.hasPermission("atb.repairItem")) {
            p.sendMessage(messageBuilder.noPermission);
            return;
        }

        ItemStack i = p.getInventory().getItemInMainHand();
        ItemMeta l = i.getItemMeta();
        if (l == null){
            p.sendMessage(messageBuilder.needItemInHand);
            return;}
        
        Damageable damageable = (Damageable) i.getItemMeta();
        int maxDurability = i.getType().getMaxDurability();
        assert damageable != null;
        int durability = maxDurability - damageable.getDamage() - 1;
        if (!(durability < maxDurability)){
            return;
        }


        i.setDurability((short)maxDurability);
    }
}

