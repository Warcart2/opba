package net.mcreator.opba.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class WantedPosterRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("BountyBillions") >= 1) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent((Math.round(itemstack.getOrCreateTag().getDouble("BountyBillions")) + " Billions Belly")), true);
		} else if (itemstack.getOrCreateTag().getDouble("Bounty") >= 1000000) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent((Math.round(Math.floor(itemstack.getOrCreateTag().getDouble("Bounty") / 1000000)) + " Milions Belly")), true);
		} else if (itemstack.getOrCreateTag().getDouble("Bounty") >= 1000) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent((Math.round(Math.floor(itemstack.getOrCreateTag().getDouble("Bounty") / 1000)) + " Thousands Belly")), true);
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent((Math.round(Math.floor(itemstack.getOrCreateTag().getDouble("Bounty"))) + " Belly")), true);
		}
	}
}
