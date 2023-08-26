package net.mcreator.opba.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;

public class CombSwitchOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = !(entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).CombatMode;
			entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CombatMode = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
