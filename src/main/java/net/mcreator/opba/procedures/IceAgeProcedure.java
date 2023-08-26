package net.mcreator.opba.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class IceAgeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState block = Blocks.AIR.defaultBlockState();
		block = Blocks.BLUE_ICE.defaultBlockState();
		BallDeleteProcedure.execute(world, x, y, z, block, 20);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (entityiterator instanceof LivingEntity _entity)
						_entity.hurt(new DamageSource("ice").bypassArmor(), (float) (35 - Math.sqrt(Math.pow(x - entityiterator.getX(), 2) + Math.pow(y - entityiterator.getY(), 2) + Math.pow(z - entityiterator.getZ(), 2))));
				}
			}
		}
	}
}
