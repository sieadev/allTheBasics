package com.sieadev.allthebasics.commands;

import com.sieadev.allthebasics.util.getPlayerFromString;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class playtime implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cYou can not use this command in the Console.");
            return true;
        }

        Player p = (Player) sender;
        if (!p.hasPermission("atb.playtime")) {
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return true;
        }
        if (args.length > 0){
            String t = args[0];
            Player target = getPlayerFromString.getPlayerFromString(p, t);

            if (target == null){
                return true;
            }
            int playtimeint = target.getStatistic(Statistic.PLAY_ONE_MINUTE);
            String playtime = playtimeConverter(playtimeint);
            p.sendMessage(target.getDisplayName() + "§e has a total Playtime of " + playtime);
            return true;
        }
        else{
            int playtimeint = p.getStatistic(Statistic.PLAY_ONE_MINUTE);
            String playtime = playtimeConverter(playtimeint);
            p.sendMessage("§eYou have a total Playtime of " + playtime);
            return true;
        }
    }


    private String playtimeConverter(int playtime){
        playtime = playtime / 1000;
        if (playtime >= 1440) {
            int days = playtime / 1440;
            return "§a" + days + " §1days";
        } else if (playtime >= 60) {
            int hours = playtime / 60;
            return "§a" + hours + " §9hours";
        } else {
            return "§a" + playtime + " §3minutes";
        }
    }
}
