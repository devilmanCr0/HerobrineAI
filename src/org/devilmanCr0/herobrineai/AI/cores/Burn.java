package org.devilmanCr0.herobrineai.AI.cores;

import org.bukkit.entity.Player;
import org.devilmanCr0.herobrineai.HerobrineAI;
import org.devilmanCr0.herobrineai.AI.Core;
import org.devilmanCr0.herobrineai.AI.CoreResult;

public class Burn extends Core {

	public Burn() {
		super(CoreType.BURN, AppearType.NORMAL, HerobrineAI.getPluginCore());
	}

	@Override
	public CoreResult CallCore(Object[] data) {
		Player player = (Player) data[0];
		player.setFireTicks(800);
		return new CoreResult(true,"Player burned!");
	}

}
