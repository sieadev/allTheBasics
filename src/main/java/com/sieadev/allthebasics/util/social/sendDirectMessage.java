package com.sieadev.allthebasics.util.social;

import com.sieadev.allthebasics.util.text.chatMessageBuilder;
import com.sieadev.allthebasics.util.getPlayerFromString;
import com.sieadev.allthebasics.util.text.messageBuilder;
import org.bukkit.entity.Player;

public class sendDirectMessage {
    public static void sendDirectMessage(Player p, String t, String m){
        if (!p.hasPermission("atb.directmessage")){
            p.sendMessage(messageBuilder.noPermission);
            return;
        }
        Player target = getPlayerFromString.getPlayerFromString(p, t);

        if (target == null)return;

        if (ignoreList.isIgnored(target,p)){
            p.sendMessage("This player added you to their ignore list.");
            return;
        }
        String message = chatMessageBuilder.all(p, m);
        target.sendMessage("§dFrom §7" + p.getDisplayName() + "§7 » " + message);
        p.sendMessage("§dTo §7" + target.getDisplayName() + "§7 » " + message);
    }

}
