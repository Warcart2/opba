package net.mcreator.opba.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.opba.network.OpbaModVariables;
import net.mcreator.opba.init.OpbaModParticleTypes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LogiaFlyProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina > 1
				&& (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Fly) {
			{
				double _setval = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina - 1;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.setDeltaMovement(
					new Vec3((entity.getLookAngle().x / 3 + (entity.getDeltaMovement().x() * 2) / 3), (entity.getLookAngle().y / 3 + (entity.getDeltaMovement().y() * 2) / 3), (entity.getLookAngle().z / 3 + (entity.getDeltaMovement().z() * 2) / 3)));
			if (((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).DevilFruit).equals("GoroGoro")) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (OpbaModParticleTypes.GORO_INVUNERABILITY.get()), x, y, z, 50, 0.75, 0, 0.75, 0);
			}
		}
	}
}
