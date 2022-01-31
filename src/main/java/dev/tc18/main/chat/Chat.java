package dev.tc18.main.chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import dev.tc18.main.MainPlugin;

public class Chat implements Listener {
	
	private MainPlugin main;
	
	public Chat(MainPlugin main){
		this.main = main;
	}
    
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player p = (Player) event.getPlayer();
		event.setFormat("§6" + p.getDisplayName() + " > §7" + event.getMessage());
	}

	/*
	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent event){
		Player p = (Player) event.getPlayer();
		Bukkit.broadcastMessage("§6§k!! §r§6" + p.getName() + " ha entrado al servidor §k !!");
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		Player p = (Player) event.getPlayer();
		Bukkit.broadcastMessage("§r§4" + p.getName() + " ha salido del servidor :(");
	}
	*/
}