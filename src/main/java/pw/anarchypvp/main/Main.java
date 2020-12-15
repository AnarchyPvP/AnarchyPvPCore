package pw.anarchypvp.main;

import org.bukkit.entity.Item;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pw.anarchypvp.commands.Help;
import pw.anarchypvp.commands.InfoCommand;
import pw.anarchypvp.commands.PlayerCountCommand;
import pw.anarchypvp.commands.ReloadConfig;
import pw.anarchypvp.hubcommands.CreeperEgg;
import pw.anarchypvp.hubcommands.DispenserMetaArena;
import pw.anarchypvp.hubcommands.KitCreator;
import pw.anarchypvp.hubcommands.MainHub;
import pw.anarchypvp.listeners.EchestLagPatch;
import pw.anarchypvp.listeners.Events;
import pw.anarchypvp.listeners.ItemClickEvent;

public final class Main extends JavaPlugin {

    public static Plugin getPlugin() {
        return getPlugin(Main.class);
    }

    @Override
    public void onEnable() {
        System.out.println(Utils.getPrefix() + "AnarchyPvPCore Enabled!");
        getServer().getPluginManager().registerEvents(new EchestLagPatch(), this);
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new ItemClickEvent(), this);
        getCommand("apr").setExecutor(new ReloadConfig());
        getCommand("help").setExecutor(new Help());
        getCommand("hub").setExecutor(new MainHub());
        getCommand("kc").setExecutor(new KitCreator());
        getCommand("32k").setExecutor(new DispenserMetaArena());
        getCommand("cegg").setExecutor(new CreeperEgg());
        getCommand("info").setExecutor(new InfoCommand());
        getCommand("players").setExecutor(new PlayerCountCommand());
        this.saveDefaultConfig();
    }
}


