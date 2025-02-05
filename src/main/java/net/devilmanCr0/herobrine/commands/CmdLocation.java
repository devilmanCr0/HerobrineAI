package net.devilmanCr0.herobrine.commands;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.devilmanCr0.herobrine.Herobrine;

public class CmdLocation extends SubCommand {

	public CmdLocation(Herobrine plugin, Logger log) {
		super(plugin, log);
	}

	@Override
	public boolean execute(Player player, String[] args) {		
		Location loc = plugin.HerobrineNPC.getBukkitEntity().getLocation();
		
		sendMessage(player, ChatColor.GREEN + "[Herobrine] Location - "
				+ "World: "+ loc.getWorld().getName()
				+ ", Coordinates: (" + (int) loc.getX() + ", " + (int) loc.getY() + ", " + (int) loc.getZ() + ")");
		
		return true;
	}

	@Override
	public String help() {
		return ChatColor.GREEN + "/herobrine location";
	}

	@Override
	public String helpDesc() {
		return ChatColor.GREEN + "Displays Herobrine's location";
	}

}
