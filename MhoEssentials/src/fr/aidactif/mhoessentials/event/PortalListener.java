package fr.aidactif.mhoessentials.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

import fr.aidactif.mhoessentials.MhoEssentials;

public class PortalListener implements Listener {
    private final MhoEssentials plugin;

    public PortalListener(MhoEssentials instance) {
        plugin = instance;
    }

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPortalCreate(PortalCreateEvent event) {
		event.setCancelled(true);
	}

}
