package com.sieadev.allthebasics.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatEvent implements Listener {
@EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String message = e.getMessage();
        if (p.hasPermission("atb.color")){
            message = ChatColor.translateAlternateColorCodes('&', message);
        }
        if (p.hasPermission("atb.highlight")){
            //will do this later
        }
            e.setMessage(message);
    }
}
