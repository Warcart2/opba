
package net.mcreator.opba.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.opba.init.OpbaModTabs;

public class ItWorksItem extends Item {
	public ItWorksItem() {
		super(new Item.Properties().tab(OpbaModTabs.TAB_DEVIL_FRUITS).stacksTo(64).rarity(Rarity.COMMON));
	}
}
