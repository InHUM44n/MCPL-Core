package de.inhum44n.mcpl.commands.itemactions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddLore implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String permission = "mcpl.addlore";
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission(permission)) {
				if (p.getItemInHand().getType()!=Material.AIR) {
					if (args.length>0) {
						String newlore = "§r";
						for (int i=0;i<args.length;i++) {
							newlore = newlore + args[i];
							if (args.length>i+1) {
								newlore = newlore + " ";
							}
						}
						
						ItemStack is = p.getItemInHand();
						ItemMeta im = is.getItemMeta();
						
						if (im.getLore()!=null) {
							List<String> LoreList = im.getLore();
							LoreList.add(newlore);
							im.setLore(LoreList);
						} else {
							List<String> NewLoreList = new ArrayList<>();
							NewLoreList.add(newlore);
							im.setLore(NewLoreList);
						}
						is.setItemMeta(im);
						p.setItemInHand(is);
						p.sendMessage(ChatColor.GREEN + "Added Item Lore: " + ChatColor.RESET + newlore + ChatColor.GREEN + ".");
					} else {
						p.sendMessage(ChatColor.RED + "Please add more Arguments");
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
