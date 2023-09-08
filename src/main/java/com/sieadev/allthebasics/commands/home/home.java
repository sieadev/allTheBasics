package com.sieadev.allthebasics.commands.home;

import com.sieadev.allthebasics.util.homeUtility;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class home implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§cYou can not use this command in the Console.");
            return true;
        }
        Player p = (Player)sender;
        homeUtility.teleportHome(p);
        return false;
    }
}
