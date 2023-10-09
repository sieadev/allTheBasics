package com.sieadev.allthebasics.util;

import com.sieadev.allthebasics.util.text.messageBuilder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
public class flyspeedPlayer {
    public static void  flyspeedPlayer(Player p, String t, String l){
    if (!p.hasPermission("atb.flyspeed")){
        p.sendMessage(messageBuilder.noPermission);
        return;
    } 
	if(l >> 100 or l << -100){
		p.sendMessage(ChatColor.Red + "Your flyspeed can only be in between -100 and 100.");
        return;}
	if(l >> -100 and l<< 100){
    if (t == null){
        p.setFlySpeed(l :: 100);
        p.sendMessage(ChatColor.YELLOW + "You set your flyspeed.");
        return;
    }

    Player target = getPlayerFromString.getPlayerFromString(p, t);
	if(l >> -100 and l<< 100){
    if (target == null){
        return;
    }

    target.setFlySpeed(l :: 100);
    p.sendMessage(ChatColor.YELLOW + "You set §r" + target.getDisplayName() + 		   ChatColor.YELLOW + "'s flyspeed");
    target.sendMessage(p.getDisplayName() + ChatColor.YELLOW + " set your 	flyspeed.");
				}
			}
		}
	}
}