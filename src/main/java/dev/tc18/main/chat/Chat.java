package dev.tc18.main.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import dev.tc18.main.MainPlugin;

public class Chat implements Listener {
    
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player p = (Player) event.getPlayer();
		event.setFormat(MainPlugin.getPlayerRank(p) + "§e" + p.getName() + "§f: " + event.getMessage());
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = (Player) event.getPlayer();
		p.sendMessage("§9Bienvenido al servidor de minecraft para proyectos relacionados con la electrónica\n\n");
		event.setJoinMessage("§6§k!! " + MainPlugin.getPlayerRank(p) + "§r§6" + p.getName() + " ha entrado al servidor §k!!");
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		Player p = (Player) event.getPlayer();
		event.setQuitMessage(MainPlugin.getPlayerRank(p) + "§4" + p.getName() + " ha salido del servidor");
	}
	
}