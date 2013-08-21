package fr.aidactif.mhoessentials.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.noise.NoiseGenerator;

import fr.aidactif.mhoessentials.MhoEssentials;
import fr.aidactif.mhoessentials.event.ChatListener;

public class ChatCommand implements CommandExecutor {
		
	MhoEssentials plugin;
	public ChatCommand(MhoEssentials instance) {
		plugin = instance;
	}
		
    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        
        /**data**/
        Player player = (Player) sender;

        if (split.length == 0) {
        	if (player.hasPermission("mhoessentials.chat")) {
        		player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat"));
        		return true;
        	}
        	else {
        		player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.permission"));
        		return true;
        	}
        }
        
        String chatvalue = plugin.getConfig().getString("MhoEssentials.Chat.chatstatut");
        
        /**on**/
        if (split.length > 0 && split[0].equalsIgnoreCase("on")) {
        	if (player.hasPermission("mhoessentials.chat")) {
        		if (chatvalue.equalsIgnoreCase("chatoff")) {
        			ChatListener.toggle = true;
        			plugin.getConfig().set("MhoEssentials.Chat.chatstatut", "chaton");
                    Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_on"));
        		}
        		else if (chatvalue.equalsIgnoreCase("chaton")) {
        			player.sendMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_already_on"));
        		}
        		else if (chatvalue.equalsIgnoreCase("chatevil")) {
        			player.sendMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_already_evil"));
        		}
        		else {
        			player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_bug"));
        		}
        	}
        	else {
        		player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.permission"));	
        	}
        }
        /**off**/
        else if (split.length > 0 && split[0].equalsIgnoreCase("off")) {
        	if (player.hasPermission("mhoessentials.chat")) {
        		if (chatvalue.equalsIgnoreCase("chaton")) {
        			ChatListener.toggle = false;
        			plugin.getConfig().set("MhoEssentials.Chat.chatstatut", "chatoff");
        			Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_off"));
        		}
        		else if (chatvalue.equalsIgnoreCase("chatoff")) {
        			player.sendMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_already_off"));
        		}
        		else if (chatvalue.equalsIgnoreCase("chatevil")) {
        			ChatListener.toggle = false;
        			plugin.getConfig().set("MhoEssentials.Chat.chatstatut", "chatoff");
        			player.sendMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_off"));
        		}
        		else {
        			player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_bug"));
        		}
        	}
        	else {
        		player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.permission"));	
        	}
        }
        /**evil**/
        else if (split.length > 0 && split[0].equalsIgnoreCase("evil")) {
        	if (player.hasPermission("mhoessentials.chat")) {
        		if (chatvalue.equalsIgnoreCase("chatoff")) {
        			ChatListener.toggle = true;
        			plugin.getConfig().set("MhoEssentials.Chat.chatstatut", "chatevil");
        			Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_on"));
        		}
        		else if (chatvalue.equalsIgnoreCase("chatevil")) {
        			player.sendMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_already_evil"));
        		}
        		else if (chatvalue.equalsIgnoreCase("chaton")) {
        			plugin.getConfig().set("MhoEssentials.Chat.chatstatut", "chatoff");
        			player.sendMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_already_on"));
        		}
        		else {
        			player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_bug"));
        		}
        	}
        	else {
        		player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.permission"));	
        	}
        }
        /**autre**/
        else {
        	if (player.hasPermission("mhoessentials.chat")) {
        		player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat"));
        	}
        	else {
        		player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.permission"));	
        	}
        }

		return false;
    }
}
