package com.sieadev.allthebasics.util.social;

import com.sieadev.allthebasics.util.text.chatMessageBuilder;
import com.sieadev.allthebasics.util.getPlayerFromString;
import org.bukkit.entity.Player;

public class sendDirectMessage {
    public static void sendDirectMessage(Player p, String t, String m){
        if (!p.hasPermission("atb.directmessage")){
            p.sendMessage("§cYou don't have the required permissions to use this command.");
            return;
        }
        Player target = getPlayerFromString.getPlayerFromString(p, t);
        if (target == null)return;

        if (ignoreList.isIgnored(p,target)){
            p.sendMessage("This player added you to their ignore list.");
            return;
        }
        String message = chatMessageBuilder.all(p, m);
        target.sendMessage(message);

    }

}
