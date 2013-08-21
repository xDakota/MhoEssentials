package fr.aidactif.mhoessentials.event;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import fr.aidactif.mhoessentials.MhoEssentials;

public class OnDeathListener implements Listener {
    private final MhoEssentials plugin;

    public OnDeathListener(MhoEssentials instance) {
        plugin = instance;
    }

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerDie(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if (player.getGameMode() != GameMode.CREATIVE || player.hasPermission("mhoessentials.dropbypass") || !player.hasPermission("mhoessentials.nodrop")) {
			return;
		}
		event.getDrops().clear();
	}
}
