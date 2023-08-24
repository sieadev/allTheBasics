package com.sieadev.allthebasics;

import org.bukkit.plugin.java.JavaPlugin;

public final class AllTheBasics extends JavaPlugin {


    @Override
    public void onEnable() {
        sendConsoleMessage("Attempting to start ATB");
        getCommand("gm").setExecutor(new gm0);
        getCommand("gm").setExecutor(new gm1);
        getCommand("gm").setExecutor(new gm2);
        getCommand("gm").setExecutor(new gm3);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void sendConsoleMessage(String message) {
        getServer().getConsoleSender().sendMessage(message);
    }


}
