package org.devilmanCr0.herobrineai.NPC.Network;

import net.minecraft.server.EnumProtocolDirection;
import net.minecraft.server.NetworkManager;

public class NetworkCore extends NetworkManager {

	public NetworkCore() {
		super(EnumProtocolDirection.SERVERBOUND);
	}

	@Override
	public void a() {

	}

}
