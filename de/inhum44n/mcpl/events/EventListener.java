package de.inhum44n.mcpl.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage(ChatColor.AQUA + e.getPlayer().getName() + ChatColor.DARK_BLUE + " joined the Server.");
	}
}
