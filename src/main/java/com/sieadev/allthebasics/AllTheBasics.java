package com.sieadev.allthebasics;

import org.bukkit.plugin.java.JavaPlugin;

public final class AllTheBasics extends JavaPlugin {



    @Override
    public void onEnable() {
        sendConsoleMessage("Attempting to start ATB");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void sendConsoleMessage(String message) {
        getServer().getConsoleSender().sendMessage(message);
    }


}
