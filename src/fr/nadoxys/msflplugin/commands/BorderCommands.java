package fr.nadoxys.msflplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static fr.nadoxys.msflplugin.MSFLplugin.msflMessage;

public class BorderCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player player) {
            World world = Bukkit.getWorld("world");
            assert world != null;
            WorldBorder worldBorder = world.getWorldBorder();
            int worldBorderSize = (int) worldBorder.getSize();
            int nbDiamond = 2 + 2 * ((worldBorderSize - 100) / 100);

            if(args.length == 0){
                msflMessage(player,
                        "§7Taille de la map : "+worldBorderSize+"\n" +
                                "Pour augmenter la map, il faut donner "+nbDiamond+" diamants avec la commande §o/border upgrade§r§7.", true
                );
                return true;
            }
            if(args.length == 1 && args[0].equalsIgnoreCase("upgrade")) {
                if(player.getInventory().contains(Material.DIAMOND, nbDiamond)) {
                    for(ItemStack is : player.getInventory().getContents()) {
                        if(is != null && is.getType() == Material.DIAMOND) {
                            is.setAmount(is.getAmount() - nbDiamond);
                            break;
                        }
                    }
                    player.updateInventory();
                    msflMessage("La taille de la map a augmenté ! Taille : "+(worldBorderSize+100)+".");
                    worldBorder.setSize(worldBorderSize + 100);
                    return true;
                } else {
                    msflMessage(player,"Vous n'avez pas "+nbDiamond+" diamants sur vous !", true);
                    return true;
                }

            }

        }
        return false;
    }
}
