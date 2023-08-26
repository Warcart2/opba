package net.mcreator.opba.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;

public class BecomeMarineProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		{
			String _setval = "Marine";
			entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Fraction = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
