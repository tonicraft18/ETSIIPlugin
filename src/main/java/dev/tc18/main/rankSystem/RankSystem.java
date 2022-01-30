package dev.tc18.main.rankSystem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.tc18.main.MainPlugin;

public class RankSystem implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private MainPlugin main;
	
	public RankSystem(MainPlugin main){
		this.main = main;
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if(cmd.getName().equalsIgnoreCase("rank")) {
			if(args.length == 0) {
				sender.sendMessage("");
				sender.sendMessage("§6§lELECT§e§lRONICA §b§lRangos §7§oInformacion");
				sender.sendMessage("");
				sender.sendMessage("§e§l» §fLista de rangos:");
				sender.sendMessage("§e§l» §7§lUSUARIO§f: Permite observar, no puede construir ni destruir.");
				sender.sendMessage("§e§l» §c§lADMIN§f: Todos los permisos.");
				sender.sendMessage("§e§l» §4§lPROFESOR§f: Rango para el profesor.");
				sender.sendMessage("");
				sender.sendMessage("§e§l» §fUsa §e/rank help§f para ver la lista de comandos.");
				sender.sendMessage("");
			}
    	}
        return true;
    }
	
}