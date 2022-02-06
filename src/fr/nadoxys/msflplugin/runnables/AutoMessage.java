package fr.nadoxys.msflplugin.runnables;

import fr.nadoxys.msflplugin.MSFLplugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoMessage extends BukkitRunnable {

    private String message = "Rappel : utilisez la commande /border pour augmenter la taille de la map";

    @Override
    public void run() {
        MSFLplugin.msflMessage(message);
    }
}
