package dev.tc18.main;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev.tc18.main.chat.Chat;
import dev.tc18.main.commands.Commands;
import dev.tc18.main.login.Login;
import dev.tc18.main.rankSystem.RankSystem;

public class MainPlugin extends JavaPlugin implements Listener {

    Login log = new Login();

    public void onEnable(){
        System.out.println("ETSII PLUGIN v 0.3 - Plugin desarrollado por prCalculadora :)");
        new RankSystem().runTaskTimer(this, 20, 20);
        log.setMap(usmap());
        registerListeners();
        comExecutor();
    }

    private Map<String,String> usmap(){
        Map<String,String> map = new HashMap<>();
        map.put("Tonicraft18", "jajayoxd");
        map.put("alers16", "romano2");
        map.put("ant22031", "caniete");
        map.put("ElGamesHD", "logi1243");
        map.put("TeuTue", "electronica101");
        return map;
    }

    
    public void registerListeners() {
    	PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Chat(), this);
        pm.registerEvents(log, this);
    }
    
    public static String getPlayerRank(Player p) {
    	String r = "§7§l[USUARIO] ";
    	
    	if(p.hasPermission("rank.admin")) {
    		r = "§c§l[ADMIN] ";
            if(p.hasPermission("rank.profesor") && p.getName().equalsIgnoreCase("teutue")) {
                r = "§4§l[PROFESOR] ";
            }
    	}
		return r;
    }
    
    //Procesa los comandos
    public void comExecutor(){
        this.getCommand("rank").setExecutor(new RankSystem());
        this.getCommand("information").setExecutor(new Commands());
        this.getCommand("go").setExecutor(new Commands());
        this.getCommand("login").setExecutor(log);
    }

}