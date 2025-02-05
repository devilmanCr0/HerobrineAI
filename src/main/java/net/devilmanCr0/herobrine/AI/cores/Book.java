package net.devilmanCr0.herobrine.AI.cores;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import net.devilmanCr0.herobrine.Herobrine;
import net.devilmanCr0.herobrine.Utils;
import net.devilmanCr0.herobrine.AI.Core;
import net.devilmanCr0.herobrine.AI.CoreResult;

public class Book extends Core {

	public Book() {
		super(CoreType.BOOK, AppearType.NORMAL, Herobrine.getPluginCore());
	}

	public CoreResult CallCore(Object[] data) {
		Player player = (Player) data[0];

		if (Herobrine.getPluginCore().getConfigDB().useWorlds.contains(player.getLocation().getWorld().getName())) {
			
			if (Herobrine.getPluginCore().getConfigDB().WriteBooks == true
				&& Herobrine.getPluginCore().getSupport().checkBooks(player.getLocation())) {
				
				int chance = Utils.getRandomGen().nextInt(100);
				if (chance > (100 - Herobrine.getPluginCore().getConfigDB().BookChance)) {
					Inventory chest = (Inventory) data[1];
					if (chest.firstEmpty() != -1) {
						if (Herobrine.getPluginCore().getAICore().getResetLimits().isBook()) {
							chest.setItem(chest.firstEmpty(), newBook());
							return new CoreResult(true, "Herobrine's book created.");
						}
					} else {
						return new CoreResult(false, "Herobrine's book creation failed.");
					}
				} else {
					return new CoreResult(false, "Herobrine's books are prohibited.");
				}
			} else {
				return new CoreResult(false, player.getDisplayName() + " is in a world that Herobrine is not allowed in.");
			}
		}
		return new CoreResult(false, "Herobrine's book creation failed.");
	}

	public ItemStack newBook() {

		int count = Herobrine.getPluginCore().getConfigDB().useBookMessages.size();

		int chance = Utils.getRandomGen().nextInt(count);

		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta meta = (BookMeta) book.getItemMeta();

		ArrayList<String> list = new ArrayList<String>();

		meta.setTitle("Death");
		meta.setAuthor("Go to Sleep");

		list.add(0, (String) Herobrine.getPluginCore().getConfigDB().useBookMessages.get(chance));

		meta.setPages(list);

		book.setItemMeta(meta);

		return (ItemStack) book;
	}

}
