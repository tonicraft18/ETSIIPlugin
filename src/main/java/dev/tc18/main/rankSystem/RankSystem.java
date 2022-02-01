package dev.tc18.main.rankSystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import dev.tc18.main.MainPlugin;

public class RankSystem extends BukkitRunnable implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private MainPlugin main;
	
	public RankSystem(MainPlugin main){
		this.main = main;
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if(cmd.getName().equalsIgnoreCase("rank")) {
    		if(sender.hasPermission("rank.admin")) {
    			if(args.length == 0) {
    				sender.sendMessage("");
    				sender.sendMessage("§6§lELECT§e§lRONICA §b§lRangos §7§oLista de comandos");
    				sender.sendMessage("");
    	    		sender.sendMessage("§f- /rank list");
    	    		sender.sendMessage("§f- /rank set <jugador> <rango>");
    				sender.sendMessage("");	
    			}
    			else if(args.length == 1) {
    				if(args[0].equalsIgnoreCase("list")) {
    					sender.sendMessage("");
    					sender.sendMessage("§6§lELECT§e§lRONICA §b§lRangos §7§oInformacion");
    					sender.sendMessage("");
    					sender.sendMessage("§e§l» §7§lUSUARIO§f: Permite observar, no puede construir ni destruir.");
    					sender.sendMessage("§e§l» §c§lADMIN§f: Todos los permisos.");
    					sender.sendMessage("§e§l» §4§lPROFESOR§f: Rango para el profesor.");
    					sender.sendMessage("");
    				}
    			}	
    		}
    	}
        return true;
    }
    
    public String getPlayerRank(Player p) {
    	String r = "";
    	if(p.hasPermission("")) return "a";
		return r;
    }

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		for(Player p: Bukkit.getOnlinePlayers()) {
			Scoreboard board = p.getScoreboard();
			Team t = board.getTeam(getPlayerRank(p));
	    			  
			if(t == null){
				t = board.registerNewTeam(getPlayerRank(p));  
			}
	    		  
			t.setPrefix(getPlayerRank(p));
	    	
			if(!t.hasPlayer(p)) {
				t.addPlayer(p);
			}
		}
	}
	
}