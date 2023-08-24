package com.sieadev.allthebasics.commands.gamemode;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;
import org.bukkit.plugin.java.JavaPlugin;


public class gm0 implements CommandExecutor {

  
/*
This function implements the /gm creative command
*/
@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

      
        Player player = (Player) sender;

        // Inserting of permission pending
        if (label.equalsIgnoreCase("gm") && args.length == 1 && args[0].equalsIgnoreCase("creative")) {
            if (player.hasPermission("-Insert permission here-")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("§cYour gamemode has been updated to creative.");
            } else {
                player.sendMessage("§cYou do not have permission to use this command.");
            }
            return true;
        }
        return false;
    }
}
