package net.mcreator.opba.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.opba.network.OpbaModVariables;
import net.mcreator.opba.init.OpbaModParticleTypes;
import net.mcreator.opba.init.OpbaModMobEffects;

public class LogiaInvunerabilityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		if (!(entity.getPersistentData().getBoolean("Disabled") || (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(OpbaModMobEffects.BLOCKED.get()) : false))) {
			if (((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).DevilFruit).equals("GoroGoro")) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (OpbaModParticleTypes.GORO_INVUNERABILITY.get()), x, (y + 0.5), z, 20, 0.5, 0.5, 0.5, 0);
			} else if (((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).DevilFruit).equals("MicroSaikin")
					&& ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).ZoanPoint).equals("Bacterial")
					&& 10 * amount < (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina) {
				{
					double _setval = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina - 10 * amount;
					entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Stamina = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (OpbaModParticleTypes.SAIKIN_INVUNERABILITY.get()), x, (y + 0.5), z, (int) amount, 0.5, 0.5, 0.5, 0);
			}
		}
		entity.getPersistentData().putBoolean("Disabled", false);
	}
}
