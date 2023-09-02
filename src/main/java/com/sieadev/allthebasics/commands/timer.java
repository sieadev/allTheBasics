package com.sieadev.allthebasics.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class timer implements CommandExecutor {

    private boolean timerRunning = false;
    private long startTime = 0;
    private long endTime = 0;
    private long elapsedTime = 0;
    private int taskId = -1;

/*
Implements the /timer start/stop command
*/
    private final Plugin plugin;

    public timer(Plugin plugin) {
        this.plugin = plugin;
    }
@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("timer")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("start")) {
                        if (!timerRunning) {
                            startTime = System.currentTimeMillis();
                            timerRunning = true;
                            sender.sendMessage("§cTimer started.");
                            taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> updateActionBar(player), 0L, 20L);
                        } else {
                            sender.sendMessage("§cTimer is already running.");
                        }
                    } else if (args[0].equalsIgnoreCase("stop")) {
                        if (timerRunning) {
                          
                            endTime = System.currentTimeMillis();
                            elapsedTime = endTime - startTime;
                            sender.sendMessage("§cTimer stopped. Time: " + (elapsedTime / 1000) + " seconds");
                            timerRunning = false;

                          
                            if (taskId != -1) {
                                Bukkit.getScheduler().cancelTask(taskId);
                                taskId = -1;
                            }
                            player.sendTitle("", "");
                        } else {
                            sender.sendMessage("§cTimer is not running.");
                        }
                    } else {
                        sender.sendMessage("§cUse: /timer start/stop");
                    }
                } else {
                    sender.sendMessage("§cUse: /timer start/stop");
                }
            } else {
                sender.sendMessage("§cYou can't use this command in the console.");
            }
            return true;
        }
        return false;
    }

    private void updateActionBar(Player player) {
        if (timerRunning) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - startTime) / 1000;
            player.sendTitle("" , "§cTimer: " + elapsedTime + " §cseconds");
        }
    }
}
