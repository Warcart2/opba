package net.mcreator.opba.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.init.OpbaModMobEffects;

public class DeathScreenDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(OpbaModMobEffects.DEATH.get()) : false;
	}
}
