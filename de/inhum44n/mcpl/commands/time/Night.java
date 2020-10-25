package de.inhum44n.mcpl.commands.time;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.inhum44n.mcpl.Functions;

public class Night  implements CommandExecutor{
	
	String permission = "mcpl.time";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission(permission)) {
				p.getWorld().setTime(13000);
				Functions.sendMessage(p, ChatColor.GREEN + "Time set to " + ChatColor.DARK_GREEN + "NIGHT" + ChatColor.GREEN + ".");
			} else {
				Functions.sendMessage(p, ChatColor.RED + "Missing Permission: " + ChatColor.WHITE + "\"" + ChatColor.DARK_RED + permission + ChatColor.WHITE + "\"");
			}
		}
		return false;
	}
}
