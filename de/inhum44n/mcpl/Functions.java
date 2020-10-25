package de.inhum44n.mcpl;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import de.inhum44n.mcpl.main.Main;

public class Functions {
	
	public static String ServerPrefix() {
		return ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + Main.getPlugin().getConfig().getString("ServerName") + ChatColor.DARK_AQUA + "]";
	}
	
	public static String MakeList(String[] list, ChatColor Color, ChatColor SeperatorColor) {
		String s = "";
		for (int i=0;i<list.length;i++) {
			s = s + Color + list[i];
			if (list.length>i+1) {
				s = s + SeperatorColor + ", ";
			}
		}
		return s;
	}
	
	public static void sendMessage(Player p, String s) {
		p.sendMessage(ServerPrefix() + " " + s);
	}
}
