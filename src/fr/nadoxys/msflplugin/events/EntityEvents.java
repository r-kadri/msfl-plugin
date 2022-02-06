package fr.nadoxys.msflplugin.events;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntityEvents implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if(e.getEntity() instanceof Player player) {

            switch (e.getDamager().getType()) {
                case ZOMBIE, ZOMBIE_VILLAGER, DROWNED -> player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*20, 1));
                case SPIDER -> player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5*20, 2));
                case SLIME -> player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5*20, 1));
            }
        }
    }
}
