
package net.mcreator.opba.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class ItWorksItem extends Item {

	public ItWorksItem() {
		super(new Item.Properties().tab(OpbaModTabs.TAB_DEVIL_FRUITS).stacksTo(64).rarity(Rarity.COMMON));
	}

}
