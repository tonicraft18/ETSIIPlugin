package dev.tc18.main.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.tc18.main.MainPlugin;

public class Commands implements CommandExecutor {

    private MainPlugin main;

    public Commands(MainPlugin main){
        this.main = main;
    }

    public void tp(Player p,double x,double y,double z){
        p.teleport(new Location(p.getWorld(), x, y, z));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(command.getName().equalsIgnoreCase("info")){
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "[ Información del Servidor ]\n"+
            ChatColor.RESET+"Este servidor es posible gracias a los alumnos de 1º Software A 21-22"+
            ", un profesor de Fundamentos de Electrónica y la "+ChatColor.BLUE+" Universidad de Málaga."+
            ChatColor.RESET + ChatColor.LIGHT_PURPLE + "\nEste servidor recrea una práctica de la"+
            " asignatura Fundamentos de Electrónica, más una Unidad Aritmetico-Lógica, en Minecraft con la lógica"+
            " implementada dentro de este juego. Este proyecto está explicado en el siguiente video de "+
            ChatColor.RESET + "You" + ChatColor.RED + "Tube" + ChatColor.LIGHT_PURPLE + ": <link>\n\n"+
            ChatColor.GREEN + ChatColor.BOLD + "\t- ETSIIPlugin");
        }

        //coordenadas provisionaless

        if(command.getName().equalsIgnoreCase("go")){
            if(!args[0].equalsIgnoreCase("")){
                if(args[0].equalsIgnoreCase("7-seg")){
                    tp(p,79,-52,-24);
                }else if(args[0].equalsIgnoreCase("alu")){
                    tp(p,57,-60,-72);
                }else if(args[0].equalsIgnoreCase("14-seg")){
                    tp(p,-51,-60,3);
                }else if(args[0].equalsIgnoreCase("grefg")){
                    p.sendMessage("§4Mira esto... §9§nhttps://www.youtube.com/watch?v=tvoh8bVTLUQ");
                }else{
                    p.sendMessage("§cArgumento del comando \"/go\" no válido");
                }
            }else{
                p.sendMessage("§cNo se ha podido ejecutar el comando");
            }
        }
        return true;
    }
}
