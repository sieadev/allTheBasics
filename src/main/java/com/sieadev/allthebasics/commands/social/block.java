package com.sieadev.allthebasics.commands.social;

import com.sieadev.allthebasics.util.social.ignoreList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class block implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§cYou can not use this command in the Console.");
            return true;
        }
        if (args.length < 1) {
            return false;
        }

        Player p = (Player)sender;
        ignoreList.addIgnored(p, args[0]);
        return true;
    }
}
