package com.sieadev.allthebasics.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerChatEvent implements Listener {

    private final boolean highlightNames;
    private final boolean emoji;
    private final boolean highlightNumbers;
    private final boolean math;
    private final boolean colorCodes;

    public PlayerChatEvent(boolean colorCodes, boolean math, boolean highlightNumbers, boolean emoji, boolean highlightNames){
        this.colorCodes = colorCodes;
        this.math = math;
        this.highlightNumbers = highlightNumbers;
        this.emoji = emoji;
        this.highlightNames = highlightNames;
    }
@EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String message = e.getMessage();
        if (p.hasPermission("atb.chat.color") || colorCodes){
            message = ChatColor.translateAlternateColorCodes('&', message);
        }
        if (p.hasPermission("atb.chat.math") || math){
            message = calculateMathInString(message);
        }
        if (p.hasPermission("atb.chat.highlightNumbers") || highlightNumbers) {
            String color = "§5";
            message = message.replaceAll("(\\d+)", color + "$1" + "§r");
        }
        if (p.hasPermission("atb.chat.emoji") || emoji) {
            //will do this later
        }
        if (highlightNames){
            //e.setCancelled(true);
            //send chat message to players individually
            //return;
        }
        e.setMessage(message);
    }

    public static String calculateMathInString(String input) {
        //Math here
        return input;
    }
}
