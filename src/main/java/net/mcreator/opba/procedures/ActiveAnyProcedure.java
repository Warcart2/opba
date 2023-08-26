package net.mcreator.opba.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;

public class ActiveAnyProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Voltage100Milions
				|| (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Voltage200Milions;
	}
}
