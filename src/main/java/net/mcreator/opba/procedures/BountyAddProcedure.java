package net.mcreator.opba.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class BountyAddProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (((entityiterator.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Fraction).equals("Pirate")
					&& ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).atteckers).contains("|" + entityiterator.getDisplayName().getString() + "|")
					&& !((entity instanceof LivingEntity _livEnt ? _livEnt.isBaby() : false) || entityiterator == entity)) {
				{
					double _setval = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 5) * ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) + 1)
							+ (entityiterator.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Bounty
							+ (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Bounty / 3;
					entityiterator.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Bounty = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				while ((entityiterator.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Bounty >= 1000000000) {
					{
						double _setval = (entityiterator.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Bounty - 1000000000;
						entityiterator.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Bounty = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = (entityiterator.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).BountyBillion + 1;
						entityiterator.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.BountyBillion = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				}
			}
		}
	}
}
