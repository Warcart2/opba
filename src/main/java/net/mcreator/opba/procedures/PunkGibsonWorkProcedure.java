package net.mcreator.opba.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.init.OpbaModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PunkGibsonWorkProcedure {
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
		if (OpbaModItems.PUNKGIBSON.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			((LivingEntity) entity).getAttribute(ForgeMod.REACH_DISTANCE.get()).setBaseValue(
					(((LivingEntity) entity).getAttribute(ForgeMod.REACH_DISTANCE.get()).getBaseValue() + Math.floor((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("far") / 10)));
			entity.getPersistentData().putBoolean("far", true);
			entity.getPersistentData().putDouble("hf", Math.floor((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("far") / 10));
		} else if (entity.getPersistentData().getBoolean("far")) {
			((LivingEntity) entity).getAttribute(ForgeMod.REACH_DISTANCE.get()).setBaseValue(3);
			entity.getPersistentData().putBoolean("far", false);
			entity.getPersistentData().putDouble("hf", 0);
		}
	}
}
