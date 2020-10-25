package de.inhum44n.mcpl.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.inhum44n.mcpl.Functions;

public class Fly implements CommandExecutor{
	
	String permission = "mcpl.fly";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission(permission)) {
				if (!p.getAllowFlight()) {
					p.setAllowFlight(true);
					Functions.sendMessage(p, ChatColor.GREEN + "You can now fly.");
				} else {
					p.setAllowFlight(false);
					Functions.sendMessage(p, ChatColor.GREEN + "You can't fly anymore.");
				}
			} else {
				Functions.sendMessage(p, ChatColor.RED + "Missing Permission: " + ChatColor.WHITE + "\"" + ChatColor.DARK_RED + permission + ChatColor.WHITE + "\"");
			}
		}
		return false;
	}
	
}
