package net.mcreator.opba.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;
import net.mcreator.opba.init.OpbaModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CooldownUpdateProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).cooldown > 1) {
			{
				double _setval = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).cooldown - 1;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = 0;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina < (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new OpbaModVariables.PlayerVariables())).StaminaMax && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(OpbaModMobEffects.FATIGUE.get()) : false) && !entity.isShiftKeyDown()) {
			{
				double _setval = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina
						+ (1 + Math.floor((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Lvl / 5))
								/ ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(OpbaModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(OpbaModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 2);
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina < (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new OpbaModVariables.PlayerVariables())).StaminaMax && !entity.isShiftKeyDown()) {
			{
				double _setval = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina + 1
						+ Math.floor((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Lvl / 5);
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina < (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new OpbaModVariables.PlayerVariables())).StaminaMax) {
			{
				double _setval = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Stamina
						+ (1 + Math.floor((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Lvl / 5)) * 2;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).StaminaMax;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).CyborgFuelType).equals("GUEA")) {
			{
				double _setval = 500;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CyborgFuel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
