package net.mcreator.opba.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class IronWitheringOnEffectActiveTickProcedure {
	public static void execute(Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("IronWithering") < 1) {
			entity.hurt(DamageSource.DROWN, (float) (amplifier + 1));
			entity.getPersistentData().putDouble("IronWithering", 20);
		} else {
			entity.getPersistentData().putDouble("IronWithering", (entity.getPersistentData().getDouble("IronWithering") - 1));
		}
	}
}
