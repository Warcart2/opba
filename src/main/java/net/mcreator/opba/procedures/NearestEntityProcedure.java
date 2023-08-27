package net.mcreator.opba.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class NearestEntityProcedure {
	public static Entity execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return null;
		Entity entityEnd = null;
		double Distance = 0;
		Distance = 40;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (Math.abs(x - entityiterator.getX()) + Math.abs(y - entityiterator.getY()) + Math.abs(z - entityiterator.getZ()) < Distance && !(entity == entityiterator)) {
					Distance = Math.abs(x - entityiterator.getX()) + Math.abs(y - entityiterator.getY()) + Math.abs(z - entityiterator.getZ());
					entityEnd = entityiterator;
				}
			}
		}
		return entityEnd;
	}
}
