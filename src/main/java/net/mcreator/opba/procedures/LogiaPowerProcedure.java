package net.mcreator.opba.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.opba.network.OpbaModVariables;
import net.mcreator.opba.init.OpbaModParticleTypes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LogiaPowerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (((sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).DevilFruit).equals("GoroGoro")
				&& (sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Voltage200Milions
				&& (sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina >= 100) {
			{
				double _setval = (sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina - 100;
				sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Stamina = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			entity.hurt(DamageSource.LIGHTNING_BOLT, 50);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (OpbaModParticleTypes.GORO_INVUNERABILITY.get()), x, y, z, 50, 0.5, 0.5, 0.5, 0);
		} else if (((sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).DevilFruit).equals("GoroGoro")
				&& ((sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Voltage200Milions
						|| (sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Voltage100Milions)
				&& (sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina >= 50) {
			{
				double _setval = (sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina - 50;
				sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Stamina = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			entity.hurt(DamageSource.LIGHTNING_BOLT, 20);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (OpbaModParticleTypes.GORO_INVUNERABILITY.get()), x, y, z, 20, 0.5, 0.5, 0.5, 0);
		} else if (((sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).DevilFruit).equals("GoroGoro")
				&& (sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina >= 10) {
			{
				double _setval = (sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina - 10;
				sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Stamina = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			entity.hurt(DamageSource.LIGHTNING_BOLT, 5);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (OpbaModParticleTypes.GORO_INVUNERABILITY.get()), x, y, z, 5, 0.5, 0.5, 0.5, 0);
		}
	}
}
