package fr.aidactif.mhoessentials.command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.aidactif.mhoessentials.MhoEssentials;
import fr.aidactif.mhoessentials.util.Cooldowns;

public class TauntCommand implements CommandExecutor {
	
	MhoEssentials plugin;
	public TauntCommand(MhoEssentials instance) {
		plugin = instance;
	}
	
    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        
        /**Data**/
    	Player player = (Player) sender;
    	String username = player.getName();
    	int cooldown_taunt = plugin.getConfig().getInt("MhoEssentials.Cooldowns.cooldown_taunt");

    	
    	List<String> r_taunt = new LinkedList<String>();
        r_taunt.add("Espèce de moche !");
        r_taunt.add("C'est moi le meilleur !");
        r_taunt.add("Dans ton cube !");
        r_taunt.add("Va te faire cuire un cube !");
        
        Random rand = new Random();
        int choice = rand.nextInt(r_taunt.size());
    	
    	/**List<String> taunt = plugin.getConfig().getStringList("taunt");

    	Random rand = new Random();
    	String choice = taunt.get(rand.nextInt(taunt.size()));

    	taunt.get(choice)
    	Random rand = new Random();
        int choice = rand.nextInt(r_taunt.size());**/
    	
        /**Taunt**/
        if (split.length == 0) {
        	if (Cooldowns.tryCooldown(player, "Taunt", cooldown_taunt)) {
        		Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "[Taunt] " + ChatColor.WHITE + username + " dit : " + r_taunt.get(choice));
        		return true;
        	} 
        	else {
        		/** player.sendMessage("You have " + (Cooldowns.getCooldown(player, "MagicHand") / 1000) + " seconds left."); **/
        		player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.cooldown"));
        		return true;
        	}
        }
        
        /**taunt player**/
        Player sendplayer = Bukkit.getPlayer(split[0]);
    	String sendusername = sendplayer.getName();
    	int cooldown_taunt_player = plugin.getConfig().getInt("MhoEssentials.Cooldowns.cooldown_taunt_player");

        if (sendplayer == null || (sender instanceof Player && !((Player) sender).canSee(sendplayer))) {
        	sender.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.unknow_pseudo"));
        	return true;
        } 
        else { 
        	if (Cooldowns.tryCooldown(player, "TauntPlayer", cooldown_taunt_player)) {
            	String result = ChatColor.GREEN + "[Taunt] " + ChatColor.WHITE + username + " te dit : " + r_taunt.get(choice);
            	sendplayer.sendMessage(result);  
            	sender.sendMessage(ChatColor.GREEN + "[Taunt] " + ChatColor.WHITE + "Vous avez envoyé à " + sendusername + " : " + r_taunt.get(choice));
        		
        		/**Envoi au staff**/
        		for (Player staff : Bukkit.getOnlinePlayers()) {
        			if (staff.getPlayer().hasPermission("mhoessentials.seetaunt")) {
        				staff.sendMessage(ChatColor.GREEN + "[TauntInfo] " + ChatColor.WHITE + username + " a envoyé un taunt à " + sendusername);
        			}
        		}
        		
        	} else {
        		sender.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.cooldown"));
        	}
         }

		return false;
        	
    }
    
}
