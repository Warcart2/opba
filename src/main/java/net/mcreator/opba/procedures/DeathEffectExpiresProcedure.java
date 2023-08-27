package net.mcreator.opba.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.opba.network.OpbaModVariables;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class DeathEffectExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean i = false;
		i = true;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).setBaseValue(0.1);
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).setBaseValue(1);
		((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue(0.1);
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(20);
		if (!((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).DevilFruit).equals("GoroGoro")
				&& (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Dies) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1000 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entity.getPersistentData().getString("Killer")).equals(entityiterator.getDisplayName().getString())) {
						entity.hurt(DamageSource.OUT_OF_WORLD, 1000000000);
						i = false;
						break;
					}
				}
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (i) {
					if ((entity.getPersistentData().getString("Killer")).equals(entityiterator.getDisplayName().getString())) {
						entity.hurt(DamageSource.OUT_OF_WORLD, 1000000000);
						i = false;
						break;
					}
				} else {
					break;
				}
			}
			if (i) {
				entity.hurt(DamageSource.OUT_OF_WORLD, 1000000000);
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Dies = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
