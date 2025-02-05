package net.devilmanCr0.herobrine.AI.cores;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.devilmanCr0.herobrine.Herobrine;
import net.devilmanCr0.herobrine.Utils;
import net.devilmanCr0.herobrine.AI.Core;
import net.devilmanCr0.herobrine.AI.CoreResult;

public class SoundCore extends Core{

	public SoundCore(){
		super(CoreType.SOUNDF,AppearType.NORMAL, Herobrine.getPluginCore());
	}
	
	public CoreResult CallCore(Object[] data){
        return playRandom((Player)data[0]);
	}
	
	public CoreResult playRandom(Player player){
		
		Sound[] sounds = {
				Sound.ENTITY_GHAST_SCREAM,
				Sound.ENTITY_WITHER_DEATH,
				Sound.ENTITY_WITHER_HURT,
				Sound.ENTITY_BAT_HURT,
				Sound.ENTITY_PLAYER_BREATH,
				Sound.ENTITY_PLAYER_HURT,
				Sound.BLOCK_IRON_DOOR_OPEN,
				Sound.BLOCK_IRON_DOOR_CLOSE
				};
		
		
       player.playSound(player.getLocation(),sounds[Utils.getRandomGen().nextInt(sounds.length)],(float) 0.75,(float) 0.75);
       
       return new CoreResult(true,"SoundF is starting.");
	}
	
}
