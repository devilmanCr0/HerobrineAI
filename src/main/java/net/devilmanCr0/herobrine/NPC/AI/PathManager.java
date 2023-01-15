package net.devilmanCr0.herobrine.NPC.AI;

import net.devilmanCr0.herobrine.Herobrine;
import net.devilmanCr0.herobrine.AI.Core.CoreType;

public class PathManager {

	Path pathNow = null;

	public void setPath(Path path) {
		pathNow = path;
	}

	public void update() {
		if (pathNow != null && (Herobrine.getPluginCore().getAICore().getCoreTypeNow().equals(CoreType.ANY) ||
				Herobrine.getPluginCore().getAICore().getCoreTypeNow().equals(CoreType.RANDOM_POSITION))) {
			pathNow.update();
		}
	}

	public Path getPath() {
		return pathNow;
	}

}
