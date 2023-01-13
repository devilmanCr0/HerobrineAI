package org.devilmanCr0.herobrineai.NPC.Entity;

import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.EnumGamemode;
import net.minecraft.server.EnumMoveType;
import net.minecraft.server.PlayerInteractManager;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.devilmanCr0.herobrineai.NPC.NPCCore;
import org.devilmanCr0.herobrineai.NPC.NMS.BWorld;
import org.devilmanCr0.herobrineai.NPC.Network.NetworkHandler;

import com.mojang.authlib.GameProfile;

public class HumanEntity extends EntityPlayer {

	private CraftPlayer cplayer = null;

	public HumanEntity(final NPCCore npcCore, final BWorld world, final GameProfile s, final PlayerInteractManager playerInteractManager) {
		super(npcCore.getServer().getMCServer(), world.getWorldServer(), s, playerInteractManager);

		playerInteractManager.b(EnumGamemode.SURVIVAL);

		playerConnection = new NetworkHandler(npcCore, this);
		fauxSleeping = true;
	}

	public void setBukkitEntity(org.bukkit.entity.Entity entity) {
		bukkitEntity = (CraftEntity) entity;
	}

	@Override
	public void move(EnumMoveType x, double arg0, double arg1, double arg2) {
		setPosition(arg0, arg1, arg2);
	}

	@Override
	public boolean a(EntityHuman entity) {
		return super.a(entity);
	}

	@Override
	public void c(Entity entity) {
		super.c(entity);
	}

	@Override
	public CraftPlayer getBukkitEntity() {
		if (cplayer == null) {
			cplayer = new CraftPlayer((CraftServer) Bukkit.getServer(), this);
		}

		return cplayer;
	}

}
