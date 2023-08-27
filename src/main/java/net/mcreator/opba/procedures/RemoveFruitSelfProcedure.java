package net.mcreator.opba.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;

public class RemoveFruitSelfProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (("GoroGoro").equals((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).DevilFruit)) {
			OpbaModVariables.MapVariables.get(world).GoroGoroUser = "974738747tueituwjgdngmsbkjn";
			OpbaModVariables.MapVariables.get(world).syncData(world);
		}
		{
			String _setval = "None";
			entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.DevilFruit = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
