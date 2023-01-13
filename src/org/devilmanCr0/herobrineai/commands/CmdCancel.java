package org.devilmanCr0.herobrineai.commands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.devilmanCr0.herobrineai.HerobrineAI;
import org.devilmanCr0.herobrineai.AI.Core.CoreType;

public class CmdCancel extends SubCommand {

	public CmdCancel(HerobrineAI plugin, Logger log) {
		super(plugin, log);
	}

	@Override
	public boolean execute(Player player, String[] args) {
		
		plugin.getAICore().CancelTarget(CoreType.ANY);
		sendMessage(player, ChatColor.RED + "[HerobrineAI] Target cancelled!");
		
		return true;
	}

	@Override
	public String help() {
		return ChatColor.GREEN + "/hb-ai cancel";
	}

}
