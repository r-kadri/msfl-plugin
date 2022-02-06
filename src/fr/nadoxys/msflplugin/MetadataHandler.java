package fr.nadoxys.msflplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class MetadataHandler implements Listener {

    /*
    MSFLplugin has ceased using metadata as its primary get/set way of cheating associating data to mobs
    The remaining metadata are here purely for third party compatibility.
    EntityTracker and EliteMobEntity expose pretty much everything you could want API-wise
     */

    //plugin name
    public final static String MSFL_PLUGIN = "MSFLplugin";
    //plugin getter
    public static Plugin PLUGIN = Bukkit.getPluginManager().getPlugin(MSFL_PLUGIN);


}