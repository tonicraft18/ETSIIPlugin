package dev.tc18.main.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dev.tc18.main.MainPlugin;

public class Chat implements Listener {
	
	private MainPlugin main;
	
	public Chat(MainPlugin main){
		this.main = main;
	}
    
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player p = (Player) event.getPlayer();
		event.setMessage("§e" + p.getName() + "§f: " + event.getMessage());
	}

}