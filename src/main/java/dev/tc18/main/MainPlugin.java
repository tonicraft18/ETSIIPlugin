<<<<<<< HEAD
package dev.tc18.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {
    
    private static MainPlugin instance;

    @Override
    public void onEnable(){
        Bukkit.broadcastMessage("All systems not offline :)");
        
    }

    public static MainPlugin getInstance(){
        return instance;
    }

=======
package dev.tc18.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {
    
    private static MainPlugin instance;

    @Override
    public void onEnable(){
        Bukkit.broadcastMessage("All systems are online :)");
    }

    public static MainPlugin getInstance(){
        return instance;
    }

>>>>>>> 5def763ff6c9aad425440be423947238d7bdaecb
}