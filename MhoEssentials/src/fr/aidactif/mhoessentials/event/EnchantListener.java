package fr.aidactif.mhoessentials.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

import fr.aidactif.mhoessentials.MhoEssentials;

public class EnchantListener implements Listener {
    private final MhoEssentials plugin;

    public EnchantListener(MhoEssentials instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
	public void onEnchantItem(EnchantItemEvent event) {
		Player player = event.getEnchanter();
		boolean cancel = false;
		if (!player.hasPermission("mhoessentials.enchantbypass")) {
			player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.enchant"));
			cancel = true;
		}
		if (cancel) {
			event.setCancelled(true);
		}
	}

}
