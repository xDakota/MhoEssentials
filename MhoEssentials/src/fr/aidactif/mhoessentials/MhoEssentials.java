package fr.aidactif.mhoessentials;

import java.io.File;
import java.util.Iterator;

import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import fr.aidactif.mhoessentials.command.*;
import fr.aidactif.mhoessentials.event.*;

public class MhoEssentials extends JavaPlugin {
    /**private final PlayerListener playerListener = new PlayerListener(this);**/
	private final EnchantListener enchantListener = new EnchantListener(this);
	private final PortalListener portalListener = new PortalListener(this);
	private final OnDeathListener onDeathListener = new OnDeathListener(this);
	private final ChatListener chatListener = new ChatListener(this);
	private final NpcWandListener npcWandListener = new NpcWandListener(this);
    
    @Override
    public void onEnable() {
        getLogger().info("[MhoEssentials] Activation de MhoEssentials.");

        /**Config**/
        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
        }
        
    	/**Event**/
        PluginManager pm = getServer().getPluginManager();
        /**pm.registerEvents(playerListener, this);**/
        pm.registerEvents(enchantListener, this);
        pm.registerEvents(portalListener, this);
        pm.registerEvents(onDeathListener, this);
        pm.registerEvents(chatListener, this);
        pm.registerEvents(npcWandListener, this);

        /**Commande**/
        getCommand("mho").setExecutor(new MhoCommand());
        getCommand("ici").setExecutor(new IciCommand(this));
        getCommand("taunt").setExecutor(new TauntCommand(this));
        getCommand("played").setExecutor(new PlayCommand());
        getCommand("aide").setExecutor(new AideCommand());
        getCommand("chat").setExecutor(new ChatCommand(this));
        
        /**Recipe remove**/
        Iterator<Recipe> recipes = getServer().recipeIterator();
        Recipe recipe;
        while(recipes.hasNext())
        {
            recipe = recipes.next();
            	if(recipe != null && recipe.getResult().getTypeId() == 46) {
            		recipes.remove();
            	}
            	if(recipe != null && recipe.getResult().getTypeId() == 116) {
            		recipes.remove();
            	}
               	if(recipe != null && recipe.getResult().getTypeId() == 145) {
               		recipes.remove();
               	}
               	if(recipe != null && recipe.getResult().getTypeId() == 373) {
               		recipes.remove();
               	}
               	if(recipe != null && recipe.getResult().getTypeId() == 381) {
               		recipes.remove();
               	}
               	if(recipe != null && recipe.getResult().getTypeId() == 900) {
               		recipes.remove();
               	}
               	if(recipe != null && recipe.getResult().getTypeId() == 904) {
               		recipes.remove();
               	}
               	if(recipe != null && recipe.getResult().getTypeId() == 9029) {
               		recipes.remove();
               	}
               	if(recipe != null && recipe.getResult().getTypeId() >= 9114 && recipe.getResult().getTypeId() <= 9133) {
               		recipes.remove();
               	}
        }
    }
    
    @Override
    public void onDisable() {	
    	getLogger().info("[MhoEssentials] Desactivation de MhoEssentials.");
    }

}
