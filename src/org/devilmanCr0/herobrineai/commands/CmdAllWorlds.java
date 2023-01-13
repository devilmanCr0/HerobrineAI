package org.devilmanCr0.herobrineai.commands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.devilmanCr0.herobrineai.HerobrineAI;
import org.devilmanCr0.herobrineai.AI.Core.CoreType;

public class CmdAllWorlds extends SubCommand {

	public CmdAllWorlds(HerobrineAI plugin, Logger log) {
		super(plugin, log);
	}

	@Override
	public boolean execute(Player player, String[] args) {
		
		plugin.getConfigDB().addAllWorlds();
		sendMessage(player, ChatColor.GREEN + "[HerobrineAI] All worlds have been added to config.");
		sendMessage(player, ChatColor.YELLOW + "[HerobrineAI] Note: Worlds with blank spaces can cause problems!");
		
		return true;
	}

	@Override
	public String help() {
		return ChatColor.GREEN + "/hb-ai allworlds";
	}

}