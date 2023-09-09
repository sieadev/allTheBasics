package com.sieadev.allthebasics.commands;

import com.sieadev.allthebasics.util.setitemnameUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Item;

public class setintemname implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§cYou can not use this command in the Console.");
        }
        Player p = (Player) sender;
        if (args.length<1) return false;

        String name = args[0];

        setitemnameUtil.setitemname(p, name);

        return true;

    }
}
