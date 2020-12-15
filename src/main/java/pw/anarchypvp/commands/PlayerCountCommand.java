package pw.anarchypvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pw.anarchypvp.main.Utils;

public class PlayerCountCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            int hubplayers = Bukkit.getWorld("world").getPlayerCount();
            int dispensermetaplayers = Bukkit.getWorld("32k").getPlayerCount();
            int kitcreatorplayers = Bukkit.getWorld("kitcreator").getPlayerCount();
            int ceggplayers = Bukkit.getWorld("cegg").getPlayerCount();
            String h = String.valueOf(hubplayers);
            String d = String.valueOf(dispensermetaplayers);
            String k = String.valueOf(kitcreatorplayers);
            String c = String.valueOf(ceggplayers);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1&m--------------------------------------------"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Main Hub (CPvP): &l" + h));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&632k Arena: &l" + d));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Creeper Egg Arena: &l" + c));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kitcreator: &l" + k));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1&m--------------------------------------------"));
        }
        return true;
    }
}
