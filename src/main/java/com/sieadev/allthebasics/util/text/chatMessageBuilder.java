package com.sieadev.allthebasics.util.text;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class chatMessageBuilder {

    private static boolean highlightNames;
    private static boolean emoji;
    private static boolean highlightNumbers;
    private static boolean math;
    private static boolean colorCodes;

    public static void loadConfig(boolean colorCodes, boolean math, boolean highlightNumbers, boolean emoji, boolean highlightNames){
        chatMessageBuilder.colorCodes = colorCodes;
        chatMessageBuilder.highlightNames = highlightNames;
        chatMessageBuilder.highlightNumbers = highlightNumbers;
        chatMessageBuilder.emoji = emoji;
        chatMessageBuilder.math = math;
    }
    public static String all(Player p, String m){
        String message = m;
        if (p.hasPermission("atb.text.color") || colorCodes){
            message = ChatColor.translateAlternateColorCodes('&', message);
        }
        if (p.hasPermission("atb.text.math") || math){
            message = calculateMathInString(message);
        }
        if (p.hasPermission("atb.text.highlightNumbers") || highlightNumbers) {
            String color = "§5";
            String colorebefore = ChatColor.getLastColors(message);
            message = message.replaceAll("(\\d+)", color + "$1" + colorebefore);
        }
        if (p.hasPermission("atb.text.emoji") || emoji) {
            message = message.replace(":heart:", "❤");
            message = message.replace(":java:", "☕");
            message = message.replace(":yes:", "✔");
            message = message.replace(":no:", "✖");
            message = message.replace(":arrow:", "➜");
            message = message.replace(":peace:", "✌");
            message = message.replace(":shrug:", "¯\\_(ツ)_/¯");
            message = message.replace(":tableflip:", "(╯°□°）╯︵ ┻━┻");
            message = message.replace(":typing:", "✎...");
            message = message.replace(":thinking:", "(0.o?)");
            message = message.replace(":gimme:", "༼つ ◕_◕ ༽つ");
            message = message.replace(":wizard:", "('-')⊃━☆ﾟ.*･｡ﾟ");
            message = message.replace(":puffer:", "<('O')>");
            message = message.replace(":sloth:", "( ⬩ ⊝ ⬩ )");
            message = message.replace(":dog:", "(ᵔᴥᵔ)");
            message = message.replace(":cat:", "= ＾● ⋏ ●＾ =");
        }
        if (highlightNames){
            for (int i = 0; i < p.getWorld().getPlayers().size(); i++){
                String target = p.getWorld().getPlayers().get(i).getName();
                if (message.contains(target)){
                    String prefix = message.split(target)[0];
                    String sufix = message.split(target)[1];
                    String color = ChatColor.getLastColors(prefix);
                    message = (prefix + "§e§l" + target + color + sufix);
                }
            }
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
