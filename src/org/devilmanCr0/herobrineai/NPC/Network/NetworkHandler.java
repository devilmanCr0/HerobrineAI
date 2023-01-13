package org.devilmanCr0.herobrineai.NPC.Network;

import org.devilmanCr0.herobrineai.NPC.NPCCore;

import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Packet;
import net.minecraft.server.PlayerConnection;

public class NetworkHandler extends PlayerConnection {

	public NetworkHandler(final NPCCore npcCore, final EntityPlayer entityPlayer) {
		super(npcCore.getServer().getMCServer(), npcCore.getNetworkCore(), entityPlayer);
	}

	@Override
	public void a(final double d0, final double d1, final double d2, final float f, final float f1) {
		
	}

	@Override
	public void sendPacket(final Packet packet) {
		
	}

}