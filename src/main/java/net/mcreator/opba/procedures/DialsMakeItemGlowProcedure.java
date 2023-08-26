package net.mcreator.opba.procedures;

import net.minecraft.world.item.ItemStack;

public class DialsMakeItemGlowProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("Force") == 0) {
			return false;
		}
		return true;
	}
}
