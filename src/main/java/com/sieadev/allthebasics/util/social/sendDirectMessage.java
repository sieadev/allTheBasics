package com.sieadev.allthebasics.util.social;

import com.sieadev.allthebasics.util.chat.chatConverter;
import com.sieadev.allthebasics.util.getPlayerFromString;
import org.bukkit.entity.Player;

public class sendDirectMessage {
    public void sendDirectMessage(Player p, String t, String m){

        Player target = getPlayerFromString.getPlayerFromString(p, t);
        if (target == null)return;

        if (ignoreList.isIgnored(p,target)){
            p.sendMessage("This player added you to their ignore list.");
            return;
        }
        String message = chatConverter.all(p, m);
        target.sendMessage(message);

    }

}
