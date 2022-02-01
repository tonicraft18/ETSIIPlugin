package dev.tc18.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev.tc18.main.chat.Chat;
import dev.tc18.main.commands.Commands;
import dev.tc18.main.rankSystem.RankSystem;

public class MainPlugin extends JavaPlugin implements Listener {

    public void onEnable(){
        Bukkit.broadcastMessage("All systems online :)");
        registerListeners();
        comExecutor();
    }
    
    public void registerListeners() {
    	PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Chat(this), this);
    }


    //Procesa los comandos
    public void comExecutor(){
        this.getCommand("rank").setExecutor(new RankSystem(this));
        this.getCommand("info").setExecutor(new Commands(this));
        this.getCommand("go").setExecutor(new Commands(this));
    }

}