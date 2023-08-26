
package net.mcreator.opba.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.opba.procedures.KikoKikoNoMiPlayerFinishesUsingItemProcedure;
import net.mcreator.opba.init.OpbaModTabs;

public class KikoKikoNoMiItem extends Item {
	public KikoKikoNoMiItem() {
		super(new Item.Properties().tab(OpbaModTabs.TAB_DEVIL_FRUITS).stacksTo(1).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0f).alwaysEat()

				.build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		KikoKikoNoMiPlayerFinishesUsingItemProcedure.execute(entity);
		return retval;
	}
}
