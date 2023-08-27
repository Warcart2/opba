
package net.mcreator.opba.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.opba.procedures.IIIIIIIIItemitemRightclickedOnBlockProcedure;
import net.mcreator.opba.init.OpbaModTabs;

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
