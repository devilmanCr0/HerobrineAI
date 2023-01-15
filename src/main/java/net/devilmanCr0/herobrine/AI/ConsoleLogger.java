package net.devilmanCr0.herobrine.AI;

import java.util.logging.Logger;

import net.devilmanCr0.herobrine.Herobrine;

public class ConsoleLogger {

	static Logger log = Logger.getLogger("Minecraft");
	
	public void info(String text){
		if (Herobrine.isDebugging){
			log.info(text);
		}
	}
	
}
