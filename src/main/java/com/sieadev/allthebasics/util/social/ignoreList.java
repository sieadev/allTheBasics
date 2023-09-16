package com.sieadev.allthebasics.util.social;

import com.sieadev.allthebasics.util.ConfigUtil;
import com.sieadev.allthebasics.util.getPlayerFromString;
import com.sieadev.allthebasics.util.text.messageBuilder;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class ignoreList {

    private static Plugin plugin = null;
    public static void ignoreListLoader(Plugin plugin) {
        ignoreList.plugin = plugin;
    }
    public static boolean isIgnored(Player p, Player target){
        ConfigUtil config = new ConfigUtil(plugin, "ignorelist.yml");
        List<String> ignoreList = config.getConfig().getStringList(p.getUniqueId().toString());
        if (ignoreList.contains(target.getUniqueId().toString())){
            return true;
        }
        return false;
    }

    public static void addIgnored(Player p, String t){
        if (!p.hasPermission("atb.ignore")){
            p.sendMessage(messageBuilder.noPermission);
            return;
        }
        ConfigUtil config = new ConfigUtil(plugin, "ignorelist.yml");

        List<String> ignoreList = config.getConfig().getStringList(p.getUniqueId().toString());

        Player target = getPlayerFromString.getPlayerFromString(p, t);

        if (target == null)return;

        if (ignoreList.contains(target.getUniqueId().toString())){

            ignoreList.remove(target.getUniqueId().toString());

            p.sendMessage("§eYou removed §r" + target.getDisplayName() + " §efrom your ignore list!");
        } else {
            ignoreList.add(target.getUniqueId().toString());
            p.sendMessage("§eYou added §r" + target.getDisplayName() + " §etoo your ignore list");
        }
        config.getConfig().set(p.getUniqueId().toString(), ignoreList);
        config.save();
    }
}
