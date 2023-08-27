package net.mcreator.opba.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;

public class RemoveStandSelfProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "None";
			entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Stand = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
