package net.devilmanCr0.herobrine.AI.cores;

import org.bukkit.entity.Player;

import net.devilmanCr0.herobrine.Herobrine;
import net.devilmanCr0.herobrine.AI.Core;
import net.devilmanCr0.herobrine.AI.CoreResult;

public class Burn extends Core {

	public Burn() {
		super(CoreType.BURN, AppearType.NORMAL, Herobrine.getPluginCore());
	}

	@Override
	public CoreResult CallCore(Object[] data) {
		Player player = (Player) data[0];
		player.setFireTicks(800);
		return new CoreResult(true, player.getDisplayName() + " was burned by Herobrine.");
	}

}
