package com.sieadev.allthebasics.commands;

import com.sieadev.allthebasics.util.tpPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§cYou can not use this command in the Console.");
        }
        if (args.length < 1 || args.length > 2){
            return false;
        }
        if (args.length == 2){
            tpPlayer.tpPlayer((Player) sender, args[0], args[1]);
            return true;
        }
        tpPlayer.tpPlayer((Player) sender, args[0], null);
        return true;
    }
}
