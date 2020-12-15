package pw.anarchypvp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import pw.anarchypvp.main.Utils;

public class ItemClickEvent implements Listener {

    public static Inventory arenaSelector = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', "&2&lAnarchyPvP Arenas and Worlds"));

    static {
        arenaSelector.setItem(0, new ItemStack(Material.END_CRYSTAL, 1));
        arenaSelector.setItem(1, new ItemStack(Material.DISPENSER, 1));
        arenaSelector.setItem(2, new ItemStack(Material.MONSTER_EGG, 1));
        arenaSelector.setItem(3, new ItemStack(Material.CHEST, 1));
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        PlayerInventory inventory = p.getInventory();
        if (inventory.getItemInMainHand().getType() == Material.REDSTONE_COMPARATOR) {
            p.openInventory(arenaSelector);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inv = event.getInventory();
        if (inv.getName().equals(arenaSelector.getName())) {
            if (clicked.getType() == Material.END_CRYSTAL) {
                event.setCancelled(true);
                p.closeInventory();
                Utils.tpHub(p);
            }
            if (clicked.getType() == Material.DISPENSER) {
                event.setCancelled(true);
                p.closeInventory();
                Utils.tp32k(p);
            }
            if (clicked.getType() == Material.MONSTER_EGG) {
                event.setCancelled(true);
                p.closeInventory();
                Utils.tpCegg(p);
            }
            if (clicked.getType() == Material.CHEST) {
                event.setCancelled(true);
                p.closeInventory();
                Utils.tpKitCreator(p);
            }
        }
    }
}
