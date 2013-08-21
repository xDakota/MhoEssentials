package fr.aidactif.mhoessentials.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.aidactif.mhoessentials.MhoEssentials;

public class ChatListener implements Listener {
    private final MhoEssentials plugin;

	public ChatListener(MhoEssentials instance) {
		plugin = instance;
	}

    public static boolean toggle;
    
    private void chatEvil(Player player) {
		player.damage(1);
		if (player.isDead()) {
			Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "[Chat] " + ChatColor.WHITE + player.getName() + plugin.getConfig().getString("MhoEssentials.Messages.chat_dead"));
		} 
		else {
			player.sendMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_nodead"));
		}
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if (toggle == true) {
			if (!player.hasPermission("mhoessentials.chatbypass")) {
				if (plugin.getConfig().getString("MhoEssentials.Chat.chatstatut").equalsIgnoreCase("chatevil")) {
					chatEvil(player);
				}
				player.sendMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_disable"));
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		if (toggle == true) {
			if (!player.hasPermission("mhoessentials.chatbypass")) {
				String message = event.getMessage().toLowerCase();
				if (message.contains("/taunt")) {
					if (plugin.getConfig().getString("MhoEssentials.Chat.chatstatut").equalsIgnoreCase("chatevil")) {
						chatEvil(player);
					}
					player.sendMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_disable"));
					event.setCancelled(true);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (toggle == true) {
			player.sendMessage(ChatColor.GREEN + "[Chat]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.chat_disable_join"));
		}
	}
    
}
