package fr.nadoxys.msflplugin;

import fr.nadoxys.msflplugin.events.EntityEvents;
import fr.nadoxys.msflplugin.events.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class EventsRegister {
    public static void registerEvents() {

        PluginManager pluginManager = Bukkit.getPluginManager();
        Plugin plugin = MetadataHandler.PLUGIN;
        pluginManager.registerEvents(new PlayerEvents(), plugin);
        pluginManager.registerEvents(new EntityEvents(), plugin);
    }
}
