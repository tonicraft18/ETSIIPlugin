package dev.tc18.main.rankSystem;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
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
    				else if(args[0].equalsIgnoreCase("set")) {
    					sender.sendMessage("§e§l>> §fUso correcto: §b/rank set <jugador> <rango>");
    				}
    			}
    			else if(args.length == 2) {
    				sender.sendMessage("§e§l>> §fUso correcto: §b/rank set " + args[1] + " <rango>");
    			}
    			else if(args.length == 3) {
    				if(Bukkit.getServer().getPlayer(args[1]) == null) sender.sendMessage("§c§l>> §4El jugador §n" + args[1] + "§r§4 no está conectado.");
    				else {
    					Player p = (Player) Bukkit.getServer().getPlayer(args[1]);
    					if(args[2].equalsIgnoreCase("usuario")) {

    					}	
    				}
    			}
    		}
    	}
        return true;
    }
    
    public String getPlayerRank(Player p) {
    	String r = "§7§lUSUARIO";
    	
    	if(p.hasPermission("rank.admin")) {
    		r = "§c§lADMIN";
    		if(p.hasPermission("rank.profesor")) {
    			r = "§4§lPROFESOR";
    		}
    	}
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