package com.sieadev.allthebasics;

import com.sieadev.allthebasics.commands.*;
import com.sieadev.allthebasics.commands.gamemode.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class AllTheBasics extends JavaPlugin {


    @Override
    public void onEnable() {
        sendConsoleMessage("Attempting to start ATB");
        getCommand("tp").setExecutor(new tp());
        getCommand("heal").setExecutor(new heal());
        getCommand("feed").setExecutor(new feed());
        getCommand("fakeop").setExecutor(new fakeop());
        getCommand("fly").setExecutor(new fly());
        getCommand("gm0").setExecutor(new gm0());
        getCommand("gm1").setExecutor(new gm1());
        getCommand("gm2").setExecutor(new gm2());
        getCommand("gm3").setExecutor(new gm3());
        getCommand("gm").setExecutor(new gm());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void sendConsoleMessage(String message) {
        getServer().getConsoleSender().sendMessage(message);
    }


}
