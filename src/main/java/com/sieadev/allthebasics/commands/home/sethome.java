package com.sieadev.allthebasics.commands.home;

import com.sieadev.allthebasics.util.homeUtility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class sethome implements CommandExecutor {
    private final Plugin plugin;

    public sethome(Plugin plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§cYou can not use this command in the Console.");
            return true;
        }
        Player p = (Player)sender;
        homeUtility.setHome(p, p.getLocation(), plugin);
        return false;
    }
}
