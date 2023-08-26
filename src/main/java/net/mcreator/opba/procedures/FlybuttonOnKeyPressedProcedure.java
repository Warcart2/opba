package net.mcreator.opba.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;

public class FlybuttonOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).DevilFruit).equals("GoroGoro") || false) {
			{
				boolean _setval = true;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Fly = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
