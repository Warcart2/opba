package net.mcreator.opba.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.network.OpbaModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AttackersProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Entity ent = null;
		if (sourceentity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			ent = sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null;
		} else {
			ent = sourceentity;
		}
		if (!((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).atteckers).contains("|" + ent.getDisplayName().getString() + "|")) {
			{
				String _setval = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).atteckers + "|" + ent.getDisplayName().getString() + "|";
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.atteckers = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
