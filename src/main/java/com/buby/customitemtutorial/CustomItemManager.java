package com.buby.customitemtutorial;

import com.buby.customitemtutorial.impl.VeryUsefulStick;

import java.util.HashSet;
import java.util.Set;

public class CustomItemManager {
    private final CustomItemTutorial plugin;
    private final Set<AbstractItem> itemRegistry = new HashSet<>();

    public CustomItemManager(CustomItemTutorial plugin) {
        this.plugin = plugin;

        registerHandler(new VeryUsefulStick(plugin));
    }

    public void registerHandler(AbstractItem... handlers){
        for(AbstractItem handler : handlers){
            this.registerHandler(handler);
        }
    }

    public void registerHandler(AbstractItem handler){
        itemRegistry.add(handler);
        plugin.registerListener(handler);
    }

    public <T> T getHandler(Class<? extends T> clazz){
        for(AbstractItem handler : itemRegistry){
            if(handler.getClass().equals(clazz))
                return (T) handler;
        }
        return null;
    }

    public AbstractItem getHandler(String itemId){
        for(AbstractItem handler : itemRegistry){
            if(handler.itemID.equals(itemId))
                return handler;
        }
        return null;

    }
}
