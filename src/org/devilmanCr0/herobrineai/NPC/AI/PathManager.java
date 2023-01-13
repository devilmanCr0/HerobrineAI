package org.devilmanCr0.herobrineai.NPC.AI;

import org.devilmanCr0.herobrineai.HerobrineAI;
import org.devilmanCr0.herobrineai.AI.Core.CoreType;

public class PathManager {

	Path pathNow = null;

	public void setPath(Path path) {
		pathNow = path;
	}

	public void update() {
		if (pathNow != null && HerobrineAI.getPluginCore().getAICore().getCoreTypeNow().equals(CoreType.RANDOM_POSITION)) {
			pathNow.update();
		}
	}

	public Path getPath() {
		return pathNow;
	}

}
