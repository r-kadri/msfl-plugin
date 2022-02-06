package fr.nadoxys.msflplugin;

import fr.nadoxys.msflplugin.commands.BorderCommands;
import fr.nadoxys.msflplugin.runnables.AutoMessage;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MSFLplugin extends JavaPlugin {

    // A FAIRE
    /*
    MAP SEED : -7088175800506671604
     */

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("   _____    ____________________.____    ");
        Bukkit.getLogger().info("  /     \\  /   _____/\\_   _____/|    |    ");
        Bukkit.getLogger().info(" /  \\ /  \\ \\_____  \\  |    __)  |    |    ");
        Bukkit.getLogger().info("/    Y    \\/        \\ |     \\   |    |___ ");
        Bukkit.getLogger().info("\\____|__  /_______  / \\___  /   |_______ \\");
        Bukkit.getLogger().info("        \\/        \\/      \\/            \\/");
        Bukkit.getLogger().info("By Nadoxys - v. " + getDescription().getVersion());
        //MetadataHandler.PLUGIN = this;

        World world = Bukkit.getWorld("world");
        assert world != null;
        WorldBorder worldBorder = world.getWorldBorder();
        worldBorder.setSize(100);
        worldBorder.setCenter(0.0,0.0);

        new AutoMessage().runTaskTimer(this, 900*20, 900*20);

        EventsRegister.registerEvents();
        this.getCommand("border").setExecutor(new BorderCommands());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static void msflMessage(String message, boolean msfl) {
        if(msfl)
            Bukkit.broadcastMessage("§8§l[§c§lMSFL§8§l] §7"+ message);
        else
            Bukkit.broadcastMessage(message);
    }

    public static void msflMessage(Player player, String message, boolean msfl) {
        if(msfl)
            player.sendMessage("§8§l[§c§lMSFL§8§l] §7"+ message);
        else
            player.sendMessage(message);
    }

    public static void msflMessage(String message) {
        msflMessage(message, true);
    }
}
