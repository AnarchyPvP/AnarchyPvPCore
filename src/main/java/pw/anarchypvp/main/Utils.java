package pw.anarchypvp.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static String getPrefix() {
        return "&8[&2AnarchyPvP&8]&r ";
    }

    public static void sendMessage(Player player, String string) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
    }

    public static void senderMessage(CommandSender sender, String string) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
    }

    public static void tpHub(CommandSender sender) {
        Player player = (Player) sender;
        World world = Bukkit.getWorld("world");
        Location location = new Location(world, 0.5, 106, 0.5);
        player.teleport(location);
        Utils.senderMessage(player, Utils.getPrefix() + "Teleported to Hub / Crystal PvP Arena.");
    }

    public static void tp32k(CommandSender sender) {
        Player player = (Player) sender;
        World world = Bukkit.getWorld("32k");
        Location location = new Location(world, 0.5, 103, 0.5);
        player.teleport(location);
        Utils.senderMessage(player, Utils.getPrefix() + "Teleported to 32k PvP Arena.");
    }

    public static void tpKitCreator(CommandSender sender) {
        Player player = (Player) sender;
        World world = Bukkit.getWorld("kitcreator");
        Location location = new Location(world, 0.5, 102.5, 0.5);
        player.teleport(location);
        Utils.senderMessage(player, Utils.getPrefix() + "Teleported to Kitcreator.");
    }

    public static void tpCegg(CommandSender sender) {
        Player player = (Player) sender;
        World world = Bukkit.getWorld("cegg");
        Location location = new Location(world, 0.5, 101, 0.5);
        player.teleport(location);
        Utils.senderMessage(player, Utils.getPrefix() + "Teleported to Creeper Egg Arena");
    }
    private static String format(double tps) {
        return (tps > 18.0D ? "§a" : (tps > 16.0D ? "§e" : "§c")) + (tps > 20.0D ? "" : "") + String.format("%.2f", Math.min((double) Math.round(tps * 100.0D) / 100.0D, 20.0D));
    }
    public static String getTps() {
        return format(Bukkit.getServer().getTPS()[0]);
    }
    public static List<String> getPlayerCountPerWorlds() {
        int hubplayers = Bukkit.getWorld("world").getPlayerCount();
        int dispensermetaplayers = Bukkit.getWorld("32k").getPlayerCount();
        int kitcreatorplayers = Bukkit.getWorld("kitcreator").getPlayerCount();
        int ceggplayers = Bukkit.getWorld("cegg").getPlayerCount();
        String h = String.valueOf(hubplayers);
        String d = String.valueOf(dispensermetaplayers);
        String k = String.valueOf(kitcreatorplayers);
        String c = String.valueOf(ceggplayers);
        return Arrays.asList(ChatColor.GOLD + h, ChatColor.GOLD + d, ChatColor.GOLD + k, ChatColor.GOLD + c);
    }
}

