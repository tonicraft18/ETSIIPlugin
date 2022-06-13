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

import java.util.HashMap;
import java.util.Map;

public class Login implements Listener, CommandExecutor{
    
    private Map<String,String> uspss;
	private Map<String,Location> usloc;

	public Login(){
		usloc = new HashMap<>();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		Player p = (Player) sender;
		if(command.getName().equalsIgnoreCase("login")){
			boolean exists = uspss.containsKey(p.getName());
            if(exists){
                if(args[0].equals(uspss.get(p.getName()))){
					p.setOp(true);
					p.sendMessage("§aSe ha logueado correctamente");
					p.teleport(usloc.get(p.getName()));
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

	public void setMap(Map<String,String> map){
		uspss = map;
	}

    @EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = (Player) event.getPlayer();
		boolean exists = uspss.containsKey(p.getName());
		p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999999, 255));
		if(p.hasPermission("rank.admin")){
			p.setOp(false);
			usloc.put(p.getName(), p.getLocation());
			p.teleport(new Location(p.getWorld(),8, 128, -73));
            p.setGameMode(GameMode.ADVENTURE);
			if(!exists){
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission unset rank.admin");
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission unset rank.profesor");
				p.kickPlayer("§cNo se ha podido verificar su nombre");
			}
		}
		if(exists){
			p.sendMessage("\n\n§aIniciar Sesión: /login <password>");
		}
		
	}
} 
