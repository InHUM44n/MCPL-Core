package de.inhum44n.mcpl.commands.itemactions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Rename implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String permission = "mcpl.rename";
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission(permission)) {
				if (p.getItemInHand().getType()!=Material.AIR) {
					if (args.length>0) {
						String itemname = "§r";
						for (int i=0;i<args.length;i++) {
							itemname = itemname + args[i];
							if (args.length>i+1) {
								itemname = itemname + " ";
							}
						}
						
						ItemStack is = p.getItemInHand();
						ItemMeta im = is.getItemMeta();
						im.setDisplayName(itemname);
						is.setItemMeta(im);
						p.setItemInHand(is);
						p.sendMessage(ChatColor.GREEN + "The item in your hand was renamed to " + ChatColor.RESET + itemname + ChatColor.GREEN + ".");
					} else {
						p.sendMessage(ChatColor.RED + "Please add a name for the item");
					}
				} else {
					p.sendMessage(ChatColor.RED + "Must be holding an item.");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Umm... no.");
				p.sendMessage(ChatColor.WHITE + "Missing Permission: " + ChatColor.WHITE + "\"" + ChatColor.DARK_RED + permission + ChatColor.WHITE + "\"");
			}
		}
		return false;
	}

}
