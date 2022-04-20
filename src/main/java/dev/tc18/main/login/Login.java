package dev.tc18.main.login;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Login implements Listener, CommandExecutor{
    
    private String[][] matriz = {{"ElGamesHD","alers16","ant22031","Tonicraft18","TeuTue","_alexcorbacho"},
    {"logi1243","romano2","caniete","jajayoxd","electronica101","corbayaeger"}};
	private Location l;

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		Player p = (Player) sender;
		if(command.getName().equalsIgnoreCase("login")){
			int pos = SearchName(matriz, p);
            if(pos > -1){
                if(args[0].equals(matriz[1][pos])){
					p.setOp(true);
					p.sendMessage("§aSe ha logueado correctamente");
					p.teleport(l);
					p.setGameMode(GameMode.CREATIVE);
				}else{
					p.sendMessage("§cLa contraseña es errónea, inténtelo de nuevo");
				}
            }else{
                p.sendMessage("§cNo tienes permiso para usar este comando.");
            }
        }
		return true;
	}

	private int SearchName(String[][] matriz,Player p){
		int i=0;
		
		while(i < matriz[0].length && !p.getName().equals(matriz[0][i])){
			i++;
		}

		if (i == matriz[0].length){
			i = -1;
		}
		return i;
	}


    @EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = (Player) event.getPlayer();
		int index = SearchName(matriz, p);
		p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999999, 255));
		if(p.hasPermission("rank.admin")){
			p.setOp(false);
			l = p.getLocation();
			p.teleport(new Location(p.getWorld(),8, 128, -73));
            p.setGameMode(GameMode.ADVENTURE);
			if(index == -1){
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission unset rank.admin");
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission unset rank.profesor");
				p.kickPlayer("§cNo se ha podido verificar su nombre");
			}
		}
		if(index > -1){
			p.sendMessage("\n\n§aIniciar Sesión: /login <password>");
		}
		
	}
} 
