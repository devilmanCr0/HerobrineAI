package org.devilmanCr0.herobrineai.AI;

import java.util.Random;

import org.bukkit.entity.Player;
import org.devilmanCr0.herobrineai.HerobrineAI;

public class Message {

	public static void SendMessage(Player player) {
		if (HerobrineAI.getPluginCore().getConfigDB().SendMessages == true) {

			int count = HerobrineAI.getPluginCore().getConfigDB().useMessages.size();

			Random randgen = new Random();
			int randmsg = randgen.nextInt(count);

			player.sendMessage("<Herobrine> " + HerobrineAI.getPluginCore().getConfigDB().useMessages.get(randmsg));

		}
	}

}
