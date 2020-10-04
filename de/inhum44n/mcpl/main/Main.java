package de.inhum44n.mcpl.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.inhum44n.mcpl.commands.ClearChat;
import de.inhum44n.mcpl.commands.ClearLag;
import de.inhum44n.mcpl.commands.Fly;
import de.inhum44n.mcpl.commands.Heal;
import de.inhum44n.mcpl.commands.MCPLConfig;
import de.inhum44n.mcpl.commands.Skull;
import de.inhum44n.mcpl.commands.itemactions.AddLore;
import de.inhum44n.mcpl.commands.itemactions.ClearLore;
import de.inhum44n.mcpl.commands.itemactions.Rename;
import de.inhum44n.mcpl.commands.time.Day;
import de.inhum44n.mcpl.commands.time.Night;
import de.inhum44n.mcpl.events.EventListener;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.MinecraftServer;

public class Main extends JavaPlugin{
	public void onEnable() {
		MinecraftServer.getServer().setMotd(ChatColor.DARK_AQUA + "InHUM44n's " + ChatColor.AQUA + "Test Server");
		getCommand("heal").setExecutor(new Heal());
		getCommand("cc").setExecutor(new ClearChat());
		getCommand("fly").setExecutor(new Fly());
		getCommand("cl").setExecutor(new ClearLag());
		getCommand("rn").setExecutor(new Rename());
		getCommand("al").setExecutor(new AddLore());
		getCommand("cll").setExecutor(new ClearLore());
		getCommand("skull").setExecutor(new Skull());
		getCommand("day").setExecutor(new Day());
		getCommand("night").setExecutor(new Night());
		getCommand("mcpl").setExecutor(new MCPLConfig());
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new EventListener(), this);
	}
}
