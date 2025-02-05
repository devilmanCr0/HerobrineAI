package net.devilmanCr0.herobrine.listeners;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

import net.devilmanCr0.herobrine.Herobrine;
import net.devilmanCr0.herobrine.AI.Core.CoreType;
import net.devilmanCr0.herobrine.misc.ItemName;

public class InventoryListener implements Listener {

	Logger log = Logger.getLogger("Minecraft");

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		if (event.getInventory().getType() == InventoryType.CHEST) {

			Object[] data = { event.getPlayer(), event.getInventory() };

			Herobrine.getPluginCore().getAICore().getCore(CoreType.BOOK).RunCore(data);

			if (new Random().nextInt(100) > 97) {

				if (Herobrine.getPluginCore().getConfigDB().UseHeads) {
					if (event.getInventory().firstEmpty() != -1) {
						if (Herobrine.getPluginCore().getAICore().getResetLimits().isHead()) {
							event.getInventory().setItem(event.getInventory().firstEmpty(),
									ItemName.CreateSkull(event.getPlayer().getUniqueId(), event.getPlayer().getName()));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) {

		if (event.getInventory().getType() == InventoryType.CHEST
			|| event.getInventory().getType() == InventoryType.FURNACE
			|| event.getInventory().getType() == InventoryType.WORKBENCH) {
			
			if (Herobrine.getPluginCore().getConfigDB().useWorlds.contains(event.getPlayer().getLocation().getWorld().getName())) {
				
				if (Herobrine.getPluginCore().getConfigDB().PlaceSigns == true
					&& Herobrine.getPluginCore().getSupport().checkSigns(event.getPlayer().getLocation())) {
					
					if (Herobrine.getPluginCore().getAICore().getResetLimits().isSign()) {
						Object[] data = { event.getPlayer().getLocation(), event.getPlayer().getLocation() };
						Herobrine.getPluginCore().getAICore().getCore(CoreType.SIGNS).RunCore(data);
					}
				}
			}
		}

	}

}
