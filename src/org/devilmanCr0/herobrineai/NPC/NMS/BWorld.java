package org.devilmanCr0.herobrineai.NPC.NMS;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.server.PlayerChunkMap;
import net.minecraft.server.WorldServer;

import org.bukkit.World;
import org.bukkit.craftbukkit.CraftWorld;

public class BWorld {
	
	private CraftWorld cWorld;
	private WorldServer wServer;

	public BWorld(final World world) {
		try {
			cWorld = (CraftWorld) world;
			wServer = cWorld.getHandle();
		} catch (Exception ex) {
			Logger.getLogger("Minecraft").log(Level.SEVERE, null, ex);
		}
	}

	public PlayerChunkMap getPlayerManager() {
		return wServer.getPlayerChunkMap();
	}

	public CraftWorld getCraftWorld() {
		return cWorld;
	}

	public WorldServer getWorldServer() {
		return wServer;
	}
}
