package net.devilmanCr0.herobrine.AI.cores;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;

import net.devilmanCr0.herobrine.Herobrine;
import net.devilmanCr0.herobrine.Utils;
import net.devilmanCr0.herobrine.AI.ConsoleLogger;
import net.devilmanCr0.herobrine.AI.Core;
import net.devilmanCr0.herobrine.AI.CoreResult;
import net.devilmanCr0.herobrine.misc.BlockChanger;

public class Signs extends Core {

	public Signs() {
		super(CoreType.SIGNS, AppearType.NORMAL, Herobrine.getPluginCore());
	}

	public CoreResult CallCore(Object[] data) {
		return placeSign((Location) data[0], (Location) data[1]);
	}

	static ConsoleLogger log = new ConsoleLogger();

	public CoreResult placeSign(Location loc, Location ploc) {
		boolean status = false;
		log.info("Generating sign at " + loc.getBlockX() + " " +loc.getBlockY() + " " + loc.getBlockZ() +"... will get floaty :)");
		//Though of it being better if signs were just placed in mid air :]
		Random randcgen = Utils.getRandomGen();
		
		int modifier = randcgen.nextBoolean() ? 1 : -1;
		if(randcgen.nextInt(100) > 55)
		{
			loc.setX(loc.getBlockX() + (2*modifier));
			createSign(loc, ploc);
			
		} else {
			loc.setZ(loc.getBlockZ() + (2*modifier));
			createSign(loc, ploc);
		}
		
		status = true;
		
		if (status) {
			return new CoreResult(true, "Sign generated successfully.");
		} else {
			return new CoreResult(false, "Sign generation failed.");
		}
	}

	public void createSign(Location loc, Location ploc) {

		Random randcgen = Utils.getRandomGen();
		int chance = randcgen.nextInt(100);
		if (chance > (100 - Herobrine.getPluginCore().getConfigDB().SignChance)) {
			Random randgen = Utils.getRandomGen();
			int count = Herobrine.getPluginCore().getConfigDB().useSignMessages.size();
			int randmsg = randgen.nextInt(count);

			Block signblock = loc.add(0, 0D, 0).getBlock();
			Block undersignblock = signblock.getLocation().subtract(0D, 1D, 0D).getBlock();
			if (!signblock.getType().isSolid() && undersignblock.getType().isSolid()) {
				
				signblock.setType(Material.OAK_SIGN);
				Sign sign = (Sign) signblock.getState();

				BlockData blockData = sign.getBlockData();
				((Directional) blockData).setFacing(BlockChanger.getPlayerBlockFace(ploc));
				sign.setBlockData(blockData);
				
				sign.setLine(1, Herobrine.getPluginCore().getConfigDB().useSignMessages.get(randmsg));
				sign.update();
			}
		}
	}
}
