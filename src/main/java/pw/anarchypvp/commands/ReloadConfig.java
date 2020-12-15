package pw.anarchypvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pw.anarchypvp.main.Main;
import pw.anarchypvp.main.Utils;

public class ReloadConfig implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    Main.getPlugin().reloadConfig();
                    Utils.senderMessage(sender, Utils.getPrefix() + "&aReloaded configuration file");
                } else {
                    Utils.senderMessage(sender, Utils.getPrefix() + "&cIncorrect Syntax! Use &6/apr reload &cto reload the plugin");
                }
            }
        }
        return true;
    }
}