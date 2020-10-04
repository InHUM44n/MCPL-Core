package de.inhum44n.mcpl.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.inhum44n.mcpl.Functions;

public class MCPLConfig implements CommandExecutor{
	
	String permission = "mcpl.config";
	
	Functions f = new Functions();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission(permission)) {
			switch(args[0]) {
			case "test":
				sender.sendMessage("Test: Setting changed");
				break;
			default:
				sender.sendMessage(ChatColor.RED + "Valid settings: " + f.MakeList(new String[] {"ErsteOption","ZweiteOption","DritteOption"}, ChatColor.DARK_RED, ChatColor.RED));
			}
		} else {
			sender.sendMessage(ChatColor.RED + "Umm... no.");
			sender.sendMessage(ChatColor.WHITE + "Missing Permission: " + ChatColor.WHITE + "\"" + ChatColor.DARK_RED + permission + ChatColor.WHITE + "\"");
		}
		return false;
	}

}
