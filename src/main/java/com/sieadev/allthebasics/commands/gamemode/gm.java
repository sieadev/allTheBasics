package com.sieadev.allthebasics.commands.gamemode;

import com.sieadev.allthebasics.util.changeGamemode;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class gm implements CommandExecutor {

    private GameMode gm;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (!(sender instanceof Player)){
            sender.sendMessage("§cYou can not use this command in the Console.");
        }
        Player p = (Player) sender;
        if (args.length < 1){
            return false;
        }
        if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) this.gm = GameMode.SURVIVAL;
        if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) this.gm = GameMode.CREATIVE;
        if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) this.gm = GameMode.ADVENTURE;
        if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) this.gm = GameMode.SPECTATOR;

        if (args.length > 1){
            String target = args[0];
            changeGamemode.changeGamemode(p, target, gm);
            return true;
        }
        changeGamemode.changeGamemode(p, null, gm);
        return true;
    }
}
