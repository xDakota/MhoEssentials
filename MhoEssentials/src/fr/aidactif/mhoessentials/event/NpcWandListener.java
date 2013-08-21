package fr.aidactif.mhoessentials.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.aidactif.mhoessentials.MhoEssentials;

public class NpcWandListener implements Listener {
    private final MhoEssentials plugin;

    public NpcWandListener(MhoEssentials instance) {
        plugin = instance;
    }

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if(!player.hasPermission("mhoessentials.npcbypass")) {
			if(player.getItemInHand().getTypeId() == 30940 && (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
				player.getInventory().remove(272);
				event.setCancelled(true);
			}
			if(player.getItemInHand().getTypeId() == 30941 && (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
				player.getInventory().remove(30941);
				event.setCancelled(true);
			}
			if(player.getItemInHand().getTypeId() == 30942 && (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
				player.getInventory().remove(30942);
				event.setCancelled(true);
			}
		}
	}

}
