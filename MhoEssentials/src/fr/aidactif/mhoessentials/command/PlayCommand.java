package fr.aidactif.mhoessentials.command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.noise.NoiseGenerator;

public class PlayCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        
        /**data**/
        Player player = (Player) sender;
        OfflinePlayer playeroff = (Player) sender;
        String username = player.getName();
        long time = System.currentTimeMillis() - playeroff.getLastPlayed();
        String seconde =""+ (time / 1000) % 60;
        String minute =""+ (time / (1000 * 60)) % 60;
        String heure = ""+(time / (1000 * 60 * 60)) % 24;

        /**play**/
        if (split.length == 0) {
            player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + " Connecté depuis " + heure + "h " + minute + "min " + seconde + "sec.");
            return true;
        }

		return false;
    }
}
