
package net.mcreator.opba.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class IIIIIIIIItemitemItem extends Item {

	public IIIIIIIIItemitemItem() {
		super(new Item.Properties().tab(OpbaModTabs.TAB_DEVIL_FRUITS).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		IIIIIIIIItemitemRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ());
		return InteractionResult.SUCCESS;
	}

}
