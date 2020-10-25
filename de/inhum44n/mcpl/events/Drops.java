package de.inhum44n.mcpl.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.inhum44n.mcpl.main.Main;

public class Drops implements Listener{
	
	FileConfiguration config = Main.getPlugin().getConfig();
	
	@EventHandler
	public void onMobDeath(EntityDeathEvent e) {
		String world=(String) config.getString("SkyPvP.World");
		if (e.getEntity().getWorld().getName().equals(world)) {
			switch(e.getEntity().getType()) {
			
			case ZOMBIE:
				ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(ChatColor.GRAY + "Silver");
				item.setItemMeta(meta);
				e.getDrops().clear();
				e.getDrops().add(item);
				break;
				
			default:
				break;
				
			}
		}
	}
	
}
