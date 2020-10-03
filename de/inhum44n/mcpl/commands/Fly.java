package de.inhum44n.mcpl.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Fly implements CommandExecutor{
	
	String permission = "mcpl.fly";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission(permission)) {
				if (!p.getAllowFlight()) {
					p.setAllowFlight(true);
					p.sendMessage(ChatColor.GREEN + "You can now fly.");
				} else {
					p.setAllowFlight(false);
					p.sendMessage(ChatColor.GREEN + "You can't fly anymore.");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Umm... no.");
				p.sendMessage(ChatColor.WHITE + "Missing Permission: " + ChatColor.WHITE + "\"" + ChatColor.DARK_RED + permission + ChatColor.WHITE + "\"");
			}
		}
		return false;
	}
	
}
