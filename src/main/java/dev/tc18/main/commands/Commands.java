package dev.tc18.main.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.tc18.main.MainPlugin;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        switch(command.toString()){
            case "info": {
                p.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Información del servidor");
            }
            case "nick": {
                if(p.getName() == "ant22031" || p.getName() == "ElGamesHD" || p.getName() == "alers16" || p.getName() == "Tonicraft18"){
                    if(!args[0].isEmpty()){
                        p.setDisplayName("putilla barata");
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "No tiene permisos para ejecutar ese comando");
                }
            }
        }
        return true;
    }
}
