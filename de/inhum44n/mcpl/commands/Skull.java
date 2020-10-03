package de.inhum44n.mcpl.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Skull implements CommandExecutor{
	
	String permission = "mcpl.skull";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission(permission)) {
				if (args.length==1) {
					ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
					SkullMeta sm = (SkullMeta) is.getItemMeta();
					sm.setOwner(args[0]);
					is.setItemMeta(sm);
					p.getInventory().addItem(is);
				} else {
					p.sendMessage(ChatColor.DARK_RED + "No " + ChatColor.RED + "or " + ChatColor.DARK_RED + "too many " + ChatColor.RED + "arguments.");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Umm... no.");
				p.sendMessage(ChatColor.WHITE + "Missing Permission: " + ChatColor.WHITE + "\"" + ChatColor.DARK_RED + permission + ChatColor.WHITE + "\"");
			}
		}
		return false;
	}
}
