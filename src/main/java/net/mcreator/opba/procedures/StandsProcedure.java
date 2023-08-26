package net.mcreator.opba.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.Util;

import javax.annotation.Nullable;

import java.io.File;

@Mod.EventBusSubscriber
public class StandsProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level);
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		File standFile = new File("");
		com.google.gson.JsonObject stand = new com.google.gson.JsonObject();
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastMessage(new TextComponent((FMLPaths.GAMEDIR.get().toString() + "" + File.separator + "data" + File.separator + "opba" + File.separator + "stands")), ChatType.SYSTEM, Util.NIL_UUID);
	}
}
