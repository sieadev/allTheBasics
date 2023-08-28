package com.sieadev.allthebasics.commands.gamemode;

import com.sieadev.allthebasics.util.changeGamemode;
import com.sieadev.allthebasics.util.feedPlayer;
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
        Player player = (Player) sender;

        if (!(sender instanceof Player)){
            sender.sendMessage("§cYou can not use this command in the Console.");
        }
        Player p = (Player) sender;
        if (args.length > 0){
            String target = args[0];
            changeGamemode.changeGamemode(p, target, GameMode.SURVIVAL);
            return true;
        }
        changeGamemode.changeGamemode(p, null, GameMode.SURVIVAL);
        return true;
    }
}
