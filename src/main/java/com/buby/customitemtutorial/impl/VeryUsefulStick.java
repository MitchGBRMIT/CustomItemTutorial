package com.buby.customitemtutorial.impl;

import com.buby.customitemtutorial.AbstractItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("deprecation")
public class VeryUsefulStick extends AbstractItem {

    public VeryUsefulStick(JavaPlugin plugin) {
        super(plugin,"VERY_USEFUL_STICK", Material.STICK);
    }

    @Override
    protected ItemStack generateItem(ItemStack itemStack, Player player) {
        ItemMeta meta = itemStack.getItemMeta();
        String name = ChatColor.translateAlternateColorCodes('&', "&eA Very Useful Stick");
        meta.setDisplayName(name);

        itemStack.setItemMeta(meta);
        return itemStack;
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if(!isApplicable(item)) return;

        player.getWorld().strikeLightningEffect(player.getLocation().add(1, 0, 0));
        String msg = ChatColor.translateAlternateColorCodes('&', "&eBANG!");
        player.sendMessage(msg);
    }
}
