package fr.aidactif.mhoessentials.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.noise.NoiseGenerator;

import fr.aidactif.mhoessentials.MhoEssentials;

public class IciCommand implements CommandExecutor {
	
	MhoEssentials plugin;
	public IciCommand(MhoEssentials instance) {
		plugin = instance;
	}
	
    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        
        /**data**/
        Player player = (Player) sender;
        Location location = player.getLocation();
        String username = player.getName();
        
		String worldname = player.getLocation().getWorld().getName();			
        String worldnameresult;
        switch(worldname)
        {
            case "world":
            	worldnameresult = plugin.getConfig().getString("MhoEssentials.Messages.world");
            break;
            case "world_donjon":
            	worldnameresult = plugin.getConfig().getString("MhoEssentials.Messages.world_donjon");
            break;
            case "world_mine":
            	worldnameresult = plugin.getConfig().getString("MhoEssentials.Messages.world_mine");
            break;
            default:
            	worldnameresult = plugin.getConfig().getString("MhoEssentials.Messages.world_other");
            break;
        }
        
        /**ici**/
        if (split.length == 0) {
            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "[" + username + "]" + ChatColor.WHITE + " Ma position " + worldnameresult + " : " + NoiseGenerator.floor(location.getX()) +", " + NoiseGenerator.floor(location.getY()) + ", " + NoiseGenerator.floor(location.getZ()));
            return true;
        }
        
        /**ici player**/
        Player sendplayer = Bukkit.getPlayer(split[0]);
    	String sendusername = sendplayer.getName();

        if (sendplayer == null || (sender instanceof Player && !((Player) sender).canSee(sendplayer))) {
        	sender.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + plugin.getConfig().getString("MhoEssentials.Messages.unknow_pseudo"));
        } 
        else {
        	StringBuilder message = new StringBuilder();
  
        	for (int i = 1; i < split.length; i++) {
        		if (i > 1) message.append(" ");
        		message.append(split[i]);
        	}
        	
        	String result = ChatColor.GREEN + "[" + username + "]" + ChatColor.WHITE + " Ma position " + worldnameresult + " : " + NoiseGenerator.floor(location.getX()) +", " + NoiseGenerator.floor(location.getY()) + ", " + NoiseGenerator.floor(location.getZ());
        	sendplayer.sendMessage(result);
        	sender.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + " Vous avez envoyé votre position à " + sendusername);
            return true;
         }

		return false;
    }
}
