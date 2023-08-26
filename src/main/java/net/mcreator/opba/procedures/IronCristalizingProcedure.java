package net.mcreator.opba.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.opba.network.OpbaModVariables;
import net.mcreator.opba.init.OpbaModMobEffects;

public class IronCristalizingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			NearestEntityProcedure.execute(world, x, y, z, entity).getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.IronPerMob = _setval;
				capability.syncPlayerVariables(NearestEntityProcedure.execute(world, x, y, z, entity));
			});
		}
		if (NearestEntityProcedure.execute(world, x, y, z, entity) instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(OpbaModMobEffects.METALIZED.get(), 100000, 3));
	}
}
