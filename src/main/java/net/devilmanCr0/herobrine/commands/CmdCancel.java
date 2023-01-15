package net.devilmanCr0.herobrine.commands;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.devilmanCr0.herobrine.Herobrine;
import net.devilmanCr0.herobrine.AI.Core.CoreType;

public class CmdCancel extends SubCommand {

	public CmdCancel(Herobrine plugin, Logger log) {
		super(plugin, log);
	}

	@Override
	public boolean execute(Player player, String[] args) {
		
		plugin.getAICore().CancelTarget(CoreType.ANY);
		sendMessage(player, ChatColor.RED + "[Herobrine] The current Herobrine victim has been saved.");
		
		return true;
	}

	@Override
	public String help() {
		return ChatColor.GREEN + "/herobrine cancel";
	}

	@Override
	public String helpDesc() {
		return ChatColor.GREEN + "Cancels Herobrine's current target";
	}

}
