package com.sieadev.allthebasics.commands;

import com.sieadev.allthebasics.util.getPlayerFromString;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fakeop implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            if (args.length != 1){
                return false;
            }else{
                Player p = (Player) sender;
                Player target = getPlayerFromString.getPlayerFromString(p, args[0]);

                if (target == null){
                    return true;
                }else{
                    target.sendMessage("§7§o[" + p.getDisplayName() + ": Made " + target.getDisplayName() + " a server operator]");
                    p.sendMessage("§eMade " + target.getDisplayName() + " a §e§lFake §eserver operator");
                }

            }

        }

        return true;
    }
}
