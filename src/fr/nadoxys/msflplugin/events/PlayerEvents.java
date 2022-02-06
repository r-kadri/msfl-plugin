package fr.nadoxys.msflplugin.events;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

import static fr.nadoxys.msflplugin.MSFLplugin.msflMessage;

public class PlayerEvents implements Listener {

    private static int playersSleep = 0;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("§6§l[§3§l+§6§l]§3 "+player.getName());
    }

    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("§6§l[§c§l-§6§l]§c "+player.getName());
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        event.getDrops().clear();
        player.getInventory().clear();
        event.setNewTotalExp(0);
        event.setDroppedExp(0);
        Location loc = player.getLocation();
        if(loc.getWorld() != null)
            loc.getWorld().strikeLightningEffect(loc);
        BanList bannedPlayers = Bukkit.getBanList(BanList.Type.NAME);
        bannedPlayers.addBan(player.getName(), "Éliminé", null, "MSFL");
        msflMessage("§8§lLe joueur "+player.getName()+ "est éliminé.");
        player.kickPlayer("Eliminé");
    }

    @EventHandler
    public void onPlayerItemBreak(PlayerItemBreakEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();
        switch (event.getBrokenItem().getType()) {
            case IRON_SWORD -> msflMessage(playerName + " a cassé une §fépée en fer§7!");
            case IRON_PICKAXE -> msflMessage(playerName + " a cassé une §fpioche en fer§7!");
            case IRON_AXE -> msflMessage(playerName + " a cassé une §fhâche en fer§7!");
            case IRON_SHOVEL -> msflMessage(playerName + " a cassé une §fpelle en fer§7!");
            case IRON_HOE -> msflMessage(playerName + " a a cassé une §fhoue en fer§7!");

            case DIAMOND_SWORD -> msflMessage(playerName + " a cassé une §bépée en diamant§7!");
            case DIAMOND_PICKAXE -> msflMessage(playerName + " a cassé une §bpioche en diamant§7!");
            case DIAMOND_AXE -> msflMessage(playerName + " a cassé une §bhâche en diamant§7!");
            case DIAMOND_SHOVEL -> msflMessage(playerName + " a cassé une §bpelle en diamant§7!");
            case DIAMOND_HOE -> msflMessage(playerName + " a a cassé une §bhoue en diamant§7!");

            case NETHERITE_SWORD -> msflMessage(playerName + " a cassé une §8épée en netherite§7!");
            case NETHERITE_PICKAXE -> msflMessage(playerName + " a cassé une §8pioche en netherite§7!");
            case NETHERITE_AXE -> msflMessage(playerName + " a cassé une §8hâche en netherite§7!");
            case NETHERITE_SHOVEL -> msflMessage(playerName + " a cassé une §8pelle en netherite§7!");
            case NETHERITE_HOE -> msflMessage(playerName + " a cassé une §8houe en netherite§7!");

            case IRON_HELMET -> msflMessage(playerName + " a cassé un §fcasque en fer§7!");
            case IRON_CHESTPLATE -> msflMessage(playerName + " a cassé un §fplastron en fer§7!");
            case IRON_LEGGINGS -> msflMessage(playerName + " a cassé des §fjambières en fer§7!");
            case IRON_BOOTS -> msflMessage(playerName + " a cassé des §fbottes en fer§7!");

            case DIAMOND_HELMET -> msflMessage(playerName + " a cassé un §bcasque en diamant§7!");
            case DIAMOND_CHESTPLATE -> msflMessage(playerName + " a cassé un §bplastron en diamant§7!");
            case DIAMOND_LEGGINGS -> msflMessage(playerName + " a cassé des §bjambières en diamant§7!");
            case DIAMOND_BOOTS -> msflMessage(playerName + " a cassé des §bbottes en diamant§7!");

            case NETHERITE_HELMET -> msflMessage(playerName + " a cassé un §8casque en netherite§7!");
            case NETHERITE_CHESTPLATE -> msflMessage(playerName + " a cassé un §8plastron en netherite§7!");
            case NETHERITE_LEGGINGS -> msflMessage(playerName + " a cassé des §8jambières en netherite§7!");
            case NETHERITE_BOOTS -> msflMessage(playerName + " a cassé des §8bottes en netherite§7!");

            case TURTLE_HELMET -> msflMessage(playerName + " a cassé un §acasque de tortue§7!");

            case BOW -> msflMessage(playerName + " a cassé un arc!");
            case CROSSBOW -> msflMessage(playerName + " a cassé une arbalète !");

            case FISHING_ROD -> msflMessage(playerName + " a cassé une canne à pêche!");
            case SHEARS -> msflMessage(playerName + " a cassé des cisailles!");
            case FLINT_AND_STEEL -> msflMessage(playerName + " a cassé un briquet!");
        }
    }

    @EventHandler
    public void onPlayerEnchant(EnchantItemEvent event) {
        Player player = event.getEnchanter();
        String playerName = player.getName();
        Material item = event.getItem().getType();
        int level = event.getExpLevelCost();
        switch (item) {
            case IRON_SWORD -> msflMessage(playerName + " a enchanté une §fépée en fer§7 au level "+ level+"!");
            case IRON_PICKAXE -> msflMessage(playerName + " a enchanté une §fpioche en fer§7 au level "+ level+"!");
            case IRON_AXE -> msflMessage(playerName + " a enchanté une §fhâche en fer§7 au level "+ level+"!");
            case IRON_SHOVEL -> msflMessage(playerName + " a enchanté une §fpelle en fer§7 au level "+ level+"!");
            case IRON_HOE -> msflMessage(playerName + " a a enchanté une §fhoue en fer§7 au level "+ level+"!");

            case DIAMOND_SWORD -> msflMessage(playerName + " a enchanté une §bépée en diamant§7 au level "+ level+"!");
            case DIAMOND_PICKAXE -> msflMessage(playerName + " a enchanté une §bpioche en diamant§7 au level "+ level+"!");
            case DIAMOND_AXE -> msflMessage(playerName + " a enchanté une §bhâche en diamant§7 au level "+ level+"!");
            case DIAMOND_SHOVEL -> msflMessage(playerName + " a enchanté une §bpelle en diamant§7 au level "+ level+"!");
            case DIAMOND_HOE -> msflMessage(playerName + " a a enchanté une §bhoue en diamant§7 au level "+ level+"!");

            case NETHERITE_SWORD -> msflMessage(playerName + " a enchanté une §8épée en netherite§7 au level "+ level+"!");
            case NETHERITE_PICKAXE -> msflMessage(playerName + " a enchanté une §8pioche en netherite§7 au level "+ level+"!");
            case NETHERITE_AXE -> msflMessage(playerName + " a enchanté une §8hâche en netherite§7 au level "+ level+"!");
            case NETHERITE_SHOVEL -> msflMessage(playerName + " a enchanté une §8pelle en netherite§7 au level "+ level+"!");
            case NETHERITE_HOE -> msflMessage(playerName + " a enchanté une §8houe en netherite§7 au level "+ level+"!");

            case IRON_HELMET -> msflMessage(playerName + " a enchanté un §fcasque en fer§7 au level "+ level+"!");
            case IRON_CHESTPLATE -> msflMessage(playerName + " a enchanté un §fplastron en fer§7 au level "+ level+"!");
            case IRON_LEGGINGS -> msflMessage(playerName + " a enchanté des §fjambières en fer§7 au level "+ level+"!");
            case IRON_BOOTS -> msflMessage(playerName + " a enchanté des §fbottes en fer§7 au level "+ level+"!");

            case DIAMOND_HELMET -> msflMessage(playerName + " a enchanté un §bcasque en diamant§7 au level "+ level+"!");
            case DIAMOND_CHESTPLATE -> msflMessage(playerName + " a enchanté un §bplastron en diamant§7 au level "+ level+"!");
            case DIAMOND_LEGGINGS -> msflMessage(playerName + " a enchanté des §bjambières en diamant§7 au level "+ level+"!");
            case DIAMOND_BOOTS -> msflMessage(playerName + " a enchanté des §bbottes en diamant§7 au level "+ level+"!");

            case NETHERITE_HELMET -> msflMessage(playerName + " a enchanté un §8casque en netherite§7 au level "+ level+"!");
            case NETHERITE_CHESTPLATE -> msflMessage(playerName + " a enchanté un §8plastron en netherite§7 au level "+ level+"!");
            case NETHERITE_LEGGINGS -> msflMessage(playerName + " a enchanté des §8jambières en netherite§7 au level "+ level+"!");
            case NETHERITE_BOOTS -> msflMessage(playerName + " a enchanté des §8bottes en netherite§7 au level "+ level+"!");

            case TURTLE_HELMET -> msflMessage(playerName + " a enchanté un §acasque de tortue§7 au level "+ level+"!");

            case BOW -> msflMessage(playerName + " a enchanté un arc au level "+ level+"!");
            case CROSSBOW -> msflMessage(playerName + " a enchanté une arbalète au level "+ level+"!");

            case FISHING_ROD -> msflMessage(playerName + " a enchanté une canne à pêche au level "+ level+"!");
            case SHEARS -> msflMessage(playerName + " a enchanté des cisailles au level "+ level+"!");
            case FLINT_AND_STEEL -> msflMessage(playerName + " a enchanté un briquet au level "+ level+"!");

            case BOOK -> msflMessage(playerName + " a enchanté un livre au level "+ level+"!");
        }
    }

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        if(!event.isCancelled()) {
            playersSleep++;
            msflMessage(player.getName() + "§9 s'endort... "+playersSleep+"/"+Bukkit.getServer().getOnlinePlayers().size());
        }
    }

    @EventHandler
    public void onPlayerBedLeave(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        if(!event.isCancelled()){
            playersSleep--;
            msflMessage(player.getName() + "§b se réveille !");
        }

    }

    @EventHandler
    public void onPlayerTeleportEvent(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        if(event.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) {
            msflMessage(player.getName() + " utilise le portail du §5Nether §7!");
        } else if(event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
            msflMessage(player.getName() + " utilise le portail de l'§8End §7!");
        }
    }


}
