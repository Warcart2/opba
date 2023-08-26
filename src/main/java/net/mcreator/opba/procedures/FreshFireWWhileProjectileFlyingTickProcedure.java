package net.mcreator.opba.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class FreshFireWWhileProjectileFlyingTickProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
		if (Math.abs(immediatesourceentity.getDeltaMovement().x()) + Math.abs(immediatesourceentity.getDeltaMovement().y()) + Math.abs(immediatesourceentity.getDeltaMovement().z()) >= 0.1) {
			immediatesourceentity.setDeltaMovement(new Vec3((immediatesourceentity.getDeltaMovement().x() * 0.9), (immediatesourceentity.getDeltaMovement().y() * 0.9), (immediatesourceentity.getDeltaMovement().z() * 0.9)));
		} else {
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
	}
}
