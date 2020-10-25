package de.inhum44n.mcpl.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.inhum44n.mcpl.Functions;

public class Heal implements CommandExecutor{
	
	String permission = "mcpl.heal";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission(permission)) {
				p.setHealth(20);
				p.setFoodLevel(20);
				p.setSaturation(20);
				p.sendMessage(ChatColor.GREEN + "There you go.");
			} else {
				Functions.sendMessage(p, ChatColor.RED + "Missing Permission: " + ChatColor.WHITE + "\"" + ChatColor.DARK_RED + permission + ChatColor.WHITE + "\"");
			}
		}
		return false;
	}

}
