package org.devilmanCr0.herobrineai;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Support {

	private boolean B_WorldGuard = false;
	private WorldGuardHook WorldGuard = null;
	
	public Support() {
		WorldGuard = new WorldGuardHook();
				
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(HerobrineAI.getPluginCore(), new Runnable() {
			public void run() {
				CheckForPlugins();
			}
		}, 1 * 2L);
	}

	public boolean isWorldGuard() {
		return B_WorldGuard;
	}

	
	public void CheckForPlugins() {
		if (WorldGuard.Check()) {
			B_WorldGuard = true;
			HerobrineAI.log.info("[HerobrineAI] WorldGuard plugin detected!");
		}
		
	}

	public boolean isSecuredArea(Location loc) {		
		if (B_WorldGuard)
		{
			return WorldGuard.isSecuredArea(loc);
		}
		else
		{
			return false;
		}
	}

	public boolean checkBuild(final Location loc) {
		return HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Build || !isSecuredArea(loc);
	}

	public boolean checkAttack(final Location loc) {
		return HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Attack || !isSecuredArea(loc);
	}

	public boolean checkHaunt(final Location loc) {
		return HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Haunt || !isSecuredArea(loc);
	}

	public boolean checkSigns(final Location loc) {
		return HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Signs || !isSecuredArea(loc);
	}

	public boolean checkBooks(final Location loc) {
		return HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Books || !isSecuredArea(loc);
	}	

}
