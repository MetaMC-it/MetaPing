package me.itswagpvp.metaping.misc;

public class Utils {
    public static String colorizePing(int ping) {
        if (ping <= 75) return "§a" + ping;
        else if (ping <= 150) return "§e" + ping;
        else if (ping <= 300) return "§c" + ping;
        else return "§4" + ping;
    }
}
