package de.inhum44n.mcpl;

import org.bukkit.ChatColor;

public class Functions {
	
	public String MakeList(String[] list, ChatColor Color, ChatColor SeperatorColor) {
		String s = "";
		for (int i=0;i<list.length;i++) {
			s = s + Color + list[i];
			if (list.length>i+1) {
				s = s + SeperatorColor + ", ";
			}
		}
		return s;
	}
}
