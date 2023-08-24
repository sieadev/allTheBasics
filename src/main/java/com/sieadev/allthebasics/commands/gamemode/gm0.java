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
            sender.sendMessage("§cYou can't use this command in the console.");
            return true;
        }

      // Inserting of permission pending
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("gm")) {
            if (args.length > 0 && args[0].equalsIgnoreCase("ADVENTURE")) {
              if (player.hasPermission("-Insert permission here-")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage("§cYour gamemode has been updated to hardcore.");
                return true;
            }
              else{
                player.sendMessage("§cYou don't have the necessary permissions to perform this command.");
              }
              
            }
        }
        return false;
    }
}
