package com.sieadev.allthebasics.commands;

import com.sieadev.allthebasics.util.changeGamemode;
import com.sieadev.allthebasics.util.getPlayerFromString;
import org.bukkit.GameMode;
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
            p.sendMessage(target.getDisplayName() + "&ehas a total Playtime of " + playtime);
            return true;
        }
        else{
            int playtimeint = p.getStatistic(Statistic.PLAY_ONE_MINUTE);
            String playtime = playtimeConverter(playtimeint);
            p.sendMessage("&eYou have a total Playtime of " + playtime);
            return true;
        }
    }


    private String playtimeConverter(int playtime){
        int playtimeresult = playtime;
        int exp = 0;
        if (playtime > 60) {
            //Convert to hours
            playtimeresult = playtimeresult / 60;
            exp++;
        }
        if (playtimeresult > 24) {
            //Convert to hours
            playtimeresult = playtimeresult / 24;
            exp++;
        }

        if (exp == 2) return "§a" + playtimeresult + " §1days";
        if (exp == 1) return "§a" + playtimeresult + " §9hours";
        return "§a" + playtimeresult + " §3minutes";
    }
}
