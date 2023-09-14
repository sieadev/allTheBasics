package com.sieadev.allthebasics.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.sieadev.allthebasics.util.text.chatMessageBuilder;

public class PlayerChatEvent implements Listener {
@EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent e) {
        String message = chatMessageBuilder.all(e.getPlayer(), e.getMessage());
        e.setMessage(message);
    }
}
