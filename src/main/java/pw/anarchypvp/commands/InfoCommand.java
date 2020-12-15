package pw.anarchypvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pw.anarchypvp.main.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String name = sender.getServer().getClass().getName();
        String version = name.substring(name.lastIndexOf('.') + 1);
        String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        String discordlink = "https://discord.anarchypvp.pw";
        int totalPlayers = Bukkit.getOfflinePlayers().length;
        int onlinePlayers = Bukkit.getOnlinePlayers().size();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1&m--------------------------------------------"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Current TPS: " + Utils.getTps()));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Online Players: " + onlinePlayers));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Total Players Joined: " + totalPlayers));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Server Version: " + "Paper 1.12.2"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Official Discord: " + discordlink));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Today's Date: " + date));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1&m--------------------------------------------"));
        return true;
    }
}
