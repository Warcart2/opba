package net.mcreator.opba.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;
import net.mcreator.opba.init.OpbaModMobEffects;

public class MeditationEffectExpiresProcedure {
	public static void execute(Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (entity.getDeltaMovement().x() + entity.getDeltaMovement().z() != 0 || entity.getDeltaMovement().y() >= 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(OpbaModMobEffects.MEDITATION.get());
		} else {
			{
				double _setval = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina + amplifier;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
