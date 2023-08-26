package net.mcreator.opba.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class RaigoWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double yLoop = 0;
		double Radius = 0;
		double loop = 0;
		double particleAmount = 0;
		double subZ = 0;
		double subX = 0;
		double subY = 0;
		immediatesourceentity.setNoGravity(true);
		immediatesourceentity.setDeltaMovement(new Vec3(0, (-0.1), 0));
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (20 >= Math.sqrt(Math.pow(x - entityiterator.getX(), 2) + Math.pow(y - entityiterator.getY(), 2) + Math.pow(z - entityiterator.getZ(), 2))) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 25, 0, true, false));
					if (!(entity == entityiterator)) {
						entityiterator.hurt(DamageSource.LIGHTNING_BOLT, 150);
					}
				}
			}
		}
	}
}
