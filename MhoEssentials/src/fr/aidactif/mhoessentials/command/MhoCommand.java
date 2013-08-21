package fr.aidactif.mhoessentials.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MhoCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        
        Player player = (Player) sender;
        String version = Bukkit.getPluginManager().getPlugin("MhoEssentials").getDescription().getVersion();
        
        if (split.length == 0) {
            player.sendMessage(ChatColor.GREEN + "[MhoEssentials]" + ChatColor.WHITE + " par xDakota - Version " + version + " - Commandes disponibles :");
            player.sendMessage(ChatColor.WHITE + "/ici - Envoi dans le chat global votre position.");
            player.sendMessage(ChatColor.WHITE + "/ici <player> - Envoi en priv� votre position � <player>.");
            player.sendMessage(ChatColor.WHITE + "/taunt - Envoi dans le chat global un taunt.");
            player.sendMessage(ChatColor.WHITE + "/taunt <player> - Envoi en priv� un taunt � <player>.");
            player.sendMessage(ChatColor.WHITE + "/played - Vous donne votre temps de connexion depuis la derni�re.");
            return true;
        }
        else {
            return false;
        }
    }
}
