package net.mcreator.opba.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;
import net.mcreator.opba.entity.StandTestEntity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class StandSummonOnKeyReleasedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("StandActive") && ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stand).equals("test")
				&& (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).cooldown <= 0) {
			entity.getPersistentData().putBoolean("StandActive", false);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof StandTestEntity && (entityiterator.getPersistentData().getString("Owner")).equals(entity.getDisplayName().getString())) {
						if (!entityiterator.level.isClientSide())
							entityiterator.discard();
					}
				}
			}
		}
	}
}
