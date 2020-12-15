package pw.anarchypvp.hubcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pw.anarchypvp.main.Utils;

public class KitCreator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Utils.tpKitCreator(player);
        } else {
            Utils.senderMessage(sender, Utils.getPrefix() + "You cant send console there fucktard");
        }
        return true;
    }
}
