package de.inhum44n.mcpl.commands.itemactions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClearLore implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String permission = "mcpl.addlore";
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission(permission)) {
				if (p.getItemInHand().getType()!=Material.AIR) {
					ItemStack is = p.getItemInHand();
					ItemMeta im = is.getItemMeta();
					im.setLore(null);
					is.setItemMeta(im);
					p.setItemInHand(is);
					p.sendMessage(ChatColor.GREEN + "Cleared the Lore on that item.");
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
