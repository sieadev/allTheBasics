package com.sieadev.allthebasics.commands;

import com.sieadev.allthebasics.util.toggleFlying;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§cYou can not use this command in the Console.");
        }
        Player p = (Player) sender;
        if (args.length > 0){
            String target = args[0];
            toggleFlying.toggleFlying(p, target);
            return true;
        }
        toggleFlying.toggleFlying(p, null);
        return true;
    }
}
