package de.inhum44n.mcpl.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.inhum44n.mcpl.Functions;

public class ClearChat implements CommandExecutor{
	
	String permission = "mcpl.clearchat";
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		if (sender.hasPermission(permission)) {
			for (int i=0;i<100;i++) {
				for (Player p : Bukkit.getOnlinePlayers()) {
					p.sendMessage("");
				}
			}
			for (Player p : Bukkit.getOnlinePlayers()) {
				Functions.sendMessage(p, ChatColor.AQUA + "Chat Cleared by " + ChatColor.RED + sender.getName());
			}
		} else {
			Functions.sendMessage((Player) sender, ChatColor.RED + "Missing Permission: " + ChatColor.WHITE + "\"" + ChatColor.DARK_RED + permission + ChatColor.WHITE + "\"");
		}
		return false;
	}

}
