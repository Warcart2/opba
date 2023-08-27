package net.mcreator.opba.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;
import net.mcreator.opba.init.OpbaModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LooseShichibukaiProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer(), event.isEndConquered());
	}

	public static void execute(LevelAccessor world, Entity entity, boolean endconquered) {
		execute(null, world, entity, endconquered);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, boolean endconquered) {
		if (entity == null)
			return;
		if (!endconquered) {
			{
				boolean _setval = world.getLevelData().getGameRules().getBoolean(OpbaModGameRules.PERMANENTSHICHIBUKAI);
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Shichibukai = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
