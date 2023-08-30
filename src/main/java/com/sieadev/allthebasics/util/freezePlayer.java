package com.sieadev.allthebasics.util;

public class freezePlayer {
	public static void freezePlayer(Player p, String t){
        if (!p.hasPermission("atb.freeze")){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }

        if (t == null){
            freeze(p);
            p.sendMessage(ChatColor.YELLOW + "You healed yourself for §c" + Math.round(missingHealth) + "§c❤");
            return;
        }

        Player target = getPlayerFromString.getPlayerFromString(p, t);

        if (target == null){
            return;
        }

        freeze(target);
        p.sendMessage(ChatColor.YELLOW + "You froze §r" + target.getDisplayName());
        target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " froze you");
    }

	public static void freeze(Player p){
         //Implement Freeze Method
    }
}
