package net.mcreator.opba.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;

public class BasicPointProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "";
			entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ZoanPoint = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
