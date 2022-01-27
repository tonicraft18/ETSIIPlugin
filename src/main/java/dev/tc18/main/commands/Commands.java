package dev.tc18.main.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


//   -- No se está utilizando actualmente --
public class Commands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        switch(command.getName()){
            case "info": {
                p.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Información del servidor");
            }
            case "nick": {
                if(p.getName() == "ant22031" || p.getName() == "ElGamesHD" || p.getName() == "alers16" || p.getName() == "Tonicraft18"){
                    if(!args[0].isEmpty()){
                        p.setDisplayName(ChatColor.GOLD +""+ ChatColor.BOLD +"[" + args[0] + "]" +  ChatColor.RESET + "" + ChatColor.GOLD + p.getName());
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "No tiene permisos para ejecutar ese comando");
                }
            }
        }
        return true;
    }
}
