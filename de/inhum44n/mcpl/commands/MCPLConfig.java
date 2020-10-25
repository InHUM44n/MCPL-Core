package de.inhum44n.mcpl.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.inhum44n.mcpl.Functions;
import de.inhum44n.mcpl.main.Main;

public class MCPLConfig implements CommandExecutor{
	
	String permission = "mcpl.config";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission(permission)) {
			if (args.length>0) {
				switch(args[0].toUpperCase()) {
				
				case "SETSKYPVPWORLD":
					if (sender instanceof Player) {
						Player p = (Player) sender;
						FileConfiguration config = Main.getPlugin().getConfig();
						config.set("SkyPvP.World", p.getWorld().getName());
						Main.getPlugin().saveConfig();
						Functions.sendMessage(p, ChatColor.DARK_GREEN + p.getWorld().getName() + ChatColor.GREEN + " is now the SkyPvP world");
					}
					break;
					
				case "SERVERNAME":
					if (args.length==2) {
						Main.getPlugin().getConfig().set("ServerName", args[1]);
						Main.getPlugin().saveConfig();
						sender.sendMessage("set to " + args[1]);
					} else {
						Functions.sendMessage((Player) sender, ChatColor.RED + "Usage: /mcpl servername <name>");
					}
					break;
					
				default:
					sender.sendMessage(Functions.ServerPrefix() + " " + ChatColor.RED + "Valid settings: " + Functions.MakeList(new String[] {"setskypvpworld", "servername"}, ChatColor.DARK_RED, ChatColor.RED));
					
				}
				
			} else {
				sender.sendMessage(Functions.ServerPrefix() + " " + ChatColor.RED + "Valid settings: " + Functions.MakeList(new String[] {"setskypvpworld", "servername"}, ChatColor.DARK_RED, ChatColor.RED));
			}
		} else {
			Functions.sendMessage((Player) sender, ChatColor.RED + "Missing Permission: " + ChatColor.WHITE + "\"" + ChatColor.DARK_RED + permission + ChatColor.WHITE + "\"");
		}
		return false;
	}

}
