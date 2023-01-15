package net.devilmanCr0.herobrine.AI.cores;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import net.devilmanCr0.herobrine.Herobrine;
import net.devilmanCr0.herobrine.Utils;
import net.devilmanCr0.herobrine.AI.AICore;
import net.devilmanCr0.herobrine.AI.Core;
import net.devilmanCr0.herobrine.AI.CoreResult;

public class Pyramid extends Core {
	private static int layers = 2;
	
	public Pyramid() {
		super(CoreType.PYRAMID, AppearType.NORMAL, Herobrine.getPluginCore());
	}

	public CoreResult CallCore(Object[] data) {
		if (data[0] instanceof Player) {
			return FindPlace((Player) data[0]);
		} else {
			return FindPlace((Chunk) data[0]);
		}
	}
	
	private CoreResult ForcePlace(Location loc)
	{
		if(loc.getBlockY() < 30)
		{
			return new CoreResult(false, "Pyramid cannot be placed below 30, Sowy!");
		}
		BuildPyramid(
				loc.getWorld(), 
				loc.getBlockX() - 5, 
				loc.getBlockY(), 
				loc.getBlockZ() - 5
				);
		
		return new CoreResult(true, "Pyramid Force Placed.");
	}
	
	private CoreResult FindPlaceHelper(Location location)
	{
			//can build 20 feet away
			int XMAX = 0;
			int ZMAX = 0;
			
			Location loc = location;
			World tempWorld = loc.getWorld();
				
			boolean canBuild = true;
			int X = 0;
			int Z = 0;
			int Y = 0;
			
			int x = 0;
			int z = 0;
						
			for(int i = 0; i < 25; i++)
			{
				XMAX = loc.getBlockX() + Utils.getRandomGen().nextInt(100)-50;
				ZMAX = loc.getBlockZ() + Utils.getRandomGen().nextInt(100)-50;
				X = XMAX;
				Z = ZMAX;
				canBuild = true;
				for(Y = loc.getBlockY()+2; Y > loc.getBlockY()-2; Y--)
				{
				int count = 3;
					for(x=X-layers; x < X+layers+1; x++) 
					{
							for(z=Z-layers; z < Z+layers+1; z++)
							{
								//checks if 9x9 clear land avaliable and if we're creating it on player
								if(!tempWorld.getBlockAt(x, Y-1, z).getType().isSolid())
								{
									count--;
								}
								
								if((loc.getBlockX() == x && loc.getBlockZ() == z))
								{
									canBuild = false;
									break;
								}
						
							}
							if(count < 0 || !canBuild)
							{
								canBuild = false;
								break;
							}
					}
					
					if (canBuild == true) {
						BuildPyramid(loc.getWorld(), x, Y, z);
						return new CoreResult(true, "Creating a pyramid.");
					}
					
				}
					
			}
			
			//if we couldn't find anything, try force
			return ForcePlace(loc);
	}
	
	
	
	public CoreResult FindPlace(Player player) {
		if (PluginCore.getConfigDB().BuildPyramids) {
			return FindPlaceHelper((Location) player.getLocation());
		}
		return new CoreResult(false, "Cannot create a pyramid.");
	}

	public CoreResult FindPlace(Chunk chunk) {
		if (PluginCore.getConfigDB().BuildPyramids) {
			Location loc = chunk.getBlock(2, 0, 2).getLocation();
			loc = loc.getWorld().getHighestBlockAt(loc).getLocation();
			return FindPlaceHelper(loc);
		}
		return new CoreResult(false, "Cannot create a pyramid.");

	}
	
	
	public void BuildPyramid(World world, int X, int Y, int Z) {

		if (Herobrine.getPluginCore().getSupport().checkBuild(new Location(world, X, Y, Z))) {		
			AICore.log.info("Creating pyramid at " + X + "," + Y + "," + Z);
			
			Material mainMat = (Material) Material.SANDSTONE;
			Material blowTorch = (Material) Material.REDSTONE_TORCH;	
			
			for(int i=layers; i > 0; i--)
			{
				//we want an odd number of rows built, hence plus uno
				for(int x=X-i; x < X+i+1; x++) 
				{
						for(int z=Z-i; z < Z+i+1; z++)
						{
								world.getBlockAt(x, Y, z).setType(mainMat);
						}
				}
				
				Y++;
			}
			// Level 4
			world.getBlockAt(X, Y, Z).setType(blowTorch);

		}

	}

}
