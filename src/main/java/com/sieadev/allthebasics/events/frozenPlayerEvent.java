package com.sieadev.allthebasics.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;

public class frozenPlayerEvent implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        // Check if the player is frozen
        if (isFrozen(player)) {
            // Prevent movement or take other actions for frozen players
            event.setCancelled(true); // This cancels the movement for frozen players
            player.sendMessage(ChatColor.RED + "You are frozen and cannot move!");
        }
    }
    public static HashMap<Player, Boolean> frozenPlayers = new HashMap<>();

    public static void toggleFreeze(Player target, Player user) {
        if (frozenPlayers.containsKey(target)) {
            frozenPlayers.remove(target);
            if (!target.getName().equalsIgnoreCase(user.getName())){
                user.sendMessage("§eYou unfroze " + target.getDisplayName());
            }
            target.sendMessage("§eYou haven been unfrozen. You may now move!");
        } else {
            frozenPlayers.put(target, true);
            if (target.getName().equalsIgnoreCase(user.getName())){
                target.sendMessage(ChatColor.YELLOW + "You froze yourself.. Why?");
                return;
            }

            user.sendMessage(ChatColor.YELLOW + "You froze §r" + target.getDisplayName());
            target.sendMessage(user.getDisplayName() + ChatColor.YELLOW + " froze you");

        }
    }
    public static boolean isFrozen(Player p) {
        return frozenPlayers.getOrDefault(p, false);
    }
}
