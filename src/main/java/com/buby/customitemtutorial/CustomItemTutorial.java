package com.buby.customitemtutorial;

import com.buby.customitemtutorial.impl.VeryUsefulStick;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemTutorial extends JavaPlugin implements Listener{

    public CustomItemManager customItemManager;

    @Override
    public void onEnable() {
        this.customItemManager = new CustomItemManager(this);

        registerListener(this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        ItemStack item =  customItemManager.getHandler(VeryUsefulStick.class).getItem(player);
        player.getInventory().addItem(item);
    }

    public void registerListener(Listener... listeners){
        for(Listener listener : listeners){
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }
}
