package net.mcreator.opba.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.opba.network.OpbaModVariables;
import net.mcreator.opba.init.OpbaModItems;

public class WantedPosterNotEmptyProcedure {
	public static ItemStack execute(Entity entity) {
		if (entity == null)
			return ItemStack.EMPTY;
		ItemStack test = ItemStack.EMPTY;
		test = new ItemStack(OpbaModItems.WANTED_POSTER.get());
		if ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).BountyBillion
				+ (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Bounty != 0) {
			test.getOrCreateTag().putDouble("BountyBillions", ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).BountyBillion));
			test.getOrCreateTag().putDouble("Bounty", ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Bounty));
			if ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).BountyBillion > 0) {
				(test).setHoverName(new TextComponent(("Wanted poster of " + "\u00A74" + entity.getDisplayName().getString())));
			} else {
				(test).setHoverName(new TextComponent(("Wanted poster of " + entity.getDisplayName().getString())));
			}
		} else {
			test = new ItemStack(Blocks.AIR);
		}
		return test;
	}
}
