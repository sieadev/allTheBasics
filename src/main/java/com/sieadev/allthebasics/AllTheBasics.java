package com.sieadev.allthebasics;

import com.sieadev.allthebasics.commands.*;
import com.sieadev.allthebasics.commands.gamemode.*;
import com.sieadev.allthebasics.commands.home.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import com.sieadev.allthebasics.events.*;
import com.sieadev.allthebasics.listeners.*;

public final class AllTheBasics extends JavaPlugin {


    private int errors;

    @Override
    public void onEnable() {
        this.errors = 0;

        sendConsoleMessage("Attempting to start ATB...");

        try {

        } catch (Exception e) {
            // Handle the exception here
            sendConsoleMessage("An error occurred when loading the Config: " + e.getMessage());
            this.errors = errors + 1;
        }

        try {
            getCommand("tp").setExecutor(new tp());
            getCommand("heal").setExecutor(new heal());
            getCommand("feed").setExecutor(new feed());
            getCommand("fakeop").setExecutor(new fakeop());
            getCommand("fly").setExecutor(new fly());
            getCommand("freeze").setExecutor(new freeze());
            getCommand("timer").setExecutor(new timer(this));
            getCommand("gm0").setExecutor(new gm0());
            getCommand("gm1").setExecutor(new gm1());
            getCommand("gm2").setExecutor(new gm2());
            getCommand("gm3").setExecutor(new gm3());
            getCommand("gm").setExecutor(new gm());
            getCommand("burn").setExecutor(new burn());
            getCommand("suicide").setExecutor(new suicide());
            getCommand("kickall").setExecutor(new kickall());
            getCommand("tpall").setExecutor(new tpall());
            getCommand("home").setExecutor(new home());
            getCommand("findhome").setExecutor(new findhome());
            getCommand("sethome").setExecutor(new sethome());
        } catch (Exception e) {
            sendConsoleMessage("An error occurred when loading in Commands: " + e.getMessage());
            this.errors = errors + 1;
        }
        try {
            getServer().getPluginManager().registerEvents(new frozenPlayerEvent(), this);
            getServer().getPluginManager().registerEvents(new PlayerChatEvent(true, true ,true ,true, true), this);
            getServer().getPluginManager().registerEvents(new playerJoinEvent(), this);
        } catch (Exception e) {
            sendConsoleMessage("An error occurred when loading in Events and/or Listeners: " + e.getMessage());
            this.errors = errors + 1;
        }

        if (errors < 1) {
            sendConsoleMessage("ATB Successfully started");
        }
        else
        {
            sendConsoleMessage(ChatColor.RED + "ATB started with one or more errors: " + errors + " errors" );
            sendConsoleMessage(ChatColor.RED + "We would appreciate you reporting this to the official GitHub https://github.com/sieadev/allTheBasics" );
        }

    }

    @Override
    public void onDisable() {
        sendConsoleMessage("Shutting down ATB...");
    }

    private void sendConsoleMessage(String message) {
        getServer().getConsoleSender().sendMessage(message);
    }


    private void loadConfig(){

    }

}
