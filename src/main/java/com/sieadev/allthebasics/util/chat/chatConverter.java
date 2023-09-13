package com.sieadev.allthebasics.util.chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class chatConverter {

    private static boolean highlightNames;
    private static boolean emoji;
    private static boolean highlightNumbers;
    private static boolean math;
    private static boolean colorCodes;

    public chatConverter(boolean colorCodes, boolean math, boolean highlightNumbers, boolean emoji, boolean highlightNames){
       chatConverter.colorCodes = colorCodes;
       chatConverter.highlightNames = highlightNames;
       chatConverter.highlightNumbers = highlightNumbers;
       chatConverter.emoji = emoji;
       chatConverter.math = math;
    }

    public static void loadConfig(boolean colorCodes, boolean math, boolean highlightNumbers, boolean emoji, boolean highlightNames){
        chatConverter.colorCodes = colorCodes;
        chatConverter.highlightNames = highlightNames;
        chatConverter.highlightNumbers = highlightNumbers;
        chatConverter.emoji = emoji;
        chatConverter.math = math;
    }
    public static String all(Player p, String message){
        if (p.hasPermission("atb.chat.color") || colorCodes){
            message = ChatColor.translateAlternateColorCodes('&', message);
        }
        if (p.hasPermission("atb.chat.math") || math){
            message = calculateMathInString(message);
        }
        if (p.hasPermission("atb.chat.highlightNumbers") || highlightNumbers) {
            String color = "§5";
            message = message.replaceAll("(\\d+)", color + "$1" + "§r");
        }
        if (p.hasPermission("atb.chat.emoji") || emoji) {
            //will do this later
        }
        if (highlightNames){
            //e.setCancelled(true);
            //send chat message to players individually
            //return;
        }
        return message;
    }

    private static String calculateMathInString(String input) {
        Matcher m = Pattern.compile ("\\d+(\\s*[+\\-*/]\\s*\\d+)+").matcher(input);
        return m.replaceAll(mr -> {
            String match = mr.group();
            Matcher digit = Pattern.compile("\\d+").matcher(match);
            Matcher operators = Pattern.compile("[+\\-*/]").matcher(match);
            if (!digit.find()) return "";
            float result = Float.parseFloat(digit.group());
            while (digit.find() && operators.find()) {
                switch (operators.group()) {
                    case "+":
                        result += Float.parseFloat(digit.group());
                        break;
                    case "-":
                        result -= Float.parseFloat(digit.group());
                        break;
                    case "*":
                        result *= Float.parseFloat(digit.group());
                        break;
                    case "/":
                        result /= Float.parseFloat(digit.group());
                        break;
                }
            }
            return Float.toString(result);
        });
    }
}
