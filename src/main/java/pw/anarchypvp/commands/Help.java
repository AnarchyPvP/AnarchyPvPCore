package pw.anarchypvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pw.anarchypvp.main.Main;
import pw.anarchypvp.main.Utils;

import java.util.List;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<String> list = Main.getPlugin().getConfig().getStringList("help");
        for (String entry : list)
            Utils.senderMessage(sender, entry);
        return true;
    }
}
