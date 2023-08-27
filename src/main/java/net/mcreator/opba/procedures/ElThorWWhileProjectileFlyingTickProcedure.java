package net.mcreator.opba.procedures;

import net.minecraft.world.entity.Entity;

public class ElThorWWhileProjectileFlyingTickProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (!immediatesourceentity.isNoGravity()) {
			immediatesourceentity.setNoGravity(true);
		}
	}
}
