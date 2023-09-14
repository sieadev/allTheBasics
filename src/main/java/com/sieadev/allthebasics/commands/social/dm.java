package com.sieadev.allthebasics.commands.social;

import com.sieadev.allthebasics.util.homeUtility;
import com.sieadev.allthebasics.util.social.sendDirectMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class dm implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§cYou can not use this command in the Console.");
            return true;
        }
        if (args.length < 2) {
            return false;
        }
        Player p = (Player)sender;

        //Credits to ChatGPT cause I was lazy as fk

        // Concatenate all arguments after args[0] into a single string
        StringBuilder messageBuilder = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            messageBuilder.append(args[i]).append(" ");
        }
        String message = messageBuilder.toString().trim();
        p.sendMessage(message);
        sendDirectMessage.sendDirectMessage(p, args[0], message);
        return true;
    }
}
