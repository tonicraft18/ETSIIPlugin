package dev.tc18.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev.tc18.main.chat.Chat;
import dev.tc18.main.commands.Commands;
import dev.tc18.main.rankSystem.RankSystem;

public class MainPlugin extends JavaPlugin implements Listener {

    public void onEnable(){
        Bukkit.broadcastMessage("All systems online :)");
        
        new RankSystem(this).runTaskTimer(this, 20, 20);
        
        registerListeners();
        comExecutor();
    }
    
    public void registerListeners() {
    	PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Chat(this), this);
    }
    
    public static String getPlayerRank(Player p) {
    	String r = "§7§lUSUARIO ";
    	
    	if(p.hasPermission("rank.admin")) {
    		r = "§c§lADMIN ";
            if(p.hasPermission("rank.profesor")) {
                r = "§4§lPROFESOR ";
            }
    	}
		return r;
    }
    
    //Procesa los comandos
    public void comExecutor(){
        this.getCommand("rank").setExecutor(new RankSystem(this));
        this.getCommand("info").setExecutor(new Commands(this));
        this.getCommand("go").setExecutor(new Commands(this));
    }

}