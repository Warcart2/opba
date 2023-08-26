package net.mcreator.opba.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.opba.network.OpbaModVariables;
import net.mcreator.opba.init.OpbaModBlocks;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class WantedPosterGetProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.world);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		boolean Bounty = false;
		if (42000 < OpbaModVariables.BoutyTimer) {
			OpbaModVariables.BoutyTimer = 0;
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Bounty
						+ (entityiterator.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).BountyBillion != 0) {
					Bounty = true;
				}
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (Bounty) {
					world.setBlock(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), OpbaModBlocks.WANTED_POSTER_PACKAGE.get().defaultBlockState(), 3);
				}
			}
		} else {
			OpbaModVariables.BoutyTimer = OpbaModVariables.BoutyTimer + 1;
		}
	}
}
