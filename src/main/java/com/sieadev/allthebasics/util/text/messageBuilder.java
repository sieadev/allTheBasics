package com.sieadev.allthebasics.util.text;

import com.sieadev.allthebasics.AllTheBasics;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class messageBuilder {
    public static String noPermission = "§cYou don't have the required permissions to use this command.";
    public static String playerOffline = ChatColor.RED + "This Player is offline.";
    public static String playerIsNull = ChatColor.RED + "This Player does not exist.";
    public static String needItemInHand = "§cYou need to be holding an Item";
    public static void loadMessagesFromLanguageFile(Plugin p){

    }
}
