package net.devilmanCr0.herobrine.commands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.devilmanCr0.herobrine.Herobrine;
import net.devilmanCr0.herobrine.AI.Core.CoreType;

public class CmdBurn extends SubCommand {

	public CmdBurn(Herobrine plugin, Logger log) {
		super(plugin, log);
	}

	@Override
	public boolean execute(Player player, String[] args) {
		
		if (args.length > 1) {

			
			Player target = Bukkit.getServer().getPlayer(args[1]);
			
			if (target == null) {
				sendMessage(player, ChatColor.RED + "[Herobrine] " + args[1] + " cannot be attacked because they are offline.");
				return true;
			}
			
			if (!target.isOnline()) {
				sendMessage(player, ChatColor.RED + "[Herobrine] " + args[1] + " cannot be attacked because they are offline.");
				return true;
			}

			Object[] data = { target };
			sendMessage(player, ChatColor.RED + "[Herobrine] " + plugin.getAICore().getCore(CoreType.BURN).RunCore(data).getResultString());	
		
			return true;
		}
		
		return false;
	}

	@Override
	public String help() {
		return ChatColor.GREEN + "/herobrine burn <player>";
	}

	@Override
	public String helpDesc() {
		return ChatColor.GREEN + "Burns the specified player";
	}

}
