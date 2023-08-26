package net.mcreator.opba.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;

public class MarineAttackProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			return false;
		}
		return (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Fraction).equals("Pirate");
	}
}
