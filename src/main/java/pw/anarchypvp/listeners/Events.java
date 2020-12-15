package pw.anarchypvp.listeners;

import org.bukkit.*;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.anarchypvp.main.Main;
import pw.anarchypvp.main.Utils;

public class Events implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        World world = Bukkit.getWorld("world");
        Location location = new Location(world, 0.5, 106, 0.5);
        player.teleport(location);
        location.setYaw(0.0F);
        location.setPitch(0.0F);
        Inventory inventory = event.getPlayer().getInventory();
        inventory.clear();
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player p = event.getPlayer();
        World w = Bukkit.getWorld("world");
        Location loc = new Location(w, 0.5, 106, 0.5);
        loc.setYaw(0.0F);
        loc.setPitch(0.0F);
        event.setRespawnLocation(loc);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (!(p.getWorld().getName().equals("cegg"))) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                ItemStack item = event.getItem();
                if (item != null && item.getType() == Material.MONSTER_EGG) {
                    event.setCancelled(true);
                    Inventory inventory = event.getPlayer().getInventory();
                    inventory.remove(item);
                    Player player = event.getPlayer();
                    Utils.sendMessage(player, Utils.getPrefix() + "Creeper Eggs are disabled in this world.");
                }
            }
        }
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntity().getType() == EntityType.CREEPER) {
            Creeper creeper = (Creeper) event.getEntity();
            creeper.setInvulnerable(true);
            creeper.setMaxFuseTicks(0);
            creeper.setExplosionRadius(Main.getPlugin().getConfig().getInt("CreeperDamageValue"));
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        if (event.getEntity().getType() == EntityType.CREEPER) {
            event.getDrops().clear();
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getDeathMessage().contains("Creeper")) {
            Player victim = event.getEntity().getPlayer();
            Player killer = victim.getWorld().getNearbyPlayers(victim.getLocation(), 10).iterator().next();
            if (killer.getName() != null || victim.getName() != null) {
                if (killer.getName().equals(victim.getName())) {
                    event.setDeathMessage(ChatColor.translateAlternateColorCodes('&', "&3" + victim.getName() + " &4committed suicide with &6a Creeper Egg"));
                } else {
                    event.setDeathMessage(ChatColor.translateAlternateColorCodes('&', "&3" + killer.getName() + " &4shoved &6a Creeper Egg &4down &3" + victim.getName() + "'s" + " &4throat"));
                }
            }
        }
    }
}
