package net.mcreator.opba.procedures;

import net.minecraft.world.item.ItemStack;

public class KeyItemIsCraftedsmeltedProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("key") == 0) {
			itemstack.getOrCreateTag().putDouble("key", 0);
		}
	}
}
