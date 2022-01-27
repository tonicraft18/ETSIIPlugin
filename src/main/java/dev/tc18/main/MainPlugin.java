package dev.tc18.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class MainPlugin extends JavaPlugin {

    @Override
    public void onEnable(){
        Bukkit.broadcastMessage("All systems online :)");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player p = (Player) sender;
        if(command.getName().equalsIgnoreCase("info")){
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "[ Información del Servidor ]\n"+
            ChatColor.RESET+"Este servidor es posible gracias a los alumnos de 1º Software A 21-22"+
            ", un profesor de Fundamentos de Electrónica y la "+ChatColor.BLUE+" Universidad de Málaga."+
            ChatColor.RESET + ChatColor.LIGHT_PURPLE + "\nEste servidor recrea una práctica de la"+
            " asignatura Fundamentos de Electrónica, más una Unidad Aritmetico-Lógica, en Minecraft con la lógica"+
            " implementada dentro de este juego. Este proyecto está explicado en el siguiente video de "+
            ChatColor.RESET + "You" + ChatColor.RED + "Tube" + ChatColor.LIGHT_PURPLE + ": <link>\n\n"+
            ChatColor.GREEN + ChatColor.BOLD + "[ Redes Sociales ]");
        }
        if(command.getName().equalsIgnoreCase("rank")){
            if(p.getName() == "ant22031" || p.getName() == "alers16" || p.getName() == "ElGamesHD" || p.getName() == "Tonicraft18"){
                if(!args[0].equals("")){
                    p.setDisplayName(ChatColor.GOLD + "" +ChatColor.BOLD + "[" + args[0] + "]" + ChatColor.RESET + "" + ChatColor.GOLD + p.getName());
                }
            }else{
                p.sendMessage(ChatColor.RED + "No tienes permiso para usar este comando.");
            }
        }
        return true;
    }

}