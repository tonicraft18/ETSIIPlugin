package dev.tc18.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {
    
    private static MainPlugin instance;

    @Override
    public void onEnable(){
        Bukkit.broadcastMessage("All systems online :)");
    }

    public static MainPlugin getInstance(){
        return instance;
    }

}