package pw.anarchypvp.listeners;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import pw.anarchypvp.main.Main;
import pw.anarchypvp.main.Utils;

public class EchestLagPatch implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        int max = Main.getPlugin().getConfig().getInt("EchestLimit");
        int amount = 0;
        if (event.getBlock().getType() == Material.ENDER_CHEST) {
            byte b;
            int i;
            BlockState[] arrayOfBlockState;
            for (i = (arrayOfBlockState = event.getBlock().getLocation().getChunk().getTileEntities()).length, b = 0; b < i; ) {
                BlockState state = arrayOfBlockState[b];
                if (state instanceof org.bukkit.block.EnderChest)
                    amount++;
                b++;
            }
            if (amount > max) {
                event.setCancelled(true);
                Player player = event.getPlayer();
                Utils.sendMessage(player, Main.getPlugin().getConfig().getString("EchestMsg"));
            }
        }
    }
}
