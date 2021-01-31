package jp.dora.sb;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;

        Bukkit.getPluginManager().registerEvents(new PlayerJoinEvents(), this);
    }

    @Override
    public void onDisable() {
        plugin = null;
    }
}
