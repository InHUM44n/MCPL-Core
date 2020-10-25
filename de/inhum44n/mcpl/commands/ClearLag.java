package de.inhum44n.mcpl.commands;

import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import de.inhum44n.mcpl.Functions;

public class ClearLag implements CommandExecutor{
	
	String permission = "mcpl.clearlag";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission(permission)) {
				int deletedItems = 0;
				List<Entity> list = p.getWorld().getEntities();
				Iterator<Entity> entities = list.iterator();
				while (entities.hasNext()) {
				    Entity entity = entities.next();
				    if (entity instanceof Item) {
				        entity.remove();
				        deletedItems++;
				    }
				}
				Bukkit.getServer().broadcastMessage(Functions.ServerPrefix() + " " + ChatColor.DARK_GREEN + Integer.toString(deletedItems) + ChatColor.GREEN + " items have been removed from the ground");
			} else {
				Functions.sendMessage(p, ChatColor.RED + "Missing Permission: " + ChatColor.WHITE + "\"" + ChatColor.DARK_RED + permission + ChatColor.WHITE + "\"");
			}
		}
		return false;
	}

}
