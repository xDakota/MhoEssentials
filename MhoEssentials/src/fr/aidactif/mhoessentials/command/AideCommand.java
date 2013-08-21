package fr.aidactif.mhoessentials.command;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AideCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        String username = player.getName();
        
        if (split.length == 0) {
        	sender.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + " Il manque votre demande d'aide !");
            return true;
        }
        
        /**Corps**/
        if (split.length > 0 ) {

            
        	sender.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + " Demande d'aide envoyé au staff.");
        	for (Player staff : Bukkit.getOnlinePlayers()) {
        		if (staff.getPlayer().hasPermission("mhoessentials.seeaide")) {
        			staff.sendMessage(ChatColor.GREEN + "[Aide] " + ChatColor.WHITE + username + " a envoyé : ");
        			return true;
        		}
        	}
        } 
        else {
            return false;
        }
		return false;
    }
}