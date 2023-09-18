package com.sieadev.allthebasics.util;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ToggleMute {

    ArrayList MutedPlayers = new ArrayList();


    public void ToggleMute(Player player, Player target){

        if (player.hasPermission("atb.mute")){

            if (MutedPlayers.contains(target.getDisplayName())){
                player.sendMessage("§c§l"+ target.getDisplayName() + " §cis already muted ");
            }else {
                MutedPlayers.add(target.getDisplayName());
            }

        }else{
            player.sendMessage("§cYou have no perms to perform this command!");
        }



    }


}
