package com.sieadev.allthebasics.commands;

import com.sieadev.allthebasics.util.freezePlayer;
import com.sieadev.allthebasics.util.toggleFlying;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class freeze implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§cYou can not use this command in the Console.");
        }
        Player p = (Player) sender;
        if (args.length > 0){
            freezePlayer.freezePlayer(p, args[0]);
            return true;
        }
        return false;
    }
}
