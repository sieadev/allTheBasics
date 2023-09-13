package com.sieadev.allthebasics.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.sieadev.allthebasics.util.chat.chatConverter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerChatEvent implements Listener {
@EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent e) {
        String message = chatConverter.all(e.getPlayer(), e.getMessage());
        e.setMessage(message);
    }
}
