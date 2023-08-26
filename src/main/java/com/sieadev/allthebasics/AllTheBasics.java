package com.sieadev.allthebasics;

import com.sieadev.allthebasics.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class AllTheBasics extends JavaPlugin {


    @Override
    public void onEnable() {
        sendConsoleMessage("Attempting to start ATB");
        getCommand("tp").setExecutor(new tp());
        getCommand("heal").setExecutor(new heal());
        getCommand("feed").setExecutor(new feed());
        getCommand("fakeop").setExecutor(new fakeop());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void sendConsoleMessage(String message) {
        getServer().getConsoleSender().sendMessage(message);
    }


}
