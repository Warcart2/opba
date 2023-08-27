package net.mcreator.opba.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class TestProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double LocX = 0;
		double LocY = 0;
		double LocZ = 0;
		BlockState block = Blocks.AIR.defaultBlockState();
		block = Blocks.AIR.defaultBlockState();
		LocX = Math.round(x);
		LocY = Math.round(y);
		LocZ = Math.round(z);
		BallDeleteProcedure.execute(world, x, y, z, block, 40);
		world.setBlock(new BlockPos(LocX, LocY, LocZ), Blocks.AIR.defaultBlockState(), 3);
		{
			final Vec3 _center = new Vec3(LocX, LocY, LocZ);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(80 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					entityiterator.hurt(DamageSource.LIGHTNING_BOLT, 120);
				}
			}
		}
	}
}
